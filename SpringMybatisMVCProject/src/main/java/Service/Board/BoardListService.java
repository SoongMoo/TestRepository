package Service.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Board.BoardCommand;
import Model.DTO.BoardDTO;
import Repository.Board.BoardWriteRepository;

@Service
public class BoardListService {
	@Autowired
	BoardWriteRepository boardWriteRepository;
	public void boardAllSelect(Model model) {
		List<BoardDTO> list =boardWriteRepository.boardAllSelect();
		
		model.addAttribute("boards", list);
	}
}
