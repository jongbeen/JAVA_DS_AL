package Generics;

public class Generics03_Method {
	public static void main(String[] args) {
		BOXED<Integer> box01 = Util.<Integer>boxing(100000);
		BOXED<String> box02 =  Util.boxing("Batman");
		System.out.println("box1 value: "+box01.get());
		System.out.println("box2 name: "+box02.get());
		
		Pair<Integer,String> p1 = new Pair<Integer,String>(70,"Genesis");
		Pair<Integer,String> p2 = new Pair<>(70,"Genesis");
		
		Pair<Integer,String> p3 = new Pair<>(80,"Genesis sports");
		Pair<Integer,String> p4 = new Pair<>(80,"Genesis SUV");
		
		// 구체적인 타입 명시적으로 지정
		boolean result = Util.<Integer,String>compare(p1,p2);

		// 구체적인 타입을 추론함 
		boolean result2 = Util.compare(p3, p4);
		
		System.out.println(result);
		System.out.println(result2);
		
		
	}
}

class Util{
	public static <T> BOXED<T> boxing(T t){				// <T> -제네릭	Box<T> - 리턴타입		T t- 제네릭 매개변수 
		BOXED<T> n_box = new BOXED<T>();				
		n_box.set(t);								// box의 object는 T형 
		return n_box;
	}
	public static <K,V> boolean compare (Pair<K,V>p1, Pair<K,V>p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
}

class BOXED<T>{
	private T object;
	public void set(T object) { this.object = object;}
	public T get() { return object;}
}

class Pair<K,V> {
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {return this.key;}
	public V getValue() {return this.value;}
}
