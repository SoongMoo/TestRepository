package Example04;

import java.util.Scanner;

public class LottoUserArrayMethod {
	static Scanner sc = new Scanner(System.in);
	static int lotto[] = new int[6];
	static int num =0, count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		su();
		userInput();
		print(num);
	}
	public static void su() {
		System.out.println("���� ������ �Է��ϼ���.");
		num = Integer.parseInt(sc.nextLine());
	}
	public static void userInput() {
		for(int i =0; i <= 2 ; i++) {	
			System.out.println((i+1) + "��° ���� �Է��Ͻÿ�");
			lotto[i] = Integer.parseInt(sc.nextLine());
			for(int j = 0; j <= i-1 ; j++) {
				if (lotto[i] == lotto[j] || 0 >= lotto[i] 
						|| 45 < lotto[i] ) {i--; break;}
			}
		}
	}
	public static void print(int num1) {
		do {
			for(int i =3; i < lotto.length ; i++) {	
				lotto[i] = (int)(Math.random() * 45) +1 ;
				for(int j = 0; j <= i-1 ; j++) {
					if (lotto[i] == lotto[j] || 0 >= lotto[i] 
							|| 45 < lotto[i] ) {i--; break;}
				}
			}
			for(int i = 0; i < lotto.length ; i++) {
				System.out.print(lotto[i]+"\t");
			}
			System.out.println();
			count++;
		}while(count < num1);
	}
}
