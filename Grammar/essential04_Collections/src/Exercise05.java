import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercise05 {
	public static void main(String[] args) {
		/*
		 * 베스킨라빈스 15 게임 변형판 (범위 1~15)
		 * - 사용자의 입력값은 최대 3개 (중복 x)
		 * - 첫번째 숫자가 그 전 숫자에 +1이기만 하면됨. x
		 * - 이미 외친 값을 외치면 패배.
		 * - 외칠 숫자가 15내에 없으면 패배.
		 * - 내가 외친 숫자의 마지막 숫자의 +1이 있으면 패배.
		 * - 상대방이 외칠 수 있게 해야 이기는 것. 
		 */
		Scanner s = new Scanner(System.in);
		Deque<Integer> input = new ArrayDeque<>();
		input.add(0);
		while(true) {
			if(input.size() > 15 || input.peekLast() == 14) {
				System.out.println("입력할 값이 없습니다. 졌습니다.");
				break;
			}
						
			System.out.println("[system] ");
			String in = s.nextLine();
			String[] ar = in.split(" ");
			
			if(input.peekLast() + 1 != Integer.valueOf(ar[0])) {
				System.out.println("이전 숫자에서 1보다 큰 값을 입력해야합니다. 졌습니다.");
				break;
			}
			
			for(int i=0; i<ar.length; i++) {
				if(input.contains(Integer.valueOf(ar[i]))) {
					System.out.println("이미 입력된 값을 입력했습니다. 졌습니다.");
					break;
				} else {
					input.add(Integer.valueOf(ar[i]));
				}
			}
			
			
		}
		/*
		 *  1. Deque를 하나 생성 (Integer)
		 *  2. 
		 *  
		 */
	}
}
