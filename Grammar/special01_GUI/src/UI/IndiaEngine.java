package UI;

/*
procedure 를 이용한 UpDown Game을 구현해보았는데, 
데이터관리나 처리를 좀더 편하게 하기 위해서 UpDownEngine 객체를 설계해보고
그걸 토대로 한번 더 1인용, 대전용을 만들어보자. 
*/
public class IndiaEngine {
	// storage
	int target;	// 정답-
	int min, max;	// 가능한 최소값과 최대값
	int tried;	// 시도회수
	boolean flag;	// 끝났는지 안끝났는지 기억시켜둘 값
	
	//==================================================
	// 엔진객체 초기화
	void start() {
		// target 이 1~200사이 랜덤으로 설정되고
		target = 1+(int)(Math.random()*200);
		// min, max 가 1과 200으로 설정되고
		min =1;
		max =200;
		// tried 가 0 이되고
		tried = 1;
		// flag 가 true로 바뀌게
		flag = true;
	}
	
	int recommend() {
		if(Math.random() >0.95) {
		// min ~ max 사이 범위 의 랜덤정수 하나를 만들어주게
			return min + (int)(Math.random()* (max-min +1));
		}else {
			return target;
		}
	}
	
	String compare(int data) {
		// 전달받은 숫자와 자신의 target 을 비교해서
		// "CORRECT", "TOO HIGH" , "HIGH" , "LOW", "TOO LOW"
		//   같으면    data가 타겟보다 큰데 그 차가 50 넘으면 "TOO HIGH", 그렇지 않으면 "HIGH"
		// data가 자신의 target보다 작은데 그차가 50이 넘으면 "TOO LOW", 그렇지 않으면 "LOW"
		tried++;
		if(data == target) {
			flag = false;
			return "CORRECT";
		}else if(data <target) {
			min = data >min ? data : min ;
			if(target-data >50) 
				return "TOO LOW";
			else
				return "LOW";
		}else {
			if(data <max)
				max = data;
	
			if(data-target >50) 
				return "TOO HIGH";
			else
				return "HIGH";
		}
	
		// 이걸하면서 동시에, min~ max 수정해두고, tried 올리고, 같으면 flag를 false로 바꾸게.
	}
	
	boolean isRun() {
		// 엔진이 작동중인지 아닌지 알려주기
		return flag == true;
	}
	
	String tell() {
		// 현재 자신의 엔진 상태를 한줄짜리 문자열로 만들어서 알려주기
		return tried+"'s TRY ("+min +" ~ "+max+") ";
	}
}
