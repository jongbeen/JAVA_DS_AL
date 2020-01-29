package Collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// ArrayList, Vector, LinkedList 모두 List 컬렉션에서 공통적으로 사용 가능한 메소드들이다.

public class Collections01_List {
	public static void main(String[] args) {
		List<String> United = new ArrayList<>();
		
		United.add("P.Pogba");
		United.add("A.Martial");
		United.add("H.Maguire");
		United.add("B.Fernandes");
		
		int size = United.size();
		System.out.println("총 객체수: "+size);
		
		String name = United.get(0);
		System.out.println("0: "+name);
		System.out.println("--------------");
		
		United.remove(0);
		United.add(0,"M.Rashford");
		name = United.get(0);
		System.out.println("0: "+name);
		System.out.println("--------------");
		
		int i=0;
		for(String str:United) {
			System.out.println(i+":"+str);
			i++;
		}
		
		boolean check = United.contains("Kane");
		System.out.println("Kane?"+check);
		United.clear();
		System.out.println("After United.clear(), is Empty? "+United.isEmpty());
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
		for (int index : list1) {
			System.out.println(index);
		}
	} 
}
