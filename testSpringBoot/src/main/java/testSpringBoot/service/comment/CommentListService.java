package testSpringBoot.service.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.controller.PageAction;
import testSpringBoot.domain.CommentDTO;
import testSpringBoot.domain.StartEndPageDTO;
import testSpringBoot.mapper.CommentMapper;
@Component
@Service
@Transactional
public class CommentListService {
	@Autowired
	CommentMapper commentMapper;
	public void execute(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow,endRow,null,null);
		
		List<CommentDTO> lists = commentMapper.getCommentList(startEndPageDTO);
		int count = commentMapper.getCommentCount();
		int maxPage = (int)((double)count / limit + 0.95);
		int startPage = 
			(int)(((double)page / limitPage + 0.9 ) -1) * limitPage +1;
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage)endPage= maxPage;
		
		model.addAttribute("count", count);
		model.addAttribute("comments", lists);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "comment_list?");
		
	}

}
