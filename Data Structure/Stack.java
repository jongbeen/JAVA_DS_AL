

public class Stack {
	public static void main(String[] args) {
		mystack <String> Mystack = new mystack<String>(8);
		
		Mystack.push("Paris");
		Mystack.push("Bern");
		Mystack.push("Interlaken");
		Mystack.push("Luzern");
		Mystack.push("Milano");
		Mystack.push("Venezia");
		Mystack.push("Florence");
		Mystack.push("Rome");
		Mystack.printAll();
		
		System.out.println("비어있니? : "+Mystack.isEmpty());
		
		for(int i=0; i<8;i++) {
			System.out.println(Mystack.pop());
		}
		System.out.println("비어있니? : "+Mystack.isEmpty());
	}
}

class mystack <T>{
	private int top;
	private int capacity;
	private Object[] stck;
	
	public mystack() {
		top=0;
		this.capacity = 10;
		stck = new Object[10];
	}
	
	public mystack(int capacity){
		top = 0;
		this.capacity = capacity;
		stck = new Object[capacity]; 	
	}
	
	public void push(T item) {
		if(top==capacity) 
			return;
		stck[top++] = item;
	}
	public T pop() {
		if(top == 0)
			return null;
		top--;
		return (T)stck[top];
	}
	
	public boolean isEmpty() {
		if(top ==0)
			return true;
		else
			return false;
	}
	
	public void printAll() {
		for(Object obj : stck) {
			System.out.println((T)obj);
		}
	}
	
}
