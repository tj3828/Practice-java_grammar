import java.util.Scanner;

/*
 * Scanner
 * - java.io의 패키지는 아니다.
 * - java.util 소속, 엄연히 따지면 입출력에 관한 클래스가 아니다.
 */
public class Source23_Scanner {
	public static void main(String[] args) {
		String data = "오늘은 목요일이다.\n곧 있으면 저녁시간이다.\n2018 10.25";
		System.out.println(data);
		Scanner scan = new Scanner(data);
		String s1 = scan.nextLine();			// 특정 구분자(\n)를 통한 String 반환, 커서는 다음줄로 이동
		System.out.println("---" + s1);
		for(int cnt=1; cnt<=3; cnt++) {
			String s2 = scan.next();			// 공백까지의 String 반환, 커서는 공백으로 이동
			System.out.println("---" + s2);
		}
		String s3 = scan.nextLine();			// 아직 커서의 줄바꿈이 이루어지지 않아 빈칸이 출력됨.
		System.out.println("---" + s3);
		int n = scan.nextInt();					// 자동으로 숫자로 파싱해줌.
		System.out.println("---" + n);
		double d = scan.nextDouble();
		System.out.println("---" + d);
		System.out.println(scan.hasNext());		// 불러올 데이터가 있는지 확인
	//	scan.next();							// 더이상 불러올 데이터가 없으면 터짐. (NoSuchElementException)
		
		
	}
}
