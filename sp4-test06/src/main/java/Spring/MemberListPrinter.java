package Spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;

public class MemberListPrinter {
	@Autowired
	@Resource(name="memberDao")
	private MemberDao memDao ;
	@Autowired
	@Qualifier("sysout")// 의존객체가 싱글톤이 아닐때 사용
	private MemberPrinter printer;
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	public void printAll() {
		Collection<MemberDTO> lists = memDao.selectAll();
		System.out.println("총사용자의 수 : " + lists.size());
		for(MemberDTO dto : lists) {
			printer.print(dto);
		}
	}
}
