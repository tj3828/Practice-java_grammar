/*
 * 특정 데이터를 가진 Wrapper 객체를 만들어내는 법 (생성 제외)
 * 
 * 모든 Wrapper 클래스에는 valueOf() 메소드가 정의되어 있다.
 * 매개변수로는 각 클래스에 해당하는 기본 데이터 타입과 String 이다.
 */
public class Source03_Wrapper {
	public static void main(String[] args) {
		Boolean b1 = new Boolean(true);
		Boolean b2 = Boolean.valueOf(true);
		Boolean b3 = Boolean.valueOf("true");	// 내부에 static으로 true와 false를 만들어두고 둘 중하나로 리턴하기 때문에 같은 객체 생성
		
		Integer i1 = new Integer(41);
		Integer i2 = Integer.valueOf(41);
		Integer i3 = Integer.valueOf("41");	// String 타입도 가능
		
		String d = "135000";
		int v = Integer.valueOf(d);	// 자동으로 String을 받아 Integer 객체 새성
		
		System.out.println(b1 == b2);	// false
		System.out.println(b2 == b3);	// true	/ valueOf()을 이용해 박싱된 레퍼 객체는 미리 만들어진 객체를 전달(클래스 내부에서 static으로 잡아둠, String Pool과 비슷) 
		System.out.println(i1 == i2);	// false
		System.out.println(i2 == i3);	// true	/ boolean과 달리 수치형은 범위가 넓어 -128~127까지만 미리 생성해두고 리턴하기 때문에 범위 사이의 값은 같은 객체 생성
		
		
		// 실수의 경우 범위가 너무 넓어 정해두지 않아 무조건 다른 객체 나옴
	}
}
