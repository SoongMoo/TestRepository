package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberModifyAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("memId");
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.memberOneSelect(id);
		req.setAttribute("member", member);
	}
}
