package Service.Library;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Command.Library.LibraryBoardCommand;
import Contoller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.AuthInfo;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	final String PATH = "WEB-INF\\view\\LibraryBoard\\update\\";
	public String writePro(LibraryBoardCommand libraryBoardCommand,
			HttpSession session,
			HttpServletRequest request) {
		LibraryBoardDTO libraryBoardDTO = new LibraryBoardDTO();
		libraryBoardDTO.setBoardContent(libraryBoardCommand.getBoardContent());
		libraryBoardDTO.setBoardName(libraryBoardCommand.getBoardName());
		libraryBoardDTO.setBoardPass(
				Encrypt.getEncryption(
						libraryBoardCommand.getBoardPass()));
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
			originalTotal += original + "-";
			storeTotal += store + "-";
			fileSizeTotal += fileSize + "-";
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
		libraryBoardDTO.setOriginalfileName(originalTotal);
		libraryBoardDTO.setStoreFileName(storeTotal);
		libraryBoardDTO.setFileSize(fileSizeTotal);
		location = "redirect:/libraryBoard/library";
		libraryBoardDAO.libraryInsert(libraryBoardDTO);
		return location;
	}
}
