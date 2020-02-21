package Controller.AnswerBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerBoardController 
extends javax.servlet.http.HttpServlet 
implements javax.servlet.Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/answerBoard.ab")) {
			AnswerBoardAction action = new AnswerBoardAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("AnswerBoard/ans_board_list.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/BoardWrite.ab")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("AnswerBoard/ans_board_write.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWritePro.ab")) {
			BoardWritePro action = new BoardWritePro();
			String path = action.execute(request,response);
			response.sendRedirect(path);
		}else if(command.equals("/BoardDetailAction.ab")) {
			AnswerBoardDetailAction action = new AnswerBoardDetailAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("AnswerBoard/ans_board_view.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.ab")) {
			AnswerBoardModifyAction action = new AnswerBoardModifyAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("AnswerBoard/ans_board_modify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/BoardModifyAction.ab")) {
			AnswerBoardModifyProAction action = 
					new AnswerBoardModifyProAction();
			action.execute(request,response);
			response.sendRedirect("BoardDetailAction.ab?num="+
					request.getParameter("BOARD_NUM"));
		}else if(command.equals("/boardDelete.ab")) {
			BoardDeleteAction action =
					new BoardDeleteAction();
			action.execute(request,response);
			response.sendRedirect("answerBoard.ab");
		}else if(command.equals("/answerBoardReply.ab")) {
			AnswerBoardReplyAction action = 
					new AnswerBoardReplyAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("AnswerBoard/ans_board_reply.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardReplyAction.ab")) {
			AnswerBoardReplyPro action = 
					new AnswerBoardReplyPro();
			action.execute(request, response);
			response.sendRedirect("answerBoard.ab");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
