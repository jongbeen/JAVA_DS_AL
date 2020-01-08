
public class ChainHash<K,V> {
	
	class Node<K,V>{
		private K key;
		private V value;
		private Node<K,V> next;

		public Node(K key, V value, Node<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		K getKey() {
			return key;
		}		
		V getValue() {
			return value;
		}
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size;
	private Node<K,V>[] table;
	
	public ChainHash(int capacity) {
		table = new Node[capacity];
		this.size = capacity;
	}
	public int hashValue(Object key) {
		return key.hashCode() % size ;
	}
	
	public V search(K key) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		
		while(p!= null) {
			if(p.getKey().equals(key)) {
				return p.getValue();
			}
			p = p.next;
		}
		return null;
	}
	public int add(K key, V data) {
		int hash = hashValue(key);
		Node<K,V>p = table[hash];
		
		while(p!= null) {
			if(p.getKey().equals(key))
				return 1;					//같은 key 들어오면 아무것도 안하고 1리턴, 즉 중복검사
			p = p.next;
		}
		Node<K,V> temp = new Node<K,V>(key,data, table[hash]);		// 최초 동작: temp->null, 2차 동작 temp->table[hash]->null ... 이런식으로
		table[hash] = temp;
		return 0;
	}
	
	public void Dump() {
		for(int i=0;i<size;i++) {
			Node<K,V>p = table[i];
			System.out.printf("%02d",i);
			while(p!=null) {
				System.out.printf("->%s (%s) ",p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
	
	
}





















