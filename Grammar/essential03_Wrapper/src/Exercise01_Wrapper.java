/*
 * Wrapper 객체의 활용 (LinkedHashSet - Wrapper 활용을 위해 일부분만 사용) 
 * Collection 객체중 하나로 같은 객체를 저장하지 않는다.
 * 
 */
import java.util.LinkedHashSet;

public class Exercise01_Wrapper {
	public static void main(String[] args) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();	// <> 다룰 객체 명을 설정
		
		for(int cnt = 1; cnt<=15; cnt++) {
			int n = 1+(int)(Math.random()*15);
			System.out.print(cnt + "'s pick = " + n);
			boolean b = set.add(n);	// n을 오토 박싱하여 객체로 set에 저장	/ 오토 박싱 기능이 없었다면 add(new Integer(n))과 같이 호출해야하는 불편함
			System.out.println(" / add result = " + b);	// 이미 저장된 값이 존재한다면 add()가 false를 반환하고 저장하지 않음	/ 객체값을 비교하는 것이 아니라 데이터 값을 비교
		}
		System.out.println(set.toString());	// 저장된 데이터가 출력되도록 오버라이드 되어있음.
		
		
	}
}
