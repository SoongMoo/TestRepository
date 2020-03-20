package Example04;

import java.util.Scanner;

public class LottoArray {
	public static void main(String [] args) {
		int lotto [] = new int[6];
		int count =0;
		int num =0;
		Scanner sc = new Scanner(System.in);
		System.out.println("구매 수량을 입력하세요.");
		num = Integer.parseInt(sc.nextLine());
		do {
			for(int i = 0; i < lotto.length; i++) {
				lotto[i] = (int)(Math.random() * 45) +1; 
				for(int j = 0; j <= i-1; j++ ) {
					if(lotto[i] == lotto[j]) {i--; break;}
				}
			}
			for(int i = 0; i < lotto.length ; i++) {
				System.out.print(lotto[i]+"\t");
			}
			System.out.println();
			count++;
		}while(count < num);
	}
	
}
