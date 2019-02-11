
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class Source14_ObjectInput {
	public static void main(String[] args) {
		try {
			FileInputStream fos = new FileInputStream("arrays.sav");
			ObjectInputStream oos = new ObjectInputStream(fos);			// Object의 input은 에러발생 가능성있음.
			// 기본적으로 readShort()을 두번 호출하여 4바이트를 확인하여 Object가 있는 파일인지 확인한다.
			// 일종의 Object 파일은 확인가능한 표식 값이 심어져있어 표식 값을 확인하는 작업.
			System.out.println("try success! input ready!");
			System.out.println(oos.available());		// 0

			int[] a = (int[])oos.readObject();				// 무조건 Object형으로 리턴되기 때문에 형변환이 필수
			boolean[] b = (boolean[]) oos.readObject();
			String s = (String)oos.readObject();
			System.out.println(a.length + " / " + a[0]);	// 7 / 4
			System.out.println(b.length + " / " + b[0]);	// 3 / true
			System.out.println(s + " / " + s.matches("[A-Z]{3}"));	// WED / true						// WED
			
			
			System.out.println("input complete...");
			
			// DataInput / Output과 마찬가지로 출력 순서를 모르면 복원할하기가 어렵다.
			// available()로 확인할 수 없어 객체 개수를 모른다면 읽어내기 어려움.
			// 
			
			oos.close();
		}catch(StreamCorruptedException e) {				// Object 파일이 아닌것을 읽었을 때 (필수 처리 x)
			System.out.println("invalid file type .." + e.getMessage());
		}catch(IOException e) {
			System.out.println("fail..." + e.getMessage());
		}catch(ClassNotFoundException e) {					// readObject()의 Exception 처리
			System.out.println("fail..." + e.getMessage());
		}
		
	}
}
