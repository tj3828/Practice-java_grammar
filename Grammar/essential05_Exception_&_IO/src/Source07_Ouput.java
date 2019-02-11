/*
 * IO
 * - 지금까지 console창을 통해 결과물을 출력하고 Scanner를 이용해 입력한 것도 IO의 일부분이다.
 * - 또한 JOtionPane, TextField와 같은 객체를 이용해서 GUI 환경에서도 데이터를 입력받아 사용했다.
 * 
 * - 사용자에게 보여지기 위한 입출력 뿐만 아니라 파일이나, 네트워크를 통한 데이터 입출력도 가능해진다.
 * - 파일을 대상으로한 입출력은 세이브, 로드를 구현할 수 있다.
 * - 네트워크를 통한 입출력은 클라이언트-서버 방식의 프로그램을 구현할 수 있게 된다.
 */
import java.io.*;
public class Source07_Ouput {
	public static void main(String[] args) {
		// 파일 출력을 위한 객체 FileOutputStream
		// 이미 있는 파일 입력(읽어오는)을 위한 객체 FileInputStream
		// Exception 처리가 거의 필수적으로 일어나게 됨.
		
		try {
			FileOutputStream fos = new FileOutputStream("output.data");	// File이나 String 인자값을 가지는 생성자를 보통 사용한다.
			// 파일이 존재하지 않는다면 파일을 생성하고 이미 존재한다면 덮어씌움. 즉, 파일이 없던 있던 새롭게 출력시도를 함.
			fos.write(45);		// 데이터를 내보내고		/ 이 데이터는 컴퓨터가 인식하는 바이트단위의 데이터
			fos.close();		// 작업이 끝나면 파일과 출력을 하기 위해서 시스템으로 연결되어 있는 것을 해제
			System.out.println("try success");
		}catch(FileNotFoundException e ) {							// FileOutputStream은 FileNotFoundException을 처리해야함.
			System.out.println("fail ..." + e.toString());			// 출력할 수 없는 대상을 지정할 때 발생  ex)디렉토리, 관리자 권한
		}catch(IOException e) {
			System.out.println("fail ..." + e.toString());			// FileOutputStream의 write 메소드는 IOException이 필요
		}
	}
}
