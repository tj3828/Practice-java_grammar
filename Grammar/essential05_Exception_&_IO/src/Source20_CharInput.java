import java.io.*;

public class Source20_CharInput {
	public static void main(String[] args) {
		File t = new File("exam.log");
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(t)
				);){
			String sum = "";
			for(int i=1; i<=3;i++) {
				int n = isr.read();		// 무조건 완성문자 한개씩을 읽어냄.(무조건 char형태)
				System.out.println(n + " / " + (char)n);
				sum += (char)n;
			}
			char[] c = new char[10];
			while(true) {
				int n = isr.read(c);
				if(n == -1) {			// available 기능 대신
					break;
				}
				sum += new String(c,0,n);
			}
			System.out.println(sum);
		}catch(IOException e) {
			System.out.println("input failed..");
		}
	}
}
