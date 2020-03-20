package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.DTO.Board;

public class BoarderExample {
	static Scanner sc = new Scanner(System.in);
	static Board [] boards = new  Board[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean stop = false;
		while(!stop) {
			System.out.println("1.게시판등록 | 2.게시판목록 | 3. 게시판 검색 | "
					+ "4. 게시글보기 | 5. 종료");
			int selectNum = Integer.parseInt(
					sc.nextLine());
			switch(selectNum) {
			case 1 : 
				Board board = setBoard();
				createBoard(board); break;
			case 2 : listBoard(); break;
			case 3 : searchBoard(); break;
			case 4 : viewBoard(); break;
			case 5 : stop = true; break;
			default : System.out.println("번호선택이 잘 못되었습니다.");
			}
		}
	}
	public static void searchBoard() {
		// 제목, 내용, 글쓴이, 날짜, 제목+내용
		System.out.println("1.제목 | 2.내용 | 3.글쓴이 | 4.날짜 | "
				+ "5.제목+내용");
		int num = Integer.parseInt(sc.nextLine());
		Board board = null;
		switch(num) {
		case 1: 
			System.out.println("찾을 제목을 입력하세요. ");
			String subject = sc.nextLine();
			for(int i = 0; i < boards.length ; i++) {
				if(boards[i] != null) {
					if(boards[i].getSubject().equals(subject)) {
						board = boards[i];
					}
				}
				else break;
			}
			break;
		case 2: 
			System.out.println("찾을 내용을 입력하세요. ");
			String contents = sc.nextLine();// 이숭무
			for(int i = 0; i < boards.length ; i++) {
				if(boards[i] != null) {
					if(boards[i].getContents().indexOf(contents)!= -1) {
						board = boards[i];
						break;
					}
				}
				else break;
			}
			break;
		case 3: 
			System.out.println("찾을 글쓴이를 입력하세요. ");
			String name = sc.nextLine();
			for(int i = 0; i < boards.length ; i++) {
				if(boards[i] != null) {
					if(boards[i].getBoardName().equals(name)) {
						board = boards[i];
					}
				}
				else break;
			}
			break;
		case 4: 
			System.out.println("찾을 내용의 등록일을 yyyy-mm-dd로 입력하세요. ");
			String regeDate = sc.nextLine();
			for(int i = 0; i < boards.length; i++) {
				SimpleDateFormat sdf = 
						new SimpleDateFormat("yyyy-MM-dd");
				String boardDate = sdf.format(boards[i].getBoardDate());
				if(boardDate.equals(regeDate)) {
					board = boards[i]; break;
				}else break;
			}
			break;
		case 5: 
			System.out.println("찾을 제목 또는 내용을 입력하세요. ");
			String searchValue = sc.nextLine();
			for(int i = 0 ; i < boards.length ; i++) {
				if(boards[i].getSubject().indexOf(searchValue) != -1 || 
				   boards[i].getContents().indexOf(searchValue) != -1) {
					board = boards[i]; break;
				}else break;
			}
			break;
		default : return; // 번호가 틀리면 함수를 종료한다.
		}
		if(board != null) {
		System.out.println("게시글 번호 : " + board.getBoardNum());
		System.out.println("게시글쓴이 : " + board.getBoardName());
		System.out.println("게시글 제목 : " + board.getSubject());
		System.out.println("게시글 내용 : " + board.getContents());
		System.out.println("게시글 아이디 : " + board.getId());
		System.out.println("게시글 등록일 : " + board.getBoardDate());
		}else {
			System.out.println("원하는 정보가 없습니다.");
		}
	}
	public static void viewBoard() {
		System.out.print("보고자하는 게시글 번호를 입력하시오. : ");
		int boardNum = Integer.parseInt(sc.nextLine());
		Board board = null;
		for(int i = 0 ; i < boards.length ; i++) {
			if(boards[i] != null) {
				if(boards[i].getBoardNum() == boardNum) { 
					/*
	    System.out.println("게시글 번호 : " + boards[i].getBoardNum());
		System.out.println("게시글쓴이 : " + boards[i].getBoardName());
		System.out.println("게시글 제목 : " + boards[i].getSubject());
		System.out.println("게시글 내용 : " + boards[i].getContents());
		System.out.println("게시글 아이디 : " + boards[i].getId());
		System.out.println("게시글 등록일 : " + boards[i].getBoardDate());
					 */
					board = boards[i];
					break;
				}
			}else  break;
		}
		if(board != null) {
		System.out.println("게시글 번호 : " + board.getBoardNum());
		System.out.println("게시글쓴이 : " + board.getBoardName());
		System.out.println("게시글 제목 : " + board.getSubject());
		System.out.println("게시글 내용 : " + board.getContents());
		System.out.println("게시글 아이디 : " + board.getId());
		System.out.println("게시글 등록일 : " + board.getBoardDate());
		}else {
			System.out.println("원하는 정보가 없습니다.");
		}
		
 	}
	public static void listBoard() {
		for(int i = 0; i < boards.length ; i++) {
			if(boards[i] != null) {
				System.out.print("게시글 번호 : " 
								+ boards[i].getBoardNum() + "\t");
				System.out.print("게시글쓴이 : " 
						+ boards[i].getBoardName() + "\t");
				System.out.print("게시글 제목 : " 
						+ boards[i].getSubject() + "\n");
				System.out.println();
			}else { break; }
		}
	}
	public static void createBoard(Board board) {
		Board b = board;
		// 게시판을 생성하기 위해 비어 있는 배열요소를 찾기 위한 반복문
		for(int i = 0; i < boards.length ; i++) {
			// 배열요소 중 빈 배열요소를 찾기 위해서 배열요소가 null인지 확인
			if(boards[i] == null) {
				// 빈 배열요소에 Board객체 생성
				b.setBoardNum(i+1);
				b.setBoardDate(new Date());
				boards[i] = b;
				break;
			}
		}
	}
	// Board객체 입력할 내용을 가져오기 위한 메서드
	public static Board setBoard() {
		System.out.print("글쓴이를 입력하세요. : ");
		String boardName = sc.nextLine();
		System.out.print("제목을 입력하세요. : ");
		String boardSubject = sc.nextLine();
		System.out.print("내용 입력하세요. : ");
		String boardContents = sc.nextLine();
		System.out.print("아이디를 입력하세요. : ");
		String id = sc.nextLine();
		return new Board(boardName,boardSubject,boardContents,id);
	}
	
}
