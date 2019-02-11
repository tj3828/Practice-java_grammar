package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

public class BtLoginHandler implements ActionListener {
	LoginFrame target;
	public BtLoginHandler(LoginFrame l) {
		target = l;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = target.text_Id.getText().trim();
		String pw = String.valueOf(target.text_Pw.getPassword()).trim();
		
		target.win.f = new File(target.home + "\\MJB user\\", id);
		
		if(target.win.f.exists()) {
			try {
				DataInputStream fis = new DataInputStream(new FileInputStream(target.win.f));
				String psw = fis.readUTF();
				if(psw.equals(pw)) {
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					target.win.foxframe = new FoxFrame(target.win);
					target.win.change("foxframe");					
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
				}
				fis.close();
			}catch(Exception i) {}
		} else {
			JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
		}
		target.text_Id.setText("");
		target.text_Pw.setText("");
	}
	
}
