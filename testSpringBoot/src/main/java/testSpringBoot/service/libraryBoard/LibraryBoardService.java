package testSpringBoot.service.libraryBoard;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import testSpringBoot.command.AuthInfo;
import testSpringBoot.command.LibraryBoardCommand;
import testSpringBoot.domain.LibraryBoardDTO;
import testSpringBoot.mapper.LibraryBoardMapper;
@Component
@Service
@Transactional
public class LibraryBoardService {
	@Autowired
	LibraryBoardMapper libraryBoardMapper;
	final String PATH = "/static/lib_Board/upload";
	//final String PATH = "WEB-INF/view/lib_Board/upload";
	public void writePro(LibraryBoardCommand libraryBoardCommand,	
			HttpSession session, HttpServletRequest request) throws Exception{
		LibraryBoardDTO libraryBoardDTO = new LibraryBoardDTO();
		libraryBoardDTO.setBoardContent(libraryBoardCommand.getBoardContent());
		libraryBoardDTO.setBoardName(libraryBoardCommand.getBoardName());
		libraryBoardDTO.setBoardPass(libraryBoardCommand.getBoardPass());
		System.out.println("LibraryBoardService : " + libraryBoardCommand.getBoardPass());
		libraryBoardDTO.setBoardSubject(libraryBoardCommand.getBoardSubject());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		libraryBoardDTO.setUserId(authInfo.getId());
		libraryBoardDTO.setIpAddr(request.getRemoteAddr());
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		String location ="";
		String filePath = request.getServletContext().getRealPath(PATH);
		System.out.println();
		System.out.println("LibraryBoardService : " + filePath);
		for(MultipartFile mf : libraryBoardCommand.getReport()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = 
					original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "")
					+ originalFileExtension;
			String fileSize = Long.toString(mf.getSize());
			originalTotal += original + "`";
			storeTotal += store + "-";
			fileSizeTotal += fileSize + "`";
			File file = new File(filePath + "\\" + store);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("fileError", "용량이 초과했습니다.");
				location = "LibraryBoard/board_write";
				e.printStackTrace();
			}
		}
		libraryBoardDTO.setOriginalFileName(originalTotal);
		libraryBoardDTO.setStoreFileName(storeTotal);
		libraryBoardDTO.setFileSize(fileSizeTotal);
		System.out.println(libraryBoardDTO.getBoardContent());
		System.out.println(libraryBoardDTO.getBoardName());
		System.out.println(libraryBoardDTO.getBoardPass());
		System.out.println(libraryBoardDTO.getBoardSubject());
		
		libraryBoardMapper.libraryInsert(libraryBoardDTO);
	}
	
}
