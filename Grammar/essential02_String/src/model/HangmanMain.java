package model;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class HangmanMain {
	public static void main(String[] args) {
		System.out.println("[HANGMAN GAME START]" + "\n");
		String[] jewels = "DIAMOND,RUBY,EMERALD,SAPHIRE".split(",");
		
		// 주제를 정해 문자열을 만들고 반복을 돌면서 HangmanWord 객체 배열을 생성
		HangmanWord[] hmw = new HangmanWord[4];
		for(int i=0;i<hmw.length;i++) {
			hmw[i] = new HangmanWord(jewels[i]);
		}
		// 그중 랜덤으로 하나의 객체를 뽑아서 게임 시작
		int p = (int)(Math.random()*hmw.length);
		HangmanWord user = hmw[p];
		Scanner s = new Scanner(System.in);
		LinkedHashSet<Character> userInputed = new LinkedHashSet<Character>();
		
		System.out.println("[문제 설정 완료!]" + "\n");
		
		while(user.life >=1) {
		// 행맨 상태
			System.out.println(user.toString());
			String input;
			char c;
		// 입력(입력받을 때 String을 받아 정규식으로 대문자 1개인가 체크해서 false면 처리 ㄴ.
		// 맞다면 charAt으로 변환하여 사용
			while(true) {
				System.out.print("문자 한개 입력하세요 : ");
				input = s.nextLine();
				if(input.matches("[A-Z]")) {
					c = input.charAt(0);
					if(!userInputed.add(c)) {
						System.out.println("\n" + c + " 은/는 이미 입력한 값입니다. 다른 값을 입력하세요.");
						System.out.println("입력했던 값 : " + userInputed.toString() + "\n");
						continue ;
					} else {
						break;
					}
				} else {
					System.out.println("\n" + "[A-Z] 문자 입력하세요.");
				}
			}
		// mark, 결과
			if(user.mark(c)) {
				System.out.println("맞췄습니다."+"\n");
			} else {
				System.out.println("아닙니다."+"\n");
			}
		// revealed 될때까지 or life 1이상일 때
			if(user.isRevealed()) {
				System.out.println("정답 : " + user.toString() + "남기고 정답!");
				System.exit(0);
			}
		}
		
		System.out.println("문제 맞추기에 실패했습니다. 정답은 " + user.answer + "입니다.");
		s.close();
	}
}
