public class Source15_ArrayArray {

	public static void main(String[] args) {
		boolean[][] map = new boolean[5][];
		for(int r=0; r<map.length;r++) {
			System.out.println(map[r]);
		}
		
		int[][] num = new int[4][5];
		for(int r=0; r<num.length; r++) {
			System.out.println(num[r] + " / " + num[r].length);
		}
		
		num[1] = new int[10];
		
		Sim[][] f = new Sim[3][5];
		for(int r=0; r<f.length; r++) {
			System.out.println(f[r]);
			for(int c=0; c<f[r].length; c++) {
				System.out.println(f[r][c]);
			}
		}
	}
}
