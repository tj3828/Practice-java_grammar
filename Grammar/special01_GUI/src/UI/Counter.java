package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Counter implements ActionListener {
	int n = 5;
	FoxFrame target;
	Timer t = null;
	
	public Counter(FoxFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(n ==0) {
			target.text_Log.append("5초의 시간이 모두 지났습니다. 졌습니다.");;
			target.bt_Muk.setEnabled(false);
			target.bt_Scissor.setEnabled(false);
			target.bt_Paper.setEnabled(false);
			target.text_Log.setEnabled(false);
			target.lbUser.setEnabled(false);
			target.bt_Start.setEnabled(true);
			target.lb_Com.setEnabled(false);
			target.bt_Logout.setEnabled(true);
			target.setInfo(-1);
			target.lb_info.setText(target.getInfo());
			target.lb_Rank.setText(target.getRank());
			t.stop();
		}
		
		target.lbCounter.setText(String.valueOf(n--));
	}
	
	public int getCount() {
		return n;
	}
	
	public void setTimer(Timer t) {
		this.t = t; 
	}
   
}
