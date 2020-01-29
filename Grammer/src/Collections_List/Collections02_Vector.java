package Collections_List;

import java.util.List;
import java.util.Vector;

// ArrayList와 유사하지만, 다른점은 Vector는 동기화된 메소드로 구성이 되어있기때문에 멀티스레드가 동시에 실행할 수 없다.
// 따라서 Vector는 스레드안전(Thread Safe) 하다고 볼 수 있다.

public class Collections02_Vector {
	public static void main(String[] args) {
		List<Board<String>> board = new Vector<>();
		
		board.add(new Board("제목1","내용1","글쓴이1"));				//Type infer 로 큰 문제X
		board.add(new Board<String>("제목2","내용2","글쓴이2"));
		board.add(new Board<String>("제목3","내용3","글쓴이3"));
		
		board.remove(2);
		for(int i=0; i<board.size();i++) {
			System.out.println(board.get(i).subject+" "+board.get(i).content);
		}
		
	}
}

class Board<T>{
	T subject;
	T content;
	T writer;
	
	public Board(T subject, T content, T writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
}
