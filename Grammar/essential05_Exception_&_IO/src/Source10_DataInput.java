import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Source10_DataInput {
	public static void main(String[] args) {
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("output.data"));
			System.out.println(dis.available());	// 28
			// 저장되어있는 형태에 따라 바이트 규격으로 읽어옴.
			int m = dis.readInt();	// 4바이트씩 읽어옴. 데이터 형태마다 읽어오는 byte가 다름.
			System.out.println("data = " + m);		//4561221
			System.out.println(dis.available());	// 24
			double d = dis.readDouble();			// 8바이트 읽어옴.
			System.out.println("data = " + d);		// 3.14
			System.out.println(dis.available());	// 16
			boolean b = dis.readBoolean();			// 1바이트 읽어옴.
			System.out.println("data = " + b);		// true
			System.out.println(dis.available());	// 15
			String s = dis.readUTF();				// 문자열 부분은 특이함.마킹에 의해 불러옴. / IOException의 계열인 UTFDataFormatException 발생
			System.out.println("data = " + s);		// 홍길동
			System.out.println(dis.available());	// 4
			int i = dis.readInt();
			System.out.println("data = " + i);		// 30
			System.out.println(dis.available());	// 0
		//	dis.readInt();	 						// 읽어낼 데이터가 없으면 IOException의 계열인 EOFException을 출력함.
			dis.close();
			System.out.println("try success");
		}catch(IOException e) {
			System.out.println("fail..! " + e.getMessage());
		}
	}
}
