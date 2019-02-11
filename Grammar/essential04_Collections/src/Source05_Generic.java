import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Source05_Generic {
	static int[] makeArray() {
		int[] ar = new int[3];
		for(int i=0; i<ar.length;i++) {
			ar[i] = 1+(int)(Math.random()*10);
		}
		return ar;
	}
	
	public static void main(String[] args) {
		Set<int[]> set = new LinkedHashSet<>();
		set.add(makeArray());
		set.add(makeArray());
		set.add(makeArray());
		System.out.println(set.size());		// 3 	/ 각 다른 int[]객체가 반환되기 때문에 중복이 아니다.
		System.out.println(set.toString());
		
		// 배열타입의 객체를 set에 담았다면 모든 값의 합
		int sum = 0;
		for(int[] i : set) {
			for(int cnt=0; cnt<i.length; cnt++) {
				sum += i[cnt];
			}
		}
		
		System.out.println("enhanced for = " + sum);
		
		sum = 0;
		for(Iterator<int[]> i = set.iterator();i.hasNext();) {
			int[] j = i.next();
			for(int cnt : j) {
				sum += cnt;					// 배열도 Iterator 사용가능
			}
		}
		System.out.println("Iterator = " + sum);
		
	/*	String m = "String";			// Iterator가 존재하는 객체에서만 작동하는 문법(배열도 가능)
		for(String : s) {
			
		}
	*/	
	}
}
