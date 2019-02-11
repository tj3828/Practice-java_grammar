
public class Source06_Array {

	public static void main(String[] args) {
		int[] t;
		
		int[] box = new int[5];             // 배열도 객체...? 왜 length는 직접접근할까??
		box[1] = 99;
		box[box.length-1] = 789;
		
		//box라는 변수가 가진 값은 int 5칸짜리 저장소 접근값
		t = box;				// 같은 타입은 복사 가능
		System.out.println(t == box);
		System.out.println(t.equals(box));         // 배열의 경우 복사하게 되면 객체안에 데이터 접근값(객체)도 복사되기 때문에 true 반환
		System.out.println(t[1] + "..." + t[4]);
		t[1] *= 2;									// 접근 주소값이 같기 때문에 
		System.out.println(box[1]);					// box의 값도 바뀌게 된다.
		
		//===============================================================================================

		Sword[] ss = new Sword[3];					// 객체의 초깃값은 null 값
		System.out.println(ss[0]);
		
		ss[0] = new Sword();
		
		Sword ex = new Sword();
		ss[1] = ex;
		ss[2] = ex;
		
		System.out.println(ss[1] == ss[2]);
		
		for(int cnt=1; cnt<=10; cnt++) {
			ss[1].enchant();
		}
		System.out.println("ss[1].atk = " + ss[1].atk);			// ex와 ss[1]이 참조하는 객체 주소값이 같기 때문에 한쪽에서 객체의 데이터를 변경해주면 자동으로 다른쪽에서 참조하는 객체 값도 변하게 된다.
		System.out.println("ex.atk = " + ex.atk + " / ss[2].atk = " + ss[2].atk);
	}

}
