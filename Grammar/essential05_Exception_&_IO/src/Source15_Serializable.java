import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class User implements Serializable{
	String name;
	int exp;
	int money;
	
	User(String name){
		this.name = name;
		exp = 0;
		money = 0;
	}
	
	void goHunt() {
		exp += (int)(Math.random()*20);
		money +=(1+ (int)(Math.random()*10))*100;
	}
	
	public String toString() {
		return name + "님의 현재상태 : " + exp + " exp / " + money + " 원";
	}
}
/*
 * 객체의 In/Out은 TreeSet처럼 객체를 저장할 때 무조건 In/Out해주는 것이 아니다.
 *  - 객체를 바이트화 시킬 수 있어야 Out이 가능. 바이트화 한다는 것을 직렬화한다고 표현함.
 *  - TreeSet의 Comparable과 같이 별도의 작업이 필요한 것은 아니고 Serializable 인터페이스를 상속해주면 끝.
 *  - Serializable을 상속한 클래스 안에 직렬화할 수 없는 것을 가지고 있다면 불가능
 *  - 내부에 존재하는 객체변수들도 모두 Serializable 이어야함.
 */
public class Source15_Serializable {
	public static void main(String[] args) {
		User u = new User("v해적왕v");
		for(int cnt=1; cnt<=5; cnt++) {
			u.goHunt();
		}
		System.out.println(u.toString());
		
		try {
			String str = System.getProperty("user.home");
			File dir = new File(str, "Source15");
			if(!dir.isDirectory()) dir.mkdirs();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(dir, u.name)));
			oos.writeObject(u);
			oos.close();
		}catch(IOException e) {
			System.out.println("에러  " + e.toString());		// Serializable 인터페이스를 상속하지 않은 객체는 NotSerializableException 발생
		}
	}
}
