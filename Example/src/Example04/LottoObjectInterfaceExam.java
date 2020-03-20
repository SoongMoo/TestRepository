package Example04;

import java.util.Scanner;

public class LottoObjectInterfaceExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("구매 수량을 입력하세요.");
		int num = Integer.parseInt(sc.nextLine());
		LottoInterface [] li = new LottoInterface[num];
		int lotto [] = new int[3];
		// 사용자가 입력한 값을 lotto배열에 대입
		for(int i = 0; i <= 2 ; i++) {
			System.out.println((i+1) + "번째 수를 입력하시오");
			lotto[i] = Integer.parseInt(sc.nextLine());
			if(lotto[i] <= 0 || lotto[i] > 45 ) {i--; continue;}
			for(int j = 0; j < i ; j++) {
				if(lotto[i] == lotto[j]) {i--; break;}
			}
		}
		for(int i = 0; i < li.length ; i++) {
			li[i] = new LottoObjectInterface();
			li[i].userLotto(lotto);
			li[i].insertLotto3();
			li[i].print();
			System.out.println();
		}
	}

}
