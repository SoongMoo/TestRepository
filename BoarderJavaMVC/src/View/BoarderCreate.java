package View;

import java.util.Scanner;

import DAO.BoarderDAO;
import DTO.BoarderDTO;

public class BoarderCreate implements 
			BoardInterface{
	@Override
	public void boarderExecute(Object obj) {
		BoarderDTO bd1 = (BoarderDTO)obj;
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("게시글을 등록하십시오.");
		System.out.println("아이디 : " );
		String id = sc.nextLine();
		System.out.println("제목 : " );
		String title = sc.nextLine();
		System.out.println("내용 : " );
		String content = sc.nextLine();
		
		bd1.setId(Integer.parseInt(id));
		bd1.setTitle(title);
		bd1.setContent(content);
	}
}
