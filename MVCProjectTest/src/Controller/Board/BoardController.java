package Controller.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController 
extends javax.servlet.http.HttpServlet 
implements javax.servlet.Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/board.bd")) {
			BoardListAction action = new BoardListAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Board/qna_board_list.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWrite.bd")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Board/qna_board_write.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWritePro.bd")) {
			BoardWriteProAction action = new BoardWriteProAction();
			String path = action.execute(request, response);
			response.sendRedirect(path);
		}else if(command.equals("/boardDetailAction.bd")) {
			BoardDetailAction action = new BoardDetailAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Board/qna_board_view.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.bd")) {
			BoardDetailAction action = new BoardDetailAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("Board/qna_board_modify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/BoardModifyAction.bd")) {
			BoardModifyAction action = new BoardModifyAction();
			action.execute(request,response);
			response.sendRedirect("boardDetailAction.bd?num="
							+request.getParameter("BOARD_NUM"));
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}
}
