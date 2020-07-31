package testSpringBoot.controller.library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import testSpringBoot.command.LibraryBoardCommand;
import testSpringBoot.controller.FileDownLoad;
import testSpringBoot.service.libraryBoard.LibBoardModifyService;
import testSpringBoot.service.libraryBoard.LibraryBoardDetailService;
import testSpringBoot.service.libraryBoard.LibraryBoardListService;
import testSpringBoot.service.libraryBoard.LibraryBoardService;

@Controller
@RequestMapping("libraryBoard")
public class LibraryController {
	@Autowired
	LibraryBoardService libraryBoardService;	
	@Autowired
	LibraryBoardListService libraryBoardListService;
	@Autowired
	LibraryBoardDetailService libraryBoardDetailService;
	@Autowired
	FileDownLoad fileDownLoad;
	@Autowired
	LibBoardModifyService libBoardModifyService;
	@ModelAttribute
	LibraryBoardCommand setLibraryBoardCommand() {
		return new LibraryBoardCommand();
	}
	
	@RequestMapping("library")
	public String libraryList(Model model, 
			@RequestParam(value = "page" , defaultValue = "1") Integer page) throws Exception{
		libraryBoardListService.libraryBoardList(model, page);
		return "lib_Board/lib_board_list";
	}
	@RequestMapping(value="libBoardForm" , method = RequestMethod.GET)
	public String libraryWrite() {
		return "thymeleaf/lib_Board/lib_board_write";
	}
	@RequestMapping(value="libBoardForm" , method = RequestMethod.POST)
	public String libraryWritePro(@Validated LibraryBoardCommand libraryBoardCommand, BindingResult result, 
			HttpSession session,
			HttpServletRequest request)  throws Exception{
		if (result.hasErrors()) {
			System.out.println("bsaicf");
 			 return "thymeleaf/lib_Board/lib_board_write";
	    }
		libraryBoardService.writePro(libraryBoardCommand, session, request);
		return "redirect:/libraryBoard/library";
	}
	@RequestMapping("libBoardDetail/{id}")
	public String libBoardDetail(@PathVariable(value = "id") String id, 
			Model model,HttpSession session)  throws Exception{
		libraryBoardDetailService.libBoardDetail(id, session, model);
		return "thymeleaf/lib_Board/lib_board_view";
	}
	@RequestMapping("fileDown/{fileName}")
	public String filDownLoad(@PathVariable(value = "fileName") String fileName, 
			HttpServletResponse response, HttpServletRequest request) {
		fileDownLoad.fileDownLoad("/static/lib_Board/upload", fileName, request, response);
		return "thymeleaf/lib_Board/lib_board_view";
	}
	@RequestMapping("libBoardModify")
	public String libBoardModify(Model model, 
			@RequestParam(value = "boardNum" ) String boardNum ,HttpSession session) throws Exception{
		libraryBoardDetailService.libBoardDetail(boardNum, session, model);
		return "thymeleaf/lib_Board/lib_board_modify";
	}
	@RequestMapping("libBoardModifyPro")
	public String libBoardModifyPro(LibraryBoardCommand libraryBoardCommand, Model model, HttpServletRequest request ,HttpSession session) throws Exception{
		System.out.println("libBoardModifyPro : " + libraryBoardCommand.getBoardNum());
		libBoardModifyService.libBoardModify( libraryBoardCommand,	 session,  request);
		return "redirect:/libraryBoard/libBoardDetail/"+libraryBoardCommand.getBoardNum();
	}
}
