import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 * 주의해야되는점.
 * - 여러 쓰레드에서 같은 객체의 데이터를 접근하여 사용할 때
 */
class NumberSaver extends Thread{
	List<Integer> li;
	public NumberSaver(List<Integer> li) {
		this.li = li;
	}
	@Override
	public void run() {
		for(int i=1; i<=10000; i++) {
			synchronized (li) {			// li를 잠구는 기능
				li.add(i);
			}
		}
		String name = getName();		// Thread에서 자기 이름을 만들어내는 기능이 존재
		System.out.println("[" + name + "] size = " + li.size());
	}
}
public class Source04_Thread {
	public static void main(String[] args) {
	//	List<Integer> li = new Vector<>();	// 여러 쓰레드에서 동시 접근하여 사용하여도 내부적으로 처리해주기 때문에 사용가능.(동기화처리 해둠.멀티 쓰레드를 고려하여 만들어진 객체), but, 처리하는 기능으로 add작업이 무겁다.
		// Vector : add 메소드에 synchronized 처리가 되어 여러 쓰레드가 동시에 접근하지 못하고 대기상태로 만들어지게함.
		List<Integer> li = new ArrayList<>();	// 멀티 쓰레드를 고려하지 않고, 싱글 쓰레드에 맞추어 설계되어 있기 때문에 에러발생. 동기화 처리 x. but, add작업이 빠름.
		// 특정 쓰레드에서 내부 배열을 사용할 때 다른 쓰레드가 접근하면 문제가 생기는 오류가 발생.
		// 동기화 처리가 안되어 있는 객체를 사용하다보면, 문제가 발생 -> 때문에 직접 처리해주어야함.
		// synchronized를 직접 처리
		NumberSaver t1 = new NumberSaver(li);
		NumberSaver t2 = new NumberSaver(li);
		
		t1.start();
		t2.start();
		System.out.println("MAIN - TERMINATE");
	}
}
