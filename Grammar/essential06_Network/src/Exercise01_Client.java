import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import javax.swing.plaf.synth.SynthSpinnerUI;

/*
 * 사용자에게 배포시킬 프로그램. (Client)
 * 서버측으로 패킷을 보낸후, 서버에서 처리된 패킷을 확인하는 작업.
 * 
 */
public class Exercise01_Client {
	public static void main(String[] args) {
		System.out.println("[client] starting");
		String ip = "192.168.10.192";
		try(DatagramSocket ds = new DatagramSocket();) {
			System.out.println("[client] started");
			
			// mode 설정
			String[] mode = new String[] {"sum", "avg", "max"};
			
			String data = mode[(int)(Math.random()*mode.length)];
			
			int limit = 3+(int)(Math.random()*5);
			// 입력할 데이터 설정
			for(int cnt=1;cnt<=limit;cnt++) {
				int n = (int)(Math.random()*90);
				data += " " + n;
			}
			System.out.println("[client] data : " + data);
			
			// 패킷 전송
			byte[] b = data.getBytes();
			SocketAddress sa = new InetSocketAddress(ip, 54321);
			DatagramPacket dp = new DatagramPacket(b, b.length, sa);
			ds.send(dp);
			System.out.println("[client] request send .. then");
			
			// 서버로부터 온 패킷 receive
			DatagramPacket resp = new DatagramPacket(new byte[1024], 1024);		// dp 패킷은 길이가 정해진 것이므로 재사용하면 크기가 부족하여 데이터가 깨질 수 있다.
			ds.receive(resp);
			System.out.println("[client] response received");
			
			// 받은 패킷 출력
			String result = new String(resp.getData(), 0, resp.getLength());
			System.out.println("[client] result : " + result);
			
			
		}catch(IOException e) {
			System.out.println("send failed... " + e.toString());
		}finally {
			System.out.println("[client] shutdown");
		}
		
	}
}
