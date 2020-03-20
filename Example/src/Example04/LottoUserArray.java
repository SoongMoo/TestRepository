package Example04;

import java.util.Scanner;

public class LottoUserArray {
	public static void main(String [] args) {
		int lotto[] = new int[6];
		Scanner sc = new Scanner(System.in);
		System.out.println("구매 수량을 입력하세요.");
		int num =0, count = 0;
		num = Integer.parseInt(sc.nextLine());
		for(int i =0; i <= 2 ; i++) {	
			System.out.println((i+1) + "번째 수를 입력하시오");
				lotto[i] = Integer.parseInt(sc.nextLine());
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j] || 0 >= lotto[i] 
						|| 45 < lotto[i] ){ i--; break;}
			}
		}
		do {
			for (int i = 3; i < lotto.length; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) { i--; break;}
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
