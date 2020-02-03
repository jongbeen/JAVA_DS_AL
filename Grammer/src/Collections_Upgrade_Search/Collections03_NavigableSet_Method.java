package Collections_Upgrade_Search;

/*
			NavigableSet<E>	headSet( E toElement			: 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴	
									 boolean inclusive)		: 주어진 객체 포함 여부는 두번째 매개값에 따라 달라짐
			
			NavigableSet<E> tailSet( E fromElement			: 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴
									 boolean inclusive)		: 주어진 객체 포함 여부는 두번째 매개값에 따라 달라짐
			
			NavigableSet<E> subSet(	E fromElement			: 시작과 끝 객체 사이의 객체들을 NavigableSet으로 리턴
									boolean frominclusive	: 시작과 끝을 포함할지는 
									E toElement				: 2번째 & 4번째가 결정함
									boolean toinclusive)	:
*/

import java.util.NavigableSet;
import java.util.TreeSet;

public class Collections03_NavigableSet_Method {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("talk");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[ c ~ talk 까 지 단어 검색 ]");
		NavigableSet<String> rangeSet = treeSet.subSet("c", false, "talk", true);
		for (String word : rangeSet) {
			System.out.println(word);
		}
	}
}
