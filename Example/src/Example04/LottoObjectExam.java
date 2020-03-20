package Example04;

import java.util.Scanner;

public class LottoObjectExam {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LottoObject lotto = new LottoObject();
		int [] lottoNum = lotto.getLotto();
		for(int i = 0 ; i < lottoNum.length ; i++ ) {
			lottoNum[i] = (int)(Math.random()* 45) + 1;
			for(int j = 0 ; j < i ; j++) {
				if(lottoNum[i] == lottoNum[j]) {i--;break;}
			}
		}
		lotto.print();
	}
}