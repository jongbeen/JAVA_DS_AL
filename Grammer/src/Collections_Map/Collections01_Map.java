package Collections_Map;

import java.util.Map;
import java.util.HashMap;

/*			
			키와 값으로 구성된 Entry 객체를 저장하는 구조를 가지고 있다
			키와 값 모두 객체이다. 키는 중복저장될수 없지만 값은 중복저장 가능하다.
*/

/*			다음 4가지 (HashMap, HashTable, Properties, TreeMap) 모두 Map인터페이스를 상속	
			Map		--->	HashMap
			Map		--->	HashTable
			Map		--->	Properties
			Map		--->	TreeMap
*/

/*
		추가	V put(K key, V value)	:키와 값 추가
			--------------------------
		탐색	boolean containsKey(Object key) 	: 키 탐색
			boolean containsValue(Object value) : value 탐색
			Set<Map.Entry<K,V>> entrySet()		: 키와 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴
			V get(Object key)					: 주어진 키값의 value 리턴
			boolean isEmpty()					: Map이 비었는지 확인
			Set<K> keySet()						: 모든 Key를 Set객체에 담아서 리턴
			int size()							: 저장된 키의 총 수를 리턴
			Collection<V> values()				: 저장된 모든 값을 Collections에 담아서 리턴
			
*/
public class Collections01_Map {
	public static void main(String[] args) {
		Map<String, Integer> myMap= new HashMap<String, Integer>();
		myMap.put("홍길동",30);
		int score = myMap.get("홍길동");
		System.out.println("길동이 점수 : "+ score);
		
		myMap.remove("홍길동");
		System.out.println("비었니? "+myMap.isEmpty());
	}
}























