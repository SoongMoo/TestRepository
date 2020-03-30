package View;

import java.util.Scanner;

import DTO.BoarderDTO;

public class BoardUpdate implements BoardInterface{

	@Override
	public void boarderExecute(Object obj) {
		// TODO Auto-generated method stub
		BoarderDTO bd = (BoarderDTO)obj;
		System.out.println();
		System.out.println("번호 : " + bd.getId());
		System.out.println("제목 : " + bd.getTitle());
		System.out.println("내용 : " + bd.getContent());
		System.out.println();
		System.out.println();
		System.out.println("수정하고 싶은 항목의 번호를 선택하세요.");
		System.out.println("1. 제목 | 2. 내용 | 3.종료");
		Scanner sc = new Scanner(System.in);
		boolean stop = true; 
		while(stop) {
			System.out.println("번호를 선택하세요.");
			String str = sc.nextLine();
			switch(str) {
				case "1" :  
					System.out.print("수정할 제목을 입력하세요 : ");
					bd.setTitle(sc.nextLine());
					break;
				case "2" :  
					System.out.print("수정할 내용을 입력하세요 : ");
					bd.setContent(sc.nextLine());
					break;
				case "3" :
					stop = false;
					break;
			}
		}
 	}
}
