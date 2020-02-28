package Service.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.BoardDTO;
import Repository.Board.BoardWriteRepository;

@Service
public class BoardDetailService {
	@Autowired
	BoardWriteRepository boardWriteRepository;
	public void boardDetail(Integer boardNum,Model model) {
		BoardDTO dto = boardWriteRepository.boardOneSelect(boardNum);
		model.addAttribute("board",dto);
	}
}
