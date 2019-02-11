/*
 * Concurrency : 병행
 * - 동시 클라이언트 처리를 위한 Thread
 * - 독자적인 흐름을 가진 또 하나의 메인이라 생각하면 됨.
 * - 지금까지는 single Thread 프로그램임.
 * - 메인의 흐름과 별도로 작동하는 다른 추가 흐름이 필요하다면 객체 설계할 때 Thread를 상속하면 된다.
 */

public class Source01_Thread {
	// 메인의 흐름과 별도로 작동하는 다른 추가 흐름이 필요하다면 객체 설계할 때 Thread를 상속하면 된다.
	public static void main(String[] args) {
		for(char c = '가'; c<'나'; c++) {
			System.out.print(c);
		}
		System.out.println();
		for(char c = '나'; c<'다'; c++) {
			System.out.print(c);
		}
		System.out.println();
	}
}
