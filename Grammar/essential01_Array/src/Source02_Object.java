/*
 * 자바에서 개발자가 사용할 수 있는 객체들은 모두 패키지 처리가 되어 있다.
 * java.lang 패키지 소속의 객체들은 import 처리를 하지 않아도 사용할 수 있다.
 * 
 */

import java.lang.Object;						// Ctrl + 객체를 선택하고 external file에서 jdk의 src.zip파일을 선택하면 객체가 설계된 코드를 볼 수 있다.

public class Source02_Object {

	public static void main(String[] args) {
		Object obj = new Object();
		
		String s = obj.toString();
		System.out.println("s = " + s);
		int c = obj.hashCode();
		
		System.out.println("c = " + c);
		
		Object obj2 = new Object();
		boolean b = obj.equals(obj2);
		System.out.println("b = " + b);
		obj2 = obj;
		boolean b2 = obj.equals(obj2);
		System.out.println("b2 = " + b2);
				
	}

}
