package controller.comment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(
				contextPath.length());
		if(command.equals("/cb/commentList.cb")) {
			CommentListAction action =
					new CommentListAction();
			action.execute(request);
			String path = "/comment/comment_list.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/cb/commentForm.cb")) {
			String path = "/comment/commentForm.html";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/cb/commentWrite.cb")) {
			CommentWriteAction action =
					new CommentWriteAction();
			action.execute(request);
			response.sendRedirect("commentList.cb");
		}else if(command.equals("/cb/commentDetail.cb")) {
			CommentDetailAction action =
					new CommentDetailAction();
			action.execute(request);
			String path = "/comment/commentCollection.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/cb/commentModify.cb")) {
			CommentDetailAction action =
					new CommentDetailAction();
			action.execute(request);
			
			String path = "/comment/commentModify.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/cb/commentModifyPro.cb")) {
			CommentModifyAction action =
					                new CommentModifyAction();
			action.execute(request);
			response.sendRedirect(
					"commentDetail.cb?commentNo="+
						request.getParameter("commentNo"));
		}else if(command.equals("/cb/commentDelete.cb")) {
			CommentDeleteAction action =
					new CommentDeleteAction();
			action.execute(request);
			response.sendRedirect("commentList.cb");
		}else if(command.equals("/cb/replyInsert.cb")) {
			ReplyInsertAction action = 
					new ReplyInsertAction();
			action.execute(request);
			response.sendRedirect(""
					+ "commentDetail.cb?commentNo="+
					request.getParameter("commentNo"));
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
