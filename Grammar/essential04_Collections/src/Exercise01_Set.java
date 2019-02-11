import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise01_Set {
	public static void main(String[] args) {
		String[] heros = "루피,조로,나미,우솝,상디,쵸파,핸콕,프랑키,브룩".split(",");
		
		Set set = new TreeSet();
		for(int i=0; i<heros.length; i++) {
			set.add(heros[i]);
		}
		System.out.println("set size = " + set.size()+"\n");
		
		Scanner s = new Scanner(System.in);
		Set userInput = new TreeSet();
		
		while(userInput.size() <3) {
			System.out.print("이름을 입력하세요 : ");
			String input = s.nextLine();
			if(set.contains(input)) {
				boolean b = userInput.add(input);
				if(!b) System.out.println("이미 입력한 영웅입니다.");
			} else {
				System.out.println("입력한 영웅은 해당사항이 없습니다.");
			}
		}
		
		System.out.println();
		System.out.println(userInput);
		for(Object obj : userInput) {
			set.remove(obj);
			System.out.println(obj);
		}
		System.out.println(set);
		
		s.close();
	}
}
