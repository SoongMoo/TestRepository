package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberInfoAction {
	public void execute(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.memberSelect(1,1,userId);
		System.out.println();
		request.setAttribute("dto", list.get(0));
	}
}
