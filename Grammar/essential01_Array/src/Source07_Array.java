
public class Source07_Array {

	public static void main(String[] args) {
		/*
		 * 배열 객체 생성시
		 * 만들때 0이상 으로 설정할 수 있고, 최대 칸수는 int 허용범위
		 */
		int size = 5;
		boolean[] box = new boolean[size];
		System.out.println("boolean [] created.. length " + box.length);
		System.out.println(box[0] + "..." + box[1] + "..." + box[2]);
		/*
		 * 생성하면서 각 칸에 데이터를 설정하면서 만들 수 있다.
		 * 사이즈를 따로 입력하지 않아도 입력한 데이터 크기만큼 자동적으로 생성된다.
		 */
		int[] n = new int[] {1,4,5,6,1,54};
		System.out.println(n.length);
		n = new int[] {1,-1,3,6};
		/*
		 * Sword 3칸짜리를 만드는데 바로 사용할 수 있게, 객체값들을 설정한 상태로 만들려면
		 */
		Sword[] sw = new Sword[] { new Sword(), new Sword(), new Sword()};
		sw[0].atk = 30;
		sw[1].atk = 30;
		sw[2].atk = 30;
		System.out.println(sw.length);
		System.out.println(sw[0]);
		System.out.println(sw[1]);
		System.out.println(sw[2]);
		
		System.out.println(sw[0] != sw[1]);
		System.out.println(sw[0] != sw[2]);
		System.out.println(sw[1] != sw[2]);
		
		/*
		 * 데이터 여러개를 묶어서 만들 관리형 객체를 만들때
		 * 칸만 지정하고 만들수도 있고 (나중에 채울용도로)
		 * 각칸에 값을 설정해서 만들어낼수도 있다. 바로 확해서 사용할 용도로
		 */
	}

}
