import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercise04_LinkWord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Deque<String> deq = new ArrayDeque<>();
		// Collection의 상황 처리에 유리한 컬렉션 객체를 선택

		// 첫 시작 단어 설정
		String str = "가나다라마다사아자차카타파하";
		int n = (int)(Math.random()*(str.length()));
		char start = str.charAt(n);
		deq.add(String.valueOf(start));
		
		System.out.println("시작 단어는 " + deq.peekLast() + "입니다.");
		
		for(int cnt = 1; cnt<=10; cnt++) {
			System.out.println();
			String user = cnt%2 == 0 ? "블루" : "레드";
			System.out.print(user + "님 차례 > ");
			String input = s.nextLine();
			
			// 이미 입력된 단어인지 체크
			if(deq.contains(input)) {
				System.out.println();
				System.out.println(user + "님이 같은 값을 입력해서 졌습니다. ");
				break;
			}
			
			// 말해야하는 첫 단어가 일치하는지 체크
			char inputFirst = input.charAt(0);
			String lastInput = deq.peekLast();
			char lastChar = lastInput.charAt(lastInput.length()-1);
			if(inputFirst == lastChar) {
				deq.offerLast(input);
			} else {
				System.out.println();
				System.out.println("시작단어는 " + lastChar + " 이어야합니다. " + user + "님이 입력하신 첫 글자는 " + inputFirst + "입니다. 졌습니다.");
				break;
			}
			
		}
		
		s.close();
		

	}
}
