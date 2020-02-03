package Collections_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Collections02_HashMap {
	public static void main(String[] args) {
		Map<String, Integer> United = new HashMap<String, Integer>();
		
		United.put("D.James",21);
		United.put("M.Rashford",10);
		United.put("P.Pogba",6);
		United.put("A.Martial",9);
		United.put("B.Fernandes",13);
		
		System.out.println("United 객체수 : "+United.size());
		System.out.println("B.Fernaneds num: "+United.get("B.Fernandes"));
		System.out.println("---------------------");
		
		
		Set<String>UnitedPlayer = United.keySet();
		Iterator<String> Player = UnitedPlayer.iterator();
		while(Player.hasNext()) {
			String str = Player.next();
			System.out.println(str);
		}
		
		System.out.println("---------------------");
		United.remove("P.Pogba");
		System.out.println("Pogba 이적");
		
		
		Set<Map.Entry<String, Integer>> entrySet = United.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(value+" : "+key);
		}
		System.out.println("---------------------");
		
		United.clear();
		System.out.println("United 객체수 : "+United.size());
		
		
		
	}
}






