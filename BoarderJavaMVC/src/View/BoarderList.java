package View;

import java.util.List;
import java.util.Scanner;

import Controller.BoarderController;
import DTO.BoarderDTO;

public class BoarderList implements BoardInterface{

	@Override
	public void boarderExecute(Object obj) {
		// TODO Auto-generated method stub
		List<BoarderDTO> list = 
				(List<BoarderDTO>) obj;
		BoarderPrint bPront = new BoarderPrint();
		System.out.println("번호 \t 제목 \t 내용");
		System.out.println("list : " + list.size());
		for(BoarderDTO bd : list) {
			bPront.print(bd);
		}
		System.out.println("1. 상세보기 | 2. 글쓰기 | 3. 메인");
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력하세요 : ");
		String str = sc.nextLine();
		BoarderController bc = 
				BoarderController.getInstance();
		switch(str) {
		case "1" : 
			System.out.println("보고 싶은 글 번호를 입력하세요.");
			int num = Integer.parseInt(sc.nextLine());
			bc.execute("게시글 보기", num);
			break;
		case "2" : 
			bc.execute("게시글 등록", null);
			break;
		case "3" : 
			bc.execute("main", null);
			break;
		}
	}
}
