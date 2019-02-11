import java.util.HashMap;
import java.util.Map;

/*
 * Map
 * 
 * - 다른 Collection과는 사용법이 조금 다르다.
 * - 객체값에 부여할 키값을 같이 설정하여 저장하는 방식
 * - 저장된 객체를 지우거나, 재 확보해야하는 상황에서 키값을 사용함.
 * - 객체를 저장하는데 이미 동일한 키 값이 사용되고 있으면 해당 키값을 가진 객체에 덮어씌워진다.
 * 
 * - Hashtable, HashMap, TreeMap, LinkedHashMap 등이 있다.
 * - 각 차이는 키값 관리에 있다.
 * 
 * - 객체 자체는 중복저장이 되지만 키값의 중복은 저장안됨.
 * - 순서대로 저장하는 것이 아니라 임의대로 저장됨. 특정 객체를 뽑아서 사용할 때 속도가 빠름.
 */
public class Source14_Map {
	public static void main(String[] args) {
		Map<String, String[]> map = new HashMap<>();	// 객체 생성시 타입설정 조건 두가지  1. 저장할 객체 타입 2. 키로 쓸 객체타입
														// <키값의 타입, 저장할 객체 타입(배열형태)>
		
		System.out.println(map.size());					// 0 	/ 관리중인 객체 사이즈
		System.out.println(map.isEmpty());				// true / 객체의 비어있는 상태 체크
		
		String[] a = "하준,도윤,시윤,시우,민준".split(",");
		map.put("f", a);								// (첫 번째 인자는 키값, 두 번째 인자는 저장 객체) map에 저장
		map.put("F", a);								// 대문자 상관없음.
		System.out.println(map.size());					// 2
		
		String[] got = map.get("f");					// 키값에 대한 객체가 전달된다.
		for(int i=0; i<got.length;i++) {
			System.out.println(got[i]);					// 하준, 도윤, 시윤, 시우, 민준
		}
		
		map.remove("f");								// 키값에 대한 객체 삭제, 키값을 모르면 객체를 제어할 방법이 없다. Map이 가지고있는 키값이 없더라도 에러가 발생하진 않음.
		map.get("f");									// 해당 키값에 대한 객체가 없으면 null 반환
		
		String[] b = "서연,하연,지우".split(",");
		map.put("F", b);								// 같은 키가 사용되면 덮어씌움
		String[] got2 = map.get("F");
		System.out.println(got2[0]);					// 서연
		
		map.clear();									// 저장된 모든 객체 삭제
		System.out.println(map.size());					// 0
	}
}
