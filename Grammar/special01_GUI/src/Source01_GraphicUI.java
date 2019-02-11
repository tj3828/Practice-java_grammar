import java.awt.*;

import javax.swing.*;

/*
 * 사용자에게 보여지는 툴을 만들고자할 때 그래픽화 시켜 사용되는 클래스들.
 * 내부적으로 데이터를 관리하고 수정하는 것이 아니라 사용자에게 보여지는 외관을 설계하는 것
 * 
 *  ## GUI(Grapchical User Interface 구축에 사용되는 클래스)
 *  - 종류가 매우 많아서 외우는 것도 힘듬. 클래스에 있는 기능들도 많다.
 *  - 사용하는게 복잡할 수도 있으나 직관적으로 사용할 수 있게 되어있음.
 *  - javax.swing 패키지와 java.awt 패키지에 나누어 설계되어있음.
 */
public class Source01_GraphicUI {
	public static void main(String[] args) {
		// 기본 Base가 될 Container 계열의 객체를 생성해서, 배치를 어떤식으로 할껀지 설정 후, Component 계열의 객체를 배열시켜 나가는 형태.
		
		// Container 계열
		// - JFrame, JWindow, JDialog
		JFrame f = new JFrame();				// 기본 창을 생성할 때 사용하는 클래스 (default : invisible)
	//	JDialog f = new JDialog();				// JFrame과 비슷하지만 프로그램에서 일부분을 새로운 창으로 띄울 때 사용
	//	JWindow f = new JWindow();				// JFrame과 비슷하지만 타이틀이 없는 창으로 이클립스 처음 시작할 때 로딩창과 같은 창
		f.setSize(500, 400);					// 창의 크기 설정
		f.setLocation(300, 100);				// 왼쪽 상단을 0,0으로 잡고 프로그램 위치 설정
		f.setTitle("Graphic UI");				// 프로그램 타이틀 설정, JWindow에는 없음.
		
	//	LayoutManager layout = new GridLayout(1, 2);	// 창의 레이아웃을 설정
		LayoutManager layout = new FlowLayout(0);		// 레이아웃마다 형태가 다양함.
		f.setLayout(layout);
		
		JButton bt = new JButton();				// 버튼 생성 클래스
		bt.setText("START");					// 버튼에 text삽입
		
		JButton bt2 = new JButton("STOP");		// 문자열로 같이 생성가능.				
		
		f.add(bt);								// 창에 버튼을 넣음.
		f.add(bt2);								// 사이즈를 제어하지 않는다면 특정 컴포넌트가 전체를 차지함. 곂친다면 나중에 저장된 컴포넌트가 출력
		
		
		
		f.setVisible(true);						// visible 상태로 전환, GUI가 보이게 하기 위한 기능
		
		
		System.out.println("Termonate");
	}
}
