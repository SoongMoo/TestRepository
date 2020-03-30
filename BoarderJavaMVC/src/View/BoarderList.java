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
		System.out.println("��ȣ \t ���� \t ����");
		System.out.println("list : " + list.size());
		for(BoarderDTO bd : list) {
			bPront.print(bd);
		}
		System.out.println("1. �󼼺��� | 2. �۾��� | 3. ����");
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȣ�� �Է��ϼ��� : ");
		String str = sc.nextLine();
		BoarderController bc = 
				BoarderController.getInstance();
		switch(str) {
		case "1" : 
			System.out.println("���� ���� �� ��ȣ�� �Է��ϼ���.");
			int num = Integer.parseInt(sc.nextLine());
			bc.execute("�Խñ� ����", num);
			break;
		case "2" : 
			bc.execute("�Խñ� ���", null);
			break;
		case "3" : 
			bc.execute("main", null);
			break;
		}
	}
}
