
import model.Soldier;

/*
 * 객체관리를 용이하게 하기위해 설계된 Collections 인터페이스
 * 
 * - 배열로 처리하는 것보다는 훨씬 쉽고 간단하게 프로그램을 만들 수 있다.
 * - 종류가 다양하고 사용 목적이 다르다.
 * 
 * - 원하는 객체를 가지고 있는지 찾는 기능이나 중복되는 객체가 있는지 등 유용하게 사용되는 메소드를
 *   정의해둔 인터페이스
 */
public class Source01_Collections {
	public static void main(String[] args) {
		Soldier[] army = new Soldier[3];
		Soldier s = new Soldier("짐레이너", 34);
		for(int i =0; i <army.length; i++) {
			if(Math.random()>0.9) {					// 랜덤확률로 s 객체를 배열에 생성
				army[i] = s;
				break;
			}else {
				army[i] = new Soldier("익명", 1);
			}
		}
		boolean find = false;
		for(int i =0; i<army.length; i++) {			// s객체가 있는지 확인
			if(army[i] == s) {
				find = true;
			}
		}
		System.out.println(find);
	}
}
