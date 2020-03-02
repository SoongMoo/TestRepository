package Command.Member;



public class ChangePwdCommand {
	private String userId;
	private String pw;
	private String newPw;
	private String reNewPw;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	public String getReNewPw() {
		return reNewPw;
	}
	public void setReNewPw(String reNewPw) {
		this.reNewPw = reNewPw;
	}
	public boolean isPasswordEqualToConfirmPassword() {
		if(newPw.equals(reNewPw)) {
			return true;
		}
		return false;
	}
}





