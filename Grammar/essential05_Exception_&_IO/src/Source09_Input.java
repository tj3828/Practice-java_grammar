import java.io.FileInputStream;
import java.io.IOException;

/*
 * 입력(Input) 작업
 * - 
 */
public class Source09_Input {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("output.data");	
			System.out.println("try success");
			for(int i=0;i<=30; i++) {
				int a = fis.available();		// 읽어낼 수 있는 바이트의 크기
				System.out.print("available = " + a );		// 28,27,26,25.....
				
				int r = fis.read();				// 파일에서 1바이트 읽어낸 값, 읽어내면 파일의 available은 1감소, available이 0이면 read는 -1, 한번 읽으면 다시 못읽음
				System.out.println(" / read = " + r);			// 0,69,153,69,64,,,,,
			}
			fis.close();
		//	fis.read(); 이미 닫힌 stream은 다시 이용 못함.
			
			FileInputStream fiss = new FileInputStream("output.data");
			for(int cnt=1; cnt<=12; cnt++) {
				byte[] b = new byte[3];
				System.out.print("available = " + fiss.available());
				int r = fiss.read(b);	// byte[] 배열로 read하면 b의 길이를 리턴하게 됨, 마찬가지로 available이 0이면 -1리턴 
				System.out.println(" / read = " + r);
			}
			
		}catch(IOException e) {			// 읽을 수 없는 대상(파일이 없거나 디렉토리이거나 접근 권한이 없을 때)을 지정할 때 에러
			System.out.println("catch..!! " + e.getMessage());
		}
	}
}

