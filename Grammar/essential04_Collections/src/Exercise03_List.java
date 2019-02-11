import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Unit {
	String name;
	int lv;
	int exp;
	
	public Unit(String name) {
		this(name,1);
	}
	
	public Unit(String name, int lv) {
		this.name = name;
		this.lv = lv;
	}
	
	@Override
	public String toString() {
		return "[" + name + " " + lv + "Lv]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Unit))
			return false;
		Unit u = (Unit)obj;
		return u.name.equals(this.name);
	}
}

class Shop {
	static Unit gachya() {
		String[] names = "기사,아처,화살,미니언,대포,박격포,고블린".split(",");
		String n = names[(int)(Math.random()*names.length)];
		return new Unit(n);
	}
}

class UnitComparator implements Comparator<Unit> {

	@Override
	public int compare(Unit o1, Unit o2) {
		int a = o1.lv - o2.lv;
		if(a<0) return 1;
		else if(a>0) return -1;
		else return o1.name.compareTo(o2.name);
	}
	
}
public class Exercise03_List {
	public static void main(String[] args) {
		List<Unit> units = new LinkedList<>();
		Comparator<Unit> c = new UnitComparator();
		units.add(new Unit("기사", 3));
		units.add(new Unit("미니언", 2));
		System.out.println("현제 덱 : " + units.toString());
		System.out.println("시스템 : 10 연속 뽑기 시작!");
		System.out.println("시스템 : 10 번째는 고랩 유닛 등장!");
		
		for(int cnt=1; cnt<=10; cnt++) {
			Unit unit = Shop.gachya();
			if(cnt == 10) {
				unit.lv = 3;
			}
			System.out.println("PICK!! " + unit.toString());
			if(units.contains(unit)) {
				System.out.println("----> 시스템 : 기존 객체에 합성됩니다.");
				Unit u = units.get(units.indexOf(unit));
				u.lv += unit.lv;
				continue;
			}
			units.add(unit);
		}
		System.out.println("시스템  : 10연 뽑기 끝!");
		units.sort(c);		
		
		// UnitComparator 객체를 한번만 사용할 것이라면 클래스를 설계하면서 객체를 생성하고 바로 사용가능 (익명 클래스 - bin 폴더에 클래스명$숫자로 클래스가 생성됨)
		// 따로 클래스 명 지정없이 설계한 객체들을 익명 클래스 객체라함.
		Comparator<Unit> t = new Comparator<Unit>() {
			
			@Override
			public int compare(Unit o1, Unit o2) {
				int a = o1.lv - o2.lv;
				if(a<0) return 1;
				else if(a>0) return -1;
				else return o1.name.compareTo(o2.name);
			}
		};
		units.sort(t);
		System.out.println("현재덱 : " + units.toString());	// 레벨이 높은 순서대로 정렬, 같은 레벨이면 가나다 순
		
	}
}
