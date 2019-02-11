package UI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

/*
 * Listener의 인자로 하나씩 제어하면 컴포넌트의 개수가 많아졌을 때 처리하기 힘든 단점이 있다.
 * 이럴때 사용하는 방법.
 */

class BtConnectHandler implements ActionListener{
	HotelFrame target;
	public BtConnectHandler(HotelFrame f) {
		target = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BtConnectHandler actionPerformed.. ");
		String data = target.tf.getText();
		String pw = target.pf.getText();
		target.tf.setEnabled(false);	// 비활성화
		target.pf.setEnabled(false);	// 비활성화
		target.btConnect.setEnabled(false);		// 비활성화
		String rst = "[SYSTEM] connect to server" + data + " ... " + pw + "\n";
		target.textArea.append(rst);
		target.lblNewLabel.setText("Welcome!!");
	}
}

class BtCancelHandler implements ActionListener {
	HotelFrame target;
	public BtCancelHandler(HotelFrame h) {
		target = h;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		target.tf.setText("");
		target.pf.setText("");
		target.tf.setEnabled(true);
		target.pf.setEnabled(true);
		target.btConnect.setEnabled(true);
		String rst = "[SYSTEM] cancel to server\n";
		target.textArea.append(rst);
		target.lblNewLabel.setText("plz Connect..");
	}
}
   

public class HotelFrame extends JFrame {
	JPasswordField pf;
	JTextField tf;
	JButton btCancel;
	JButton btConnect;
	JTextArea textArea;
	JLabel lblNewLabel;
	
	public HotelFrame() {
		init();
		
		ActionListener bch = new BtConnectHandler(this);	// 자신의 객체를 넘기면서 일일이 인자를 넘기지 않아도됨
		btConnect.addActionListener(bch);
		
		ActionListener bch2 = new BtCancelHandler(this);
		btCancel.addActionListener(bch2);
	}
	
	public void init() {
		setSize(400, 300);
		getContentPane().setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(141, 46, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(141, 77, 116, 21);
		getContentPane().add(pf);
		
		btConnect = new JButton("Connect");
		btConnect.setBounds(82, 108, 97, 23);
		getContentPane().add(btConnect);
		
		btCancel = new JButton("Cancel");
		btCancel.setBounds(214, 108, 97, 23);
		getContentPane().add(btCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 141, 360, 110);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		lblNewLabel = new JLabel("plz Connect");
		lblNewLabel.setBounds(164, 20, 76, 15);
		getContentPane().add(lblNewLabel);
	}
}
