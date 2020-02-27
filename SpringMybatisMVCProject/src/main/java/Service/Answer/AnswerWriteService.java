package Service.Answer;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Command.Answer.AnswerCommand;
import Controller.Encrypt;
import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;
import Model.DTO.AuthInfo;

public class AnswerWriteService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;
	final String PATH = "WEB-INF\\view\\AnswerBoard\\update\\";
	public String answerInsert(AnswerCommand answerCommand,
			HttpServletRequest request, HttpSession session) {
		AnswerBoardDTO dto = new AnswerBoardDTO();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setUserId(authInfo.getId());
		dto.setBoardContent(answerCommand.getBoardContent());
		dto.setBoardName(answerCommand.getBoardName());
		dto.setBoardPass(Encrypt.getEncryption(
				answerCommand.getBoardPass()));
		dto.setBoardSubject(answerCommand.getBoardSubject());
		dto.setIpAddr(request.getRemoteAddr());
		
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		
		String realPath = request.getServletContext().getRealPath(PATH);
		System.out.println(realPath);
		for(MultipartFile mf : answerCommand.getBoardFile()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = // test.txt.txt.txt
					original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "")
					+ originalFileExtension;
			Long fileSize = mf.getSize(); 
			originalTotal += original + "-";
			storeTotal += store + "-";
			fileSizeTotal += fileSize + "-";	
			File file = new File(realPath + "\\" + store);// 파일 객체 생성
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("fileError", "용량이 초과했습니다.");
				e.printStackTrace();
				return "AnswerBoard/ans_board_write";
			}
		}
		dto.setOriginalfileName(originalTotal);
		dto.setStoreFileName(storeTotal);
		dto.setFileSize(fileSizeTotal);
		answerBoardDAO.answerInsert(dto);
		return "redirect:/answer/answerBoard";
	}
}
