/*
 * 필수처리 Exception은 extends Exception으로 객체 설계
 */
class CriticalException extends Exception {
	
}

class Account {
	int balance;
	
	public void addBalance(int a) throws CriticalException {	// 필수처리 Exception은 다음과 같이 처리해야함.
		if(a<0) {
			throw new CriticalException();
		}
		if(a%100 != 0)
			throw new InvalidException();
		balance += a;
	}
}
public class Source04_Exception {
	public static void main(String[] args) {
		Account ac = new Account();
		try {
			ac.addBalance(1000);		// 필수 처리 Exception이기 때문에 Exception 발생시 처리할 내용을 반드시 설계해야함.
			System.out.println("try success");
		}catch(CriticalException e) {
			System.out.println("CriticalException..");
			System.out.println("try fail");
		}
		try {
			Thread.sleep(1000, 10);
			System.out.println("try success");
		}catch(InterruptedException e) {
			System.out.println("try fail");
		}
		
	}	
}
