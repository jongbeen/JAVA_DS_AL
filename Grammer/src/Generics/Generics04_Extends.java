package Generics;

public class Generics04_Extends {
	public static void main(String[] args) {
		int result1 = Utilize.compare(10, 20);	//		10, 20 으로 자동 Integer Boxing 
		System.out.println(result1);
		
		int result2 = Utilize.compare(4.5,3);	//		4.5는 Double로 Boxing, 3은 Integer로 Boxing
		System.out.println(result2);
		
	}
}

class Utilize {
	//
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();		// Number의 doubleValue() 메소드 사용
		double v2 = t2.doubleValue();		// Number의 doubleValue() 메소드 사용
		return Double.compare(v1, v2);
	}
}
