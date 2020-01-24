package Generics;

public class Generics00_Why {
	public static void main(String[] args) {
		Box box = new Box();
		box.set("홍길동");					// -> String에서 Object으로 강제 형변환
		String name= (String)box.get();		// -> Object에서 String으로 강제 형변환
		System.out.println(name);
		
		box.set("박종빈");
		Apple ipod = (Apple)box.get();		
		System.out.println(ipod.toString());
		// -> 매번 수동 타입변환의 문제 발생
	}
}

class Box{
	private Object object;
	public void set(Object object) { this.object = object;}
	public Object get() { return object;}
}

class Apple{
}