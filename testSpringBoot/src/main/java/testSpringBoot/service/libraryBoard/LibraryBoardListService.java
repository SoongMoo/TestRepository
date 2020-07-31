package testSpringBoot.service.libraryBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.controller.PageAction;
import testSpringBoot.domain.LibraryBoardDTO;
import testSpringBoot.domain.StartEndPageDTO;
import testSpringBoot.mapper.LibraryBoardMapper;
@Component
@Service
@Transactional
public class LibraryBoardListService {
	@Autowired
	LibraryBoardMapper libraryBoardMapper;
	public void libraryBoardList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow,endRow,null,null);
		
		List<LibraryBoardDTO> lists = 
				libraryBoardMapper.getLibraryBoardList(startEndPageDTO);
		System.out.println("libraryBoardList: " + lists.size());
		// 전체페이지 갯수를 구하기 위해 총 리스트의 수를 가져온다.
		int count = libraryBoardMapper.getLibraryCount();
		System.out.println(count);
		int maxPage = (int)((double)count / limit + 0.95);
		int startPage = 
			(int)(((double)page / limitPage + 0.9 ) -1) * limitPage +1;
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage)endPage= maxPage;
		
		model.addAttribute("count", count);
		model.addAttribute("lists", lists);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "library?");
	}
}
