package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BtSignupHandler implements ActionListener{
	LoginFrame target;
	public BtSignupHandler(LoginFrame l) {
		target = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		target.win.change("SignUpFrame");
		
	}
}
