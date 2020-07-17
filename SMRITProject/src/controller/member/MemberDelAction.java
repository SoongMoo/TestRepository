package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDelAction {
	public void execute(HttpServletRequest request) {
		String userId = request.getParameter("id");
		String userPw = request.getParameter("userPw");
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserPw(userPw);
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(dto);
	}
}
