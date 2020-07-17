package controller.answerBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerBoardController extends HttpServlet
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(
				contextPath.length());
		String path;
		if(command.equals("/ans/ansBoardList.ans")) {
			AnsBoardListAction action = 
					new AnsBoardListAction();
			action.execute(request);
			path = "/answerBoard/ans_board_list.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/ans/ansBoardWrite.ans")) {
			path = "/answerBoard/ans_board_write.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/ans/answerBoardWritePro.ans")) {
			AnswerBoardWriteAction action = 
					new  AnswerBoardWriteAction();
			action.execute(request);
			response.sendRedirect("ansBoardList.ans");
		}else if(command.equals("/ans/ansBoardDetail.ans")) {
			AnsBoardDetailAction action = 
					new AnsBoardDetailAction();
			action.execute(request);
			path = "/answerBoard/ans_board_view.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/ans/answerBoardDelete.ans")) {
			request.setAttribute("boardNum", 
					request.getParameter("boardNum"));
			path = "/answerBoard/ans_board_delete.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/ans/answerBoardDelPro.ans")) {
			AnswerBoardDelAction action =
					new AnswerBoardDelAction();
			action.execute(request);
			response.sendRedirect("ansBoardList.ans");
		}else if(command.equals(
				"/ans/answerBoardModify.ans")) {
			AnsBoardDetailAction action = 
					new AnsBoardDetailAction();
			action.execute(request);
			
			path = "/answerBoard/ans_board_modify.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals(
				"/ans/answerBoardModifyPro.ans")) {
			AnswerBoardModifyAction action =
					new AnswerBoardModifyAction();
			String num = action.execute(request);
			response.sendRedirect(
					"ansBoardDetail.ans?boardNum="+num);
		}else if(command.equals("/ans/answerBoardReply.ans")) {
			AnsBoardDetailAction action = 
					new AnsBoardDetailAction();
			action.execute(request);
			
			path = "/answerBoard/ans_board_reply.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/ans/answerBoardReplyPro.ans")) {
			AnswerBoardReplyAction action =
					new AnswerBoardReplyAction();
			action.execute(request);
			response.sendRedirect("ansBoardList.ans");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
