import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Source03_Set {
	public static void main(String[] args) {
		Set set;
		if(Math.random()>0.666) {
			System.out.println("HashSet()");
			set = new HashSet<>();					// 비어있는 공간에 그냥 저장하는 구조이기 때문에 연산속도 빠름.하지만 순서 x
		} else if(Math.random()>0.5) {
			System.out.println("TreeSet()");
			set = new TreeSet<>();					// 크기순으로 객체 확보
		} else {
			System.out.println("LinkedHashSet()");
			set = new LinkedHashSet<>();			// 들어간 순서대로 학보
		}
		
		System.out.println(set.add("조운"));
		System.out.println(set.add("관우"));
		System.out.println(set.add("조조"));
		System.out.println(set.add("조운"));			// 동일한 객체이므로 false
		System.out.println(set.add("사마의"));
		System.out.println(set.add("하후돈"));
		System.out.println(set.add("여포"));
		System.out.println(set.size());				// 6
		System.out.println(set.toString());			// [조운, 관우, 조조, 사마의, 하후돈, 여포]	/ 생성된 Set의 종류에 따라 순서와 정렬이 달라짐.
		
		
		// Set에 설정된 객체값을 뽑아서 제어하는 3가지 방법
		
		// 1.toArray
		Object[] ar = set.toArray();				// 내부 관리 객체를 배열에 옮겨 담아줌.
		for(int i=0;i<ar.length;i++) {
			String s = (String)ar[i];
			System.out.println(s);				// set<>이 미설정 이기 때문에 Object 배열로 모두 생성됨. 만약 객체 타입을 알고 있다면 캐스팅해서 사용.
		}
		
		// 2.Iterator : 컬렉션에 저장된 객체에 접근하기 위한 커서 역할
		Iterator i = set.iterator();	
		for(int cnt=1;cnt<=6;cnt++){
			System.out.println(i.hasNext());
			Object o = i.next();
			i.remove();
			System.out.println(o);
		}
		System.out.println("set.isEmpty? " + set.isEmpty());
		for(Iterator li = set.iterator(); li.hasNext(); ) {
			String o = (String)li.next();
			System.out.println(o);
		}
		
		// 3. enhanced for (Iterator를 자동으로 설정해서 돌려주는 for)
		for(Object obj : set) {
			System.out.println(obj);
		}
		
		
	}
}
