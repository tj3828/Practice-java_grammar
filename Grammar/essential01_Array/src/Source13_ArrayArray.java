
public class Source13_ArrayArray {
	static int[] makeRow() {
		int size = 2 + (int)(Math.random()*4);    // 2~5size 배열 생성
		int[] ar = new int[size];
		for(int idx=0; idx<ar.length; idx++) {
			int val = (int)Math.pow(size, idx+1);
			ar[idx] = val; 
		}
		return ar;
	}
	
	public static void main(String[] args) {
		int[] got = makeRow();
		for(int i = 0; i<got.length; i++) {
			System.out.println(i + "..." + got[i]);
		}
		
		System.out.println();
		
		int[][] multi = new int[5][];
		for(int r=0; r<multi.length; r++) {
			multi[r] = makeRow();
			System.out.print(r + "... " );
			for(int j=0; j<multi[r].length; j++) {
				System.out.print(multi[r][j]+ " ");
			}
			System.out.println();
		}
		
		// multi 배열에 들어가져 있는 int[] 길이의 합
		int length_Sum=0;
		for(int j=0; j<multi.length;j++) {
			length_Sum += multi[j].length;
		}
		System.out.println("multi 배열이 가지고 있는 int[] 길이의 합 : " + length_Sum);
		
		//multi에 들어가져 있는 1번째 int[] 요소의 합
		int first_Sum = 0;
		for(int a =0; a<multi.length; a++) {
			first_Sum += multi[a][1];
		}
		System.out.println("multi에 들어있는 1번째 int[] 요소의 합 : " + first_Sum);
		
		//multi에 들어가져 있는 int[] 배열들이 가지고 있는 int 합
		int all_Sum = 0;
		for(int i=0; i<multi.length; i++) {
			for(int j=0; j< multi[i].length; j++) {
				all_Sum += multi[i][j];
			}
		}
		System.out.println("multi에 들어있는 모든 요소들의 합 : " + all_Sum);
	}
}
