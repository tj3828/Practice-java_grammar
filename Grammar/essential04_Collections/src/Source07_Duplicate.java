import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Set - 중복 객체 저장하지 않는다.
 */
public class Source07_Duplicate {
	public static void main(String[] args) {
		Set<Integer> s = new LinkedHashSet<>();
		s.add(3);
		s.add(Integer.valueOf(3));
		System.out.println(s.size());	// 같은 객체이므로 size = 1
		s.add(new Integer(3));			// 객체값이 다른 객체를 생성
		System.out.println(s.size());	// 객체값이 달라도 조건 만족시 같은 객체라고 인식한다. size = 1 / Integer객체는 그 처리가 되어있음.
		
		Integer i1 = new Integer(31);
		Integer i2 = new Integer(31);
		System.out.println(i1 == i2);	// false
		System.out.println(s.add(i1));	// true
		System.out.println(s.add(i2));	// false	/ == 로 판단하는 것이아니라 equals와 hashcode로 판단하도록 되어있음.
		System.out.println(i1.equals(i2));
		System.out.println(i1.hashCode() + " , " + i2.hashCode());	// hashcode는 객체가 생성될 때 부여하도록 되어있음.
		/*
		 * Integer의 hashCode()는 오버라이드를 이용해 hashCode를 자신의 int 값을 반환하도록 재정의해놨음.
		 */
		System.out.println(System.identityHashCode(i1) + " , " + System.identityHashCode(i2));	// identityHashCode는 절대 고유값
		
		// 종종 기본적으로 생성하여 자바에서 제공하는 클래스는 이러한 처리가 되어있음.
		// 개발자가 필요에 의해서 설계하는 객체의 경우엔 수동으로 처리해야함.
	}
}
