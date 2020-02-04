package Collections_Upgrade_Search;

import java.util.TreeMap;
import java.util.Map;
import java.util.NavigableMap;


/*
			NavigableMap<E>	headSet( K toKey				: 주어진 객체보다 낮은 객체들을 NavigableMap으로 리턴	
						 			boolean inclusive)		: 주어진 객체 포함 여부는 두번째 매개값에 따라 달라짐

			NavigableMap<E> tailSet( K fromKey				: 주어진 객체보다 높은 객체들을 NavigableMap으로 리턴
						 			boolean inclusive)		: 주어진 객체 포함 여부는 두번째 매개값에 따라 달라짐

			NavigableMap<E> subSet(	K fromKey				: 시작과 끝 객체 사이의 객체들을 NavigableMap으로 리턴
									boolean frominclusive	: 시작과 끝을 포함할지는 
									K toKey					: 2번째 & 4번째가 결정함
									boolean toinclusive)	:
*/

public class Collections06_NavigableMap_Method {
	public static void main(String[] args) {
		TreeMap<String,Integer> treeMap = new TreeMap<>();
		treeMap.put("apple",10);
		treeMap.put("banana",20);
		treeMap.put("cherry",30);
		treeMap.put("donkey",40);
		treeMap.put("eat",50);
		treeMap.put("fail",60);
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableMap<String,Integer> rangeMap = treeMap.subMap("c",true,"f",true);
		
		for(Map.Entry<String, Integer>entry: rangeMap.entrySet()) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
		
	}
}
















