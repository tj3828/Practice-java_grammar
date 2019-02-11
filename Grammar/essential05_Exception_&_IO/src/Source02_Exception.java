import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * Exception이 발생하는 종류에 따라 여러가지 클래스들이 설계되어있다.
 *  - IndexOutOfBoundsException, NullPointerException ....등
 *  
 *  크게 두 가지 분류로 나눌 수 있다.
 *   1. 반드시 예외처리를 하지 않아도 되는 Exception (IllegalArgumentException, RuntimeException,
 *   	- 반드시 예외처리를 하지 않아도 되는 Exception은 JVM에 크게 악영향이 없고, if와 같은 방식으로 프로그래밍적으로 막아낼 수 있는 것들이 많음.
 *   2. 반드시 예외처리를 해야하는 Exception (IOException, UnknowndHostException ...)
 *   	- 반드시 예외처리를 해야하는데 안한다면 객체 사용 불가
 *   	- 실제 가동이 되어서 결과로만 아는 예외들로, 프로그램적으로 막아내지 못하고 실행이 어디서 되냐에 따라서 발생할 수도 있고, 아닐수도 있는 예외들
 *   	- JVM쪽으로 접근하는 것을 막아야만 하는 것들, 
 *  	ex)
 *   Socket의 경우 맞는 ip주소와 port 번호로 접근해도 외부 환경에 따라 접속 못할 경우에 발생하는 IOException
 */

public class Source02_Exception {
	public static void main(String[] args) {
		String str = null;	
	//	System.out.println(str.length());	// NullPointerException 발생
		List<String> li = new ArrayList<>();
	//	li.add(3, "월요일");					// IndexOutOfBoundsException 발생
		/*
		 * add를 타고 들어가면 rangeCheckForAdd()에 Exception처리를 해두었다.
		 */
		try {
			new Socket("192.168.10.27", 135);	// 네트워크 통신할 때 사용하는 객체인데 다양한 Exception이 발생한다.
												// UnknownHostException, IllegalArgumentExceptionm, IOException 등 발생..
			System.out.println("객체 생성 성공");
		}catch(UnknownHostException e) {		// Socket 첫 번째 인자에 이상한 패턴의 주소를 입력하면 터짐.
			System.out.println("UnknownHostException");
		}catch(IOException e) {
			System.out.println("IOException");
		}
	//	catch(IllegalArgumentException e) {	// java.lang 패키지이기 때문에 import안해도 사용가능
			// 입력하지 않아도 발생함. 음수의 Port를 넘겼을 시
	//	}
		
		System.out.println("메인 종료");
	}
}
