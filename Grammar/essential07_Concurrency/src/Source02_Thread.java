// - 메인의 흐름과 별도로 작동하는 다른 추가 흐름이 필요하다면 객체 설계할 때 Thread를 상속하면 된다.

class CharPrint extends Thread{
	char start;
	char end;
	public CharPrint(char s, char e) {
		// TODO Auto-generated constructor stub
		start = s;
		end = e;
	}
	
	// 추가 흐름이 작동할 메인이라 생각하면 됨.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(char c = start; c<end;c++) {
			System.out.print(c);
			
		}
		System.out.println();
	}
}

public class Source02_Thread{
	public static void main(String[] args) {
		Thread t = new CharPrint('가', '나');
		// run()을 호출하는 것은 무의미하다.	
		t.start();	// 추가로 처리할 독립적인 작업 실행.
					// run을 실행할 시 Thread의 모든 작업이 종료되고 다음 작업이 진행됨.
		Thread t2 = new CharPrint('나', '다');
		t2.start();
		for(int cnt=1; cnt<=10;cnt++) {
			System.out.println("---" + cnt);
		}
		
		// 결과적으로 t Thread의 모든 작업이 끝나고 다음 문이 실행하는 것이 아니라
		// Thread와 for문이 따로 작업함.
		// 돌아가는 모든 Thread가 끝나야지만 메인이 종료
		// 강제로 stop 시킬수 있는 stop() 메소드가 존재하지만 권장하지 않음. 컴퓨터 강제종료 같은 느낌
	}
}
