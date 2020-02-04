package Collections_Upgrade_Search;

import java.util.TreeMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;


/*				NavigableSet과 사용 방법이 굉장히 유사하다
				
				NavigableSet<K>		descendingKeySet()		내림차순으로 정렬된 키의 NavigableSet을 리턴
				NavigableMap<K,V>	descendingMap()			내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴
				NavigableMap 역시 lower/higherEntry 등 TreeMap의 메소드를 지원한다.
*/			

public class Collections05_NavigableMap {
	public static void main(String[] args) {
		TreeMap<Integer, String> Final = new TreeMap<>();
		
		Final.put(50,"홍길동");
		Final.put(60,"오우석");
		Final.put(70,"최유성");
		Final.put(80,"이상호");
		Final.put(90,"김현석");
		Final.put(100,"박종빈");
		
		NavigableMap<Integer,String> descendingMap = Final.descendingMap();
		Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
		for(Map.Entry<Integer, String>entry : descendingEntrySet){
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
		System.out.println("-------------");
		
		NavigableMap<Integer,String> ascendingMap = descendingMap.descendingMap();
		Set<Map.Entry<Integer,String>> ascendingEntrySet = ascendingMap.entrySet();
		for(Map.Entry<Integer, String>entry: ascendingEntrySet ) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}
}
