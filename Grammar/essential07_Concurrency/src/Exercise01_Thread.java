import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Exercise01_Thread extends JFrame{
	private JTextField textField;
	private JLabel lb;
	
	public Exercise01_Thread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		getContentPane().setLayout(null);
		
		lb = new JLabel("");
		lb.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb.setBounds(12, 10, 360, 52);
		getContentPane().add(lb);
		
		textField = new JTextField();
		textField.setBounds(256, 198, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		new Thread() {
			@Override
			public void run() {
				for(;;) {
					try {
						Thread.sleep(1000);
						String txt = "WELCOME TO MY HOME";
						for(int end=1;end<=txt.length();end++) {
							lb.setText(txt.substring(0, end));
								Thread.sleep(100);
						}
					}catch(Exception e) {}
				}
			}
		}.start();
		
	}
	
	public static void main(String[] args) {
		JFrame f = new Exercise01_Thread();
		f.setVisible(true);
	}
}
