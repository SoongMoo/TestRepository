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
		}else if(path.equals("�Խñ� ���")){
			// view ==> ����  �޾ƿ��� ���� view
			// DAO 
			bf = new BoarderCreate();
			bf.boarderExecute(bd); // view
			
			int result = dao.boarderInsert(bd);
			if(result > 0) {
				System.out.println("���������� ����Ǿ����ϴ�.");
			}else {
				System.out.println("������� �ʾҽ��ϴ�.");
			}
			bf = new BoardMain();
			bf.boarderExecute(null);
		}else if(path.equals("�Խñ� ���")){
			call();
		}else if(path.equals("�Խñ� ����")){
			int seq = num;
			dao.searchBoard(seq,bd);
			bf = new BoarderView();
			bf.boarderExecute(bd);
		}else if(path.equals("�Խñ� ����")){
			int seq = num;
			dao.deleteBoard(seq);
			bf = new BoardMain();
			bf.boarderExecute(null);
		}else if(path.equals("�Խñ� ����")){
			int seq = num;
			// bd : call by referece
			dao.searchBoard(seq,bd);
			bf = new BoardUpdate();
			bf.boarderExecute(bd);
			i = dao.updateBoard(bd);
			if(i > 0) {
				// update�� ��� ����� ���� ���� �Լ�
				call();
			}else {
				dao.searchBoard(seq,bd);
				bf = new BoarderView();
				bf.boarderExecute(bd);
			}
		}else if(path.equals("���� ��������")){
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
