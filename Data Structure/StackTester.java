import java.util.Scanner;

public class StackTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("스택의 용량을 입력하세요 :");
		int size = scanner.nextInt();
		StackManager sm = new StackManager(size);
		
		sm.Datacount();
		/*
		 추가적인 코드는 작성할 수 있지만, 기능은 Stack과 동일하기에 생략한다
		 */
	}
}

class StackManager <T> {
	private int ptr;
	private Object Stack[];
	private int capacity;
	
	public StackManager(int capacity) {
		ptr = 0;
		this.capacity = capacity;
		Stack = new Stack[capacity];
	}
	
	public void Datacount() {
		System.out.println("현재 데이터 수: " +this.ptr);
	}
	
	public void push(T item) {
		if(ptr == this.capacity) {
			return ;
		}
		else {
			Stack[ptr++] = item;
		}
	}
	public T pop() {
		if(ptr == 0) {
			System.out.println("스택이 비었습니다");
			return null;
		}
		else {
			return (T) Stack[--ptr];
		}
	}
}