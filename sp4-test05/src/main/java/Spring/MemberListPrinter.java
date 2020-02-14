package Spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao ;
	private MemberPrinter printer;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		System.out.println("총사용자의 수 : " + lists.size());
		for(MemberDTO dto : lists) {
			printer.print(dto);
		}
	}
}
