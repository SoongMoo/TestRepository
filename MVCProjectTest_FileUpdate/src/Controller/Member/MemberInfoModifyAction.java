package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberInfoModifyAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
			String id = req.getParameter("id");
			MemberDAO dao = new MemberDAO();
			MemberDTO member = dao.memberOneSelect(id);
			req.setAttribute("member", member);
	}
}
