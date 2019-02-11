package UI;
import java.awt.*;
import javax.swing.*;

public class BravoFrame extends JFrame {
	public BravoFrame() {
		// 보통 4가지의 레이아웃을 많이 사용
		// Grid - 바둑판 형식의 레이아웃 사용할 때
		// 		- JFrame의 부영역을 설정한 행렬로 분할하고 컴포넌트들이 같은 크기로 ->방향으로 배치
		// Border - 화면을 동서남북과 가운데 영역으로 분할해서 컴포넌트를 위치잡아 배치
		// AbsoluteLayout(null) - 화면을 좌표로 설정해서 원하는 곳에 원하는 크기로 컴포넌트를 배치.

		
		// 여기서 실행시키면 메인메소드가 없는데 자동으로 제일 최근의 메인을 찾아서 실행시킴.
	// 	initTypeA();  	// Borderlayout
	//	initTypeB();	// AbsoluteLayout(null)
	}
	public void initTypeA() {			// Border
		setLayout(new BorderLayout());
		setTitle("BorderLayout");
		JLabel lb = new JLabel("Graphic User Interface");
		add(lb,BorderLayout.CENTER);	// 레이아웃에 
		JTextField tf = new JTextField();
		add(tf,BorderLayout.SOUTH);
		JToggleButton bt = new JToggleButton("READY");
		add(bt,BorderLayout.NORTH);
		setSize(400, 300);
	}
	
	public void initTypeB() {			// AbsoluteLayout
		setTitle("AbsoluteLayout");
		setLayout(null);				// 레이아웃을 안쓰겠다는것
		setSize(500, 300);
		
		JTextField tf = new JTextField();
			tf.setSize(100, 30);
			tf.setLocation(300,180); 		// JFrame을 기준으로 시작 위치 설정
		JPasswordField pf = new JPasswordField();
			pf.setBounds(300,220,150,30);	// Size와 Location을 동시에 설정
			
		add(tf);						// 컴포넌트 사이즈 설정을 안하면 컴포넌트 출력이 불가
		add(pf);
	}
}
