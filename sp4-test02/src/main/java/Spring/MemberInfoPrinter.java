package Spring;

public class MemberInfoPrinter {
	private MemberDao memberDao = new MemberDao();
	private MemberPrinter printer = new MemberPrinter();
	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(dto);
	}
}
