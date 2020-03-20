package Example04;

import java.util.Scanner;

public class LottoObjectArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구매 수량을 입력하세요.");
		int num = Integer.parseInt(sc.nextLine());
		LottoObject [] lo = new LottoObject[num];
		for(int i = 0; i < lo.length ; i++) {
			lo[i] = new LottoObject();
			lo[i].insertLotto();
			lo[i].print();
			System.out.println();
		}
	}

}
