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
		System.out.println("�Խñ��� ����Ͻʽÿ�.");
		System.out.println("���̵� : " );
		String id = sc.nextLine();
		System.out.println("���� : " );
		String title = sc.nextLine();
		System.out.println("���� : " );
		String content = sc.nextLine();
		
		bd1.setId(Integer.parseInt(id));
		bd1.setTitle(title);
		bd1.setContent(content);
	}
}
