import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/*
 * gson을 jre lib ext 폴더에 넣는다.
 */
public class Source02_Json {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String s1 = gson.toJson(true);
		System.out.println(s1);				// true
		
		String s2 = gson.toJson(13);
		System.out.println(s2);				//13
		String s3 = gson.toJson("문자열");
		System.out.println(s3);				//"문자열"
		
		int[] ar = new int[] {1,34,543,45};
		String s4 = gson.toJson(ar);		
		System.out.println(s4);				// [1,34,543,45]
		
		List<String> li = new ArrayList<>();
			li.add("월요일");
			li.add("화요일");
			li.add("수요일");
		String s5 = gson.toJson(li);
		System.out.println(s5);				// ["월요일","화요일","수요일"]
		
		Map<String, String> map = new HashMap<>();
		map.put("a", "에이");
		map.put("b", "비");
		map.put("c", "씨");
		
		String s6 = gson.toJson(map);
		System.out.println(s6);				// {"a":"에이","b":"비","c":"씨"}
		
		Hero h = new Hero("루피", 1, true);
		String s7 = gson.toJson(h);
		System.out.println(s7);
	}
}
