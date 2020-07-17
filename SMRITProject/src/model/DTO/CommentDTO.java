package model.DTO;

import java.sql.Timestamp;

public class CommentDTO {
	private Long commentNo;
	private String cuserId;
	private Timestamp regDate;
	private String commentSubject;
	private String commentContent;
	
	
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public String getCuserId() {
		return cuserId;
	}
	public void setCuserId(String cuserId) {
		this.cuserId = cuserId;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getCommentSubject() {
		return commentSubject;
	}
	public void setCommentSubject(String commentSubject) {
		this.commentSubject = commentSubject;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
