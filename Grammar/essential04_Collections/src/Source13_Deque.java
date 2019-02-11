import java.util.ArrayDeque;
import java.util.Deque;
/* Deque
 *  - Queue의 단점을 보완한 Queue의 특수 계열 클래스로 Queue를 상속받아 구현되어있다.
 *  - Queue는 한쪽 방향으로만 빼고 넣을 수 있지만 Deque는 어느 방향이든 넣고 빼고 가능
 *  - List처럼 인덱스로 중간에서 빼고 삭제는 불가능
 */


public class Source13_Deque {
	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		
		// 뒤쪽 마지막에 객체를 추가시키는 기능
		deque.add("조운");
		deque.offer("관우");
		deque.addLast("주유");		
		deque.offerLast("태사자");
		
		System.out.println(deque.toString());	// [조운, 관우, 주유, 태사자]
		
		// 앞에서부터 밀어넣는 기능 List의 add(0)과 같은 기능, 하지만 인덱스로 제어는 불가능
		deque.addFirst("제갈량");	
		deque.addFirst("하후돈");
		deque.offerFirst("사마의");
		deque.push("순욱");
		System.out.println(deque.toString());	// [순욱, 사마의, 하후돈, 제갈량, 조운, 관우, 주유, 태사자]
		
		// peekFirst(), peekLast(), pollFirst(), pollLast()
		System.out.println(deque.peekFirst());	// 맨 앞의 객체를 확인만하고 지우진 않음.	/ 순욱
		System.out.println(deque.peek());		// peekFirst와 같음				/ 순욱
		System.out.println(deque.peekLast());	// 맨 뒤의 객체를 확인만 하고 지우진 않음.	/ 태사자
		
		System.out.println(deque.pollFirst());	// 맨 앞의 객체를 확인하고 지움.	/ 순욱
		System.out.println(deque.toString());	// [사마의, 하후돈, 제갈량, 조운, 관우, 주유, 태사자]
		
		System.out.println(deque.pollLast());	// 맨 뒤의 객체를 확인하고 지움.	/ 태사자
		System.out.println(deque.toString());	// [사마의, 하후돈, 제갈량, 조운, 관우, 주유]
		
		System.out.println(deque.pop());		// pollFirst()랑 같음 			/ 사마의
		System.out.println(deque.toString());	// [하후돈, 제갈량, 조운, 관우, 주유]
		
		// push로 객체저장하고 pop으로 객체를 확보하면 가장 마지막에 push된 객체가 pop으로 나옴. -> Stack 특성
		// offer로 객체저장하고 poll로 객체를 확보하면 가장 첫번째에 offer된 객체가 poll로 나옴. -> Queue 특성
		// Queue에서 peekFirst, pollFirst, peekLast, pollLast로 양쪽방향으로 어느 곳이든 데이터를 제어할 수 있음 -> Deque 특성
		
	}
}
