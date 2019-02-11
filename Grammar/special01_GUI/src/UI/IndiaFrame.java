package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/*
 * 전에 만든 UpDown 게임을 GUI로 설계
 */
class BtStartHandler implements ActionListener {
	IndiaFrame target;
	
	public BtStartHandler(IndiaFrame h) {
		target = h;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		target.engine.start();
		target.tf.setText("");
		target.btStart.setEnabled(false);
		target.tf.setEnabled(true);
		target.tf.setEditable(true);
		target.lbStatus.setEnabled(true);
		target.lbStatus.setText(target.engine.tell());
		
	}
}

class TfInputHandler implements ActionListener {
	IndiaFrame target;
	
	public TfInputHandler(IndiaFrame h) {
		target = h;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = target.tf.getText();
		if(str.matches("\\d{1,3}")) { 
			int data = Integer.parseInt(str);
			String result = target.engine.compare(data);
			if(target.engine.isRun()) {
				target.lbStatus.setText(result);
				JOptionPane.showMessageDialog(target, result);
				target.lbStatus.setText(target.engine.tell());
			} else {
				target.lbStatus.setText("맞췄습니다.");
				target.btStart.setEnabled(true);
				target.tf.setEnabled(false);
				target.tf.setEditable(false);
				target.lbStatus.setEnabled(false);
			}
		}
	}	
}

public class IndiaFrame extends JFrame {
	IndiaEngine engine;
	
	JTextField tf;
	JLabel lbStatus;
	JButton btStart;
	
	public IndiaFrame() {
		engine = new IndiaEngine();
		init();
		
		ActionListener bsh = new BtStartHandler(this);
		btStart.addActionListener(bsh);
		
		ActionListener tih = new TfInputHandler(this);
		tf.addActionListener(tih);
	}
	
	private void init() {
		setSize(500, 400);
		getContentPane().setLayout(null);
		
		btStart = new JButton("START");
		btStart.setBounds(375, 10, 97, 23);
		getContentPane().add(btStart);
		
		lbStatus = new JLabel("??");
		lbStatus.setEnabled(false);
		lbStatus.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbStatus.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		lbStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatus.setBounds(12, 82, 460, 189);
		getContentPane().add(lbStatus);
		
		tf = new JTextField();
		tf.setEditable(false);
		tf.setEnabled(false);
		tf.setFont(new Font("굴림", Font.BOLD, 18));
		tf.setHorizontalAlignment(SwingConstants.CENTER);
		tf.setBounds(186, 281, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);
	}
}
