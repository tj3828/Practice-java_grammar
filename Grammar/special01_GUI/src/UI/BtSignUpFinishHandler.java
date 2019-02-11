package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class BtSignUpFinishHandler implements ActionListener{
	SignUpFrame target;
	public BtSignUpFinishHandler(SignUpFrame s) {
		target = s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = target.text_IdInput.getText().trim();
		String pw = target.text_PwInput.getText().trim();
		if(id.equals("") || pw.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 적어주세요.");
		} else {
			String path = System.getProperty("user.home");
			File f = new File(path, "MJB user");
			f.mkdir();
			File f1 = new File(f.getAbsolutePath(), id);
			if(f1.exists()) {
				JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
			} else {
				try {
					f1.createNewFile();
					DataOutputStream dos = new DataOutputStream(new FileOutputStream(path + "\\MJB user\\" + id));
					dos.writeUTF(pw);
					dos.writeInt(0);
					dos.writeInt(0);
					dos.close();
					JOptionPane.showMessageDialog(null, "아이디를 생성했습니다.");
					target.text_IdInput.setText("");
					target.text_PwInput.setText("");
					target.m.change("loginframe");
				}catch(Exception i) {}
			}
		}
	}
	
	
}
