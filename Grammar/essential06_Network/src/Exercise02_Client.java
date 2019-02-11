import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Exercise02_Client {
	public static void main(String[] args) {
		// TCP로 가동되는 프로그램 같은 경우엔 매번 연결을 시도하는것이 아니다.
		Scanner cin = new Scanner(System.in);
		System.out.println("[client] input server ip address");
		String ip = cin.nextLine();
		try {
			Socket soc = new Socket(ip, 12321);
			System.out.println("[client] connected to server");
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			System.out.println("[client] established i/o stream");
			
			// 재연결이나, io 재 확보없이, 계속 유지 시킨상테에서 데이터 주고 받으면 된다.
			while(soc.isConnected()) {
				System.out.println("[client] request : ");
				String req = cin.nextLine();
				oos.writeObject(req);
				if(req.equals("exit")) break;
				String resp = (String)ois.readObject();
				System.out.println("[client] response : " + resp);
			}
			soc.close();
		}catch(ClassNotFoundException | IOException e) {
			System.out.println("[client] network error " + e.toString());
		}
	}
}
