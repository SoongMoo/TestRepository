package Spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao = new MemberDao();
	private MemberPrinter printer = new MemberPrinter();
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		System.out.println("총사용자의 수 : " + lists.size());
		for(MemberDTO dto : lists) {
			printer.print(dto);
		}
	}
}
