package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;

public class MemberInfoDelAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		String userid = req.getParameter("id");
		MemberDAO dao = new MemberDAO();
		dao.memberInfoDelete(userid);
	}
}
