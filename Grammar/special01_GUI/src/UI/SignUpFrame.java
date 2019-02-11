package UI;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SignUpFrame extends JPanel{
	JTextField text_IdInput;
	JTextField text_PwInput;
	JButton bt_Ok;
	FrameChangeHandler m;
	public SignUpFrame(FrameChangeHandler m) {
		setBackground(Color.PINK);
		this.m = m;
		setSize(1100, 750);
		setLayout(null);
		
		bt_Ok = new JButton("\uC644\uB8CC");
		bt_Ok.setBounds(496, 431, 97, 23);
		add(bt_Ok);
		
		text_IdInput = new JTextField();
		text_IdInput.setBounds(513, 250, 116, 21);
		add(text_IdInput);
		text_IdInput.setColumns(10);
		
		text_PwInput = new JTextField();
		text_PwInput.setBounds(513, 294, 116, 21);
		add(text_PwInput);
		text_PwInput.setColumns(10);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(433, 253, 57, 15);
		add(lblId);
		
		JLabel lblPw = new JLabel("PW :");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setBounds(433, 297, 57, 15);
		add(lblPw);
		
		ActionListener bsfh = new BtSignUpFinishHandler(this);
		bt_Ok.addActionListener(bsfh);
	}

}
