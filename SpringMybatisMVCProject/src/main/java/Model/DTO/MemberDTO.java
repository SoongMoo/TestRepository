package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class MemberDTO implements Serializable{
	String userId ;
	String userPw  ; 
	String userName;
	Timestamp userBirth;
	String userGender;
	String userEmail;
	String userAddr;
	String userPh1;
	String userPh2;
	Timestamp userRegist;
	String joinOk;

	CommentDTO commentDTO;
	
	public MemberDTO() {}
	
	public MemberDTO(String userId, String userPw, String userName, Timestamp userBirth, String userGender,
			String userEmail, String userAddr, String userPh1, String userPh2, Timestamp userRegist) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userAddr = userAddr;
		this.userPh1 = userPh1;
		this.userPh2 = userPh2;
		this.userRegist = userRegist;
	}
	
	public String getJoinOk() {
		return joinOk;
	}

	public void setJoinOk(String joinOk) {
		this.joinOk = joinOk;
	}

	public CommentDTO getCommentDTO() {
		return commentDTO;
	}

	public void setCommentDTO(CommentDTO commentDTO) {
		this.commentDTO = commentDTO;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Timestamp userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserPh1() {
		return userPh1;
	}
	public void setUserPh1(String userPh1) {
		this.userPh1 = userPh1;
	}
	public String getUserPh2() {
		return userPh2;
	}
	public void setUserPh2(String userPh2) {
		this.userPh2 = userPh2;
	}
	public Timestamp getUserRegist() {
		return userRegist;
	}
	public void setUserRegist(Timestamp userRegist) {
		this.userRegist = userRegist;
	}
}
