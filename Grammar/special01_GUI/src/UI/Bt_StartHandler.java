package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class Bt_StartHandler implements ActionListener {
	FoxFrame target;
	
	public Bt_StartHandler(FoxFrame f) {
		target = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		target.engine.finish = false;
		target.bt_Muk.setEnabled(true);
		target.bt_Scissor.setEnabled(true);
		target.bt_Paper.setEnabled(true);
		target.text_Log.setText("");
		target.text_Log.setEnabled(true);
		target.lbUser.setIcon(new ImageIcon(""));
		target.lbUser.setEnabled(true);
		target.lb_Com.setIcon(new ImageIcon(""));
		target.lb_Com.setEnabled(true);
		target.bt_Start.setEnabled(false);
		target.bt_Logout.setEnabled(false);
		target.text_Log.append("게임이 시작되었습니다!!\n");
		target.engine.Start();
		
		if(target.engine.attack) {
			target.lbUserAttack.setVisible(true);
			target.lbComAttack.setVisible(false);
			target.lb_Com.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			target.lbComName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			target.lbUser.setBorder(new LineBorder(new Color(255, 0, 0), 4));
			target.lbUserName.setBorder(new LineBorder(new Color(255, 0, 0), 4));
			target.text_Log.append("사용자가 먼저 공격입니다!!\n");
			target.text_Log.append("버튼을 클릭하여 가위바위보를 하세요!\n");
		} else {
			target.lbUserAttack.setVisible(false);
			target.lbComAttack.setVisible(true);
			target.lbUser.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			target.lbUserName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			target.lb_Com.setBorder(new LineBorder(new Color(255, 0, 0), 4));
			target.lbComName.setBorder(new LineBorder(new Color(255, 0, 0), 4));
			target.text_Log.append("컴퓨터가 먼저 공격입니다!!\n");			
			target.text_Log.append("버튼을 클릭하여 가위바위보를 하세요!\n");
		}
		// target.setThread();
		// target.cnt.start();
		target.setTimer();
		target.timer.start();
	}
	
}
