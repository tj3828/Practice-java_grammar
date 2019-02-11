/*
 * Exception은 자바의 버전이 올라갈 수록 계속 추가되고
 * 개발자가 개인적으로 만들어 사용할 수도 있기 때문에 외우는건 불가능.
 */
class InvalidException extends RuntimeException {	// try catch를 안해도 되는 Exception
	
}

class ImpossibleException extends RuntimeException {
	
}

class Triangle {
	int x,y,z;
	
	Triangle(int x, int y,int z){
		if(x<=0 || y<=0 || z<=0) {
			throw new InvalidException();
		}
		int a = Math.max(Math.max(x, y), z);
		int b = x+y+z - a;
		if(b<=a) {
			throw new ImpossibleException();
		}
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}

public class Source03_Exception {
	public static void main(String[] args) {
		try {
		//	new Triangle(1, 2, -2);		// ImpossibleException 발생
			new Triangle(1, 2, 1);
		} catch(InvalidException e) {
			System.out.println("InvalidException...");
		} catch(ImpossibleException e) {
			System.out.println("ImpossibleException...");
		}
		
		try {							// 다음과 같이 처리가능
		//	new Triangle(1, 2, -2);		// ImpossibleException 발생
			new Triangle(1, 2, 1);
		} catch(InvalidException | ImpossibleException e) {
			System.out.println("InvalidException... | ImpossibleException...");
		} 
	}
}
