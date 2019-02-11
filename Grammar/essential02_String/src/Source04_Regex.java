/*
 * 정규식
 * - 문자 값들의 패턴을 분석하는데 사용
 * - [] : 한 문자를 나타내고자 할때 사용
 *  	: 이안에 문자구성이 연결되어있는 문자값이라면 - 처리로 가능 ( [A-Za-z]라하면 a부터 z까지, A-Z까지의 문자값을 체크 )
 *  
 * - ^ 	: 제외하고자 할때 사용
 * 
 * - .  : 어떤 문자든지 상관없을 때 사용 (공백도 문자취급)
 * 
 * - \\d: 수치형 문자 (0~9까지의 한 숫자를 비교), [0-9]와 같은 효과
 * - \\D: 수치형 문자 제외, [^0-9]와 같은 효과
 * 
 * - \\w: char형 문자, 한글을 제외한 char형 문자인지 확인, _ 도 포함 [A-Za-z_0-9]와 같은 효과
 * - \\W: \\w 제외
 * 
 * - \\s: 공백형 문자, 공백확인
 * - \\S: 공백형 문자 제외
 */

public class Source04_Regex {
	public static void main(String[] args) {
		String[] sample = "홍길동,trumt,trump,arump,prump,te0506,A홍길동A".split(",");
		for(int i=0;i<sample.length;i++) {
			String s = sample[i];
			System.out.print("[" + i + "]" +  s + " : ");
		//	System.out.println(s.matches("trump"));		// 문자열 글자를 입력하면 equals와 같은 기능 / trump
		//	System.out.println(s.matches("[at]rump"));	// [] 안에 문자중 하나라도 포함하면 true / arump, trump
		//	System.out.println(s.matches("[at]rum[pt]"));	// arump, trump, trumt
		//	System.out.println(s.matches("[a-t]rum[pt]"));	// arump, trump, prump, trumt	
		//	System.out.println(s.matches("[^a-p]rum[pt]"));	// trumt, trump 	(a-p)문자를 제외한 패턴 검색
		//	System.out.println(s.matches(".rum[pt]"));		// trumt, trump, arump, prump   rum 앞에는 아무 글자나 상관없다.
			
		}
		System.out.println("13".matches("\\d\\d"));			// true	(\\d가 숫자 하나를 의미하여 십자리 숫자 판단)
		System.out.println("loc_p5".matches("loc_[a-z]\\d"));	// true
		System.out.println("loc_p5".matches("loc_[a-z][0-9]"));	// true  [0-9]와 같은 효과
		System.out.println("loc_pa".matches("loc_[a-z]\\d"));	// false
		System.out.println("loc_pa".matches("loc_[a-z]\\D"));	// true
	}
}
