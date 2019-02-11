/*
 * 2. public boolean equals(Object obj) : Object에서의 equals는 객체가 같은 주소을 가진 것인지 확인하도록 설계되어 있지만 보통 데이터가 같은 것인지 확인하기 위해 오버라이드하여 사용한다.
 * 										  대부분의 데이터를 중요시하는 클래스는 equals를 오버라이드하여 데이터 비교로 재정의한다.
 */

import java.awt.Rectangle;   // lang만 import 필요없음.
import sample.Coord;


public class Source04_Object {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10,20,100,100);
		System.out.println(r1);                             // Rectangle 클래스 안에 toString이 오버라이드 되어 있다.
		
		Rectangle r2 = new Rectangle(10, 20, 100, 100);
		System.out.println(r1 == r2);                       // 재정의하지 않는다면 객체로만 비교하기 때문에 false
		
		boolean b = r1.equals(r2);
		System.out.println(b);								// equals가 Rectangle 클래스 안에 재정의 되어있기 때문에 값을 비교하여 boolean 반환
															
		//============================================================
		
		Coord c = new Coord(3, 2);
		System.out.println(c);
		Coord c2 = new Coord(3, 2);
		System.out.println(c == c2);
		boolean bb = c.equals(c2);
		System.out.println(bb);
		
		Object o = new Coord(11, 5);
		System.out.println(o instanceof Coord);   // true;
		Coord t = (Coord)o;             // 객체의 캐스팅
		t.isDuplicated(c2);             // true
		
		Object o1 = new Coord(11, 5);
		o1 = null;
		
		// finalize() 사용
		o = null;
		System.gc();
		
		int n = 0;
		for(;;) 
			n++;
		
	}

}
