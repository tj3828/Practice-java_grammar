package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtLogoutHandler implements ActionListener {
	FoxFrame target;
	public BtLogoutHandler(FoxFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		target.m.change("loginframe");
	}
	
}
