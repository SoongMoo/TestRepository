package Example04;

import java.util.Scanner;

public class LottoObjectUserExam {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int lotto [] = new int[3];
		System.out.println("���� ������ �Է��ϼ���.");
		int num = Integer.parseInt(sc.nextLine());
		LottoObject [] lo = new LottoObject[num];
		for(int i = 0; i <= 2 ; i++) { // 3�� �Է� �޾� ��.
			System.out.println((i+1) + "��° ���� �Է��Ͻÿ�");
			lotto[i] = Integer.parseInt(sc.nextLine());
			if(lotto[i] <= 0 || lotto[i] > 45) {i--; continue;}
			for (int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {i--; break;}
			}			
		}
		for(int i = 0 ; i < lo.length ; i++) {
			lo[i] = new LottoObject();
			lo[i].userLotto(lotto);
			lo[i].insertLotto3();
			lo[i].print();
			System.out.println();
		}
		
	}
}
