/*
 * java.lang.Object 객체란
 * 클래스가 다른 클래스를 상속하고 있지 않다면 디폴트로 Object 객체를 상속한다.
 * 그렇기 때문에 무조건 가질 수 밖에 없다.
 * 만약 다른 클래스를 상속하고 있다면 그 클래스 또한 다른 클래스를 상속하던가 아니면 Object를 상속하기 때문에 결과적으로 무조건 상속되어 있는 구조가 된다.
 * 
 */

class Sword {
	int atk;
	
	Sword() {
		super();                         // 모든 클래스는 기본적으로 Object를 상속하기 때문에 에러가 발생하지 않는다.
		atk = 30;
	}
	
	boolean enchant() {
		if(Math.random()>0.8) {
			atk *= 1.1;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "Sword! ATK = " + atk;
	}
}

public class Source03_Object {
	public static void main(String[] args) {
		Sword s = new Sword();
		boolean b = s.enchant();
		System.out.println("b = " + b);
		System.out.println(s.atk);
		
		String str = s.toString();
		System.out.println("str = " + str);
		int c = s.hashCode();
		System.out.println("d = " + c);
		Sword s2 = s;
		System.out.println("equals? " + s.equals(s2));               // Object의 equals 호출
		
		System.out.println(s2.toString());                           // toString 오버라이드
		
		/*
		 * 객체라면 어쩔 수 없이 가지게 되는 Object로부터 받는 기능은 반드시 설계해야하는 것은 아니지만 해두면 좋은 기능들이 있다. (오버라이드)
		 * 
		 * 1. public String toString() : 객체 상태를 문자열로 만들어 반환 / 디폴트 : 객체명@해시코드(16진 값)
		 * 
		 * 
		 */
		Object ob = new Sword();
		System.out.println(ob.toString());                           // Object는 상위타입이기 때문에 객체 생성 가능하다.
		
		Sword s3 = new Sword();
		System.out.println(s3);                                      // Sword 클래스에 toString을 오버라이드해서 설계했다면 syso에서 객체만 넣어도 자동으로 toString을 호출한다.
																	 // 괄호 안에서 Ctrl+space 눌러보면 들어갈 수 있는 타입에 따라 오버로딩이 되어있는데 모든 클래스는 Object에 상속되어
																	 // 있기 때문에 자동으로 Object 파라미터의 메소드를 호출하게 된다.
		
		
	}																			
}
