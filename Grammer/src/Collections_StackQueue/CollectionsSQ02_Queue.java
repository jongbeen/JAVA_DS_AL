package Collections_StackQueue;

import java.util.LinkedList;
import java.util.Queue;

//Queue 인터페이스로 선언해  LinkedList 객체 생성

//offer(E item) - 객체 삽입  (근데 add도 되던데...?)
//peek() - 첫번째 객체 리턴, 삭제 X 
//poll() - 첫번째 객체 리턴, 삭제 O


public class CollectionsSQ02_Queue {
	public static void main(String[] args) {
		Queue<Coin> queue = new LinkedList<Coin>();
		
		queue.offer(new Coin(100));
		queue.offer(new Coin(500));
		queue.offer(new Coin(10));
		queue.add(new Coin(50));
		
		System.out.println("FIFO");
		while(!queue.isEmpty()) {
			Coin coin = queue.poll();
			System.out.println(coin.getValue());
		}
	}
}