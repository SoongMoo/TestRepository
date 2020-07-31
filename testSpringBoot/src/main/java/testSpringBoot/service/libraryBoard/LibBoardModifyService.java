package testSpringBoot.service.libraryBoard;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
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
import testSpringBoot.domain.StartEndPageDTO;
import testSpringBoot.mapper.LibraryBoardMapper;
@Component
@Service
@Transactional
public class LibBoardModifyService {
	@Autowired
	LibraryBoardMapper libraryBoardMapper;
	public void libBoardModify(LibraryBoardCommand libraryBoardCommand,	HttpSession session, HttpServletRequest request) throws Exception{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String realPath = request.getServletContext().getRealPath("/static/lib_Board/upload");
		String userId = (String)session.getAttribute("logId");

		LibraryBoardDTO libraryBoardDTO = new  LibraryBoardDTO();
		libraryBoardDTO.setBoardNum(Integer.parseInt(libraryBoardCommand.getBoardNum()));
		libraryBoardDTO.setUserId(userId);
		libraryBoardDTO.setBoardContent(libraryBoardCommand.getBoardContent());
		libraryBoardDTO.setBoardPass(libraryBoardCommand.getBoardPass());
		libraryBoardDTO.setBoardSubject(libraryBoardCommand.getBoardSubject());
		libraryBoardDTO.setBoardContent(libraryBoardCommand.getBoardContent());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		libraryBoardDTO.setUserId(authInfo.getId());
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, userId,libraryBoardCommand.getBoardNum());
		List<LibraryBoardDTO> list = libraryBoardMapper.getLibraryBoardList(startEndPageDTO);
		libraryBoardDTO.setOriginalFileName(list.get(0).getOriginalFileName());
		libraryBoardDTO.setStoreFileName(list.get(0).getStoreFileName());
		libraryBoardDTO.setFileSize(list.get(0).getFileSize());
		System.out.println(libraryBoardDTO.getBoardNum());
		System.out.println(libraryBoardDTO.getBoardContent());
		System.out.println(libraryBoardDTO.getBoardPass());
		System.out.println(libraryBoardDTO.getBoardSubject());
		System.out.println(libraryBoardDTO.getFileSize());
		System.out.println(libraryBoardDTO.getOriginalFileName());
		System.out.println(libraryBoardDTO.getStoreFileName());
		System.out.println(libraryBoardDTO.getFileSize());
		System.out.println(libraryBoardDTO.getUserId());
		if(libraryBoardCommand.getOriginalFileName() != null && libraryBoardCommand.getOriginalFileName().trim() != "") {// 삭제 할 파일이 있는 경우
			libraryBoardDTO.setOriginalFileName(libraryBoardDTO.getStoreFileName().replace(libraryBoardCommand.getStoreFileName(), ""));
			libraryBoardDTO.setStoreFileName(libraryBoardDTO.getOriginalFileName().replace(libraryBoardCommand.getOriginalFileName(), ""));
			libraryBoardDTO.setFileSize(libraryBoardDTO.getFileSize().replace(libraryBoardCommand.getFileSize(), ""));
		}
		
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		String location ="";
		
		if(libraryBoardCommand.getReport() != null) { // 등록할 파일이 있는 경우
			for(MultipartFile mf : libraryBoardCommand.getReport()) {
				if(libraryBoardDTO.getStoreFileName() == null){
					libraryBoardDTO.setOriginalFileName("");
					libraryBoardDTO.setStoreFileName("");
					libraryBoardDTO.setFileSize("");
				}
				String original = mf.getOriginalFilename();
				String originalFileExtension = 
						original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "")
						+ originalFileExtension;
				String fileSize = Long.toString(mf.getSize());
				originalTotal += original + "`";
				storeTotal += store + "-";
				fileSizeTotal += fileSize + "`";
				File file = new File(realPath + "\\" + store);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				libraryBoardDTO.setOriginalFileName(libraryBoardDTO.getStoreFileName()+"`"+originalTotal);
				libraryBoardDTO.setStoreFileName(libraryBoardDTO.getOriginalFileName()+"`"+storeTotal);
				libraryBoardDTO.setFileSize(libraryBoardDTO.getFileSize()+"`"+fileSizeTotal);
			}

		}
		int i = libraryBoardMapper.libContenfileUpdate(libraryBoardDTO);
		if(i >= 1) {
			if(libraryBoardCommand.getStoreFileName()==null) {
				String [] fileNames = libraryBoardCommand.getStoreFileName().split("`");
				for(String fileName : fileNames) {
					File file = new File(realPath + "/" + fileName);
					if(file.exists()) file.delete();	
				}
			}
		}
	}
}
