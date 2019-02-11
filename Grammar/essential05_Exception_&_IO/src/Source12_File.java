import java.io.File;
import java.io.IOException;

public class Source12_File {
	public static void main(String[] args) {
		// File 객체를 통해서 프로그램적으로 파일시스템을 제어할 수 있다.
		File root = new File("C:\\data\\temp\\");
		
		File t = new File(root, "storage");
		System.out.println(t.getAbsolutePath() + " , " + t.exists());
		boolean f = t.mkdir();				// 디렉토리가 없다면 해당 디렉토리 생성, 이미 만들어져있거나 만들수있는 권한이 없는 장소, 경로가 잘못되었을 때 false
		System.out.println(f);
		System.out.println(t.getAbsolutePath() + " , " + t.exists());
		
		// mkdir보다는 mkdirs를 더 많이 활용된다.
		// 경로가 잘못됬을 때 자동으로 경로에 따른 디렉토리를 생성해준다.
		
		File a = new File(t, "data.sav");
	/*	
		// 파일생성
		try {
			boolean r = a.createNewFile();		// 해당 파일을 만든다.
			System.out.println(r);
		}catch(IOException e) {
			System.out.println();
		}
	*/
	//	boolean rf = a.renameTo(new File(a.getParentFile(), "data2.sav"));		// 파일의 이름을 변경
		boolean rf = a.renameTo(new File(root, a.getName()));					// 파일의 이름을 변경하는 것이 아니라 새로운 파일을 생성하고 기존의 파일을 생성하는 것.
		System.out.println("renameTo = " + rf);
		boolean rf1 = root.renameTo(new File("c:\\", root.getName()));
		System.out.println(rf1);
		
		File tt = new File("c:\\temp", "storage");		// 자식 디렉토리가 있는 경우 삭제가 안됨.
		boolean z = tt.delete();
		System.out.println(z);
	}
}
