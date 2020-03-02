package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class AnswerBoardDTO implements Serializable{
	Integer boardNum;
	String userId;
	String boardName;
	String boardPass;
	String boardSubject;
	String boardContent;
	Timestamp boardDate;
	String ipAddr;
	Integer readCount;
	String originalfileName;
	String storeFileName;
	String fileSize;
	Integer boardReRef;
	Integer boardReLev;
	Integer boardReSeq;
	
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
	public String getOriginalfileName() {
		return originalfileName;
	}
	public void setOriginalfileName(String originalfileName) {
		this.originalfileName = originalfileName;
	}
	public String getStoreFileName() {
		return storeFileName;
	}
	public void setStoreFileName(String storeFileName) {
		this.storeFileName = storeFileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
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
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
}
