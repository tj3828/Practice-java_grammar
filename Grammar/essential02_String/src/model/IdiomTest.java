package model;

import java.util.Scanner;

public class IdiomTest {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String[] ws = new String[] {"가령주구", "각골난망", "감탄고토", "견물생심"};
		String[] hs = new String[] {
				"세금을 혹독하게 징수하고 물건을 강제로 요구함",
				"입은 은혜에 대한 고마운 마음이 뼈에 사무쳐 잊혀지지 않음",
				"달면 삼키고 쓰면 뱉는다는 뜻",
				"물건을 보면 갖고 싶은 욕심이 생김"
		};
		String[][] data = new String[][] {ws, hs};
		
		// 문자열 배열에 사자성어 믹스
		for(int i=0;i<ws.length;i++) {
			int p =(int)(Math.random()*ws.length);
			String temp = ws[i];
			ws[i] = ws[p];
			ws[p] = temp;
			
			temp = hs[i];
			hs[i] = hs[p];
			hs[p] = temp;
		}
		
		
		// Idiom[]을 생성해서 랜덤사자성어 맞추기 게임
		Idiom[] user = new Idiom[4];
		for(int i=0;i<user.length;i++) {
			user[i] = new Idiom(data[0][i],data[1][i]);
		}
		
		for(int i=0; i<user.length;i++) {
			String rr = user[i].mixChar();
			while(true) {
				System.out.println(rr);
				System.out.print("답을 입력하세요. : ");
				String str = s.nextLine();
				if(user[i].mark(str)) {
					System.out.println("정답입니다.");
					break;
				} else {
					System.out.println("틀렸습니다.");
					System.out.println(user[i].toString());
				}
				System.out.println();
			}
			System.out.println();
			
		}
		s.close();
		
	}
}
