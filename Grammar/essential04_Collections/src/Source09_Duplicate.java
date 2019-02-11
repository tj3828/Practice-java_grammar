import java.util.Set;
import java.util.TreeSet;

/*
 * Exercise02_Set에서 TreeSet을 쓰지 못하는 이유
 * 
 * - TreeSet은 크기에 따라 오름정렬하는 특징을 가지고 있다.
 * - 실제 객체값에는 크기가 없기 때문에 크기비교가 가능한 객체에 한해서만 관리가 됨.
 * 
 * - TreeSet 객체는 hashCode / equals로 중복객체라고 판단하는 것이 아니라 크기비교 결과가 0일 때 같은 객체로 인식함.
 */
public class Source09_Duplicate {
	public static void main(String[] args) {
		Set<Double> ds = new TreeSet<>();
		Double d1 = new Double(3.14);
		Double d2 = new Double(3.14);
		System.out.println(ds.add(d1));		// true
		System.out.println(ds.add(d2));		// false	/ TreeSet에서 add 메소드 호출시 compareTo 메소드를 통해 이미 있는지 확인
		
		
		String s1 = "조조";
		String s2 = "조운";
		int i = s1.compareTo(s2);	// s1 - s2의 결과가 인트값으로 나온다.
		System.out.println(i);		// 444
		
		// TreeSet에 두 객체를 집어넣으면 조운부터 뽑힘.
		Card p1 = CardShop.random();
		Card p2 = CardShop.random();
	//	System.out.println(p1 - p2);	// compareTo를 오버라이드하여 구현하면 가능.
	}
}
