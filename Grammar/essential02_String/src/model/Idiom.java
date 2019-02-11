package model;

public class Idiom {
	static char[] ar;
	static {
		ar = new char[] {'가', '금', '원', '화', '호', '세', '천', '지', '수', '월', '명', '몽', '유'};
	}
	String answer;
	String hint;
	
	public Idiom(String answer, String hint) {
		this.answer = answer;
		this.hint = hint;
	}
	
	// 6글자 문자열 생성
	// 기존의 answer 4글자는 포함, 나머지 2글자는 ar에서 랜덤뽑음.	
	public String mixChar() {
		String str = answer;
		int p = (int)(Math.random()*ar.length);
		int q = (int)(Math.random()*ar.length);
		str += "" + ar[p] + ar[q];
		char[] ch = str.toCharArray();
		// word의 문자를 랜덤으로 섞어서 새로운 문자열로 만듬
		for(int i=0;i<ch.length;i++) {
			int r =(int)(Math.random()*ch.length);
			char temp = ch[i];
			ch[i] = ch[r];
			ch[r] = temp;
		}
		return new String(ch);
	}
	
	// 답과 일치하는지 확인
	public boolean mark(String input) {
		return answer.equals(input);
	}
	
	// 힌트 생성
	// answer의 첫글자와 hint를 합쳐 문자열로 출력
	@Override
	public String toString() {
		return hint + " : " + answer.charAt(0);
	}
}
