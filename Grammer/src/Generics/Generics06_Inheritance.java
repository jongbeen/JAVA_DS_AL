package Generics;

public class Generics06_Inheritance {
	public static void main(String[] args) {
		ChildProduction<Car,String,String> product = new ChildProduction<>();
		product.setKind(new Car("G70"));
		product.setModel("Genesis Sports");
		product.setCompany("Hyundai");
		
		Storage<Car> storage = new StorageImpl(10);
		storage.add(product.getKind(),0);
		Car car = storage.get(0);
		
	}

}


class Production<T,M>{
	private T kind;
	private M model;
	
	public T getKind() { return kind;}
	public M getModel() { return model;}
	
	public void setKind(T kind) {this.kind = kind;}
	public void setModel(M model) { this.model = model;}
}

class ChildProduction<T,M,C> extends Production<T,M>{ 		// 제네릭 <T,M>을 상속받고, C를 추가로 정의하는것 같지만,
															// 사실 ChildProduction을 정의하면서 선언된 T,M,C타입이 부모의 T,M타입을 결정한다.
	private C company;
	public C getCompany() { return this.company;}
	public void setCompany(C company) {this.company = company;}
	
}


class Car{
	private String name;
	public Car(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

interface Storage<T>{
	public void add (T item, int index);
	public T get (int index);
}

class StorageImpl<T> implements Storage<T>{
	private T[] array;
	
	public StorageImpl(int size) {
		this.array = (T[]) new Object[size];
	}

	@Override
	public void add(T item, int index) {
		array[index] = item;
	}

	@Override
	public T get(int index) {
		return array[index];
	}
}

