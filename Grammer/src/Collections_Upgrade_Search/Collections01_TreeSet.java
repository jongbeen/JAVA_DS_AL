package Collections_Upgrade_Search;

import java.util.TreeSet;

/*
			이진트리를 기반으로 한 Set 컬렉션으로, 
			부모값과 비교해서 낮은것은 왼쪽 자식노드, 큰 것은 오른쪽 자식 노드에 저장 
*/

/*
			E	first()		:	가장 작은요소 리턴 (가장 낮은 객체)
			E	last()		:	가장 큰 요소 리턴	(제일 높은 객체)
			E	lower(E e)	:	주어진 객체보다 바로 아래를 리턴	( 객체 미만! 을 찾음)
			E	higher(E e)	:	주어진 객체보다 바로 위를 리턴		( 객체 초과! 를 찾음)
			E	floor(E e)	:	주어진 객체와 동등하거나 바로 아래 객체 리턴	( 객체 이하! 를 찾음)
			E	ceiling(E e):	주어진 객체와 동등하거나 바로 위 객체 리턴		( 객체 이상! 을 찾음)
			E	pollFirst()	:	제일 낮은 객체를 꺼내고 리턴 (컬렉션에서 삭제함)
			E	pollLast()	:	제일 높은 객체를 꺼내고 리턴 (컬렉션에서 삭제함)
*/
public class Collections01_TreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> Score = new TreeSet<>();
		
		Score.add(80);
		Score.add(75);
		Score.add(98);
		Score.add(87);
		Score.add(95);
		
		Integer score = null;
		
		score = Score.first();
		System.out.println("가장 낮은 점수: "+score);
		
		score = Score.last();
		System.out.println("가장 높은 점수"+score);
		
		score = Score.lower(new Integer(95));
		System.out.println("95점 아래 점수: "+score);
		
		score = Score.higher(new Integer(95));
		System.out.println("95점 위의 점수: "+score);
		
		score = Score.floor(88);
		System.out.println("88점이거나 바로 아래 점수"+score);
		
		score = Score.ceiling(95);
		System.out.println("95점이거나 바로 위의 점수"+score);
		
		while(!Score.isEmpty()) {
			score = Score.pollFirst();
			System.out.println(score+"  남은 객체 수:" + Score.size() );
				
		}
		
	}
}
