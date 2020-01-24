package Generics;

public class Generics02_Multi_Parameter {
	public static void main(String[] args) {
		Product<String,Integer> G70 = new Product<>();
		G70.setKind("Genesis sports");
		G70.setModel(70);
		
		Product<Integer,String> GV80 = new Product<>();
		GV80.setKind(80);
		GV80.setModel("Genesis SUV");
		
	}
}

class Product<T,M>{
	private T kind;
	private M model;
	
	public T getKind() { return kind;}
	public M getModel() { return model;}
	
	public void setKind(T kind) {this.kind = kind;}
	public void setModel(M model) { this.model = model;}
}