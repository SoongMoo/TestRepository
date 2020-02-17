package Spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	int i;
	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void changePassword(String email, String oldPwd,String newPwd) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPwd, newPwd);
		memberDao.update(dto);
	}
}
