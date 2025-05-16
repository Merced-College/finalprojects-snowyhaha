import java.util.*;
import java.util.List;
import java.util.Map;

public class Quiz {
		// convert hashmap to array list
		
		// linear search for subject 
	public int linearSearchSubjects(List<String> subjects, String targetSubject) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).equalsIgnoreCase(targetSubject)) {
                return i;
            }
        }
        return -1; // Not found
    }
	public void startQuiz(Map<String, List<Flashcard>> flashcardsMap, List<String> subjects, String quizSubject) {
			Scanner input = new Scanner(System.in);
			// linear search to find the subject. I used this because I wanted to use another algorithm that was different, despite it being slower.
			int index = linearSearchSubjects(subjects, quizSubject);
	        if (index == -1) {
	        	// In case the subject is not found.
	            System.out.println("Subject '" + quizSubject + "' not found.");
	        }
	        // This is so it keeps running in case the user wants to quiz again or retry again. 
	        boolean keepQuizzing = true;
	        // The main quiz loop that will be quizzing the users
	        while (keepQuizzing) {
	        	// When the linear search finds the index, I create an arrayList to convert the Hashmap to an arrayList because it will make it easier to use.
	            List<Flashcard> flashcards = new ArrayList<>(flashcardsMap.get(subjects.get(index)));
	            Collections.shuffle(flashcards); // Shuffle flashcards
	            
	            // Using another HashMap for the results
	            Map<Flashcard, Boolean> results = new LinkedHashMap<>();
	            for (Flashcard card : flashcards) {
	                System.out.println("Q: " + card.getQuestion());
	                String userAnswer = input.nextLine().trim();

	                boolean correct = userAnswer.equalsIgnoreCase(card.getAnswer());
	                // It puts the card with the correct answer
	                results.put(card, correct);
	                
	            }
	            // This is where the results are printed for the quiz.
	            System.out.println("Quiz Results:");
	            // This is the inital score of what they got correct.
	            int correctCount = 0;

	            for (Map.Entry<Flashcard, Boolean> entry : results.entrySet()) {
	            	// This is to access the key from the Flash card Hashmap
	                Flashcard card = entry.getKey();
	                boolean wasCorrect = entry.getValue();
	                // If it was correct it runs
	                if (wasCorrect) {
	                    System.out.println("Q: " + card.getQuestion() + " Your answer was correct!");
	                    correctCount++;
	                // If it wasn't correct this is what runs.
	                } else {
	                	System.out.println("Q: " + card.getQuestion());
	                	System.out.println("  Incorrect. Correct answer: " + card.getAnswer());
	                }
	            }
	            // Gives the total score for what was incorrect.
	            System.out.println("Total Correct: " + correctCount + " / " + results.size());
	            // This is if they want to retake the quiz. 
	            System.out.print("Do you want to retry the quiz? (yes/no): ");
	            String retry = input.nextLine().trim().toLowerCase();
	            keepQuizzing = retry.equals("yes");

	        }
	        input.close();
		
	}

}
