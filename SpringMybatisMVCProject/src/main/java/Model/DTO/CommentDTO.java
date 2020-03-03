package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@SuppressWarnings("serial")
public class CommentDTO implements Serializable{
	private Long commentNo;
	private String cuserId;
	private Timestamp regDate;
	private String commentSubject;
	private String commentContent;
	
	public CommentDTO() {}
	public CommentDTO(Long commentNo, String cuserId, 
			Timestamp regDate, String commentSubject, 
			String commentContent) {
		super();
		this.commentNo = commentNo;
		this.cuserId = cuserId;
		this.regDate = regDate;
		this.commentSubject = commentSubject;
		this.commentContent = commentContent;
	}
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
