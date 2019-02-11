package sample;

public class LineBingoTest {

	public static void main(String[] args) {
		LineBingo u = new LineBingo();
		System.out.println(u);
		
		System.out.println(u.toHiddenString());
		
		boolean f1 = u.mark(1);
		boolean f2 = u.mark(2);
		boolean f3 = u.mark(3);
		boolean f4 = u.mark(4);
		boolean f5 = u.mark(5);
		boolean f6 = u.mark(6);
		boolean f7 = u.mark(7);
		boolean f8 = u.mark(8);
		boolean f9 = u.mark(9);
		
		System.out.println(f1 + " /" + f2 + " / " + f3 + " / " + f4 + " / " + f5 + " / " + f6 + " / " + f7 + " / " + f8 +" / " + f9);
		System.out.println(u.toHiddenString());
		
		System.out.println(u.isRevealed());
		
		
		
	}

}
