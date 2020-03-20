package Model.DTO;

import java.util.*;

// 데이터를 저장히기 위한 클래스가 뭐가 있어야 하는 지?
// DTO : 데이터를 전송하는 객체 : 메서드
// VO : 값을 가지고 있는 객체 : 멤버필드
public class Board {
	// 뭘 저장할 것인지? ==> 멤버필드
	// 멤버필드에 초기화 ? ===> 생성자
	// 멤버필드의 값을 변경하거나 보내주기 위해서 setter/getter
	// 멤버 필드 값을 가공하기 위한 메서드가 필요한지?(필요에 따라서)
	
	// 번호, 글쓴이, 날짜, 제목, 내용, 아이디
	int boardNum;
	String boardName;
	Date boardDate;
	String subject;
	String contents;
	String id;
	
	public Board() {} // 메서드의 이름은 같고 매개변수의 수나 타입 그리고 갯수 
	                 // 또 순서 가 다른것을 오버로딩이라고 한다.
	// 생성자의 매개변수가 6개이므로 생성자를 실행할 때 인자가 6개이어야한다.
	public Board(String boardName,String subject, 
			String contents,String id ) {
		this.boardName = boardName;
		this.subject = subject;
		this.contents = contents;
		this.id = id;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
