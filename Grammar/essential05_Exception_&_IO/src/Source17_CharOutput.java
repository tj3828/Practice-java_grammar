import java.io.FileOutputStream;
import java.io.IOException;

public class Source17_CharOutput {
	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("output.log");) {
			System.out.println("[SYSTEM] OUTPUT READY .. ");
			
			fos.write(Integer.parseInt("B9", 16));
			System.out.println(Integer.parseInt("B9", 16));
			fos.write(Integer.parseInt("AE", 16));
			System.out.println(Integer.parseInt("AE", 16));
			fos.write(13);
			fos.write(10);
			String d = "문자열 출력";
			byte[] b = d.getBytes();
			fos.write(b);
			
			System.out.println("success");
		}catch(IOException e) {
			System.out.println("exception !! " + e.toString());
		}
	}
}
