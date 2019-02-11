import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

/*
 * 이제까지 만들어본 프로그램 형태와는 다르게, java.net 패키지를 이용하여 기계적으로 연결되어 있지 않은 서로 다른 머신간에 데이터를 주고받는 네트워킹 작업에 대하여 알아보자.
 * 
 * 네트워크를 이용한 데이터 전송 방식
 * - TCP : 통화방식 (서로 먼저 연결을 하고 그 후에 데이터를 주고 받는것, 더이상 주고 받을 데이터가 없다면 연결을 끊으면 됨.)
 * - UDP : 문자방식 (별도의 연결과정 은 필요없고 상대방의 주소만 알고 있다면, 데이터를 보낼 수있다.)
 * - UDP에 비해 TCP가 안정적.(UDP는 상대방이 데이터를 받았나 확신이 없음.)
 * - UDP는 TCP의 단점을 보완하기 위해 만들어진 방식 (ex. 속도, 방식)
 * 
 * 프로그래머는 실제 전송원리보다는 전송방식의 특징과 방식에 따른 사용법을 알고 있으면 된다.
 * 
 * 대부분 네트워크 전송은 TCP를 베이스로 잡고 설계하는 경우가 많다.
 * 하지만 구현자체는 UDP가 쉽다.
 */

public class Source01_Network {
	public static void main(String[] args) {
		/*
		 * UDP방식으로 원격 컴퓨터로부터 데이터 전송을 받아 전송받은 데이터를 확인해보는 작업.
		 */
		System.out.println("[시스템] 스타트");
		
		/*
		 * UDP 방식은 DatagramSocket, DatagramPacket 객체만 이용하면 되기 때문에 쉽다.
		 * - DatagramSocket : 송수신기(메신저역할)
		 * - DatagramPacket : 문자역할
		 */
		
		// try with resource
		DatagramSocket socket = null;
		try {	
			socket = new DatagramSocket(45454); 	// 생성자의 인자값으로 port번호를 결정해줌, 기본 생성자로는  port 번호를 자동 생성(1~65535)
													// 이미 사용중인 포트 : BindException, 음수 : IllegalArgumentException, 0 : 자동 생성
													// 포트번호를 고정해야 계속해서 전달 받을 수 있다.
			int port = socket.getLocalPort();
			System.out.println("[시스템] 소켓 확보됨! " + port);
			
			// 받는 작업
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);	// byte 배열과 길이 값을 설정해주어야함.
			System.out.print("[시스템] 수신대기!..");
			socket.receive(packet);			// 데이터가 날라올 때까지 기다리고 있음. 
			System.out.println("완료");		// 데이터가 전달되어야 풀림.
			SocketAddress addr = packet.getSocketAddress();			// 발신자의 SocketAddress를 얻을 수 있다.
			System.out.println("[시스템] 수신된 패킷 " + packet.toString());
			
			byte[] b = packet.getData();
			int len = packet.getLength();		// 실제 받은 byte[]의 길이가 나옴.
			
			// byte[] -> String -> parse or split
			String s = new String(b,0,len);		// byte[]을 문자열화
			System.out.println(s);
			System.out.println("누가 보냈어 : " + addr);
			
			

		}catch(SocketException e) {
			System.out.println("[시스템] 소켓 오류!" + e.toString());
		}catch(IOException e) {
			System.out.println("[시스템] 소켓 오류!" + e.toString());
		}finally {	
			if(socket != null)
				socket.close();
		}
		
	}
}
