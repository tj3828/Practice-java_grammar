import java.util.Scanner;

/*
 * String 객체
 * 문자열은 new 없이 생성되는 특이한 객체 (기본데이터와 같이 사용함)
 * 실제 String 객체는 문자열을 내부에 char[] 형태로 지니고 있다.
 */
public class Source01_String {
	public static void main(String[] args) {
		char[] c = new char[] {'프', '로', '그', '램'};
		System.out.println(c);		// char[]은 출력시 문자열로 출력됨
		String s = new String(c);	// char[]을  모두 문자열로 생성
		System.out.println(s);    	// 프로그램
		String s1 = new String(c, 1, 2);	// 1~2번 배열을 문자열로 생성
		System.out.println(s1);		// 로그
		String s2 = new String(c, 0, 4);	
		System.out.println(s2);		// 프로그램
		
		// String도 객체이기 때문에 문자열 객체값이 들어가져 있다.
		System.out.println(s1 == s2);	// false
		String r = s.intern();		// 해당 String 객체 가지고 있는 char[]과 같은 구성을 띄고 있는 String 객체를 찾아서 없으면 등록.
		System.out.println("s code = " + System.identityHashCode(s));
		System.out.println("r code = " + System.identityHashCode(r));	// 찾고자하는 String 객체가 String pool에 존재하면 그 값을 불러옴
		System.out.println(r==s);
		
		
		//new 없이도 String 객체를 생성
		String c1 = "프로그램";	// ""로 표기하면 String 객체 생성됨
	//	String r = s.intern();		// 해당 String 객체 가지고 있는 char[]과 같은 구성을 띄고 있는 String 객체를 찾아서 없으면 등록.
	//	System.out.println("s code = " + System.identityHashCode(s));
	//	System.out.println("r code = " + System.identityHashCode(r));	// 찾고자하는 String 객체가 String pool에 존재하면 그 값을 불러옴
	//	System.out.println(r==s);
		//	s.intern();				// 이미 "프로그램"값을 가진 c1이 JVM에 올라갔기 때문에 등록 불가	
		String c2 = "프로그램";
		System.out.println(c1 == c2);	// true	(내부적으로 char[]을 찍도록 정의되어 있음)
		
		// 쌍따옴표를 이용하여 자동 생성된 String 객체는 따로 JVM에서 관리가 된다.(String pool에서 관리)
		// 때문에 한번 만들어진 객체들은 다시 생성을 안하고 해당 객체값을 재활용한다.
		
		System.out.println(System.identityHashCode(s));	// JVM에 의해서 부여된 실제 객체값을 얻어내는 방법
		System.out.println(System.identityHashCode(s2));	// s1 == s2 false
		System.out.println(System.identityHashCode(c1));	// c1 == c2 true
		System.out.println(System.identityHashCode(c2));
		
		System.out.println(s == c1);	// s.intern()에 의해 true
		
		// String 객체에서 실제 관리중인 char[]에 같은 문자로 구성되어 있다해도 == 연산자로 같은 객체냐고 물어본다면 특정경우에만 true라고 나옴.
		Scanner cin = new Scanner(System.in);	// 사용자 입력으로부터 객체를 생성해주는 기능
		String input = cin.nextLine();
		// input.intern();	// 이 메소드 사용할 시에는 true;
		System.out.println(input == "1q2w3e");	// ""로 문자열 객체를 만든다면 JVM이 따로 관리하는 String 객체를 생성, 객체 비교이기 때문에 false
		
		// 객체 값이 아니라 char[]의 구성이 같은지 비교하고 싶다면 equals() 메소드 사용
		System.out.println(input.equals("1q2w3e"));	//true
		System.out.println("1q2w3e".equals(input));	//true
		
		String[] ar = new String[5];	// String도 객체이기 때문에 초깃값으로 null 출력
		for(int i=0;i<ar.length;i++) {
			System.out.println(ar[i]);
		}
		
		cin.close();
	}
}
