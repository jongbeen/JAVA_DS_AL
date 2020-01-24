package Generics;

public class Generics01_Type {
	public static void main(String[] args) {
		
		Box2<Integer> box1 = new Box2<Integer>();	// 기존의 방식, 선언할때 두번 다 타입을 명시했어야 함
		//Box2 box2 = new Box2<String>();			// 이렇게 하면 안되네..? 컴파일 오류는 없는데 반환을 여전히 Object로 반환함
		
		Box2<String> box2 = new Box2<>();			// 자바7부터 허용된 타입
		Box2<Double> box3 = new Box2<>();			
		
		box1.set(7777777);
		box2.set("Hello~");
		box3.set(1.24);
		
		int value = box1.get();
		String Hi = box2.get();
		double date= box3.get();
		
		System.out.println("date: "+date);
		System.out.println(Hi);
		System.out.println("value:"+value);
		
	}
}

class Box2 <T>{
	private T object;
	public void set(T object) { this.object = object;}
	public T get() { return object;}
}

class Apple2{
}