package Collections_Set;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/*
		hashCode를 바탕으로, 같은 객체를 중복저장 하지 않는다
		따라서 hashCode()와 equals를 재정의 해야한다.
		또한, 객체들을 순서 없이 저장한다는 특징을 가진다.
*/
public class Collections02_HashSet {
	public static void main(String[] args) {
		Set<Member> NameSet = new HashSet<Member>();
		
		NameSet.add(new Member("박종빈",25));
		NameSet.add(new Member("박종빈",25));
		NameSet.add(new Member("김현석",24));
		NameSet.add(new Member("김현석",24));
		
		Iterator<Member> NIterator = NameSet.iterator();
		System.out.println("총 객체수: "+NameSet.size());
		while(NIterator.hasNext()) {
			String str = NIterator.next().getValue();
			System.out.println(str);
		}
	}
}

class Member{
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getValue() {
		return this.name+","+this.age;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member mem = (Member) obj;
			return mem.name.equals(this.name) && (mem.age==this.age);
		}
		else
			return false;
	}
//	hashCode를 Override하지 않는다면, 동일한 객체라고 생각하지 않음
	public int hashCode() {
		return name.hashCode() + age;
	}
}
