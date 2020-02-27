package Service.Library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

public class LibraryBoardListService {
	@Autowired
	LibraryBoardDAO libraryBoardDAO;
	public void libraryBoardList(Model model, Integer page) {
		int nowPage = 1;
		if(page != null) {
			nowPage = page;
		}
		int limit = 10; 
		int limitPage = 10 ;
		List<LibraryBoardDTO> lists = 
				libraryBoardDAO.BoardList(nowPage,limit);
		// 전체페이지 갯수를 구하기 위해 총 리스트의 수를 가져온다.
		int totalCount = libraryBoardDAO.count();
		int maxPage = (int)((double)totalCount/limit + 0.95);
		int startPage =
				(int)(((double)nowPage/limitPage + 0.9)-1) * 10 + 1;
		int endPage  = startPage + limitPage -1;
		if(endPage > maxPage) endPage = maxPage;
		model.addAttribute("boards",lists );
		model.addAttribute("count", totalCount);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", nowPage);
	}
}
