import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
class FrameKeyHandler implements KeyListener {
	Exercise02_Thread ui;
	public FrameKeyHandler(Exercise02_Thread ui) {
		this.ui = ui;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		// 글자가 찍히는 것들
		System.out.println("ketTyped() 호출");
	}

	@Override
	public void keyPressed(KeyEvent e) {	// 글자 or 화살표
		
		if(e.getKeyCode() == 10) {
			System.out.println("keyPressed() 호출 / " + e.getKeyCode());
			if(ui.getTitle().equals("START")) {
				System.out.println("pause");
				ui.setTitle("STOP");
				ui.t.suspend();
			}
			else if(ui.getTitle().equals("STOP")){
				System.out.println("resume");
				ui.setTitle("START");
				ui.t.resume();
			}
		} else if (e.getKeyCode() == 27){
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {	// 키에서 땠을때
		System.out.println("keyReleased() 호출");
	}
	
}
public class Exercise02_Thread extends JFrame{
	JLabel lb;
	Thread t;
	public Exercise02_Thread() {
		setTitle("START");
		setSize(400, 400);
		getContentPane().setLayout(null);
		
		lb = new JLabel("");
		lb.setBounds(104, 135, 173, 64);
		getContentPane().add(lb);
		
		
		this.addKeyListener(new FrameKeyHandler(this));
		t = new Thread() {
			@Override
			public void run() {
				int n = 0;
				while(true) {
					lb.setText(String.valueOf(n++));
				}
			}
		};
		t.start();
		
	}
	
	public static void main(String[] args) {
		JFrame t = new Exercise02_Thread();
		t.setVisible(true);
	}
	
}
