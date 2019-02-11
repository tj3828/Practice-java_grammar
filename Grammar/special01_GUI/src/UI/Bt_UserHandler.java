package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Bt_UserHandler implements ActionListener {
	FoxFrame target;
	int type;
	public Bt_UserHandler(FoxFrame f, int d) {
		target = f;
		type = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	//	target.cnt.stop();
		target.timer.stop();
		if((JButton)e.getSource() == target.bt_Muk)
			target.lbUser.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\bigrock.png"));
		else if(type == 1)
			target.lbUser.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\bigscissors.png"));
		else if(type == 2)
			target.lbUser.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\bigpaper.png"));
		
		target.engine.setAuto();
		int auto = target.engine.auto;
		if(auto == 0)
			target.lb_Com.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\bigrock.png"));
		else if(auto == 1)
			target.lb_Com.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\bigscissors.png"));
		else if(auto == 2)
			target.lb_Com.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\bigpaper.png"));
		
		String str = target.engine.compare(type);
		target.text_Log.append(str+"\n");
		if(target.engine.finish) {
		//	target.cnt = null;
			target.setInfo(target.engine.attack ? 1 : -1);
			target.lb_info.setText(target.getInfo());
			target.lb_Rank.setText(target.getRank());
			target.bt_Muk.setEnabled(false);
			target.bt_Scissor.setEnabled(false);
			target.bt_Paper.setEnabled(false);
			target.text_Log.setEnabled(false);
			target.lbUser.setEnabled(false);
			target.bt_Start.setEnabled(true);
			target.lb_Com.setEnabled(false);
			target.bt_Logout.setEnabled(true);
		} 
		else {
			if(target.engine.attack){
			//	target.cnt = null;
			//	target.setThread();
			//	target.cnt.start();
				target.setTimer();
				target.timer.start();
				target.lbUserAttack.setVisible(true);
				target.lbComAttack.setVisible(false);
				target.lbUser.setBorder(new LineBorder(new Color(255, 0, 0), 4));
				target.lbUserName.setBorder(new LineBorder(new Color(255, 0, 0), 4));
				target.lb_Com.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				target.lbComName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			} else {
			//	target.cnt = null;
			//	target.setThread();
			//	target.cnt.start();
				target.setTimer();
				target.timer.start();
				target.lbUserAttack.setVisible(false);
				target.lbComAttack.setVisible(true);
				target.lb_Com.setBorder(new LineBorder(new Color(255, 0, 0), 4));
				target.lbComName.setBorder(new LineBorder(new Color(255, 0, 0), 4));
				target.lbUser.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				target.lbUserName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			}
		}
	}
}
