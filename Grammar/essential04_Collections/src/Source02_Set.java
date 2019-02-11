import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*
 * Collections형 객체들의 분류 4가지 계열 (java.util패키지에 있는 interface)
 *  - Set, List, Queue (Collection 인터페이스를 상속) 
 *    - Set : HastSet, TreeSet, LinkedHashSet
 *    - List : Vector, ArrayList, LinkedList
 *    - Queue : ArrayQueue
 *    - 가지고 있는 기능은 거의 다 같다.
 *    
 *    
 *  - Map (Collection 인터페이스를 상속하진 않지만 같은 계열이라 칭함) : 
 *    - Hashtable, HashMap
 *    
 *  - Set : 데이터를 중복으로 저장할 수 없음
 *        - HashSet : 가장 빠른 연산을 처리하지만, 순서보장 x
 *        - TreeSet : 크기에 따른 정렬을 지원하지만, HashSet 보다는 연산이 느림.
 *        - LinkedHashSet : 들어간 순서가 유지되지만, HashSet보다는 연산이 느림.
 *        - Set형 컬렉션은 더 많이 존재 
 */
public class Source02_Set {
	public static void main(String[] args) {
		Set set;
	//	set = new LinkedHashSet();
		set = new HashSet();
	//	set = new TreeSet();
		
		// <> : 어떤 객체값을 저장할것인지 설정하고 설계하는 것을 권장하는데 미 설정시 Object로 설정됨.
		
		int size = set.size();					// 관리 중인 객체의 수
		System.out.println("size = " + size);	// 0
		
		boolean b = set.isEmpty();				// set에 저장된 객체가 있는지 없는지
		System.out.println("isEmpty = " + b);	// true
		
		boolean t = set.add("월요일");			// 객체 저장
		System.out.println(t);					// true
		boolean t1 = set.add("월요일");			// 중복 객체 저장안함
		System.out.println(t1);					// false
		
		int[] ar = new int[3];
		boolean t3 = set.add(ar);
		System.out.println(t3);					// true
		System.out.println("size = " + set.size());	// 2	/ 월요일 객체와 ar int배열 2개
		
		boolean t4 = set.contains(ar);			// set 객체에 ar객체가 존재하는지 검사
		System.out.println(t4);					// true
		
		System.out.println(set.contains("금요일"));	// false
		
		boolean t5 = set.remove(ar);			// 해당 객체 삭제
		System.out.println(t5);					// true
		
		set.clear();							// 모든 객체 삭제 (void 반환형)
		System.out.println(set.size());			// 0
		
		for(int i=0;i<=100000; i++) {			// 메모리만 허용한다면 개수 제한은 없다
			int[] z = new int[5];				// 자바를 사용하면서 사용할 수 있는 메모리 제한이 있기 때문에 배열 크기를 50000으로 한다면 터짐
			set.add(z);
		}
		System.out.println(set.size());
	}
}
