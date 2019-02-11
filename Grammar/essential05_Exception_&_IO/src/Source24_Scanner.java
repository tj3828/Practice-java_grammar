import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// Scanner 객체는 직접 문자열을 소스로 설정안해도, 문자 Byte를 읽어낼 수 있는 InputStream을 설정해도 알아서 해당 input을 개조해서 문자열을 확보하면서 작업한다.
public class Source24_Scanner {
	public static void main(String[] args) {
		/*
		 * System.in 은 키보드로 입력받은 내용이 실제로 존재하지 않는 메모리상의 파일(입력버퍼)같은 곳에 byte로 저장되는데 거기서 byte값을 읽어낼 수 있게 설정된 객체가 System.in 객체
		 * 입력버퍼에서 가지고 올 byte가 없다면 대기하도록 설계되어 있음.
		 */
		Scanner cin = new Scanner(System.in);
		System.out.println(cin.next());			// 대기상태.	, 반지름 8 5 입니다.르를ㄹ르!! 입력하기, 반지름 출력
		int a = cin.nextInt();					// 8
		int b = cin.nextInt();					// 5
		System.out.println(a+b);				// 13 출력
		String s = cin.nextLine();				//  
		System.out.println(s);					// 입니다.르를ㄹ르!! 
		cin.nextLine();
		
		File f = new File("exam.log");
		try(Scanner scan = new Scanner(new FileInputStream(f));) {
			System.out.println(scan.hasNext() + "..." + scan.hasNextLine());
			
			System.out.println(scan.next());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			
			System.out.println(scan.nextDouble());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			
		}catch(IOException e){
			System.out.println("# faild.");
		}
	}
}
