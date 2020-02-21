package Controller.Goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsController extends javax.servlet.http.HttpServlet
			implements javax.servlet.Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/goodsList.gd")){
			GoodsListAction action = new GoodsListAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("GoodsView/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsWriter.gd")){
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("GoodsView/goodsForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsPro.gd")){	
			GoodsProAction action = new GoodsProAction();
			action.execute(request, response);
			response.sendRedirect("goodsList.gd");
		}else if(command.equals("/goodsDetail.gd")){	
			GoodsDetailAction action = new GoodsDetailAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("GoodsView/goodsDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsModify.gd")){	
			GoodsDetailAction action = new GoodsDetailAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("GoodsView/goodsModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsModifyPro.gd")){	
			GoodsModifyProAction action = new GoodsModifyProAction();
			String path = action.execute(request, response);	
			response.sendRedirect("goodsDetail.gd?num=" + path );
		}else if(command.equals("/goodsDelete.gd")){
			GoodsDeleteAction action = new GoodsDeleteAction();
			action.execute(request, response);
			response.sendRedirect("goodsList.gd");
		}else if(command.equals("/goodsCartList.gd")){
			GoodsCartListAction action =
					new GoodsCartListAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("GoodsView/goodsCartList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsCartAdd.gd")){
			GoodsCartAddAction action = new GoodsCartAddAction();
			action.execute(request, response);
			response.sendRedirect("goodsCartList.gd");
		}else if(command.equals("/goodsCartQtyUp.gd")){
			GoodsCartQtyUpAction action =
					new GoodsCartQtyUpAction();
			action.execute(request, response);
			response.sendRedirect("goodsCartList.gd");
		}else if(command.equals("/goodsCartQtyDown.gd")){
			GoodsCartQtyDownAction action = new GoodsCartQtyDownAction();
			action.execute(request, response);
			response.sendRedirect("goodsCartList.gd");
		}else if(command.equals("/goodsCartRemove.gd")){
			GoodsCartRemoveAction action =
					new GoodsCartRemoveAction();
			action.execute(request, response);
			response.sendRedirect("goodsCartList.gd");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		doProcess(req, resp);
	}
}
