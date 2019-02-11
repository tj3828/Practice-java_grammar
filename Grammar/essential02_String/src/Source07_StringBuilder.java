/*
 * StringBuilder만의 기능 / 특징
 * - 자신에게 설정된 char[]을 제어할수 있게 해둠.	(문자열로 만들어지기 전에 toCharArray()을 통해 char[]에 저장해두고 있기때문에 가능)
 * - 대부분의 메소드 반환값이 StringBuilder객체(this)
 * 자바1.5버전에서 사용하던 것
 * 
 * StringBuffer
 * - StringBuilder를 StringBuffer로 바꿔서 사용해도 똑같이 사용가능
 * 자바 1.0버전에서 사용하던 것
 * - 다만 StringBuffer는 동기화 지원 여부가 안된다.
 */

public class Source07_StringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("JavaProgramming");	// String 객체를 생성하면서, toCharArray()를 통해 char[]에 복사해둠.
		char c = sb.charAt(4);	// String 기능을 똑같이 사용
		System.out.println(c);	// P
		
		sb.delete(3, 6);		// 1~3까지의 char[]을 지움 (이후의 char[]의 값을 비어있는 인덱스로 땡김)
		System.out.println(sb.toString());	// Javoogramming
		sb.deleteCharAt(0);		// 해당 인덱스 문자 삭제
		System.out.println(sb.toString());	//avogramming
		
		sb.insert(5, "BAAAM!");	// 해당 인덱스에 문자열 삽입
		System.out.println(sb.toString());	// avogrBAAAM!amming
		
		sb.replace(0, 4, "?");	// 0~3번까지의 문자열을 ?로 바꿈.
		System.out.println(sb.toString() + " / " + sb.length());	// ?rBAAAM!amming / 14
		
		sb.setCharAt(5, '#');	// 해당 인덱스에 문자만 교체
		System.out.println(sb.toString() + " / " + sb.length());	// ?rBAA#M!amming / 14
		
		StringBuilder sbb = sb.reverse();			// 문자열의 순서를 변환하여 자기 자신의 객체 리턴
		System.out.println(sb.toString() + " / " + sb.length());	// gnimma!M#AABr? / 14
		
		System.out.println(sbb == sb);				// true (거의 모든 기능의 반환값이 자기 자신의 객체를 리턴하기 때문에 같은 객체로 인식)
		
		sb.reverse().insert(3, "12345").reverse();	// 자기 자신의 객체를 반환하는 특징을 이용해 작업을 이어서 설계가능.
		System.out.println(sb.toString());			// gnimma!M#AA54321Br?
	}
}
