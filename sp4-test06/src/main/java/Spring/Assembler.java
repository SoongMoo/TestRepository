package Spring;

public class Assembler { // 객체조립기
	private MemberDao memberDao;
	private MemberPrinter printer;
	private MemberRegisterService memberRegisterService;
	private MemberListPrinter memberListPrinter;
	private ChangePasswordService changePasswordService;
	private MemberInfoPrinter memberInfoPrinter;
	public Assembler() {
		this.memberDao = new MemberDao();
		this.printer = new MemberPrinter();
		this.memberRegisterService = new MemberRegisterService(memberDao);
		this.memberListPrinter = new MemberListPrinter();
		this.changePasswordService = new ChangePasswordService();
		this.memberInfoPrinter = new MemberInfoPrinter(memberDao,printer);
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public MemberPrinter getPrinter() {
		return printer;
	}
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	public MemberListPrinter getMemberListPrinter() {
		memberListPrinter.setMemberDao(memberDao);
		memberListPrinter.setPrinter(printer);
		return memberListPrinter;
	}
	public ChangePasswordService getChangePasswordService() {
		changePasswordService.setMemberDao(memberDao);
		return changePasswordService;
	}
	public MemberInfoPrinter getMemberInfoPrinter() {
		return memberInfoPrinter;
	}
}
