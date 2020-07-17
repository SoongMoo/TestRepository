package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;

public class MemberInfoCngAction {
	public Integer execute(HttpServletRequest request) {
		Integer i = 0;
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("logId");
		String userPw = request.getParameter("userPw");
		MemberDAO dao = new MemberDAO();
		i = dao.memberLoginCk(userId, userPw);
		return i;
	}
}
