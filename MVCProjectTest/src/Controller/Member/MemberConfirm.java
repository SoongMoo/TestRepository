package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;

public class MemberConfirm {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = request.getParameter("userId");
		MemberDAO dao = new MemberDAO();
		String confirmId = dao.selectId(userId);
		System.out.println("MemberConfirm : " + confirmId);
		if(confirmId == null) {
			request.setAttribute("msg", "사용가능한 id입니다.");
			request.setAttribute("num", 2);
		}else {
			request.setAttribute("msg", "사용중인 id입니다.");
			request.setAttribute("num", 1);
		}
		request.setAttribute("userId", userId);
	}
}
