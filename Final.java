// Name: Reem Amro
// Class: CSPC-39
// Assignment: Final Project
// Date: 5-15-2025

import java.util.Scanner;
import java.util.*;


public class Final {

	public static void main(String[] args) {
		// This is for user input so  I can have the user input things.
		Scanner input = new Scanner(System.in);
		// The introduction of the program
		System.out.println("Hello! Welcome to StudyBuddy where you can create flashcards to study with.");
		// get number of subjects
		System.out.print("How many subjects will you do? ");
		int numberSubjects = input.nextInt();
		input.nextLine();
		// create the array lists (subjects and flashcard lists)
		List<String> subjects = new ArrayList<>();
		// I prefer using a hashmap because it can connect the question and answer easier and I can just convert it to an array list in another class
        Map<String, List<Flashcard>> flashcardsMap = new HashMap<>();
		// Input subjects and # of flashcards for each subject
		for(int i = 0; i < numberSubjects; i++) {
			// Ths is for each subject they would like to make and then the flashcards that go with the subject. The flashcards are then stored in an arraylist.
			// The subjects are stored in an array list as well. 
			System.out.println("Enter the subject you would like to do:" );
			String subject = input.nextLine();
			subjects.add(subject);
			// An array list used for holding the flashcards in each subject
			List<Flashcard> flashcards = new ArrayList<>();
			System.out.println("How many flashcards for this subject? ");
			int numberFlashcards = input.nextInt();
			input.nextLine();
			
			// This loop was from Chatgpt because I forgot what to do for a second. 
			for(int j = 0; j < numberFlashcards; j++) {
				System.out.print("Enter question for flashcard " + (j + 1) + ": ");
                String question = input.nextLine();
                System.out.print("Enter answer for flashcard " + (j + 1) + ": ");
                String answer = input.nextLine();
                flashcards.add(new Flashcard(question, answer));
			}
			
			// putting everything in the hashmap so it stores easier. It also connects the subjects with the flashcards.
			flashcardsMap.put(subject, flashcards);
		}

		
		// ask if they want to search each subject, quiz, or view
		System.out.println("Would you like to quiz or view? ");
		String answer = input.nextLine();
		if(answer.equals("view")) {
			// search(binary search and sorting algorithm)
			// sorting so we are able to search the subjects with binary search.
			Collections.sort(subjects);
			// asking which subject they are trying to find with input
			System.out.println("What subject would you like to find? ");
			String subjectFinder = input.nextLine();
			// using binary search to find the subject because it is faster then a linear search when sorted.
			int index = binarySearch(subjects, subjectFinder);
			if (index >= 0) {
	            String foundSubject = subjects.get(index);
	            System.out.println("Found subject: " + foundSubject);
	            System.out.println("Flashcards:");
	            // This prints the questions and answers for the flashcards in that subject.
	            for (Flashcard card : flashcardsMap.get(foundSubject)) {
	                System.out.println("- " + card);
	            }
	        } else {
	        	// This is for the subject not being found
	            System.out.println("Subject not found.");
	        }
		}else if(answer.equals("quiz")) {
			// ask which subject
			System.out.println("What subject would you like to quiz on? ");
			String quizSubject = input.nextLine();
			Quiz quiz = new Quiz();
	        quiz.startQuiz(flashcardsMap, subjects, quizSubject);
			// for quiz(call quiz class)
		}
		// You have to close the input so that is what I did here.
		input.close();
	}
	// binary search algorithm that I got from online. I couldn't figure out how to put the binary search in the class so I searched it up.
	public static int binarySearch(List<String> list, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = target.compareToIgnoreCase(list.get(mid));

            if (comparison == 0) {
                return mid; // Found it!
            } else if (comparison < 0) {
                right = mid - 1; // Look left
            } else {
                left = mid + 1; // Look right
            }
        }

        return -1; // Not found
    }

}
