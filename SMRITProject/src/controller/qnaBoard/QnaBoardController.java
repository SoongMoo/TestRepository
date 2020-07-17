package controller.qnaBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QnaBoardController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(
				contextPath.length());
		if(command.equals("/qna/qnaList.qna")) {
			QnaListAction action = new QnaListAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"/QNA_Board/qna_board_list.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/qna/qnaWrite.qna")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"/QNA_Board/qna_board_write.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/qna/qnaWritePro.qna")) {
			QnaWriteProAction action =
					new QnaWriteProAction();
			action.execute(request);
			response.sendRedirect("qnaList.qna");
		}else if(command.equals("/qna/qnaDetail.qna")) {
			String path = "/QNA_Board/qna_board_view.jsp";
			QnaDetailAction action = new QnaDetailAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/qna/qnaBoardModify.qna")) {
			QnaDetailAction action = new QnaDetailAction();
			action.execute(request);
			String path = "/QNA_Board/qna_board_modify.jsp";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/qna/qnaBoardModifyPro.qna")) {
			QnaBoardModifyAction action = 
					new QnaBoardModifyAction();
			action.execute(request);
			response.sendRedirect("qnaDetail.qna?num="
					+ request.getParameter("boardNum"));
		}else if(command.equals("/qna/qnaBoardDelete.qna")) {
			String path = "/QNA_Board/qna_board_delete.jsp";
			request.setAttribute("boardNum",
					request.getParameter("num"));
			System.out.println(request.getParameter("num"));
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/qna/qnaBoardDeletePro.qna")) {
			QnaBoardDeleteAction action =
					new QnaBoardDeleteAction();
			action.execute(request);
			response.sendRedirect("qnaList.qna");
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
