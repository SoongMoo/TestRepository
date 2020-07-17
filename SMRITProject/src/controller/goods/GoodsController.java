package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsController extends HttpServlet 
implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = 
				RequestURI.substring(contextPath.length());
		if(command.equals("/gd/goodsList.gd")) {
			GoodsListAction action =
					new GoodsListAction();
			action.execute(request);
			String path = "/goodsView/goodsList.jsp";
			RequestDispatcher dispatcher= 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/gd/goodsForm.gd")) {
			String path = "/goodsView/goodsForm.jsp";
			RequestDispatcher dispatcher= 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/gd/goodsPro.gd")) {
			GoodsProAction action = new GoodsProAction();
			action.execute(request); // request 빼먹었음.
			response.sendRedirect("goodsList.gd");
		}else if(command.equals("/gd/goodsDetail.gd")) {
			GoodsDetailAction action =
					new GoodsDetailAction();
			action.execute(request);
			String path = "/goodsView/goodsDetail.jsp";
			RequestDispatcher dispatcher= 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/gd/goodsDelete.gd")) {
			GoodsDeleteAction action = 
					new GoodsDeleteAction();
			action.execute(request);
			response.sendRedirect("goodsList.gd");
		}else if(command.equals("/gd/goodsModify.gd")) {
			GoodsDetailAction action =
					new GoodsDetailAction();
			action.execute(request);
			String path = "/goodsView/goodsModify.jsp";
			RequestDispatcher dispatcher= 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/gd/goodsModifyPro.gd")) {
			GoodsModifyAction action =
					new GoodsModifyAction();
			String goodsNum = action.execute(request);
			response.sendRedirect(
					"goodsDetail.gd?goodsNum="+goodsNum);
		}else if(command.equals("/gd/goodsCartAdd.gd")) {
			GoodsCartAddAction action =
					new GoodsCartAddAction();
			action.execute(request);
			response.sendRedirect("goodsCartList.gd");
		}else if(command.equals("/gd/goodsCartList.gd")) {
			GoodsCartListAction action =
					new GoodsCartListAction();
			action.execute(request);
			String path = "/goodsView/goodsCartList.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);					
		}else if(command.equals("/gd/goodsCartQtyDown.gd")) {
			GoodsCartQtyDownAction action =
					new GoodsCartQtyDownAction();
			action.execute(request);
			response.sendRedirect("goodsCartList.gd");
		}else if(command.equals("/gd/goodsCartRemove.gd")) {
			GoodsCartRemoveAction action =
					new GoodsCartRemoveAction();
			action.execute(request);
			response.sendRedirect("goodsCartList.gd");
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
