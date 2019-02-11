import javax.swing.JFrame;

import UI.FrameChangeHandler;
import UI.LoginFrame;
import UI.SignUpFrame;

public class Source04_GraphicUI {
	public static void main(String[] args) {
	//	JFrame f = new GolfFrame();
	//	f.setVisible(true);
	//	JFrame h = new HotelFrame();
	//	h.setVisible(true);
	//	JFrame h = new IndiaFrame();
		FrameChangeHandler h = new FrameChangeHandler();
		
		h.setTitle("¹¬Âîºü Login");
		h.loginframe = new LoginFrame(h);
		h.signupframe = new SignUpFrame(h);
		
		h.add(h.loginframe);
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		h.setSize(1100, 750);
		h.setVisible(true);
	}
}
