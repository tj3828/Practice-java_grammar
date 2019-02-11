package sample;
/*
 * 좌표 관리 객체
 * 2차원 평면상
 */
public class Coord {
	int x;
	int y;
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "[x = " + x + ", y = " + y +"]";
	}
	@Override
	// 데이터를 비교하기 위한 idDuplicated 메소드를 equals에 오버라이드하여 설계해보기
	public boolean equals(Object obj) {
	/*	다음과 같이 복사하여 한다하면 파라미터로 받은 객체의 타입이 다르기 때문에 오류.
	 *  객체값도 캐스팅을 통한 작업 필요
	 * 	if(this.x == obj.x && this.y == obj.y) {
			return true;
		} else {
			return false;
		}
	*/	
		if(obj instanceof Coord) {
			Coord other = (Coord)obj;
			return this.x == other.x && this.y == other.y;
		} else {
			return false;
		}
	}
	
	public boolean isDuplicated(Coord other) {
		if(this.x == other.x && this.y == other.y) {
			return true;
		} else {
			return false;
		}
	}
	
	// 가비지 컬렉션이 작동될 때 호출되는 메소드
	// 이론으로만 알고 있고 사용 안하는게 좋음
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}
}
