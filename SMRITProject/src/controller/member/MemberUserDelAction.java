package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;

public class MemberUserDelAction {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = 
				(String)session.getAttribute("logId");
		String userPw = request.getParameter("userPw");
		MemberDAO dao = new MemberDAO();
		dao.userMemberDel(userId, userPw);
	}
}
