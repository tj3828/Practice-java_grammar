import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Exerciser02_Server {
	public static void main(String[] args) {
		Set<String> pool = new HashSet<>();
		try {
			ServerSocket server = new ServerSocket(12321);
			Socket socket = server.accept();
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			a : while(socket.isConnected()) {
				String received = (String)ois.readObject();
				System.out.println("[server] received : " + received);
				String[] command = received.split("#");
				switch(command[0]) {
				case "reserve":
					boolean b = pool.add(command[1]);
					if(b) {
						oos.writeObject("true");
						System.out.println("[server] send : " + command[0] + " true");
					} else {
						oos.writeObject("false");
						System.out.println("[server] send : " + command[0] + " false");
					}
					break;
				case "cancel":
					boolean c = pool.remove(command[1]);
					if(c) {
						oos.writeObject("true");
						System.out.println("[server] send : " + command[0] + " true");
					} else {
						oos.writeObject("false");
						System.out.println("[server] send : " + command[0] + " false");
					}
					break;
				case "exit":
					System.out.println("[server] send : " + command[0] + " exit");
					break a;
				}
					
			}
			server.close();
		}catch(ClassNotFoundException | IOException e) {
			System.out.println("[server] network error "  + e.toString()); 
		}
	}
}
