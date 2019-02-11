import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
 * Set의 단점
 * - 중복데이터를 제거하면서 객체를 모이기는 편하나
 * - 나중에 그 집합안에서 특정객체를 다이렉트로 확보해서 사용하기 힘들다.
 * 
 * List
 * - 중복객체를 저장을 허용하고 특정객체의 위치를 알려주고 위치를 안다면 바로 객체를 확보할 수 있다.
 * 
 * - 기본적인 사용은 Set과 List가 거의 같다.
 */
public class Source10_List {
	public static void main(String[] args) {
		List<String> li;
		// List에서 자주쓰는 종류 3가지
	//	li = new Vector<>();			// Collection이 만들어지기 전에 생성된 클래스 	/ Collection 은 1.2버전부터, Vector는 1.0버전
	//	li = new ArrayList<>();			// 배열기반으로 Vector의 문제점을 개선시켜 만든 객체
	//	li = new LinkedList<>();		// Vector와는 다른 형태로 객체를 관리하기 위해 만든 객체 (배열 기반 x)
		
		li = new Vector<>();	
		System.out.println(li.size());		// 0
		System.out.println(li.isEmpty());	// true
		
		String s = "컬렉션";
		System.out.println("add = " + li.add(s));			// true
		System.out.println("contains = " + li.contains(s));	// true
		System.out.println("remove = " + li.remove(s));		// true
		
		System.out.println("add = " + li.add(s));
		System.out.println("add = " + li.add(s));
		System.out.println("add = " + li.add("collections"));
		System.out.println("add = " + li.add(s));
		System.out.println("size = " + li.size());			// 4	/ 중복 허용
		
		li.iterator();
		for(String m: li) {
			System.out.println("--" + m);
		}
		
		int idx = li.indexOf("collections");				// 객체가 존재하는 index를 뽑아내서 사용할 수 있다.
		System.out.println("idx = " + idx);					// 2
		
		String m = li.get(idx);								// idx를 통해 해당 인덱스에 들어있는 객체를 뽑아낼 수 있음.
		System.out.println(m);
		
		System.out.println("size = " + li.size());			// 4
		li.set(0, "set");									// 0번째 인덱스 값을 변경
		System.out.println("size = " + li.size());			// 4
		System.out.println(li.get(0));						// set
		System.out.println(li.toString());					// [set, 컬렉션, collections, 컬렉션]
		li.add(2, "HashSet");								// set과 달리 2번째 인덱스에 값을 설정하면서 기존에 존재하던 값들은 뒤로 밀어냄
		System.out.println(li.toString());					// [set, 컬렉션, HashSet, collections, 컬렉션]
		li.remove(4);										// 해당 인덱스 객체 삭제
		System.out.println(li.toString());					// [set, 컬렉션, HashSet, collections]
		
		List<String> sub = li.subList(1, 3);				// 1~2 사이의 객체 리스트를 얻어냄
		System.out.println(sub.toString());					// [컬렉션, HashSet]
		sub.set(0, "totoro");								// 일부분의 객체 리스트를 제어하면 기존에 존재하던 리스트의 객체 값도 변함
		System.out.println(li.toString());					// [set, totoro, HashSet, collections]
		
		sub.add(1, "totoro");								// sub에 add를 해도 기존 li 객체에도 영향을 끼침
		System.out.println(li.toString());					// [set, totoro, totoro, HashSet, collections]
		
		// 내부 index에 변화가 없다면 Vector나 ArrayList가 성능이 좋음
		// 변화가 있다면 LinkedList가 좋음
	}
}
