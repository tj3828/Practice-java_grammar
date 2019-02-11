
public class Source03_String {
	public static void main(String[] args) {
		// equals : 문자구성이 같은지 확인
		// boolean endWith(String) , boolean startWith(String) : 해당 문자열로 시작한다던가 끝난다던가
		// int compareTo(String) : 크기비교 (abcd... , 가나다라... 순으로 커짐), 작으면 음수, 같으면 0, 크면 양수
		// boolean matches(String) : 특징 패턴(정규식)에 부합하는지 확인
		String[] names = "관우,조조,조운,황충,하후돈,마초,사마의,제갈량,하후인".split(",");
		for(int i=0; i<names.length; i++) {
			String s = names[i];
			System.out.println(s + " ... " + s.equals("관우"));
			System.out.println("  ... " + s.startsWith("하후") + " ... " + s.endsWith("의"));
			System.out.println("  ... " + s.compareTo("조조"));
			System.out.println("  ... " + s.matches("관[가-힇]{1}"));
		}
		
		
	}
}
