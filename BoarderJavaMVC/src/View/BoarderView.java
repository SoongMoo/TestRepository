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
		System.out.println("��ȣ : " + bd.getId());
		System.out.println("���� : " + bd.getTitle());
		System.out.println("���� : " + bd.getContent());
		
		System.out.println();
		System.out.println("1. ���� | 2. ����Ʈ | 3. ����");
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȣ�� �����ϼ���.");
		String str = sc.nextLine();
		BoarderController bc = 
				BoarderController.getInstance();
		switch(str) {
			case "1" : 
				bc.execute("�Խñ� ����", bd.getId());
				break;
			case "2" : 
				bc.execute("�Խñ� ���", null);
				break;
			case "3" : 
				bc.execute("�Խñ� ����", bd.getId());
				break;
		}
	}

}
