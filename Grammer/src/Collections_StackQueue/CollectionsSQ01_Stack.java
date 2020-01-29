package Collections_StackQueue;

import java.util.Stack;

//LIFO 자료구조
//push(item), peek(), pop() 3개 메소드 존재
//peek()은 삭제 X 마지막 객체 리턴
//pop()은 삭제 O 마지막 객체 리턴

public class CollectionsSQ01_Stack {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.add(new Coin(100));
		coinBox.add(new Coin(500));
		coinBox.add(new Coin(10));
		coinBox.add(new Coin(50));
		
		System.out.println("LIFO");
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println(coin.getValue());
		}
	}
}

class Coin{
	private int value;
	
	public Coin(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
}