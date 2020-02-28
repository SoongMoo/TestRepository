package Service.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

@Service
public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memberList(Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		List<MemberDTO> members = 
				memberRepository.getMemberList(page, limit);
		System.out.println(members.size());
		int listCount = memberRepository.getListCount();
		int maxPage = (int)((double)listCount / limit + 0.95);
		int startPage = 
			(int)(((double)page / limitPage + 0.9 ) -1) * limitPage +1;
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage)endPage= maxPage;
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("count", listCount);
		model.addAttribute("memberList", members);
	}
	
}
