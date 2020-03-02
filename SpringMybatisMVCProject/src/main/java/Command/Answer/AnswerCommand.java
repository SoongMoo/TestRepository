package Command.Answer;

import org.springframework.web.multipart.MultipartFile;



public class AnswerCommand {
	private Integer boardReLev;
	private Integer boardReRef;
	private Integer boardReSeq;
	private Integer boardNum;
	private String boardName;
	private String boardPass;
	private String boardSubject;
	private String boardContent;
	private MultipartFile [] boardFile;
	
	public Integer getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(Integer boardReLev) {
		this.boardReLev = boardReLev;
	}
	public Integer getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(Integer boardReRef) {
		this.boardReRef = boardReRef;
	}
	public Integer getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(Integer boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
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
	public MultipartFile[] getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile[] boardFile) {
		this.boardFile = boardFile;
	}
}
