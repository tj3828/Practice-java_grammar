/*
 * StringBuilder 객체
 * - 사용하고자 하는 문자열을 효율적으로 만들어내고자 할 때 사용하는 객체
 * - String과 매우 흡사
 * - 기본 생성, String, char, int 형태의 생성가능
 * - String 내부에 가지고 있는 char[]은 길이가 고정되어있어 변경이 불가능하나 StringBuilder는 가능
 * 
 */
public class Source06_StringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(30);			// int : char[]크기 설정
	//	StringBuilder sb = new StringBuilder("String");		// String : char[]에 해당 문자열 올림
		System.out.println(sb.length());		// StringBuilder에 생성된 문자열의 길이	/ 0
		System.out.println(sb.capacity());		// 문자열을 생성하기 위해 생성한 char[]의 크기 / default : 16
		
		sb.append("String");					// StringBuilder 객체에 char[]에 String 문자열 추가
		
		System.out.println(sb.toString());		// 만들고 있는 문자열을 출력	/ String
		System.out.println(sb.length());		// 6
		System.out.println(sb.capacity());		// 30
		
		sb.append("Builder");					// Builder 문자열 추가
		sb.append(true);						// boolean 변수도 추가 가능(실질적으로 문자열화되어 true문자열로 들어감)
		
		System.out.println(sb.toString());		// 만들고 있는 문자열을 출력	/ StringBuildertrue
		System.out.println(sb.length());		// 17
		System.out.println(sb.capacity());		// 30
		
		//==============================================================================================
		String str = "";
		System.out.println(System.identityHashCode(str));	// String의 경우 문자열을 추가할 때 새로운 String 객체를 생성하여 리턴해주는 것이기 때문에 문자열을 계속 추가시 메모리 낭비인 객체가 남는다.
		str += "String";									// String은 연산을 진행할 때 새로운 String 객체를 반환하면서 String Pool에 올라가지 않음
		System.out.println(System.identityHashCode(str));
		str += "Builder";
		System.out.println(System.identityHashCode(str));
		str += true;
		System.out.println(System.identityHashCode(str));
		System.out.println(str);				// StringBuilder 객체와 String 객체의 결과는 같음  / StringBuildertrue
		
		
	}
}
