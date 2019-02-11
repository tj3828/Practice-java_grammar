import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Source15_Map {
	public static void main(String[] args) {
		Map<Integer, String[]> map = new HashMap<>();
		
		map.put(2, new String[] {"이","둘","二","two","に"});
		map.put(5, new String[] {"오","다섯","五","five","ご"});
		map.put(3, new String[] {"삼","셋","三","three","さん"});
		map.put(4, new String[] {"사","넷","四","four","し"});
		
		
		// put을 할 때 원래 키 값을 사용하던 객체가 있으면 기존에 존재하는 객체가 반환되지만 없었으면 null이 반환
		// remove 시에도 키값이 있던 객체를 삭제하면 삭제된 객체가 반환되고 키값이 없으면 null 반환
		// get도 마찬가지.
		
		String[] obt = map.get(4);
		for(String m : obt) {
			System.out.println(m);
		}
		
		// containsKey()로 특정키가 사용되고 있는지 확인할 수 있음.
		// put 하기전에 체크해서 없으면 새로 객체 생성, 있으면 덮어씌우기
		// get 하기전에 체크해서 없으면 등록객체 없는 것이고, 있으면 객체 반환
		// remove 하기전에 체크해서 없으면 삭제할 키값이 없는 것이고, 있으면 삭제 후 객체 반환
		// containsKey() 는 Map의 종류에 따라 객체값이 달라도 동일 객체로 판단할 수 있음.
		System.out.println(map.containsKey(2));		// true
		
		// containsValue()
		// equals 구현에 따라 바꿀 수도 있음.
		System.out.println(map.containsValue(new String[] {"이","둘","二","two","に"}));	// false	/ 새로운 String인스턴스 생성이기 때문
		
		// Map의 모든 객체를 확인하고 싶을 때는 keySet()으로 Key값을 얻어낸다. 
		// Map의 종류에 따라 정렬이 다르기 때문에 얻어지는 key정렬도 달라진다.
		Set<Integer> k = map.keySet();
		System.out.println(k);		// [2, 3, 4, 5]	
		for(Integer i : k) {		// for(Integer i : map.keySet()) {
			System.out.println(i);	// 2,3,4,5
		}
		
		// 어떤 키가 사용되고 있는지 몰라도 되고 특정 객체만 알고 시다면 values() 메소드를 사용
		Collection<String[]> c = map.values();	// Collection 최상위 객체로 반환
		for(String[] s : c) {					// for(String[] s : map.values()) {
			System.out.println(s);
		}
		
		System.out.println(map.toString());		// {2=[Ljava.lang.String;@15db9742, 3=[Ljava.lang.String;@6d06d69c, 4=[Ljava.lang.String;@7852e922, 5=[Ljava.lang.String;@4e25154f}
		
		// entrySet()
		// Entry의 제네릭 설정은 Map이랑 같게하면 된다.
		// 키와 키에 해당하는 객체를 하나의 Entry 객체로 만들어 Set에 저장
		Set<Entry<Integer,String[]>> eset = map.entrySet();
		for(Entry<Integer,String[]> e : eset) {
			System.out.println(e);
			System.out.println(e.getKey());			// Entry에서 key와 value를 뽑아냄
			System.out.println(e.getValue());
		}
			
			
		
	}
}
