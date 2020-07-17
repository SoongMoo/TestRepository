package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;

public class MemberJoinOkAction {
	public String execute(HttpServletRequest request) {
		String path = null;
		String email = request.getParameter("email");
		String joinOk = request.getParameter("joinOk");
		MemberDAO dao = new MemberDAO();
		Integer i = dao.joinOkUPdate(email,joinOk);
		if(i == 1) {
			path = "/member/success.html";
		}else {
			path = "/member/fail.jsp";
		}
		return path;
	}
}
