
public class Exercise02_Math {
	public static void main(String[] args) {
		// 위도, 경도 두 쌍일 때 거리 계산
		double x1 = Math.toRadians(127.0254323); //경도
		double y1 = Math.toRadians(37.497942);	//위도
		
		
		double x2 = Math.toRadians(127.0979449);
		double y2 = Math.toRadians(37.5132612);
		
		double deltaX = x2 - x1;
		double deltaY = y2 - y1;
		double a = Math.pow(Math.sin(deltaY/2.0),2) + Math.cos(y1) * Math.cos(y2) * Math.pow(Math.sin(deltaX/2.0),2);
		double c = 2.0 * Math.atan(Math.sqrt(a)/Math.sqrt(1-a));
		double d = 6371.0 * c;
		System.out.println(d);
	}
}
