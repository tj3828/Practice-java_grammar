
public class Source09_Array {
	static boolean[] makeSample() {
		boolean[] sheet = new boolean[5 + (int)(Math.random()*10)];
		
		for(int idx = 0; idx<sheet.length; idx++) {
			if(Math.random()>0.5) {
				continue;
			}
			sheet[idx] = true;
			
		}
		return sheet;
	}

	public static void main(String[] args) {
		boolean[] sheet = makeSample();							// 배열도 다른 것과 마찬가지로 매개변수로 넘겨주고 반환형으로 받을 수 있다.
		System.out.println("sample...obtained...");
		System.out.println("setting...");
		for(int idx = 0; idx<sheet.length;idx++) {
			System.out.println(idx + " : " + sheet[idx]);
		}
		System.out.println(sheet.toString());					// 배열의 경우 toString 오버라이드 불가
		
		// 배열로 데이터를 저장시켜두고, 자주 하는 작업이 특정 상태를 가진 데이터 갯수 확인하는 작업을 많이함
		// true 개수 세고, 전체 데이터 중 true 의 비중은 ...?
		int n = 0;
		for(int cnt = 0; cnt<sheet.length;cnt++) {
			if(sheet[cnt] == true) {
				n++;
			}
		}
		double per = (double)n / (sheet.length) * 100;
		System.out.println("총 배열 길이 :" + (sheet.length+1) +" / true의 갯수 : " + n + "개 / true의 비중 : " + per + "%");

	}

}
