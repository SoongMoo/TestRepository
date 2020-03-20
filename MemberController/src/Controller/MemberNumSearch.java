package Controller;

import Model.DAO.MemberDAO;
import Model.DTO.Member;

public class MemberNumSearch implements Action {
	Member member;
	@Override
	public void execute(Object[] objs, Object obj) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		member = dao.memberNumSearch(objs, obj);
	}
	public Member getMember() {
		return member;
	}
}
