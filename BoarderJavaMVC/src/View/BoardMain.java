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
		System.out.println("���� ��ȣ�� �����ϼ���.");
		System.out.println("1.�Խ��ǵ�� | 2.�Խ��Ǹ�� | "
	 			+ " 3. ���� ���� DB���� | 5. ����");
		int selectNum = 0;
		
		while (true) {
			try {
				System.out.println("��ȣ���� : ");
				selectNum = Integer.parseInt(sc.nextLine());
						break;
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է����ּ���.");
			}
		}
		switch (selectNum) {
		case 1 : 
			System.out.println("1�� ����");
			bc.execute("�Խñ� ���",null);
			break;
		case 2 : 
			bc.execute("�Խñ� ���",null);
			break;
		case 3:
			bc.execute("���� ��������",null);
			break;
		case 5 : 
			System.out.println("���α׷��� ����Ǿ����ϴ�.");
			System.exit(0);
			break;
		}
	}
}
