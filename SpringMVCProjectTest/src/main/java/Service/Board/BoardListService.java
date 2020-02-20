package Service.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DAO.BoardDAO;
import Model.DAO.MemberDAO;
import Model.DTO.BoardDTO;

public class BoardListService {
	@Autowired
	private BoardDAO boardDAO;

	public void boardList(Model model) {
		List<BoardDTO> board = boardDAO.allSelect();
		if(board!=null) {
			model.addAttribute("boards",board);
			model.addAttribute("count", boardDAO.count());
		}
	
	}
	
}
