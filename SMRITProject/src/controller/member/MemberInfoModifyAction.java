package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberInfoModifyAction {
	public void execute(HttpServletRequest request) {
		String userPw = request.getParameter("userPw");
		String userId = request.getParameter("id") ;
		String userEmail = request.getParameter("userEmail") ;
		String userAddr = request.getParameter("userAddr") ;
		String userPh1 = request.getParameter("userPh1") ;
		String userPh2 = request.getParameter("userPh2") ;
		
		MemberDTO  dto = new MemberDTO();
		dto.setUserAddr(userAddr);
		dto.setUserEmail(userEmail);
		dto.setUserPh1(userPh1);
		dto.setUserId(userId);
		dto.setUserPh2(userPh2);
		dto.setUserPw(userPw);
		
		MemberDAO  dao = new MemberDAO();
		dao.memberUpdate(dto);
		
		
		
		
	}
}
