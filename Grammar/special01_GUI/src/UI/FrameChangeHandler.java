package UI;

import java.io.File;

import javax.swing.JFrame;

public class FrameChangeHandler extends JFrame{
	public LoginFrame loginframe = null;
	public FoxFrame foxframe = null;
	public SignUpFrame signupframe = null;
	public File f = null;
	
	public void change(String panelName) {
		if(panelName.equals("loginframe")) {
			this.getContentPane().removeAll();
			this.setTitle("묵찌빠 Login");
			this.getContentPane().add(loginframe);
			this.revalidate();
			this.repaint();
		} else if(panelName.equals("foxframe")){
			this.getContentPane().removeAll();
			this.setTitle("묵찌빠");
			this.getContentPane().add(foxframe);
			this.revalidate();
			this.repaint();
		} else {
			this.getContentPane().removeAll();
			this.setTitle("묵찌빠 SignUp");
			this.getContentPane().add(signupframe);
			this.revalidate();
			this.repaint();
		}
	}
}
