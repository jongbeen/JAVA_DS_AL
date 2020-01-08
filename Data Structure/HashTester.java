
public class HashTester {
	public static void main(String[] args) {
		ChainHash<Integer, String> hash 
		= new ChainHash<Integer, String>(10);
		
		hash.add(1, "Park");
		hash.add(2, "Jong");
		hash.add(3, "Bin");
		
		hash.add(12, "Black");
		
		hash.Dump();
		
		System.out.println();
	}

}
