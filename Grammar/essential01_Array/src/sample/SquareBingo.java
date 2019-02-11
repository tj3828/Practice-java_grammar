package sample;

public class SquareBingo {
	private int size;
	private int[][] num;
	private boolean[][] flag;
	
	public SquareBingo(int size) {
		this.size = size;
		num = new int[size][size];
		
		// num에 중복되지 않은 숫자를 size*2로 랜덤 설정
		for(int i=0; i<num.length;i++) {
			int idx = 0;
			a : while(idx<num[i].length) {
				int p = 1 + (int)(Math.random()*(size*size*2));
				
				// 같은 숫자라면 다시 설정
				for(int cnt=0; cnt<=i; cnt++) {
					for(int scnt=0;scnt<num[cnt].length;scnt++) {
						if(num[cnt][scnt] == p) {
							continue a;
						}
					}
				}
				num[i][idx++] = p;
			}
		}
		
		flag = new boolean[size][size];
	}
	
	public SquareBingo() {
		this(5);
	}
	
	// 2차원 배열에 일치하는 숫자있으면 리턴 true, 아니면 false
	// true라면 같은 칸의 boolean배열을 true로 설정
	public boolean mark(int data) {
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[i].length;j++) {
				if(num[i][j] == data) {
					flag[i][j] = true;
					return true;
				}
			}
		}		
		return false;
	}
	
	// 가로, 세로, 대각선이 전부 true인 갯수확인
	public int revealedCount() {
		int count = 0;
		
		a :for(int row=0; row<size; row++) {
			for(int col = 0; col<size; col++) {
				if(flag[row][col] == false) {
					continue a;
				}
			}
			count++;
		}
		
		b : for(int col=0; col<size; col++) {
			for(int row = 0; row<size; row++) {
				if(flag[row][col] == false) {
					continue b;
				}
			}
			count++;
		}
		
		int[] cross = new int[2];
		for(int r=0; r<size; r++) {
			if(flag[r][r])
				cross[0]+=1;
			if(flag[r][size-r-1])
				cross[1]+=1;
		}
		if(cross[0]==size)
			count++;
		if(cross[1]==size)
			count++;
		
		//==================================================
	/*	boolean result = false;
		int col =0;
		int row =0;
		
		for(int i=0; i<=1; i++) {
			while(col<size && row <size) {
				int tem = col < 0 ? col*-1 : col; 
				if(flag[row][tem] == false) {
					result = false;
					break ;
				}
				result = true;
				col++;
				row++;
			}
			row = 0;
			col = (size-1)*-1;
			if(result == true) {
				result = false;
				count++;
			}
		}
	*/	
		return count;
	}
		// =======================================================
	/*	boolean result1 = false;
		int col =0;
		int row =0;
		while(col<size && row<size) {
			if(flag[row][col] == false) {
				result1 = false;
				break ;
			}
			result1 = true;
			col++;
			row++;
		}
		if(result1 == true) {
			count++;
		}
		
		boolean result2 = false;
		col =size-1;
		row = 0;
		
		while(row<size && col>0) {
			if(flag[row][col] == false) {
				result2 = false;
				break;
			}
			result2 = true;
			col--;
			row++;
		}
		if(result2 == true) {
			count++;
		}
		return count;
	}
	*/
	// 같은 칸의 boolean 값이 false면,??? 아니면 숫자값 출력
	public String toHiddenString() {
		String str = "";
		for(int r=0; r<num.length; r++) {
			str += "[";
			for(int c=0; c<num[r].length;c++) {
				if(flag[r][c]) {
					str += num[r][c] <10 ? "0" + num[r][c] : num[r][c];
				} else {
					str += "??";
				}
				if(c != num[r].length-1) {
					str += ",";
				}
			}
			str += "]\n";
		}
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int r=0; r<num.length; r++) {
			str += "[";
			for(int c=0; c<num[r].length;c++) {
				str += num[r][c] <10 ? "0" + num[r][c] : num[r][c];
				if(c != num[r].length-1) {
					str += ",";
				}
			}
			str += "]\n";
		}
		return str;
	}
}
