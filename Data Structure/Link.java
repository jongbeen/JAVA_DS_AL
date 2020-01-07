
public class Link {
	public static void main(String[] args) {
		NodeMgmt test = new NodeMgmt(10);
		for(int i=0; i<10; i++) {
			test.insert(i);
		}
		//test.printAll();
		test.search_from_head(3);
	}

}

class Node{
	private int value = 0;
	private Node next = null;
	private Node prev = null;
	
	public Node(int value) {
		this.value = value;
	}
	public Node getNext() {
		return this.next;
	}
	public Node getPrev() {
		return this.prev;
	}
	public void setNext(Node N) {
		this.next = N;
	}
	public void setPrev(Node N) {
		this.prev = N;
	}
	public int getValue() {
		return this.value;
	}
	
}

class NodeMgmt{
	private Node head = null;
	private Node tail = null;
	
	public NodeMgmt(int value) {
		this.head = new Node(value);
		this.tail = this.head;
	}
	
	public void insert(int value) {
		if (this.head == null) {
			this.head = new Node(value);
			this.tail = this.head;
		}
		else {
			Node temp = this.head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			Node new_data = new Node(value);
			temp.setNext(new_data);
			new_data.setPrev(temp);
			this.tail = new_data;	
		}
	}
	public void printAll() {
		Node N = this.head;
		while(N != null) {
			System.out.println("Node value: "+N.getValue());
			N=N.getNext();		
		}
	}
	public void search_from_head(int value) {
		if (this.head == null)
			System.out.println("빈 NodeManager");
		Node S = this.head;
		while(S != null) {
			if(S.getValue() == value) {
				System.out.println("찾음");
				break;
			}
			else
				S = S.getNext();
		}
		
	}
}













