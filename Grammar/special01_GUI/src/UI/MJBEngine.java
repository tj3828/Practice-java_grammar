package UI;

public class MJBEngine {
	boolean attack;
	int auto;
	boolean finish = false;
	
	public MJBEngine() {
		attack = false;
		auto = 0;
	}
	public void Start() {
		attack = Math.random() > 0.5;
	}
	
	public void setAuto() {
		auto = (int)(Math.random()*3); 
	}
	
	public String compare(int choice) {
		if(!attack == true && choice == auto) {
			finish = true;
			return "승부가 났습니다!\nAI가 승리하였습니다!";
			
		}else if(attack == true && choice == auto) {
			finish = true;
			return "승부가 났습니다!\n사용자가 승리하였습니다!";
			
		} else {
			// 이 else branch 안에서, branch를 좀 더 만들어서 공격권을 유지하거나, 바꿔줘야 한다.
			
			if((attack == true) &&
			   ((choice == 0 && auto == 2) ||
			   (choice == 1 && auto == 0) ||
			   (choice == 2 && auto == 1))) { // 공격중이었는데, 가위 바위 보를 진 상황
				attack = false;
				return "승부가 나지 않았습니다..\n공격권이 변경되었습니다!\n공격권이 AI에게 넘어갑니다.";
				
			}else if((attack == false) &&
			         ((choice == 0 && auto == 2) ||
			         (choice == 1 && auto == 0) ||
			         (choice == 2 && auto == 1))) { // 수비중이었는데, 가위 바위 보를 진 상황
				return "승부가 나지 않았습니다..\n공격권이 AI에게 유지됩니다.";
				
				

			}else if((attack == false) &&
				     ((choice == 0 && auto == 1) ||
			         (choice == 1 && auto == 2) ||
			         (choice == 2 && auto == 0))) {
				attack = true;
					return "승부가 나지 않았습니다..\n공격권이 변경되었습니다!\n공격권이 사용자에게 넘어갑니다.";  // 수비중이었는데, 가위 바위 보를 이긴 상황
				

			}else if ((attack == true) &&
				      ((choice == 0 && auto == 1) ||
			          (choice == 1 && auto == 2) ||
			          (choice == 2 && auto == 0))) {
					return "승부가 나지 않았습니다..\n공격권이 사용자에게 유지됩니다.";  // 공격중이었는데, 가위 바위 보를 이긴 상황
			}		
			else {
					return "";
			}
		}
	}
}
