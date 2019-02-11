import sample.Coord;

public class Source10_Array {

	static Coord[] makeCoords() {
		Coord[] cs = new Coord[10];
		cs[0] = new Coord(0,0);
		cs[1] = new Coord(0,0);
		for(int idx = 2; idx<cs.length; idx++) {
			int x = (int)(Math.random()*4);
			int y = (int)(Math.random()*4);
			cs[idx] = new Coord(x,y);
		}
		return cs;
	}
	
	public static void main(String[] args) {
		Coord[] box = makeCoords();
		for(int i=0; i<box.length;i++) {
			System.out.println(i + " : " + box[i].toString());
		}
		
		// 첫번째 방법 ==================================================================
		
		boolean[] result = new boolean[box.length];
		int cnt=0;
		
		for(int i=0;i<box.length;i++) {
			if(result[i] == true) continue;
			for(int j=i;j<box.length;j++) {
				if(box[i].isDuplicated(box[j])) {
					result[j] = true;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
		
		// 두번째 방법 ===================================================================
		
		int count = box.length;
		for(int i=0; i<box.length;i++) {
			for(int srch= i+1; srch<box.length; srch++) {
				if(box[i].equals(box[srch])) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
		
		//==============================================================================
	}
}
