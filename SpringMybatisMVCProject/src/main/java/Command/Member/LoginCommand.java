package Command.Member;



public class LoginCommand {
	private String id1;
	private Boolean idStore;
	private Boolean autoLogin;
	private String pw;
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public Boolean getIdStore() {
		return idStore;
	}
	public void setIdStore(Boolean idStore) {
		this.idStore = idStore;
	}
	public Boolean getAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(Boolean autoLogin) {
		this.autoLogin = autoLogin;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
