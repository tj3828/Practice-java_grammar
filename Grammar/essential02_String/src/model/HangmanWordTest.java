package model;

public class HangmanWordTest {
	public static void main(String[] args) {
		HangmanWord w = new HangmanWord("DIAMOND");
		System.out.println(w.toString()); 	// ??????? [♡♡♡♡♡] 
		
		boolean b = w.mark('A');
		System.out.println(b); 		// true
		
		System.out.println(w.toString());	// ??A???? [♡♡♡♡♡]
		
		boolean bb = w.mark('F');
		System.out.println(bb);   	// false
		
		System.out.println(w.toString());	// ??A???? [♡♡♡♡]
		
		boolean bbb = w.mark('D');
		System.out.println(bbb);
		System.out.println(w.toString());	// D?A???D [♡♡♡♡]
		
		System.out.println(w.isRevealed()); // false
		
		w.mark('I');
		w.mark('O');
		w.mark('M');
		w.mark('N');
		System.out.println(w.isRevealed()); // true
	}
}
