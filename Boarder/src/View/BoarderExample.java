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
			System.out.println("1.�Խ��ǵ�� | 2.�Խ��Ǹ�� | 3. �Խ��� �˻� | "
					+ "4. �Խñۺ��� | 5. ����");
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
			default : System.out.println("��ȣ������ �� ���Ǿ����ϴ�.");
			}
		}
	}
	public static void searchBoard() {
		// ����, ����, �۾���, ��¥, ����+����
		System.out.println("1.���� | 2.���� | 3.�۾��� | 4.��¥ | "
				+ "5.����+����");
		int num = Integer.parseInt(sc.nextLine());
		Board board = null;
		switch(num) {
		case 1: 
			System.out.println("ã�� ������ �Է��ϼ���. ");
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
			System.out.println("ã�� ������ �Է��ϼ���. ");
			String contents = sc.nextLine();// �̼���
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
			System.out.println("ã�� �۾��̸� �Է��ϼ���. ");
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
			System.out.println("ã�� ������ ������� yyyy-mm-dd�� �Է��ϼ���. ");
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
			System.out.println("ã�� ���� �Ǵ� ������ �Է��ϼ���. ");
			String searchValue = sc.nextLine();
			for(int i = 0 ; i < boards.length ; i++) {
				if(boards[i].getSubject().indexOf(searchValue) != -1 || 
				   boards[i].getContents().indexOf(searchValue) != -1) {
					board = boards[i]; break;
				}else break;
			}
			break;
		default : return; // ��ȣ�� Ʋ���� �Լ��� �����Ѵ�.
		}
		if(board != null) {
		System.out.println("�Խñ� ��ȣ : " + board.getBoardNum());
		System.out.println("�Խñ۾��� : " + board.getBoardName());
		System.out.println("�Խñ� ���� : " + board.getSubject());
		System.out.println("�Խñ� ���� : " + board.getContents());
		System.out.println("�Խñ� ���̵� : " + board.getId());
		System.out.println("�Խñ� ����� : " + board.getBoardDate());
		}else {
			System.out.println("���ϴ� ������ �����ϴ�.");
		}
	}
	public static void viewBoard() {
		System.out.print("�������ϴ� �Խñ� ��ȣ�� �Է��Ͻÿ�. : ");
		int boardNum = Integer.parseInt(sc.nextLine());
		Board board = null;
		for(int i = 0 ; i < boards.length ; i++) {
			if(boards[i] != null) {
				if(boards[i].getBoardNum() == boardNum) { 
					/*
	    System.out.println("�Խñ� ��ȣ : " + boards[i].getBoardNum());
		System.out.println("�Խñ۾��� : " + boards[i].getBoardName());
		System.out.println("�Խñ� ���� : " + boards[i].getSubject());
		System.out.println("�Խñ� ���� : " + boards[i].getContents());
		System.out.println("�Խñ� ���̵� : " + boards[i].getId());
		System.out.println("�Խñ� ����� : " + boards[i].getBoardDate());
					 */
					board = boards[i];
					break;
				}
			}else  break;
		}
		if(board != null) {
		System.out.println("�Խñ� ��ȣ : " + board.getBoardNum());
		System.out.println("�Խñ۾��� : " + board.getBoardName());
		System.out.println("�Խñ� ���� : " + board.getSubject());
		System.out.println("�Խñ� ���� : " + board.getContents());
		System.out.println("�Խñ� ���̵� : " + board.getId());
		System.out.println("�Խñ� ����� : " + board.getBoardDate());
		}else {
			System.out.println("���ϴ� ������ �����ϴ�.");
		}
		
 	}
	public static void listBoard() {
		for(int i = 0; i < boards.length ; i++) {
			if(boards[i] != null) {
				System.out.print("�Խñ� ��ȣ : " 
								+ boards[i].getBoardNum() + "\t");
				System.out.print("�Խñ۾��� : " 
						+ boards[i].getBoardName() + "\t");
				System.out.print("�Խñ� ���� : " 
						+ boards[i].getSubject() + "\n");
				System.out.println();
			}else { break; }
		}
	}
	public static void createBoard(Board board) {
		Board b = board;
		// �Խ����� �����ϱ� ���� ��� �ִ� �迭��Ҹ� ã�� ���� �ݺ���
		for(int i = 0; i < boards.length ; i++) {
			// �迭��� �� �� �迭��Ҹ� ã�� ���ؼ� �迭��Ұ� null���� Ȯ��
			if(boards[i] == null) {
				// �� �迭��ҿ� Board��ü ����
				b.setBoardNum(i+1);
				b.setBoardDate(new Date());
				boards[i] = b;
				break;
			}
		}
	}
	// Board��ü �Է��� ������ �������� ���� �޼���
	public static Board setBoard() {
		System.out.print("�۾��̸� �Է��ϼ���. : ");
		String boardName = sc.nextLine();
		System.out.print("������ �Է��ϼ���. : ");
		String boardSubject = sc.nextLine();
		System.out.print("���� �Է��ϼ���. : ");
		String boardContents = sc.nextLine();
		System.out.print("���̵� �Է��ϼ���. : ");
		String id = sc.nextLine();
		return new Board(boardName,boardSubject,boardContents,id);
	}
	
}
