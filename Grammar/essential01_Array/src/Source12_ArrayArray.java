
public class Source12_ArrayArray {

	public static void main(String[] args) {
		// 배열도 객체이기 때문에 배열로 배열을 관리하여 2차원 배열 생성
		
		System.out.println(new int[3][]); // int[]을 3개 저장할 수 있는 배열을 만든것.
		
		int[][] nums ;
		boolean[][] flag;
		Sword[][] sws;
		
		nums = new int[10][];
		System.out.println(nums.length);
		for(int i=0;i<nums.length;i++) {
			System.out.println(i + " : " + nums[i]);          // 배열을 관리할 배열을 만든 것이기 때문에 객체의 초깃값인 null로 설정되어있음.
		}
		nums[0] = new int[5];
		int[] t = new int[3];
		nums[1] = t;
		nums[2] = t;
		
		
		flag = new boolean[3][];
		int d = 3;
		for(int i=0;i<flag.length;i++) {
			flag[i] = new boolean[d];
			d += 2;
			System.out.println(i + " : " + flag[i] + " / "+ flag[i].length);
		}
		
		sws = new Sword[][]	{
			new Sword[]{new Sword(), new Sword()}, 
			new Sword[]{new Sword(), new Sword(), new Sword()}
			};
		
		for(int i=0;i<sws.length;i++) {
			Sword[] e = sws[i];
			System.out.println(i + " ... " + e.length);
			for(int j=0;j<e.length;j++) {
				System.out.println(e[j]);
			}
				
		}
		
		// 내부배열 요소에 접근할 때
		Sword[] obt = sws[1];
		System.out.println("--- " + obt[1] + " / " + sws[1].length + " / " + sws[1][1]);
		System.out.println(obt[1] == sws[1][1]);       //true
	}

}
