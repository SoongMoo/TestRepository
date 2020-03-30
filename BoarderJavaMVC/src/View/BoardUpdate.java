package View;

import java.util.Scanner;

import DTO.BoarderDTO;

public class BoardUpdate implements BoardInterface{

	@Override
	public void boarderExecute(Object obj) {
		// TODO Auto-generated method stub
		BoarderDTO bd = (BoarderDTO)obj;
		System.out.println();
		System.out.println("��ȣ : " + bd.getId());
		System.out.println("���� : " + bd.getTitle());
		System.out.println("���� : " + bd.getContent());
		System.out.println();
		System.out.println();
		System.out.println("�����ϰ� ���� �׸��� ��ȣ�� �����ϼ���.");
		System.out.println("1. ���� | 2. ���� | 3.����");
		Scanner sc = new Scanner(System.in);
		boolean stop = true; 
		while(stop) {
			System.out.println("��ȣ�� �����ϼ���.");
			String str = sc.nextLine();
			switch(str) {
				case "1" :  
					System.out.print("������ ������ �Է��ϼ��� : ");
					bd.setTitle(sc.nextLine());
					break;
				case "2" :  
					System.out.print("������ ������ �Է��ϼ��� : ");
					bd.setContent(sc.nextLine());
					break;
				case "3" :
					stop = false;
					break;
			}
		}
 	}
}
