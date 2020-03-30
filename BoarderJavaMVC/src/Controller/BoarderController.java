package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.BoarderDAO;
import DTO.BoarderDTO;
import DTO.FileDTO;
import View.BoardInterface;
import View.BoardMain;
import View.BoardUpdate;
import View.BoarderCreate;
import View.BoarderList;
import View.BoarderView;
import View.FileDbUpload;
public class BoarderController {
	private static BoarderController bc = 
			new BoarderController();
	
	public static BoarderController getInstance() {
		return bc;
	}
	
	BoardInterface bf ;
	BoarderDAO dao = new BoarderDAO();
	BoarderDTO bd = new BoarderDTO();
	List<BoarderDTO> list ;
	public void execute(String path, Integer num) {
		int i = 10;
		if(path.equals("main")) {
			bf = new BoardMain();
			bf.boarderExecute(null);
		}else if(path.equals("게시글 등록")){
			// view ==> 값을  받아오기 위한 view
			// DAO 
			bf = new BoarderCreate();
			bf.boarderExecute(bd); // view
			
			int result = dao.boarderInsert(bd);
			if(result > 0) {
				System.out.println("정상적으로 저장되었습니다.");
			}else {
				System.out.println("저장되지 않았습니다.");
			}
			bf = new BoardMain();
			bf.boarderExecute(null);
		}else if(path.equals("게시글 목록")){
			call();
		}else if(path.equals("게시글 보기")){
			int seq = num;
			dao.searchBoard(seq,bd);
			bf = new BoarderView();
			bf.boarderExecute(bd);
		}else if(path.equals("게시글 삭제")){
			int seq = num;
			dao.deleteBoard(seq);
			bf = new BoardMain();
			bf.boarderExecute(null);
		}else if(path.equals("게시글 수정")){
			int seq = num;
			// bd : call by referece
			dao.searchBoard(seq,bd);
			bf = new BoardUpdate();
			bf.boarderExecute(bd);
			i = dao.updateBoard(bd);
			if(i > 0) {
				// update후 목록 보기로 가기 위한 함수
				call();
			}else {
				dao.searchBoard(seq,bd);
				bf = new BoarderView();
				bf.boarderExecute(bd);
			}
		}else if(path.equals("파일 내용저장")){
			FileDbUpload fd = new FileDbUpload();
			try {
				List<FileDTO> list = 
						new ArrayList<FileDTO>();
				fd.boarderExecute(list);
				dao.FileInsert(list);
				bf = new BoardMain();
				bf.boarderExecute(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void call() {
		list = new ArrayList<BoarderDTO>();
		list = dao.listBoard();
		bf = new BoarderList();
		bf.boarderExecute(list);
	}
}
