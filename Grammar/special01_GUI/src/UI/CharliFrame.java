package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 하나의 창에 레이아웃을 섞어 사용하고 싶을 때는
 * JPanel이라는 JFrame에 장착되는 Container형 Component라 생각하면 된다.
 * 
 */
public class CharliFrame extends JFrame {
	public CharliFrame() {
		setTitle("Mixed Layout");
		// 일단 하나의 레이아웃은 생성해야함.
		setLayout(new BorderLayout());
		
		JLabel lb = new JLabel("rount 1");
		add(lb,BorderLayout.NORTH);
		
		JPanel pn = new JPanel();
			pn.setLayout(new GridLayout(1, 2));
			
			JButton bt = new JButton("READY");
			pn.add(bt);
			JPanel rpn = new JPanel();
				rpn.setLayout(new GridLayout(3, 3));
				for(int cnt=1; cnt<=9;cnt++) {
					rpn.add(new JButton());
				}
			pn.add(rpn);
		add(pn, BorderLayout.CENTER);
		
		setSize(500, 250);
		
	}
}
