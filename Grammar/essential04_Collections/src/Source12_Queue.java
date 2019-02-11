import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Queue
 * - 기본 컬렉션의 하나의 계열
 * - 실제 구현 객체로는 ArrayDeque, PriorityQueue 등이 존재
 * - 저장시켜둔 객체를 하나씩 제거하면서 뽑을 수 있게 구현시켜둔 컬렉션
 * - 기본 컬렉션의 기능들과 유사하게 가지고 있음.
 * - 중복 허용
 * - Queue는 먼저 들어간 객체가 먼저 나오는 구조로 이에 관한 기능이 있음.
 */
public class Source12_Queue {
	public static void main(String[] args) {
		Queue<String> que = new ArrayDeque<>();		// 들어간 순서대로 정렬해놓고 차례대로 기능하는 Queue
	//	Queue<String> que = new PriorityQueue<>();	// 크기로 정렬해놓고 기능하는 Queue
		
		que.add("Monday");
		que.add("Monday");
		System.out.println(que.size());	// 2
		
		que.add("Friday");
		que.add("ThursDay");
		System.out.println(que.toString());	// [Monday, Monday, Friday, ThursDay]
		
		System.out.println(que.peek());		// 제일 먼저 저장한  첫 번째 요소객체 뽑아냄.	/Monday
		System.out.println(que.peek());		// Monday
		System.out.println(que.element());	// Monday	/ peek과 같음
		
		System.out.println(que.size());		// 4
		
		String s = que.poll();				// 가장 앞에 있는 객체를 뽑아내고 Queue에서 제외시킴.
		System.out.println(s);				// Monday
		System.out.println(que.size());		// 한번 뽑았으므로 3
		System.out.println(que.toString());	// [Monday, Friday, ThursDay]
		
		que.remove("Friday");				// queue의 고유 기능이 아니라 모든 컬렉션에 있는 기능
		String s1 = que.remove();			// poll() 과 같은 기능
		System.out.println(s1);				// Monday
		System.out.println(que.size());		// 1
		System.out.println(que.toString());	// [ThursDay]
		
		que.offer("Sunday");				// add()와 같은 기능
		System.out.println(que.size());		// 2
		System.out.println(que.toString());	// [ThursDay, Sunday]
		
		// contains 메소드가 실행될 때 equals로만 체크하게 됨. -> 실제 데이터 값을 비교하고 싶다면 equals만 바꾸면 된다는거...
		
	}
}
