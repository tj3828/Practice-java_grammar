import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Source05_Exception {
	public static void main(String[] args) {
		/*
		 * 1. 에러메세지 찍어두고 프로그램 종료.(네트워크에서 연결이 안되면 뒤 작업은 무의미함)
		 * 2. 에러 상황일 때는 다른식으로 작동할 수 있게 유도
		 */
		
		Socket s = null;
		try {
			s = new Socket("192.168.10.27", 5040);
			System.out.println("try success");
		}catch(UnknownHostException e) {
			System.out.println(e.getMessage());	// Exception 발생시 원인에 대한 메세지 출력
			System.exit(0);
		}catch(IOException e) {
			System.out.println(e.toString());
			System.exit(0);
		}
		
		System.out.println(s.isConnected());
		
		Triangle t = null;
		try {
			t = new Triangle(1, 2, 1);
			System.out.println("try success");
		}catch(ImpossibleException e) {
			System.out.println("try fail");
			t = new Triangle(1, 1, 1);		// 다른 것으로 대체해서 연결
			
		}finally {
			System.out.println("finally object = " + t);	// try와 catch 작업이 끝난 후에 무조건 작동해야하는 작업을 설정 finally
		}
		System.out.println(t.toString());
	}
}
