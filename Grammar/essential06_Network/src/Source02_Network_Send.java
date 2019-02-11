import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/*
 * 데이터를 보내는 프로그램!
 */
public class Source02_Network_Send {
	public static void main(String[] args) {
		try(DatagramSocket soc = new DatagramSocket();){
			int port = soc.getLocalPort();		// 자기가 보낼 port 개방
			System.out.println("[시스템] 네트워크 가능! " + port);
			
			String data = "오탁종";
			byte[] b = data.getBytes();
			
		//	InetAddress address = InetAddress.getByName("192.168.10.192");	// 도메인을 적어도 상관없음. 도메인으로 설정시 도메인이 이름, ip주소가 값으로 저장됨.
			SocketAddress address = new InetSocketAddress("192.168.10.199", 62667);
			DatagramPacket packet = new DatagramPacket(b,b.length,address);	// 보내고자하는 데이터를 byte[]로 변환해서 패킷 생성해야함. 또한 목적지도 설정해서 생성시켜야함.
																			// InetAddress : ip관리 객체, port : 번호  이 둘을 합한 객체가 SocketAddress
			soc.send(packet);
			System.out.println("[시스템] 패킷 전송 완료");
			
			// Packet에는 byte[]과 address가 합쳐져있음.
			
			
		}catch(IOException e){
			System.out.println("[시스템] 네트워크 오류! " + e.toString());  
		}
	}
}
