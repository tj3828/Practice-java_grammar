import java.util.Set;
import java.util.TreeSet;
// TreeSet의 크기 비교를 위해 사용하는 compartTo를 오버라이드 하기 위한 Comparable 인터페이스 구현
// 비교하고자 하는 타입을 제너릭설정 <Card>
class Card implements Comparable<Card>{
	static String[] made;
	static {
		made = new String[] {"탱커","딜러","힐러","서포터"};
	}
	
	String name;
	int type;
	
	public Card(String n, int t) {
		name = n;
		type = t;
	}
	
	@Override
	public String toString() {
		return "{" + name + "(" + made[type] + ")}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) {
			return false;
		}
		Card c = (Card)obj;
		return c.type == this.type && c.name.equals(this.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	// Treeset 객체의 크기 비교 판단을 위해 생성
	@Override
	public int compareTo(Card o) {
		// this - other 값을 리턴	/ o가 작으면 앞쪽에 , o가 크면 o를 뒤에,
	/*	if(this.type == o.type) 
			return this.name.compareTo(o.name);
		else {
			if(type < o.type)
				return -1;										// 타입을 비교하고 같은 타입이면 이름 순
			else 
				return 1;
		}
	*/
		
		
		// 이름이 작은애가 작은 객체, 이름이 같다면 type이 작은 애가 작은객체
		int i = this.name.compareTo(o.name);
		if(i == 0){
			return this.type - o.type;
		} else {
			if(i<0)
				return -1;
			else 
				return 1;
		}
	}
}

class CardShop {
	static Card random() {
		String[] name = "루피,조로,나미,우솝,상디".split(",");
		
		Card t = new Card(name[(int)(Math.random()*name.length)], (int)(Math.random()*4));
		return t;
	}
}

public class Exercise02_Card {
	public static void main(String[] args) {
		Set<Card> cards = new TreeSet<>();		// LinkedHashSet은 똑같이 작동하지만 TreeSet은 터짐 이유는 다음 장에서
		System.out.println("7연속 카드 뽑기! 시작!! ");
		for(int cnt=1; cnt<=7; cnt++) {
			Card t = CardShop.random();
			String result = cnt + " ... " + t.toString();
			if(!cards.contains(t)) {			// contains 비교에서도 hashCode와 equals가 일어남.
				result += " NEW!";
			}
			System.out.println(result);
			cards.add(t);
		}
		for(Card m : cards) {
			System.out.println("-- " + m);
		}
	}
}
