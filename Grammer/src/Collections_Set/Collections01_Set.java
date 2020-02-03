package Collections_Set;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/*
	Set		--->	HashSet
	Set		--->	LinkedHashSet
	Set		--->	TreeSet				위 3가지는 Set인터페이스에서 공통적으로 사용가능
*/

/*		Set 관련 메소드
 
	추가	boolean add(E e) : 객체 삽입
		-------------------------
	탐색	boolean contains(Object o) : 주어진 객체가 존재하는지 확인
		isEmpty() : 컬렉션이 비어있는지 확인
		Iterator<E> iterator() : 저장된 객체를 한번씩 가져오는 반복자 리턴
		int size() : 저장된 객체수 리턴
		-------------------------
	삭제	void clear() : 저장된 객체 모두 삭제
		boolean remove(Object o) : 주어진 객체 삭제                             		Iterator와 remove가 다르다!!!!!!!!!!!!!!

*/

/*		Iterator 인터페이스

		boolean hasNext() : 객체 있으면 true, 없으면 false 리턴
		E next()		  : 다음 객체 리턴
		void remove()  : Set 컬렉션에서 해당 객체 제거					Set 의 remove(Object o)와 달리 인자가 없다!!!!!!!!!!
*/
public class Collections01_Set {
	public static void main(String[] args) {
		Set<String> Korea = new HashSet<String>();
//		Iterator<String> Kiterator = Korea.iterator();  
		
		Korea.add("Park");
		Korea.add("Son");
		Korea.add("Cha");
		Korea.add("LEE");
		Korea.add("Hong");
		
		Iterator<String> Kiterator = Korea.iterator();
//		Korea에 아무것도 없는 상태에서 Iterator를 생성하면 아무것도 들어있지 않다고 판단한다
		
		while(Kiterator.hasNext()) {
			String str = Kiterator.next();
			System.out.println(str);
			if(str.equals("Hong"))
				Kiterator.remove();
		}
		System.out.println("-----------------");
		
		for(String str : Korea) {
			System.out.println(str);
		}
		
	}
}

























