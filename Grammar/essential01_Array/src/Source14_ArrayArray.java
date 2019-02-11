
class Sim {
	static String[] first;
	static String[] last;
	
	static {
		first = new String[] {"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임"};
		last = new String[] {"하준", "도윤", "서준", "시우", "민준", "하윤", "서윤", "서연", "하은", "지우"};
	}
	
	String name;
	int age;
	boolean gender;
	
	Sim() {
		int fidx = (int)(Math.random()*first.length);
		int lidx = (int)(Math.random()*last.length);
		
		name = first[fidx] + last[lidx];
		name.intern(); // String 객체의 데이터를 비교하고자 할 때 == 사용가능하게 함.
		age = 7 + (int)(Math.random()*50);
		gender = Math.random()>0.5;
	}
	
	@Override
	public String toString() {
		// 이름(xx세/성별)
		return name + "(" + age +"세 / " + (gender ? "남성" : "여성") +")";
	}
}

public class Source14_ArrayArray {
	public static void main(String[] args) {
		Sim[][] families = new Sim[7][];
		
		// 2~5인 가구의 배열에 Sim 객체를 설정하여 families에 등록
		for(int i=0; i<families.length; i++) {
			families[i] = new Sim[2+(int)(Math.random()*4)];	
			System.out.print(i+1 + "번째 구성원 : ");
			for(int j=0; j<families[i].length; j++) {
				families[i][j] = new Sim();
				System.out.print(families[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 가족들 중 남녀 각각 명수
		for(int i=0; i<families.length; i++) {
			System.out.print(i+1 + "번째 가족 남녀 구성 : ");
			int man = 0, girl = 0;
			for(int j=0; j<families[i].length; j++) {
				if(families[i][j].gender == true) {
					man++;
				} else {
					girl++;
				}
			}
			System.out.println("남자의 수 : " + man + "명, 여자의 수 : " + girl + "명");
		}
		
		System.out.println();
		// 2인가족의 수
		int count = 0;;
		for(int i=0; i<families.length; i++) {
			if(families[i].length == 2) {
				count++;
			}
		}
		System.out.println("2인 가족인 가구 : " + count + "개");

		// 10대는 몇명인가 (10~19)
		System.out.println();
		int num = 0;
		for(int i=0; i <families.length; i++) {
			for(int j=0; j< families[i].length; j++) {
				if(families[i][j].age >=10 && families[i][j].age<=19) {
					num++;
				}
			}
		}
		System.out.println("10대의 수 : " + num + "명");
		
		// families 중에 박시우 이름가진 사람이 존재하나
		System.out.println();
		boolean result = false;
		for(int i=0; i <families.length; i++) {
			for(int j=0; j< families[i].length; j++) {
				if(families[i][j].name == "박시우") {
					result = true;
				}
			}
		}
		if(result == true) {
			System.out.println("박시우란 이름을 가진 사람이 존재합니다.");
		} else {
			System.out.println("박시우란 이름을 가진 사람이 존재하지 않습니다.");
		}
		
		// families에 들어가져 있는 Sim중 하나를 random()으로 뽑아라.
		System.out.println();
		Sim pick = null;
		int a = (int)(Math.random()*families.length);
		pick = families[a][(int)(Math.random()*families[a].length)];
		System.out.println(pick + " 이/가 모든 가족들의 창찬을 받습니다.");
		
	}
}
