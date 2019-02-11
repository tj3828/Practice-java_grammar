import java.util.HashSet;
import java.util.Set;

class Position {
	int x;
	int y;
	
	public Position(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;								
	}
	
	@Override
	public String toString() {
		return "[x= " + x + ", y= " +y + "]"; 
	}
	
	// 2. hashCode()가 같을 때 데이터 값을 비교하기위해 equals메소드 오버라이드
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals called ....!!!");
		if(obj instanceof Position) {
			Position other = (Position)obj;
			return this.x == other.x && this.y == other.y;
		} else {
			return false;
		}
	}
	
	// 1. hashCode()의 리턴값을 수정해야한다.
	@Override
	public int hashCode() {
		System.out.println("hashCode called ....!!!");
		return x*y;		// 실제로 가진 데이터가 달라도 같은 hashCode가 만들어질 수 있음. 그러므로 최대한 안겹치게 복잡하게 설정해야함.
	}
}
public class Source08_Duplicate {
	public static void main(String[] args) {
		// Set Collection이 같은 객체를 저장하지 않는다는 것을 이용해 처리
		Set<Position> ps = new HashSet<>();
		Position p = new Position(1, 1);
		ps.add(p);				
		
		while(ps.size()<7) {
			int rx = (int)(Math.random()*4);
			int ry = (int)(Math.random()*4);
			Position p1 = new Position(rx, ry);
		//	System.out.println(p1.toString() + " / " + p1.hashCode() + " / " + System.identityHashCode(p1));	// 기존에는 객체 고유값과 해쉬코드가 동일하게 설정되어 있다.
			System.out.println("Before ADD !");
			boolean b = ps.add(p1);		
			// add() 메소드 호출시에 hashCode 확인 작업이 일어남(없으면 무조건 저장) -> 
			// hashCode이 같으면 2차 확인을 위해 equals() 메소드 호출(false면 hashcode만 같고 실제로는 다른 객체라 생각하여 저장) -> 
			// 이 마저도 같으면 같은 객체라 판단
			
			System.out.println("After ADD !");
			System.out.println(b);
		}
		
		System.out.println(ps.toString());	// 같은 객체값은 저장을 안하는데 만약에 실제 객체 값이 달라도 가지고 있는 데이터가 같아서 같게 판단하고 싶을 때는 hashCode를 오버라이드.
		
		// 결론 : 객체가 같다고 판단하기 위해서는 hashCode()와 equals()를 맞춰줘야함.
		
	}
}
