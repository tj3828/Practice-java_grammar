package model;



public class HangmanWord {
	int life;
	String answer;
	StringBuilder builder;
	
	public HangmanWord(String a) {
		this.answer = a;
		life = 5;
		builder = new StringBuilder(answer);
		for(int i=0; i<builder.length(); i++) {
			builder.setCharAt(i, '?');
		}
	}
	
	@Override
	public String toString() {
		StringBuilder a = new StringBuilder();
		for(int i=1; i<=life;i++) {
			a.append("♡");
		}
		return builder.toString() + " [" + a + "]";
	}
	
	
	public boolean mark(char c) {
		char[] ch = answer.toCharArray();
		boolean result = false;
		for(int i=0;i<ch.length;i++) {
			if(ch[i] == c) {
				builder.setCharAt(i, c);
				result = true;
			}
		}
		if(result == false)
			life--;
		return result;
	}
	
	public boolean isRevealed() {
		return answer.equals(builder.toString());
	}
	
}
