import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*
 * Set은 종류에 따라 사용목적이 달랐지만
 * List는 성능차이가 있다
 * 
 * List를 만들어놓고 중복체크를 위한 Set을 설계한 것.
 */
class CustomComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// o1 객체가 작다고 한다면 -1 , 크다고하면 1 , 같으면 0
		int c = o1.compareTo(o2);
		return c < 0 ? -1 : c > 0 ? 1 : 0;
	}
	
}

class ParseComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int a = Integer.parseInt(o1);
		int b = Integer.parseInt(o2);
		int c = a - b;
		return c < 0 ? -1 : c > 0 ? 1 : 0;
	}
	
}
public class Source11_List {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("11");
		li.add("101");
		li.add("10");
		li.add("100");
		li.add("1001"); 
		li.add("111");
		System.out.println(li.toString());
		System.out.println("contains? " + li.contains("101"));	// true
		String data = new String("10");
		System.out.println("contains? " + li.contains(data));	// true
		// List계열은 contains나 indexOf 객체 판별할 때 equals만 사용 (hashCode 판단안함)
		System.out.println(li.indexOf(data));		// 2
		System.out.println(li.get(2) == data);		// false	/ 객체 값과 데이터 값 판단하는 것은 다른 것과 같지만 List는 hashCode메소드 판별을 안함.
		System.out.println(li.get(2).equals(data));	// true
		
		// List에 저장된 객체를 정렬시킬 수 있다. 객체 자체의 크기를 비교할 compareTo를 사용하는 것이 아니라 크기비교를 할 객체를 설곟서 넘겨줘야한다.
		// 예를 들어, String 객체값이 들어있는 List를 특정조건으로 정렬하고 싶다면 String을 비교하는 객체를 외부에서 설계해야한다.
		Comparator<String> c = new CustomComparator();	// li.sort(new CustomComparator() ); 와 같음
		li.sort(c); 	// c에 정의한 대로 정렬
		
		for(int idx =0; idx < li.size(); idx ++) {
			String m = li.get(idx);
			System.out.println("--" + m + " / " + Integer.parseInt(m, 2));	// 문자열로 바라봐 정렬하는 것과 실제 숫자 정렬과는 다르다.
		}
		
		System.out.println();
		
		Comparator<String> t = new ParseComparator();
		li.sort(t);
		
		for(Iterator<String> s = li.iterator(); s.hasNext();) {
			String d = s.next();
			System.out.println("--" + d + " / " + Integer.parseInt(d, 2));
		}
		
		
	}
}
