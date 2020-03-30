package View;

import java.util.Scanner;

import Controller.BoarderController;
import DTO.BoarderDTO;

public class BoarderView implements 
						BoardInterface{

	@Override
	public void boarderExecute(Object obj) {
		BoarderDTO bd = (BoarderDTO)obj;
		// TODO Auto-generated method stub
		System.out.println("번호 : " + bd.getId());
		System.out.println("제목 : " + bd.getTitle());
		System.out.println("내용 : " + bd.getContent());
		
		System.out.println();
		System.out.println("1. 수정 | 2. 리스트 | 3. 삭제");
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 선택하세요.");
		String str = sc.nextLine();
		BoarderController bc = 
				BoarderController.getInstance();
		switch(str) {
			case "1" : 
				bc.execute("게시글 수정", bd.getId());
				break;
			case "2" : 
				bc.execute("게시글 목록", null);
				break;
			case "3" : 
				bc.execute("게시글 삭제", bd.getId());
				break;
		}
	}

}
