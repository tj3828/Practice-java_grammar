import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * PrintWriter는 BufferedWriter의 업그레이드버전이라 생각하면 된다.
 */
public class Source22_PrintWriter {
	public static void main(String[] args) {
		try {
			OutputStreamWriter osw = new FileWriter("exam.log");
			PrintWriter pw = new PrintWriter(osw);
			pw.println("문자열 출력"); 		// System.out.println과 같이 바로 출력가능
			pw.println("해보자");
			pw.println(Math.PI);
			pw.println(true);
			pw.println(44651);				
			
			pw.close();
			System.out.println("success");
		}catch(IOException e) {
			System.out.println("input failed..");
		}
	}
}
