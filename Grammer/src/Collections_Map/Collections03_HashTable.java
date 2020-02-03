package Collections_Map;

import java.util.Map;
import java.util.Hashtable;
import java.util.Scanner;

/*
 				HashMap과 유사하지만,
				스레드 안전(Thread Safe) 하다는 점이 차이점을 가진다
 					 
 */

public class Collections03_HashTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<String,String> Login = new Hashtable<>();
		
		Login.put("yrs03041","1111");
		Login.put("licon","2222");
		Login.put("licon121","333");
		Login.put("sss","444");
		
		while(true) {
			System.out.println("아이디와 비밀번호 입력바람");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			
			if(Login.containsKey(id)) {
				if(Login.get(id).equals(password)) {
					System.out.println("로그인 성공!");
					break;
				}
				else{
					System.out.println("비밀번호 오류");
				}
			}else {
				System.out.println("아이디 없음");
			}
		}
		
		sc.close();
	}
}
