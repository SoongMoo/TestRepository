package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Encrypt;
import Model.DAO.MemberDAO;

public class PwModifyAction {
	public Integer execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String pw= Encrypt.getEncryption(
				request.getParameter("pw"));
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("memId");
		MemberDAO dao = new MemberDAO();
		Integer result = dao.userCheck(userId,pw);
		return result;
	}
}
