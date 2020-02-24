package Service.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;
@Service
public class LibraryBoardDetailService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	public void boardView(Long boardNum,Model model,String tablename
			,Integer num) {
		libraryBoardDAO.boardReadcountUpdate(boardNum);
		LibraryBoardDTO dto = 
				libraryBoardDAO.boardDetail(boardNum, tablename);
		
		if(num != 1) {
			dto.setBoardContent(dto.getBoardContent().replace("\n", "<br />"));
		}
		model.addAttribute("libraryBoardCommand", dto);
	}
}
