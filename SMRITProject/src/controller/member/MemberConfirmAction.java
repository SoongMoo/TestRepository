package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;

public class MemberConfirmAction {
	public void execute(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		MemberDAO dao = new MemberDAO();
		String confirmId = dao.memberConfirm(userId);
		request.setAttribute("userId" , userId);
		request.setAttribute("confirmId",confirmId);
	}
}
