package testSpringBoot.service.libraryBoard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.command.AuthInfo;
import testSpringBoot.domain.FileName;
import testSpringBoot.domain.LibraryBoardDTO;
import testSpringBoot.domain.StartEndPageDTO;
import testSpringBoot.mapper.LibraryBoardMapper;
@Component
@Service
@Transactional
public class LibraryBoardDetailService {
	@Autowired
	LibraryBoardMapper libraryBoardMapper;
	public void libBoardDetail(String num,HttpSession session,Model model) throws Exception{
		libraryBoardMapper.updateReadCount(num);
		AuthInfo authInfo= (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getId();
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, userId, num );
		List<LibraryBoardDTO> list = libraryBoardMapper.getLibraryBoardList(startEndPageDTO);
		list.get(0).setBoardContent(list.get(0).getBoardContent());
		System.out.println(list.get(0).getOriginalFileName());
		String [] oriFile = list.get(0).getOriginalFileName().split("`");
		String [] strFile = list.get(0).getStoreFileName().split("`");
		String [] fileSize = list.get(0).getFileSize().split("`");
		List<FileName> fileList = new ArrayList<FileName>();
		System.out.println(oriFile[0]);
		int i = 0;
		for (String file : oriFile) {
				FileName  fileName = new FileName(file, strFile[i],fileSize[i]);
				fileList.add(fileName);
				i++;
		}

		model.addAttribute("fileList", fileList);
		model.addAttribute("list", list);
	}
}
