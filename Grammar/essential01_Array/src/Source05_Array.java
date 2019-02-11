import sample.Coord;

/*
 * 배열 객체?
 * 값(데이터,객체)을 여러개 한번에 저장할 수 있게 설계된 설계
 * 이것 또한 Object를 상속받아 생성된 객체
 */


public class Source05_Array {

	public static void main(String[] args) {
		System.out.println(new int[5]);           // 객체 값 출력한 후 저장을 하지 않았기 때문에 다시 참조 할 수 없는 배열
												  // 이것도 마찬가지로 toString 형태로 오버라이드 된 것
		System.out.println(new Sword[3]);
		
		int[] a;
		Sword[] b;
		boolean[] f;
		Coord[] c;									// Ctrl+Shift+o 알아서 찾아서 임포트해주는 단축키
		
		a = new int[3];
		int[] aa = new int[5];
		Object o = aa;
		
		// 배열 객체에 length라는 int형 변수가 존재.
		System.out.println(a.length);
		System.out.println(aa.length);
		
		// 배열 객체가 가지고 있는 실제 데이터 저장공간을 사용
		// 참조할 때 사용하는 번호 = 인덱스(index)
		a[0] = 4;
		a[1] = 5;
		a[2] = 10;
		System.out.println(a[1]);
		
		// 칼 두자루를 가질 수 있는 배열 객체 생성
		Sword[] sw = new Sword[2];
		System.out.println("sw.length = " + sw.length);
		sw[0] = new Sword();                     // 배열에 객체를 바로 생성해서 넣으나
		Sword s = new Sword();					 // 객체를 생성해서
		sw[1] = s;								 // 배열에 넣으나 상관없다.
		
	}

}
