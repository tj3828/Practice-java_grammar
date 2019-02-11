package UI;

import javax.swing.JFrame;

public class EcoFrame extends JFrame {
	public EcoFrame() {
		setLayout(null);
		
		setSize(900, 440);
		
		DeltaPanel pn = new DeltaPanel();
			pn.setBounds(20,20,300,300);
	//	add(pn);
		
		DeltaPanel pn2 = new DeltaPanel();
			pn2.setBounds(420,20,300,300);
	//	add(pn2);
			
		// 실제 프레임이 사용중인 JPanel 얻어옴
		getContentPane().add(pn);
		
		// 프레임에 장착된 기본Panel자체를 교체
		setContentPane(pn2);
	}
}

// 툴을 이용해서 GUI를 사용하기
// windowbuilder를 검색해 웹사이트 ㄱㄱ
// 다운로드 ㄱㄱ
// 사용법대로 ㄱㄱ