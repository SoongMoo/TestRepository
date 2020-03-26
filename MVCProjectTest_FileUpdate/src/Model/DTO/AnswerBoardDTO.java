package Model.DTO;

import java.sql.Timestamp;

public class AnswerBoardDTO {
	Integer boardNum;
	String userId;
	String boardName;
	String boardPass;
	String boardSubject;
	String boardContent;
	Integer boardReRef;
	Integer boardReLev;
	Integer boardReSeq;
	Integer boardReadcount;
	Timestamp boardDate;
	
	
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardPass() {
		return boardPass;
	}
	public void setBoardPass(String boardPass) {
		this.boardPass = boardPass;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Integer getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(Integer boardReRef) {
		this.boardReRef = boardReRef;
	}
	public Integer getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(Integer boardReLev) {
		this.boardReLev = boardReLev;
	}
	public Integer getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(Integer boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
	public Integer getBoardReadcount() {
		return boardReadcount;
	}
	public void setBoardReadcount(Integer boardReadcount) {
		this.boardReadcount = boardReadcount;
	}
	public Timestamp getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
}
