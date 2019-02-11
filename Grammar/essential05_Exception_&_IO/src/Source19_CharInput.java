import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Source19_CharInput {
	public static void main(String[] args) {
		// 파일에 적혀져있는 값들은 읽어서 문자로 만들어 확보가능하다.
		File t = new File("exam.log");
		try(FileInputStream is = new FileInputStream(t);){
			byte[] ar =  new byte[512];			// 적당한 크기의 byte 배열로 받아 문자열로 변환하면 읽을 수 있다. 크기를 작게 생성하면 깨질 수 있다.
			String  s = "";
			while(is.available()>0) {
				int len = is.read(ar);
				s += new String(ar,0,len);		// 길이 생성없이 ar만 인자로 준다면 이전에 사용했던 바이트의 값이 남아있기 때문에 문자가 더 찍힌다.
												// 마지막에 바이트를 읽어올 때 크기가 작기 때문.
			}
			System.out.println(s);
		}catch(IOException e) {
			System.out.println("input failed..");
		}
	}
}
