package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;

public class MemberMailOk {
	public String execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String num = request.getParameter("num");
		String userEmail = request.getParameter("email");
		MemberDAO dao = new MemberDAO();
		System.out.println("aaaa");
		String joinOk = dao.joinOkcheck(userEmail);
		String path = "";
		if(joinOk.equals("t")) {
			dao.joinUpdate(num, userEmail);
			path = "Member/memberTrue.jsp";
		}else {
			path = "Member/memberFail.jsp";
		}
		return path;
	}
}
