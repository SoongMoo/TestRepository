package Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	@Autowired
	public MemberInfoPrinter(MemberDao memberDao, 
			@Qualifier("sysout")MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(dto);
	}
}
