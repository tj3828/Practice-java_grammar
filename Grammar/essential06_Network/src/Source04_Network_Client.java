import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP를 이용한 Network 통신
 * - Data교환을 위한 상대방과의 연결확인 작업이 필요함.
 * - 
 */
public class Source04_Network_Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.10.192", 56789);	
			// Socket을 이용하여 통신, DatagrameSocket과 달리 상대방과 1:1로 연결이 유지되는 객체
			// 연결하고자하는 대상의 ip와 port를 설정하여 생성할 수 있다.(port도 상대방의 port)
			// socket 객체가 생성된다면 연결에 성공한 것
			// 한번 시도해서 연결 유무를 체크하는 것이 아니라 여러번 연결시도를 함.
			// 내 port는 랜덤으로 열리게 됨.
			System.out.println("[client] connet to opposite in " + socket.getLocalPort());
			
			InputStream is = socket.getInputStream();	// socket이 생성(연결)이 되면 InputStream 객체를 얻을 수 있다. 상대방에게서 받을 때 사용되는 연결통로(객체)
			OutputStream os = socket.getOutputStream();	// 상대방에게 보낼 때 사용되는 연결통로(객체)
			
			// TCP는 In, Out을 DataIn,Out | ObjectIn, Out | BufferedReader, BufferedWritter, PrintWritter, Scanner로 변경시켜 데이터를 교환할 수 있음.
			
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			
			String req = "join#saan#1q2w3e4r#윤형호";
			dos.writeUTF(req);
			System.out.println("[client] send : " + req);
			
			String resp = dis.readUTF();
			System.out.println("[client] received : " + resp);
			
			System.out.println("[client] done");
		}catch(IOException e) {
			System.out.println("[client] socket error .." + e.toString());
		}
	} 
	
}
