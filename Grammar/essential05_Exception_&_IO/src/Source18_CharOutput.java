import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Source18_CharOutput {
	// 사람이 읽을 수 있게 문자열을 바이트화 하여 하나하나 계산하는 것은 너무 비효율적.
	// 하지만 복원을 하기위한 기능은 아니고 출력만하여 사용자가 읽을 수 있게 하는 기능.
	// OutputStreamWriter, InputStreamReader 객체를 이용하면 해결
	// 보통 OutputStreamWriter를 BufferedWriter로 바꾸어 출력한다.
	// 다 같은데 줄바꿈 기능을 가지고 있다.
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("output.log");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write("그룹데이터 v1.0");
			bw.newLine();
			bw.write("========================================");
			bw.newLine();
			bw.write("# 밀짚모자 #");
			bw.newLine();
			bw.write("-> 루피");
			bw.write("조로 나미");
			bw.newLine();
			bw.newLine();
			bw.write("# 빅맘 #");
			
			
		/*	osw.write('문');
			char[] data = new char[] {'자', '열', '출', '력', '!', '!'};
			osw.write(data);
			osw.write(13);
			osw.write(10);
			osw.write("[SYSTEM] 문자열 출력");
		*/	
			
			System.out.println("success");
		//  osw.close();
			bw.close();
		}catch(IOException e) {
			System.out.println("exception !! " + e.toString());
		}
	}
}
