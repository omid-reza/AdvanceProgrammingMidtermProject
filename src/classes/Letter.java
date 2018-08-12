package classes;

import java.util.Random;

public class Letter {
	
	protected int correctAnswers=0
				,allAnswers=0
				,correctLetter=0
				,allLetter=0;
	
	protected String answer="";
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getAllAnswers() {
		return allAnswers;
	}

	public void setAllAnswers(int allAnswers) {
		this.allAnswers = allAnswers;
	}

	public int getCorrectLetter() {
		return correctLetter;
	}

	public void setCorrectLetter(int correctLetter) {
		this.correctLetter = correctLetter;
	}

	public int getAllLetter() {
		return allLetter;
	}

	public void setAllLetter(int allLetter) {
		this.allLetter = allLetter;
	}
	
	public String getrandomletter(int level) {
		String resualt="";
		int letterNum;
		if (level<=5) {
			letterNum=1;
		}else if(level<=8){
			letterNum=2;
		}else if(level<=12) {
			letterNum=3;
		}else { // level <=15
			letterNum=4;
		}
		Random rand = new Random();
		for(int i=1;i<=letterNum;i++) {
			String show = (char) (rand.nextInt(26)+97) +"";
			while(resualt.contains(show)){
				show = (char) (rand.nextInt(26)+97) +"";
			}
			resualt=resualt + show;
		}
		return resualt;
	}
	
	public boolean LetterChecker(String word,String letter) {
		if (word.contains(letter)){
            return true;
        }
		return false;
	}
	
	public void ClearAnswer() {
		this.answer="";
	}
	
	
	public int CheckAnswer(String goal) {
	  if (goal.length() == this.answer.length()){
	      if (goal.equals(this.answer)){
	          setCorrectAnswers(getCorrectAnswers()+1);
	          return 1;
	      }else {
	    	  return 0;
	      }
	  }
	  return -1;
	}
	
}
