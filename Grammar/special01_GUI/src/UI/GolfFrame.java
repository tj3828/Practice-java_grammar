package UI;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 사용자의 행동에 따라 이벤트가 발생하게 되었을 때 내부적으로 처리해줄 기능을 정의하는 법
 * - 이벤트가 발생했을 때 정의할 수 있는 선언문은 작성되어 있기 때문에 우리가 처리할 기능만 정의해주면 됨.
 * 
 * 설계
 * 버튼 클릭시 텍스트필드의 문자를 label에 출력
 */ 

/* JButton
 * - 사용자가 버튼을 누르면 Action이라는 이벤트가 발생
 * - ActionListener 인터페이스를 토대로 클래스를 설계
 * 
 */
class BtActionHandler implements ActionListener {
	JTextField targetTf;
	JLabel targetLb;
	
	public BtActionHandler(JTextField targetTf, JLabel targetLb) {
		this.targetTf = targetTf;
		this.targetLb = targetLb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = targetTf.getText();
		targetLb.setText(str);
		targetTf.setText("");
	}
	
}

class TfActionHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Tf ... actionPerformed..." + e);
		
	}
	
	
}

public class GolfFrame extends JFrame{
	private JTextField tf;
	public GolfFrame() {
		setSize(900,600); 									// 디자인에서는 실행시 창 크기를 조절할 수 없어 수동으로 설정해야함
		getContentPane().setLayout(null);
		
		JButton bt = new JButton("New button");
	
		bt.setBounds(219, 248, 113, 36);
		getContentPane().add(bt);
		
		JLabel lb = new JLabel("New label");
		lb.setBounds(246, 80, 57, 15);
		getContentPane().add(lb);
		
		tf = new JTextField();
		tf.setBounds(219, 153, 125, 30);
		
		getContentPane().add(tf);
		tf.setColumns(10);
		
	//	bt.addActionListener(new BtActionHandler());		// 버튼 클릭 이벤트 발생시 사용될 기능
		ActionListener l = new BtActionHandler(tf, lb);		// 제어해야하는 GUI객체값을 넘겨줌.
		bt.addActionListener(l);
		
		tf.addActionListener(new TfActionHandler());		// 텍스트 필드 클릭시 작동
	}
}
