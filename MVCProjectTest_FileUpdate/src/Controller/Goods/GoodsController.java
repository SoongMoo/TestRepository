package Controller.Goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsController 
	extends javax.servlet.http.HttpServlet 
	implements javax.servlet.Servlet{
	ActionForward forward = null; // 경로와 redirect에 대한 정보를 가져오기 위해서
	// Action은 interface를 사용한 이유는 action이라는 이름으로 객체 생성시키기 위해
	Action action = null; // ActionForward를 반환 하기 위해 execute를 실행
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 요청한 경로를 알기 위해서
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command =  //contextPath이후의 경로를 가져온다.
				RequestURI.substring(contextPath.length());
		if(command.equals("/goodsList.gd")) {
			// 동적 바인딩
			action = new GoodsListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		}else if(command.equals("/goodsWriter.gd")) {
			action = new GoodsWriterAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/goodsPro.gd")) {
			action = new GoodsProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/goodsDetail.gd")) {
			action = new GoodsDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/goodsDelete.gd")) {
			action = new GoodsDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/goodsModify.gd")) {
			action = new GoodsModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/goodsModifyPro.gd")) {
			action = new GoodsModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/goodsCartAdd.gd")) {
			action = new GoodsCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/goodsCartList.gd")) {
			action = new GoodsCartListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/goodsCartQtyUp.gd")) {
			// 세션에 있는 리스에 제품의 수량 up
			action = new GoodsCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/goodsCartQtyDown.gd")){
			action = new GoodsCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/goodsCartRemove.gd")) {
			action = new GoodsCartRemoveAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher= 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
