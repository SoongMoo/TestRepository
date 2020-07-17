package model.DTO;

import java.sql.Timestamp;

public class AnswerBoardDTO {
	Long boardNum ;
	String userId ;
	String boardName ;
	String boardPass;
	String boardSubject ;
	String boardContent ;
	Timestamp boardDate ;
	String ipAddr ;
	Long readCount ;
	String originalFileName ;
	String storeFileName ;
	Long fileSize; 
	Long boardReRef; 
	Long boardReLev ;
	Long boardReSeq ;
	public Long getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(Long boardReRef) {
		this.boardReRef = boardReRef;
	}
	public Long getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(Long boardReLev) {
		this.boardReLev = boardReLev;
	}
	public Long getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(Long boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public Timestamp getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public Long getReadCount() {
		return readCount;
	}
	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoreFileName() {
		return storeFileName;
	}
	public void setStoreFileName(String storeFileName) {
		this.storeFileName = storeFileName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
}
