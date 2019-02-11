package UI;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class LoginFrame extends JPanel{
	String home;
	JButton bt_Login;
	JButton bt_SignUp;
	JTextField text_Id;
	JPasswordField text_Pw;
	JLabel lb_Id;
	JLabel lb_Pw;
	FrameChangeHandler win;
	
	
	public LoginFrame(FrameChangeHandler win) {
		setBackground(Color.PINK);
		setSize(1100, 750);
		this.win = win;
		home = System.getProperty("user.home");
		init();
		
		ActionListener blh = new BtLoginHandler(this);
		bt_Login.addActionListener(blh);
		ActionListener bsh = new BtSignupHandler(this);
		bt_SignUp.addActionListener(bsh);
	}
	
	private void init() {
		setLayout(null);
		
		bt_Login = new JButton("Login");
		bt_Login.setBounds(456, 376, 85, 29);
		add(bt_Login);
		
		bt_SignUp = new JButton("SignUp");
		bt_SignUp.setBounds(565, 376, 91, 29);
		add(bt_SignUp);
		
		text_Id = new JTextField();
		text_Id.setBounds(519, 286, 116, 21);
		add(text_Id);
		text_Id.setColumns(10);
		
		lb_Id = new JLabel("ID : ");
		lb_Id.setBounds(450, 289, 57, 15);
		lb_Id.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lb_Id);
		
		text_Pw = new JPasswordField();
		text_Pw.setBounds(519, 317, 116, 21);
		add(text_Pw);
		
		lb_Pw = new JLabel("PW : ");
		lb_Pw.setBounds(450, 320, 57, 15);
		lb_Pw.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lb_Pw);
	}
}
