import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Source06_Exception {
	public static void main(String[] args) {
		/*
		 * 객체 사용이 완료되고 나면, 안정성을 위해 특정작업을 꼭 처리하는 걸 권장하는 것들이 있다.
		 */
		Scanner cin = new Scanner(System.in);
		try {
			System.out.print("SYSTEM> ");
			String line = cin.nextLine();
			String[] ar = line.split(" ");
			int s=0;
			for(String a : ar) {
				s += Integer.parseInt(a);
			}
			System.out.println("SUM = " + s);
		} finally {
			cin.close();			// 중간에 입력된 값이 의도치 않는 값이 아니라면 오류발생시에도 무조건 일어나야할 작업을 설계할 수 있음.
			System.out.println("Scanner closed");
		}
		
		// 입출력 객체들은 보통 Closeable을 토대로 만들어져 있기 때문에 close()작업을 해주는 경우가 대반사
		try(CustomScanner cs = new CustomScanner();) {	// try에 ()에서 생성하여 사용한 객체들은 자동으로 close()까지 콜됨.
			cs.nextLine();
			cs.nextLine();
			if(Math.random()>0.0) {
				throw new RuntimeException();			// Exception이 발생해도 자동으로 close 작업이 일어남.
			}
		}
	}
}

class CustomScanner implements AutoCloseable {

	public String nextLine() {
		return "....";
	}

	@Override
	public void close() {
		System.out.println("CustomScanner.close()");		
	}
	
	
}
