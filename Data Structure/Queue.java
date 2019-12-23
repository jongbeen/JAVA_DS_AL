
public class Queue {
	
	public static void main(String[] args) {
		MyQueue<String> myQueue = new MyQueue<String>();
		myQueue.push("Paris");
		myQueue.push("Bern");
		myQueue.push("Interlaken");
		myQueue.push("Luzern");
		myQueue.push("Milano");
		myQueue.push("Venezia");
		myQueue.push("Florence");
		myQueue.push("Rome");
		
		System.out.println(myQueue.isEmpty());
		for(int i=0;i<8;i++) {
			System.out.println(myQueue.pop());
		}
		System.out.println(myQueue.isEmpty());
	}

}

class MyQueue <T>{
	private int front;
	private int rear;
	private int capacity;
	private Object[] queue;
	
	public MyQueue() {
		this.front=0 ;
		this.rear=0;
		this.capacity=10;
		this.queue = new Object[10];
	}
	
	public void push(T item) {
		if(rear==capacity)
			System.out.println("큐가 꽉참");
		else {
			queue[rear++] = item;
		}
		
	}
	
	public T pop() {
		if(rear==0) {
			System.out.println("비어있는 큐 입니다");
			return null;
		}
		else 
			return (T)queue[front++];
	}
	
	public boolean isEmpty() {
		if(front==rear)
			return true;
		return false;
	}

}