import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Source04_Network_Server {
	public static void main(String[] args) {
		try {
			System.out.println("[server] starting");
			// Client에서 발생한 socket을 연결하는 작업. Client와 Server측에서 둘다 new Socket을 한다면 연결 불가능.
			// 한쪽에서는 ServerSocket을 사용.
			// Socket의 연결요청을 받아주는(준비만하는) 객체
			ServerSocket server = new ServerSocket(56789);	// 생성만으로 연결을 다받아주진 않는다. 연결 받을 port에 binding한다. (자기 자신(서버)의 port 지정)
			System.out.println("[server] bind at " + server.getLocalPort());
			
			Socket socket = server.accept(); 	// 해당 port로 들어오는 socket의 연결을 기다리고 연결되면 socket 객체를 만들어냄.
												// UDP에서 receive 메소드를 통해 올 때까지 기다리는 작업과 비슷.
			
			System.out.println("[server] connected by opposite ");
			System.out.println("[server] local : " + socket.getLocalSocketAddress());		// 서버 ip와 port
			System.out.println("[server] remote : " + socket.getRemoteSocketAddress());		// Client가 보낸 ip와 port
			
			// 전송측에서 데이터를 보내기위해 사용한 stream과 같은 것을 사용해야 받을 수 있다.
			// DataOutput으로 전송했기 때문에 DataInput으로 받아야함.
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			// Client가 DataInput으로 전달받기 때문에 DataOutput으로 전송해야 좋다.
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			String req = dis.readUTF();
			System.out.println("[server] received : " + req);
			String resp = "success";
			dos.writeUTF(resp);
			System.out.println("[server] send : " + resp);
			
			
		}catch(IOException e) {
			System.out.println("[server] main error " + e.toString());
		}
	}
}
