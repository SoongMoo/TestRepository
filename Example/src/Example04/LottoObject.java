package Example04;

public class LottoObject {
	int lotto[] = new int[6];
	public int[] getLotto() {
		return lotto;
	}
	public void setLotto(int[] lotto) {
		this.lotto = lotto;
	}
	public void print() {
		for(int i = 0; i < lotto.length ; i++) {
			System.out.print(lotto[i]+"\t");
		}
	}
	public void insertLotto() {
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < i ; j++) {
				if(lotto[i] == lotto[j]) {i--; break;}
			}
		}
	}
	public void userLotto(int [] lotto3) {
		for(int i = 0; i <= 2 ; i++ ) {
			lotto[i] = lotto3[i]; // lotto[0] ~ lotto[2]
		}
	}
	public void insertLotto3() { // lotto[3] ~ lotto[5]
		for(int i = 3; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < i ; j++) {
				if(lotto[i] == lotto[j]) {i--; break;}
			}
		}
	}
}
