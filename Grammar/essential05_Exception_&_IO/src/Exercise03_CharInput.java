import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * access_log.txt 파일의 내용을 가져와
 * ip별 요청회수 통계
 */
public class Exercise03_CharInput {
	public static void main(String[] args) {
		File f = new File("access_log.txt");
		Map<String,List<String>> map = new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(f));) {
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				String[] temp = line.split("-");
				if(!(map.containsKey(temp[0]))) {
					map.put(temp[0], new ArrayList<>());
				}
				map.get(temp[0]).add(temp[2]);
				
			}
			System.out.println("총 아이피 개수 : " + map.size() + "개");
			System.out.println();
			for(String m : map.keySet()) {
				System.out.println("====" + m + " 의 정보 (" + map.get(m).size() + ")개 ====");
				for(String li : map.get(m)) {
					System.out.println(li);
				}
				System.out.println();
			}
		}catch(IOException e) {
			System.out.println("input failed ...");
		}
	}
}
