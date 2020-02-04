package Collections_Upgrade_Search;

import java.util.Map;
import java.util.TreeMap;

/*
			TreeSet과 차이점은 키와 값이 저장된 Map.Entry를 저장한다는 점 
			TreeMap 에 객체를 저장하면 자동으로 정렬되는데, 
			기본적으로 부모 키보다 작은 키를 가진 객체는 왼쪽,
			부모 키 보다 큰 키를 가진 객체는 오른쪽 에 Map.Entry객체를 저장함
*/
/*
 			리턴 타입			함수명
			Map.Entry<K,V>	firstEntry()		:	제일 낮은 Map.Entry 리턴
			Map.Entry<K,V>	lastEntry()			:	제일 높은 Map.Entry 리턴
			Map.Entry<K,V>	lowertEntry(K Key)	:	해당 키보다 바로 아래  Map.Entry 리턴
			Map.Entry<K,V>	higherEntry(K Key)	:	해당 키보다 바로 위 Map.Entry 리턴
			Map.Entry<K,V>	floorEntry(K Key)	:	Key와 동등한 키가 있으면 해당 Map.Entry 리턴, 없으면 바로 아래 Key의 Map.Entry 리턴
			Map.Entry<K,V>	ceilingEntry(K Key)	:	Key와 동등한 키가 있으면 해당 Map.Entry 리턴, 없으면 바로 위  Key의 Map.Entry리턴
			Map.Entry<K,V>	pollFirstEntry()	:	제일 낮은 Map.Entry를 꺼내고 컬렉션에서 제거	
			Map.Entry<K,V>	pollLastEntry()		:	제일 높은 Map.Entry를 꺼내고 컬렉션에서 제거
			
			
*/
public class Collections04_TreeMap {
	public static void main(String[] args) {
		TreeMap<Integer,String> Mid = new TreeMap<>();
		Mid.put(87,"홍길동");
		Mid.put(98,"이동수");
		Mid.put(75,"박길순");
		Mid.put(95,"신용권");
		Mid.put(100,"박자바");
		
		Map.Entry<Integer, String> entry = null;
		entry= Mid.firstEntry();
		System.out.println("최하 점수 : "+entry.getKey()+"-"+entry.getValue());
		
		entry=Mid.lastEntry();
		System.out.println("최고 점수 : "+entry.getKey()+"-"+entry.getValue());
		
		entry = Mid.lowerEntry(95);
		System.out.println("95점 바로 아래점수 : "+entry.getKey()+"-"+entry.getValue());
		
		entry = Mid.higherEntry(95);
		System.out.println("95점 바로 위 점수 : "+entry.getKey()+"-"+entry.getValue());
		
		entry = Mid.floorEntry(95);
		System.out.println("95점 이거나 바로 아래 점수 : "+entry.getKey()+"-"+entry.getValue());
		
		entry = Mid.ceilingEntry(95);
		System.out.println("95점 이거나 바로 위 점수 : "+entry.getKey()+"-"+entry.getValue());
		
		while(!Mid.isEmpty()) {
			entry = Mid.pollFirstEntry();
			System.out.println("현재 최저 점수 "+entry.getKey()+"-"+entry.getValue()+"  남은 객체수"+Mid.size() );
		}
		
		
		
	}
}
