
public class Exercise01_String {
	public static void main(String[] args) {
		String word = "타산지석";
		char[] ch = word.toCharArray();
		// word의 문자를 랜덤으로 섞어서 새로운 문자열로 만듬
		for(int i=0;i<ch.length;i++) {
			int p =(int)(Math.random()*ch.length);
			char temp = ch[i];
			ch[i] = ch[p];
			ch[p] = temp;
		}
		
		String cword = new String(ch);
		System.out.println(cword);
	}
}
