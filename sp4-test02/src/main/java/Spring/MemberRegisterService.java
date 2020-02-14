package Spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao = new MemberDao();
	public void regist(RegisterRequest req) {
		System.out.println("aaaa : " + req.getEmail());
		MemberDTO dto = memberDao.selectByEmail(req.getEmail());
		if(dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			memberDao.insert(dto);
			System.out.println("사용자 등록이 완료 되었습니다.");
		}else {
			System.out.println("중복 사용자입니다.");
		}
	}
}
