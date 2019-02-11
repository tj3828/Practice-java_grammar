
public class Source11_Array {
	
	static int[] make() {
		int[] a = new int[5];
		int idx = 0;
		a : while(idx<a.length) {
			int p = 1 + (int)(Math.random()*10);
			
			// 같은 숫자라면 다시 설정
			for(int cnt=0; cnt<idx; cnt++) {
				if(a[cnt] == p) {
					continue a;
				}
			}
			a[idx++] = p;
		}
		return a;
	}
	

	public static void main(String[] args) {
		int[] box = make();
		int n = 3; // 찾아야할 데이터 (바뀔수 있음.)
		
		// n의 데이터가 존재하는지 확인.
		boolean find = false;
		for(int cnt=0; cnt<box.length; cnt++) {
			System.out.println(box[cnt]);
			if(box[cnt] == n) {
				find = true;
			}
		}
		
		System.out.println("box contains data ?? " + find);
		
		
	}

}
