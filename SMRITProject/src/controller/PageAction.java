package controller;

import javax.servlet.http.HttpServletRequest;

public class PageAction {
	public void page(HttpServletRequest request, 
			int count,int limit,int limitPage ,
			int page , String pageUrl) {
		int maxPage = (int)((double)count/limit + 0.95); 
		int startPage = 
				(int)(((double)page / limitPage + 0.95) -1) 
				* limitPage + 1;  
		int endPage =  startPage + limitPage -1 ;
		if(endPage > maxPage) endPage = maxPage;
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);
		request.setAttribute("pageUrl", pageUrl);
	}
}