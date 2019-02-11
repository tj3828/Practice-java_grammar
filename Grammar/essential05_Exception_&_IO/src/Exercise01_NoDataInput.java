import java.io.FileOutputStream;
import java.io.IOException;
import java.text.FieldPosition;

public class Exercise01_NoDataInput {
	public static void main(String[] args) {
		int r = (int)(Math.random()*456120);
		System.out.println("r = " + r);
		try {
			FileOutputStream fos = new FileOutputStream("number.dat");
			
			while(r>0) {
				fos.write(r%10);
				r /=10;
			}
			fos.close();
			System.out.println("data output comlete");
		}catch(IOException e) {
			System.out.println("output failed");
		}
	}
}
