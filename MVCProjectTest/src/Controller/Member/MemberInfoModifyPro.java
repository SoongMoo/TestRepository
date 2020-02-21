package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberInfoModifyPro {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		MemberDTO member = new MemberDTO();
		member.setUserId(request.getParameter("id"));
		member.setUserAddr(request.getParameter("userAddr"));
		member.setUserEmail(request.getParameter("userEmail"));
		member.setUserPh1(request.getParameter("userPh1"));
		member.setUserPh2(request.getParameter("userPh2"));
		MemberDAO dao = new MemberDAO();
		dao.updateInfoMember(member);
	}
}
