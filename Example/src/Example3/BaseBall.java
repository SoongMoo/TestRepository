package Example3;

import java.util.Scanner;

public class BaseBall {
	int [] baseball = new int[3];
	Scanner sc = new Scanner(System.in);
	
	public int[] getBaseball() {
		return baseball;
	}

	public void setBaseball(int[] baseball) {
		this.baseball = baseball;
	}
	public void comPlay() {
		for(int i = 0; i < baseball.length; i++) {
			baseball[i] = (int)(Math.random() * 9);
			for(int j = 0; j <= i-1; j++ ) {
				if(baseball[i] == baseball[j]) {i--; break;}
			}
		}
	}
	public void userPlay() {
		for(int i = 0; i < baseball.length; i++) {
			System.out.println( (i+1) + " 번째 숫자를 입력하세요.");
			baseball[i] = Integer.parseInt(sc.nextLine());
			for(int j = 0; j <= i-1; j++ ) {
				if(baseball[i] == baseball[j]) {i--; break;}
			}
		}
	}
}
