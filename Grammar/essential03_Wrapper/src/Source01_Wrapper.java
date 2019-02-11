/*
 * Wrapper 클래스
 * 
 * - 기본데이터(true,false,int,double,char...)를 객체화 할 때 사용하는 클래스
 * - Integer : int
 * - Long : long
 * - Float : float
 * - Double : double
 * - Short : short
 * - Byte : byte
 * - Character : char
 */
public class Source01_Wrapper {
	public static void main(String[] args) {
		boolean b = true;
		Boolean wb1 = new Boolean(b); 
		Boolean wb2 = new Boolean(b);
		System.out.println(wb1);	// Wrapper 클래스에 toString() 메소드가 오버라이드되어 있어 바로 데이터 출력
		System.out.println(wb2);	// true
		System.out.println(wb1 == wb2);	// false(객체이여서)
		
		boolean d1 = wb1.booleanValue();	// wb1가 지니고 있는 boolean 변수 반환(UnWrap과정)
		boolean d2 = wb2.booleanValue();	
		System.out.println(d1 == d2);	// true(단순 기본데이터)
		
		
	}
}
