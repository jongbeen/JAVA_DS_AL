package Collections_List;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

// ArrayList와 사용방법은 똑같지만 내부구조가 다르다
// 공부했다시피, Linkedlist는 앞뒤로 Link가 존재해, 중간의 객체 삽입or삭제시,
// 한번씩 모두 앞,뒤로 이동하는 ArrayList와 달리  중간 해당 index 앞,뒤 link만 교체하면 되므로 문제 X

public class Collections03_LinkedList {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		// 뭐 탐색시간 비교는 굳이 안하는걸로... 사용법 똑같고 생성하는법만 요렇게 다르다....
	}
}
