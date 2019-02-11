import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Source16_Serializable {
	public static void main(String[] args) {
		try {
			String str = System.getProperty("user.home");
			File dir = new File(str, "Source15");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(dir, "v해적왕v")));
			User u = (User)ois.readObject();
			System.out.println(u.toString());
			ois.close();
		}catch(IOException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
}
