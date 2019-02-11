import java.util.Scanner;

/*
 * 정규식
 * [특정그룹]<제한문자>
 * 
 * - 제한문자 : 
 *       ? : 있거나 없거나
 *       + : 한 개이상 있어야함
 *       * : 없어도 되고 여러개가 있어도 됨
 *       {n} : 정확하게 몇개가 있어야한다.
 *       {n, } : 최소한 몇개가 있어야함
 *       {n, m} : 최소 ~ 최대 개수 
 * 
 * - ?, *과 같이 특수 문자로 쓰이는 것을 문자로 사용하고 싶다면 \\문자 적으면 가능
 */
public class Source05_Regex {
	public static void main(String[] args) {
		String[] s1 = "A1,A-1,B-14,C-".split(",");
		for(int i=0;i<s1.length;i++) {
			System.out.println(s1[i] + " matches " + s1[i].matches("\\w-?\\d"));	// A1, A-1  \\w char형 문자뒤에 -가 있을수도 없을 수도 있다.
		}
		
		System.out.println();
		String[] s2 = "A1,A-1,B-14,C-".split(",");
		for(int i=0;i<s2.length;i++) {
		//	System.out.println(s2[i] + " matches " + s2[i].matches("\\w-?\\d+"));	// A1, A-1, B-14  \\d가 여러개 있어도 true
			System.out.println(s2[i] + " matches " + s2[i].matches("\\w-?\\d*"));	// A1, A-1, B-14, C-  \\d가 없어도 되고 여러개 있어도됨
			
		}
		
		System.out.println();
		String[] s3 = "41오9135,97  나4539,11허32".split(",");
		for(int i=0;i<s3.length;i++) {
			System.out.println(s3[i] + " matches " + s3[i].matches("\\d{2}\\s?[가-힇]\\d{3,}"));	// 41오9135 ( 97  나4539의 공백은 2개이기 때문에 ?로는 false, *로하면 true)  			
		}
		
		Scanner cin = new Scanner(System.in);
		System.out.println("당신의 연락처를 적어주세요. : ");
		String input = cin.nextLine();
		System.out.println(input + "은 핸드폰 번호 인가요? " + input.matches("01[01789]-?\\d{3,4}-?\\d{4}"));
		
		System.out.println("당신의 이메일 주소를 입력해주세요. : ");
		String email = cin.nextLine();
		System.out.println(email + "은 이메일 주소 인가요?" + email.matches("\\w{1,}@\\w{1,}(\\.\\w{1,}){1,}"));	// ()을 이용해서 중복하여 체크가능
		
		cin.close();
	}
}



























