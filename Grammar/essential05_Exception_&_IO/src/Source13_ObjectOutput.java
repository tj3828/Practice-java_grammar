import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * ObjectInput / OutputStream을 이용해서 객체를 입출력해보자.
 * - 기본데이터 입출력만으로는 너무 한계가 크다.
 */
public class Source13_ObjectOutput {
	public static void main(String[] args) {
		int[] data = new int[] {4, 1, 49, 15, 11, 6, 2};
		boolean[] flag = new boolean[] {true, true, false};
		String day = "WED";
		try {
			FileOutputStream fos = new FileOutputStream("arrays.sav");
			ObjectOutputStream oos = new ObjectOutputStream(fos);		// 내용이 없더라도 4바이트 파일로 약간의 출력이 생기면서 파일 생성
			System.out.println("try success! output ready!");
			
			oos.writeObject(data);			// 객체를 출력시키면, 자동으로 복원할 수 있는 형태로 해당 객체를 출력해놓음.
			oos.writeObject(flag);
			oos.writeObject(day);
			
			System.out.println("output complete...");
			
			oos.close();
		}catch(IOException e) {
			System.out.println("fail..." + e.getMessage());
		}
	}
}
