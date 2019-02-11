package sample;

public class SquareBingoTest {
	public static void main(String[] args) {
		SquareBingo sb = new SquareBingo(6);
		System.out.println(sb.toString());
		
		System.out.println();
		
		System.out.println(sb.toHiddenString());
		
		
		for(int i=0;i<=60;i++) {
			sb.mark(i);
		}
		
		
		System.out.println(sb.toHiddenString());
		
		System.out.println(sb.revealedCount());
	}
}
