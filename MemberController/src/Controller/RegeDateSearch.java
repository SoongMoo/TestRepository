package Controller;

import Model.DAO.MemberDAO;
import Model.DTO.Member;

public class RegeDateSearch  implements Action {
	Member member;
	@Override
	public void execute(Object[] objs, Object obj) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		member = dao.regeDateSearch(objs, obj);
	}
	public Member getMember() {
		return member;
	}
}
