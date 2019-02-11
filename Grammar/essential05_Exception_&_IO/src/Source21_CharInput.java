import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Source21_CharInput {
	public static void main(String[] args) {
		File f = new File("exam.log");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));){
		// BufferedReader br = new BufferedReader(new FileReader(f));
			while(true) {
				String s = br.readLine();				// 한 줄씩 읽어올 수 있는 기능을 가짐. 13,10 앞까지의 char를 모아 문자열로 반환(13,10은 무시, 라인갱신바이트)
				if(s == null) break;
				System.out.println(s);
			}
		}catch(IOException e) {
			System.out.println("input failed ..");
		}
	}
}
