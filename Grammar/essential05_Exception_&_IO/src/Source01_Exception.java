/*
 * ## IO
 * - 파일을 통해서 데이터를 관리하게 될 때 이용하는 것
 * - 세이브되어있던 파일을 로드하거나 파일을 생성하여 저장하는 과정을 다룸
 * - 이때 사용되는 객체들은 Exception(예외) 처리를 알아야 사용할 수 있음.
 * 
 * ## Exception 처리
 * - 특별히 기능적으로 어떤것들을 처리하기 위해서 설계된 객체는 아님.
 * - JVM 실행을 멈출 수 있는 능력이 있는 객체 
 * - 몇가지 기능을 사용할 때에는 개발자가 직접 Exception 처리를 반드시 해주어야한다.
 * - 무의미한 처리를 하지 않아도 된다는 장점.
 * - 객체를 쓰는 개발자 입장에서 특정 객체를 사용할 때 좀 더 안전한 프로그램을 만들어내도록 유도할 수 있다.
 * 
 */
public class Source01_Exception {
	public static void main(String[] args) {
		String str = "string";
		System.out.println("main...start");
		RuntimeException re = new RuntimeException();
		System.out.println("exception create");
		if(Math.random() > 0.5) {
		//	throw str;	// 컴파일 실패
			throw re;	// throw, Exception 객체들에만 설정할 수 있는 키워드	
						// throw를 사용시 Exception 객체가 작동되고 JVM이 위험감지해서 바로 종료.
		}
		

		System.out.println("main...end");
	}
}
