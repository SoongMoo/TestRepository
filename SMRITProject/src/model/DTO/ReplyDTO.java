package model.DTO;

import java.sql.Timestamp;

public class ReplyDTO {
	private Long commentNo;
	private String cuserId;
	private Long replyNo;
	private String ruserId;
	private String replyContent;
	private Timestamp regDate;
	
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
	public Long getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Long replyNo) {
		this.replyNo = replyNo;
	}
	public String getRuserId() {
		return ruserId;
	}
	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}	
}
