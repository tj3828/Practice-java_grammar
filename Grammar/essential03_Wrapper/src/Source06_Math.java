/*
 * Math
 * 
 * Wrapper 객체가 아님!!
 * 
 * 수치, 수학에 관련된 기능을 모아둔 객체
 * 객체 생성은 불가능(기본 생성자를 private으로 구현하고 기능들을 static으로 설계함)
 */
public class Source06_Math {
	public static void main(String[] args) {
		System.out.println(Math.PI);	// 3.141592653589793
		System.out.println(Math.E);		// 2.718281828459045
		System.out.println(Math.abs(-3));	// 3
		System.out.println(Math.ceil(3.7));	// 4.0
		System.out.println(Math.floor(3.7));// 3.0
		System.out.println(Math.round(3.7));// 4
		System.out.println(Math.min(3, 5));	// 3
		System.out.println(Math.max(3, 5));	// 5
		System.out.println(Math.log10(10));	// 1.0
		System.out.println(Math.log(10));	// 2.302585092994046
		System.out.println(Math.pow(2, 3));	// 8.0
		System.out.println(Math.sqrt(4));	// 2.0
		System.out.println(Math.exp(4));	// 54.598150033144236
		double r = Math.toRadians(30);
		System.out.println(Math.sin(r));	// 0.4999999999	/ 삼각함수의 각도는 라디안으로 바꾸어 사용해야함
	}
}
