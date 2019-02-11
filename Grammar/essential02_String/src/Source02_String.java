/*
 * String 객체가 처리해주는 기능
 */
public class Source02_String {
	public static void main(String[] args) {
		String str = "사면초가초";
		int len = str.length(); // 문자열의 글자(char[]의 크기)
		System.out.println("length == " + len);
		char c = str.charAt(0);	// 전달되는 인덱스에 대한 char 출력
		System.out.println(c); 	// c
		System.out.println(c == '사');	// char는 일반데이터형과 같아 == 로 비교가능
		char[] ar = str.toCharArray();	// 문자열 -> char[] 반환
		for(int i=0;i<ar.length;i++) {
			System.out.println(ar[i]);	// 사,면,초,가
		}
		
		int s1 = str.indexOf('초');	// 해당 문자의 인덱스반환 (없으면 -1 반환,여러 개면 첫번째 인덱스 반환)
		System.out.println("s1 = " + s1);	// s1=2
		
		int s2 = str.indexOf("면초");	// 문자열로도 인덱스반환 (시작점 반환)
		System.out.println("s2 = " + s2);	// s2=1
		
		int s3 = str.lastIndexOf('초');	// 뒤에서부터 찾아 인덱스 반환 (문자열도 마찬가지로 가능)
		System.out.println("s3 = " + s3);	// s3=4
		
		int s4 = str.indexOf('초',4);	// indexOf, lastIndexOf 둘다 시작지점을 지정하여 탐색가능
		System.out.println("s4 = " + s4);	// s4=4
		
		String s5 = str.substring(1,3);		// 자기의 배열에서 일부분을 추출하여 새로운 문자생성(이상~미만)
		System.out.println("s5 = " + s5);	// s5=면초
		
		String s6 = str.substring(2);	// 지정인덱스부터 끝까지
		System.out.println("s6 = " + s6);	// s6=초가초
		
		String data = "사면초가,풍전등화,진퇴양난,설상가상,전화위복";
		String[] s7 = data.split(",");	// 특정 문자열로부터 분리시킴	
		for(int i=0;i<s7.length;i++) {
			System.out.println(s7[i]); 	// 사면초가 풍전등화 진퇴양난 설상가상 전화위복
		}
		
		String s8 = data.replace(',', '-');	// 특정문자를 변경하여 새로운 String 생성
		System.out.println(s8);		// 사면초가-풍전등화-진퇴양난-설상가상-전화위복
		
		String s9 = data.replace("풍전등화", "????");	// 문자열도 변경가능
		System.out.println(s9);		// 사면초가-????-진퇴양난-설상가상-전화위복
		
		String p = "  가나다라  ";	// 공백이 있는 문자열 생성
		System.out.println(p);	//	  가나다라
		String s10 = p.trim();	// 문자열 처음과 끝의 공백을 제거하는 기능
		System.out.println(s10);	// 가나다라
	}
}
