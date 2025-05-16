
// this class is for creating each flashcard, I created this so the code is more simpler and I can combine the answers and questions together
//It makes it easier for everything to smoothly run and I can just group them together. 

import java.util.Objects;

public class Flashcard {
		String question;
		String answer;
		
		public Flashcard(String question, String answer) {
			this.question = question;
			this.answer = answer;
		}
		
		public String getQuestion() {
			return question;
		}
		
		public String getAnswer() {
			return answer;
		}
		// I also got these from chatGpt because the output wasn't working for some reason.
		@Override
		public String toString() {
		    return "Q: " + question + " | A: " + answer;
		}
		@Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof Flashcard)) return false;
	        Flashcard other = (Flashcard) obj;
	        return question.equalsIgnoreCase(other.question) && answer.equalsIgnoreCase(other.answer);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(question.toLowerCase(), answer.toLowerCase());
	    }
}

