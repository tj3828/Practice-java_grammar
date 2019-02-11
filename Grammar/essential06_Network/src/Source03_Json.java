import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Source03_Json {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String s1 = "true";
		boolean b = gson.fromJson(s1, Boolean.class);
		System.out.println(b);	// true
		
		String s2 = "[11,22,33,5,79]";
		int[] ar = gson.fromJson(s2, int[].class);
		for(int a : ar) {
			System.out.println("--" + a);
		}
	//	gson.fromJson(s2, Integer.class);	// 변경 불가
		
		Hero h = new Hero("손오공", 7, true);
		String s3 = gson.toJson(h);
		System.out.println(s3);
		
		Hero hh = gson.fromJson(s3, Hero.class);
		System.out.println(hh.name);
		System.out.println(hh.type);
		System.out.println(hh.special);
		
		List li = gson.fromJson(s2, List.class);
		for(Object obj : li) {
			System.out.println((obj instanceof Integer) +" / " + (obj instanceof Double));
		}
		String s4 = "[11,3.14,true,11]";	// 이런형태의 표기가 가능해서.
		Map map = gson.fromJson(s3, Map.class);
		System.out.println(map.get("name") instanceof String);	
		System.out.println(map.get("type") instanceof Double);
		System.out.println(map.get("special") instanceof Boolean);
		//=========================================================================
		
		
		
		
	}
}
