import javax.swing.JDialog;

/*
 * Thread를 생성하는 법.
 * 1. extends Thread(Source02_Thread)
 * 2. implements Runnable(Source03_Thread)
 * 3. anonymous Class(Source03_Thread)
 */

class Terror implements Runnable{
	String t;
	public Terror(String t) {
		// TODO Auto-generated constructor stub
		this.t= t;
	}
	@Override
	public void run() {
		for(int cnt=1; cnt<=5; cnt++) {
			JDialog d = new JDialog();
			d.setTitle(t);
				int s = 200 + (int)(Math.random()*200);
				int x = 0 + (int)(Math.random()*1000);
			d.setSize(s,s);
			d.setLocation(x, x);
			d.setVisible(true);
		}
	}
}
public class Source03_Thread {
	public static void main(String[] args) {
		Terror r = new Terror("T E R R O R");	// Runnable
		Thread t = new Thread(r);	// Runnable을 구현한 클래스를 Thread에 장착
		t.start();
		
		new Thread() {	// anonymous Class (익명 클래스), 한번쓰고 버릴 때 작성할 수 있는 방법
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int cnt=1; cnt<=1000;cnt++) {
					System.out.println("!!!!");
				}
			}
		}.start();
		
		
	}
}
