package sample;

import java.util.Scanner;

public class LineBingoMain {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("========== LineBingo Start ==========");
		System.out.print("[Setting] 몇 칸의 빙고판을 만들겠습니까? : " );
		int line = Integer.valueOf(s.nextLine());
		LineBingo u = new LineBingo(line);
		LineBingo com = new LineBingo(line);
		int[] com_inputs = new int[line*2];
		int idx = 0;
		System.out.println("[Setting] 빙고판이 설정되었습니다.");
		System.out.println("[START] 게임이 시작됩니다.");
		
		while(true) {
			System.out.println("================================================");
			System.out.println("\n사용자의 차례 : 컴퓨터의 빙고판" + com.toHiddenString());
			System.out.print("\n" + "사용자님! 숫자 (1 ~ " + line*2 + ")를 입력하세요 : ");
			int input = Integer.valueOf(s.nextLine());
			boolean result = com.mark(input);
			if(result) {
				System.out.println("맞췄습니다.");
			} else {
				System.out.println("틀렸습니다.");
			}
			if(com.isRevealed()) {
				System.out.println("\n================================================");
				System.out.println(com.toString());
				System.out.println("\n" + "사용자가 다 맞췄습니다.");
				break;
			}
			System.out.println("================================================");
			System.out.println("\n컴퓨터의 차례 : 사용자의 빙고판" + u.toHiddenString());
			int p = 0;
			a : while(true) {
				p = 1 + (int)(Math.random()*(line*2));
				// 같은 숫자라면 다시 설정
				for(int cnt=0; cnt<idx; cnt++) {
					if(com_inputs[cnt] == p) {
						continue a;
					}
				}
				com_inputs[idx++] = p;
				break;
			}
			
			System.out.print("\n" + "컴퓨터는 " + p + " 를 입력했습니다.");
			boolean com_result = u.mark(p);
			
			if(com_result) {
				System.out.println("맞췄습니다.");
			} else {
				System.out.println("틀렸습니다.");
			}
			if(u.isRevealed()) {
				System.out.println(u.toString());
				System.out.println("\n" + "컴퓨터가 다 맞췄습니다.");
				break;
			}
		}
		
		s.close();
	}
}
