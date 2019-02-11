import java.util.HashSet;
import java.util.Set;

/*
 * Set Collection은 Collection간 집합/대규모연산(bulk operation)이 가능하다.
 */
public class Source06_Set {
	static Set<Integer> makeSample(){
		Set<Integer> s = new HashSet<>();
		for(int cnt=1;cnt<=5;cnt++) {
			int n = 1+(int)(Math.random()*13);
			s.add(n);
		}
		return s;
	}
	
	public static void main(String[] args) {
		Set<Integer> s1 = makeSample();
		Set<Integer> s2 = makeSample();
		System.out.println("s1 = " + s1.toString());
		System.out.println("s2 = " + s2.toString());
		
		boolean c = s1.containsAll(s2);				// s1이 s2를 모두 가지고 있나 확인
		System.out.println("containsAll = " + c);	
		
		boolean b = s1.addAll(s2);					// false
		System.out.println(b + " / s1 = " + s1.toString());		// true
		System.out.println(s1.addAll(s2));						// false	/ 변화가 있어야지만 true
		
		boolean c1 = s1.containsAll(s2);	
		System.out.println("containsAll = " + c1);	// true
		
		boolean c2 = s1.removeAll(s2);				// s2값과 같은 것을 s1에서 지움
		System.out.println("removeAll = " + c2);	// true
		boolean c3 = s1.removeAll(s2);				// 지울 것이 없기 때문에 false (차집합)
		System.out.println("removeAll = " + c3);	// false
		
		boolean c4 = s1.retainAll(s2);				// removeAll과 반대로 같은 것만 두고 다 삭제(교집합)
		System.out.println("retainAll = " + c4);  	// true
		boolean c5 = s1.retainAll(s2);				// 삭제된 것이 없어서 false
		System.out.println("retainAll = " + c5);	// false
	}
}
