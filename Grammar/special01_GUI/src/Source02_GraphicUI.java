import java.awt.*;
import javax.swing.*;
/*
 * 같은 형태로 2개 설계된 JDialog를 같이 돌린다면 2개를 설계해야한다는 불편함
 * -> 그렇기 때문에 보통 extends를 이용해 설계 -> 상속의 장점
 *
 */
class AlphaFrame extends JFrame {
	public AlphaFrame() {
		LayoutManager m = new GridLayout(3,4);		// 격자모양 생성할 때 사용하는 레이아웃
		setLayout(m);								// 자신의 객체에 설정.
		
		for(int i=1; i<=12; i++) {
			JToggleButton bt = new JToggleButton(String.valueOf(i));
			add(bt);
		}
		setSize(240,320);
	}
}
public class Source02_GraphicUI {
	public static void main(String[] args) {
		JFrame f1 = new AlphaFrame();
		f1.setVisible(true);
		JFrame f2 = new AlphaFrame();
		f2.setVisible(true);
		System.out.println("main....   brefore terminate");
	} 
	
}
