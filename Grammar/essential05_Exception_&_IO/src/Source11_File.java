/*
 * 객체 생성시 문자열로 대상을 지정했지만, 내부적으로는 File객체로 바뀌어 작동한다.
 * 
 * File
 * - 시스템상에 존재하는 디렉터리, 파일을 관리하기 위한 객체
 * 
 */
import java.io.*;
public class Source11_File {
	public static void main(String[] args) {
		// 파일 객체 생성은 절대경로로도 가능하고 상대경로로도 가능, 파일 디렉토리 모두 가능.)
		System.out.println(System.getProperty("user.home"));	// 프로그램 사용자의 홈 디렉토리
		System.out.println(System.getProperty("user.name"));	// 프로그램 사용자의 시스템 이름
		File home = new File(System.getProperty("user.home"));	// 문자열객체를 생성하여 파일객체를 잡음.
		File[] ar = new File[] {
			new File("C:\\Users\\kgitbank\\Desktop\\Eclipse"),							// 절대경로
			new File("C:\\Users\\kgitbank\\Desktop\\Eclipse\\smallscissors.png"),		// 절대경로
			new File("bin"),															// 상대경로
			new File(".classpath"),														// 상대경로
			new File("intro.dat"),
			new File("C:\\Users\\kgitbank\\Desktop\\", "Eclipse"),						// 절대경로일시 경로와 파일명을 따로 가능.
			new File(home, "Desktop")													// 프로그램 사용자의 경로를 읽어 그 안의 파일 불러옴.
		};
		
		for(int i=0;i<ar.length;i++) {
			File t = ar[i];
			System.out.println(t.exists() + "? " + t.isDirectory() + " / " + t.isFile());
			System.out.println(t.getAbsolutePath() + " vs " + t.getPath());		// getAbsolutePath 전체경로, getPath는 내가 불러온 경로에 따라 출력
			String name = t.getName();
			String parent = t.getParent();
			long len = t.length();
			System.out.println("name = " + name);				// 파일, 디렉토리의 이름만 출력
			System.out.println("parent = " + parent);			// 경로를 설정하지 않고 상대경로로 생성한 파일들은 parent null
			System.out.println("len = " + len);					// 파일이라면 파일의 크기가 byte단위로 나오는데, 디렉토리의 경우 의미가 없다.
			
			String[] li = t.list();								// 디렉토리인 경우에만 해당하는 것으로 디렉토리 안에 있는 구성을 뽑아 올 수 있다.
			if(t.isDirectory()) {
				System.out.println("li = " + li.length);
				for(String m : li) {
					File child = new File(t, m);
					System.out.println("     " + m + "    " +
					(child.isDirectory() ? "DIR" : "FILE") );
				}
			}
			System.out.println();
			System.out.println();
			
		}
		
		File target = new File(home, ".p2");
		System.out.println(target.isDirectory());
		String p = target.getParent();
		System.out.println(p);
		File fp = target.getParentFile();			// 해당 파일의 부모경로를 파일로 뽑음.
		System.out.println(home.equals(fp) + " / " + (home == fp));		// true
		String[] c = target.list();
		File[] fc = target.listFiles(); 			// 자식들을 File 객체 배열로 만들어 줌
		for(File t : fc) {
			System.out.println(t.getAbsolutePath() + " , " + t.getName() + " , " + t.getParent());
		}
		
		
		
		
		
	
	}
}