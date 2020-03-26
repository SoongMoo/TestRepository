package Controller.Answer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerController 
		extends javax.servlet.http.HttpServlet 
		implements javax.servlet.Servlet{
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		doProcess(request,response );
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		doProcess(request,response );
	}
	public void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(
				contextPath.length());
		if(command.equals("/answerBoard.ab")) {
			AnswerBoardListAction action = 
					new AnswerBoardListAction();
			
			action.execute(request, response);
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"AnswerBoard/board_list.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/answerBoardWrite.ab")) {
		
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"AnswerBoard/board_write.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/answerBoardWritePro.ab")) {
			System.out.println("/answerBoardWritePro.ab");
			AnswerBoardAddAction action = 
					new AnswerBoardAddAction();
			Integer result;
			try {
				result = action.execute(request, response);
				if(result > 0) {
					response.sendRedirect("answerBoard.ab");
				}else {
					response.sendRedirect("answerBoardWrite.ab");
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}else if(command.equals("/answerBoardDetail.ab")) {
 			AnswerBoardDetailAction action = // DAO를 사용하기 위한 class
 					new AnswerBoardDetailAction();
 			action.execute(request, response);
 			RequestDispatcher dispatcher = 
 					request.getRequestDispatcher("AnswerBoard/board_view.jsp");
 			dispatcher.forward(request, response);
 		}else if(command.equals("/answerBoardUpdate.ab")) {
 			AnswerBoardUpdateAction action = 
 					new AnswerBoardUpdateAction();
 			action.execute(request, response);
 			RequestDispatcher dispatcher = 
 					request.getRequestDispatcher("AnswerBoard/boardModify.jsp");
 			dispatcher.forward(request, response);
 		}else if(command.equals("/answerBoardModify.ab")) {
 			AnswerBoardModifyAction action =
 					new AnswerBoardModifyAction();
 			Integer result = null;
			try {
				result = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			String num = request.getParameter("boardNum");
 			if(result > 0) {
 				response.sendRedirect("answerBoardDetail.ab?num="+num);
 			}else{
 				response.sendRedirect("answerBoardUpdate.ab?num="+num);
 			}
 		}else if(command.equals("/answerBoardDelete.ab")) {
 			RequestDispatcher dispatcher = 
 					request.getRequestDispatcher(
 							"AnswerBoard/boardDelete.jsp");
 			dispatcher.forward(request, response);
 		}else if(command.equals("/answerBoardDeletePro.ab")) {
 			AnswerBoardDeleteProAction action = 
 					new AnswerBoardDeleteProAction();
 			Integer result = action.execute(request, response);

 			if(result > 0) {
 				response.sendRedirect("answerBoard.ab");
 			}else {
 				response.sendRedirect("answerBoardDelete.ab?num="+
 						request.getParameter("boardNum"));
 			}
 		}else if(command.equals("/answerBoardReply.ab")) {
 			AnswerBoardReplyAction action = 
 					new AnswerBoardReplyAction();
 			action.execute(request, response);
 			RequestDispatcher dispatcher = 
 					request.getRequestDispatcher("AnswerBoard/boardReply.jsp");
 			dispatcher.forward(request, response);
 		}else if(command.equals("/answerBoardReplyPro.ab")) {
 			System.out.println("aaaaa");
 			AnswerBoardReplyPro action = 
 					new AnswerBoardReplyPro();
 			try {
				action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			response.sendRedirect("answerBoard.ab");
 		}
	}








}
