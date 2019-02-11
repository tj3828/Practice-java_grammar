import java.io.*;

public class Source08_DataOutput {
	public static void main(String[] args) {
		// 파일에 출력되어야 하는 형태는 1byte의 수치.
		// 기본 출력 상태로는 원하는 데이터를 저장하여 출력하기 힘듬.
		try {
			FileOutputStream fos = new FileOutputStream("output.data");
			System.out.println("output ready ..." + (fos instanceof OutputStream));
			DataOutputStream dos = new DataOutputStream(fos);	// OutputStream을 상속하는 모든 객체를 생성자로 가능.
																// DataOutputStream은 문자타입에 따른 바이트로 출력 가능				
			dos.writeInt(4561221);	// 4바이트로 출력
			dos.writeDouble(3.14);	// 8바이트로 출력
			dos.writeBoolean(true); // 1바이트로 출력
			dos.writeUTF("홍길동");	// 문자열 을 바이트로 출력
			dos.writeInt(30);
			
			dos.close();
			System.out.println("try data out success!!");
		}catch(IOException e) {		// FileNotFoundException가 IOException을 상속받고 있기 때문에 다형성을 통해 IOException으로 제어가 가능.
			System.out.println("try failed... cause " + e.getMessage());
		}
	}
}
