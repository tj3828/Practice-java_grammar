import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Collections형 객체는 객체타입을 설정하고 사용하는 것을 권장한다. (제너릭 설정때문)
 * 
 * 제너릭 - 사용하고자 하는 타입을 컴파일할 때 결정지을 수 있게 가변 처리해둔 기능
 */
class Box<E>{
	E one;
	E other;
	
	public boolean setData(E e) {
		if(one == null) {
			one = e;
			return true;
		} else if(other == null) {
			other = e;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "one =" + one + ", other = " + other;
	}
}

public class Source04_Generic {
	public static void main(String[] args) {
		Box b = new Box();
	//	b.setData();		// 이때 인자타입은  Object으로 설정됨
		Box<Integer> bb = new Box<Integer>();
		bb.setData(3);		// 이때 인자타입은 Integer로 설정됨
		
		Set<String> filter = new HashSet<>();	// 앞에 설정해두면 뒤에는 생략 가능
		filter.add("nice");	// 문자열 Set이므로 문자열만 저장 가능
		filter.add("good");
		
		//Iterator 또는 enhanced for 사용시 캐스팅을 할 필요 없다.
		Iterator<String> i = filter.iterator();	
		while(i.hasNext()) {
			String n = i.next();	// 바로 String 객체를 얻을 수 있다.
			System.out.println(n + " ... " + n.charAt(0));
		}
		
		for(String o : filter) {
			System.out.println(o + " ... " + o.charAt(0));
		}
		
		
	}
}
