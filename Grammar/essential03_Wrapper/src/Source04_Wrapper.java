/*
 * Wrapper 클래스에는 실제 객체가 가지고 있는 데이터를 토대로 기능들이 구현되어 있다.
 * 
 *  - 데이터로 기반으로 작동하는 기능들은 유용한 기능들이 딱히 없다.
 *  - equals, compareTo 기능 포함됨
 *  - static으로 구현해둔 기능들이 유용하다.
 *  
 *  - 전달되는 String을 분석해 해당 type의 데이터를 만들어내는 기능
 */
public class Source04_Wrapper {
	public static void main(String[] args) {
		Boolean b = new Boolean(true);
		Integer i = 44;
		i.doubleValue();
		boolean a = Boolean.logicalAnd(true, true);
		System.out.println(a);	// true
		
		boolean r1 = Boolean.parseBoolean("true");
		int r2 = Integer.parseInt("123");	// 파싱에 의해 생성 	/ 문자열을 분석하여 변환
		int r3 = Integer.valueOf("123");	// 박싱에 의해 생성
		
		
	}
}
