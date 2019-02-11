package UI;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public LoginFrame loginframe = null;
	public FoxFrame foxframe = null;
	public SignUpFrame signupframe = null;
	
	public void change(String panelName) {
		if(panelName.equals("loginframe")) {
			getContentPane().removeAll();
			getContentPane().add(loginframe);
			revalidate();
			repaint();
		} else if(panelName.equals("foxframe")){
			getContentPane().removeAll();
			getContentPane().add(foxframe);
			revalidate();
			repaint();
		} else {
			getContentPane().removeAll();
			getContentPane().add(signupframe);
			revalidate();
			repaint();
		}
	}
}
