package Controller;

import Model.DAO.MemberDAO;

public class MemberCreate implements Action {

	@Override
	public void execute(Object[] objs, Object obj) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		dao.createMember(objs, obj);
	}

}
