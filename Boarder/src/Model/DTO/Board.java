package Model.DTO;

import java.util.*;

// �����͸� �������� ���� Ŭ������ ���� �־�� �ϴ� ��?
// DTO : �����͸� �����ϴ� ��ü : �޼���
// VO : ���� ������ �ִ� ��ü : ����ʵ�
public class Board {
	// �� ������ ������? ==> ����ʵ�
	// ����ʵ忡 �ʱ�ȭ ? ===> ������
	// ����ʵ��� ���� �����ϰų� �����ֱ� ���ؼ� setter/getter
	// ��� �ʵ� ���� �����ϱ� ���� �޼��尡 �ʿ�����?(�ʿ信 ����)
	
	// ��ȣ, �۾���, ��¥, ����, ����, ���̵�
	int boardNum;
	String boardName;
	Date boardDate;
	String subject;
	String contents;
	String id;
	
	public Board() {} // �޼����� �̸��� ���� �Ű������� ���� Ÿ�� �׸��� ���� 
	                 // �� ���� �� �ٸ����� �����ε��̶�� �Ѵ�.
	// �������� �Ű������� 6���̹Ƿ� �����ڸ� ������ �� ���ڰ� 6���̾���Ѵ�.
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
