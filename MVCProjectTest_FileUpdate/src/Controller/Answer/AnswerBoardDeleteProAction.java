package Controller.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.AnswerBoardDAO;

public class AnswerBoardDeleteProAction {
	public Integer execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String boardNum = request.getParameter("boardNum");
		String boardPass = request.getParameter("boardPass");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("memId");
		AnswerBoardDAO dao = new AnswerBoardDAO();
		Integer result = dao.boardDelete(userId, boardNum, boardPass);
		if(result > 0) {
			session.removeAttribute("deleteMsg");
		}else {
			session.setAttribute("deleteMsg", "권한이 없습니다.");
		}
		return result;
	}
}
