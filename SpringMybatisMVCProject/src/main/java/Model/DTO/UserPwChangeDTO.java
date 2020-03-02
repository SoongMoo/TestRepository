package Model.DTO;

public class UserPwChangeDTO {
	String userId;
	String userPw;
	String newUserPw;
	public UserPwChangeDTO(String userId, String userPw, String newUserPw) {
		this.userId = userId;
		this.userPw = userPw;
		this.newUserPw = newUserPw;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public String getNewUserPw() {
		return newUserPw;
	}
}
