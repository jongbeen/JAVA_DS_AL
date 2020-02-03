package Collections_Upgrade_Search;

/*
		(1)	Iterator<E>	descendingIterator()	: 내림차순으로 정렬된 Iterator를 리턴
		(2)	NavigableSet<E>	descendingSet()		: 내림차순으로 정렬된 NavigableSet을 반환
			
			(1)의 Iterator를 반환하는 경우는, Set에서 Iterator사용 방법과 동일하다
			(2)의 NavigableSet은  TreeSet과 마찬가지로, first(),last(),lower(),higer(),floor(),ceiling(), 메소드를 제공하고,
			정렬 순서를 바꾸는 descendingSet() 메소드도 제공한다.
			오름차순으로 정렬하고 싶다면 descendingSet()메소드를 두번 호출하면 된다.
			NavigableSet<E> descendingSet = treeSet.descendingSet();
			NavigableSet<E> ascendingSet = descendingSet.descendingSet();
	
*/

import java.util.NavigableSet;
import java.util.TreeSet;

public class Collections02_NavigableSet {
	public static void main(String[] args) {
		TreeSet<Integer> Scores = new TreeSet<Integer>();
		
		Scores.add(87);
		Scores.add(98);
		Scores.add(75);
		Scores.add(95);
		Scores.add(80);
		
		NavigableSet<Integer> descendingSet = Scores.descendingSet();
		System.out.println("1.내림차순");
		for(Integer score:descendingSet) {
			System.out.println(score);
		}
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		System.out.println("2. 오름차순");
		for(Integer score: ascendingSet) {
			System.out.println(score);
		}
		
	}
}
