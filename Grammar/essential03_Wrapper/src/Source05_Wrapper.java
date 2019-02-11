/*
 * java.sun.com 에서 자바 api 문서확인가능
 * 
 */
public class Source05_Wrapper {
	public static void main(String[] args) {
		String s2 = Integer.toHexString(255); // 숫자를 16진 문자열로 생성
		System.out.println(s2);	// ff
		String s3 = Integer.toBinaryString(10); 	// 숫자를 2진 문자열로 생성		 
		System.out.println(s3);	// 1010
		String s4 = Integer.toOctalString(16);
		System.out.println(s4);	// 20
		String s5 = Integer.toString(16);	// 숫자를 10진 문자열로 생성
		int[] d = new int[] { 2,8,10,16};
		for(int i=0;i<d.length;i++) {
			System.out.println("16 의 " + d[i] + "진 문자열 ? " +  Integer.toString(16,d[i]));
		}
		
		int n = Integer.parseInt("11",8);
		System.out.println(n);	// 9
		
		double r = 10.0/0.0;
		System.out.println(r);	//Infinity
		System.out.println(Double.isInfinite(r));	// true
		double rr = Math.sqrt(-1); // NaN
		System.out.println(Double.isNaN(rr));	// true 	/ NaN인지 체크
		
		String str = "Jdk 1.8.181";
		char[] ar = str.toCharArray();
		for(int i=0;i<ar.length;i++) {
			char t = ar[i];
			System.out.println(t + " isWhitespace " + Character.isWhitespace(t));	// 공백인가
			System.out.println(t + " toLowerCase " + Character.toLowerCase(t));	// 소문자로 변경
			System.out.println(t + " toUpperCase " + Character.toUpperCase(t));	//	대문자로 변경
			System.out.println(t + " isDigit " + Character.isDigit(t));	// 수치형 문자인가
		}
	}
}
