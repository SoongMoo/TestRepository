package testSpringBoot.service.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.controller.PageAction;
import testSpringBoot.domain.MemberDTO;
import testSpringBoot.domain.StartEndPageDTO;
import testSpringBoot.mapper.MemberMapper;

@Component
@Service
@Transactional
public class MemberListService {
	@Autowired
	MemberMapper memberRepository;
	public void memberList(Model model, Integer page) throws Exception{
		System.out.println(page);
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow,endRow,null,null);
		List<MemberDTO> members = 
				memberRepository.getMemberList(startEndPageDTO);
		System.out.println(members.size());
		int count = memberRepository.getMemberCount();
		
		model.addAttribute("count", count);
		model.addAttribute("memberList", members);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "list?");
	}
}
