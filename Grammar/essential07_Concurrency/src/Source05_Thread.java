import javax.swing.JOptionPane;

class Worker extends Thread{
	@Override
	public void run() {
		for(int cnt = 1; cnt<=1000000; cnt++) {
			boolean t = this.isInterrupted();
			System.out.println(cnt + " / do working.. / " + t);
			if(t) break;
		}
	}
}

public class Source05_Thread {
	public static void main(String[] args) {
		System.out.println("[Main] start");
		Worker w = new Worker();
		w.setDaemon(true);				// 자신을 제외하고 가동중인 쓰레드가 없다면 알아서 멈춤.
		w.start();
		try {
			for(;;) {
				String cmd = JOptionPane.showInputDialog("controll?");
				switch(cmd) {
					case "sleep":	
						Thread.sleep(3000);			// 해당 초만큼 일시정지
						break;
					case "start":
						w.start(); break;
					case "interrupt":
						w.interrupt(); break;
					case "join":
						w.join(2000);				// 해당 쓰레드의 작업을 2초동안 끝나길 기다린다. 현재 쓰레드는 일시정지
						break;
					case "suspend":
						w.suspend();				// 쓰레드를 일시정지시킴       
						break;
					case "resume":
						w.resume();					// 정지된 쓰레드를 다시 가동
						break;
				}
			}
		}catch(InterruptedException e){
			System.out.println("InterruptedException..");
		}finally {
		//	w.stop();
		}
		
	}
}
