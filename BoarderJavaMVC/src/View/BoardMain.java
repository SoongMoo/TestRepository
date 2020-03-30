package View;

import java.util.Scanner;

import Controller.BoarderController;
import DTO.BoarderDTO;

public class BoardMain implements BoardInterface{
	@Override
	public void boarderExecute(Object obj) {
		BoarderDTO bd = (BoarderDTO) obj;
		// TODO Auto-generated method stub
		BoarderController bc = 
				BoarderController.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("다음 번호를 선택하세요.");
		System.out.println("1.게시판등록 | 2.게시판목록 | "
	 			+ " 3. 파일 내용 DB저장 | 5. 종료");
		int selectNum = 0;
		
		while (true) {
			try {
				System.out.println("번호선택 : ");
				selectNum = Integer.parseInt(sc.nextLine());
						break;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
		switch (selectNum) {
		case 1 : 
			System.out.println("1번 선택");
			bc.execute("게시글 등록",null);
			break;
		case 2 : 
			bc.execute("게시글 목록",null);
			break;
		case 3:
			bc.execute("파일 내용저장",null);
			break;
		case 5 : 
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			break;
		}
	}
}
