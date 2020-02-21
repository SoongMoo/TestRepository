package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;

public class MemberInfoDelAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String userId = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		dao.memberInfoDelete(userId);
	}
}
