/*
 *Wrap(Boxing), UnWrap(UnBoxing)
 * - 이 기능은 자동으로 호출됨
 */
public class Source02_Wrapper {
	public static void main(String[] args) {
		Integer n1 = 4561;	// 오토 박싱 	/ new Integer(4561)
		Integer n2 = 4561;
		System.out.println(n1 + " / " + n2);	// 실제 데이터를 찍히도록 오버라이드 되어짐.
		System.out.println(n1 == n2);			// 객체 비교이기 때문에 false
		System.out.println(n1.equals(n2)); 		// 데이터 값비교 true
		System.out.println(n1.intValue() == n2.intValue());	// true
		
		int y1 = n1;	// 오토 언박싱 	/ 객체가 int 타입으로 변환	/ n1.intValue()
		System.out.println(n1 + n2);	// 9122 	/ 오토 언박싱이 되어 연산가능
		
		Boolean b1 = true;
		Boolean b2 = true;
		System.out.println(b1 == b2);	// true
		
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(i1 == i2);	// true	/ -128~127 까지는 같은 객체라고 인식
		
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3 == i4);	// false
	}
}
