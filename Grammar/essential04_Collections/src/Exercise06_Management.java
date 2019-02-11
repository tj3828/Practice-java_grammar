import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

/*
 * 문자열 관리 시스템
 * - String 객체
 * - List와 Map을 섞어서 사용
 */
public class Exercise06_Management {
	
	// 이름이 존재하면 삭제 (list에 아무도 들어있지 않는 키값도 삭제)
	static boolean checkNameDel(Map<String,List<String>> groups, String name) {
		for(String s : groups.keySet()) {
			List<String> list = groups.get(s);
			if(list.contains(name)) {
				list.remove(name);
				if(list.isEmpty() ) {
					groups.remove(s);
				}
				return true;
			}
		}
		return false;
	}
	
	// 찾고자하는 이름이 있는가
	static Map.Entry<String, List<String>> checkName(Map<String,List<String>> groups, String str) {
		Set<Entry<String, List<String>>> eset = groups.entrySet();
		for(Entry<String,List<String>> e : eset) {
			for(String s : e.getValue()) {
				if(s.equals(str))
					return e;
			}
		}
		return null;
	}
	
	// 생성하고자 하는 키값이 이미 존재하는가
	static boolean checkGroup(Map<String,List<String>> groups, String str) {
		if(groups.containsKey(str))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		Map<String,List<String>> groups = new TreeMap<>();
		
				
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print("SYSTEM> ");
			String cmd = s.nextLine();
			String[] ar = cmd.split(" ");
			switch(ar[0]) {
				case "저장":
					checkNameDel(groups, ar[1]);
					/*
					 * groups.get(ar[2]) == null 로 체크해도 checkGroup과 같은 기능 가능.
					 */
					if(checkGroup(groups, ar[2])) {
						groups.get(ar[2]).add(ar[1]);
						System.out.println(ar[1] + "은/는 " + ar[2] + "소속으로 저장되었습니다.");
					} else {
						groups.put(ar[2], new ArrayList<>());
						System.out.println(ar[2] + "소속이 새로 생성되었습니다");
						groups.get(ar[2]).add(ar[1]);
						System.out.println(ar[1] + "은/는 " + ar[2] + "소속으로 저장되었습니다.");
					}
					break;
					
				case "삭제":
					boolean b = checkNameDel(groups, ar[1]);
					if(b) {
						System.out.println(ar[1] + "은/는 삭제되었습니다.");
					} else {
						System.out.println(ar[1] + "은/는 존재하지 않습니다.");
					}
					break;
				case "확인":
					Map.Entry<String,List<String>> e = checkName(groups, ar[1]);
					if(e == null) {
						System.out.println(ar[1] + "은/는 존재하지 않습니다.");
					} else {
						System.out.println(ar[1] + "은/는 " + e.getKey() +"소속에 등록되어있습니다.");
					}
					break;
				case "전체":
					for(String m : groups.keySet()) {
						System.out.println("====" + m + "소속의 인원입니다. ====");
						System.out.println(groups.get(m));
					}
					if(groups.isEmpty()) {
						System.out.println("설정된 정보가 없습니다. 설정해주세요.");
					}
					break;
				case "종료":
					System.out.println("종료되었습니다.");
					System.exit(0);
					break;
			}
			
		}
		/*
		 * 처리 메뉴
		 * - 저장 / 이름 / 소속 	(이름은 고유해야함, Map에 어딘가에 동일한 이름이 존재한다면 삭제하고 해당 소속에 저장)
		 *      		   	(새로운 소속이면 소속을 생성하고 저장)
		 * - 삭제 / 이름
		 * - 확인 / 이름 	(존재한다면 ?? 은/는 ??소속에 등록되어있습니다.)
		 * - 전체 		(저장되어 있는 모든 이름을 출력)
		 */
	}
}
