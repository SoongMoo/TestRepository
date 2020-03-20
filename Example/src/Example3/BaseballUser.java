package Example3;

import java.util.Scanner;

public class BaseballUser implements BaseBallInterface{
	int [] ball = new int [3];
	Scanner sc = new Scanner(System.in);
	public int[] getBall() { return ball; }
	@Override
	public void play() {
		// TODO Auto-generated method stub
		for(int i = 0; i < ball.length; i++) {
			System.out.println( (i+1) + " 번째 숫자를 입력하세요.");
			ball[i] = Integer.parseInt(sc.nextLine());
			for(int j = 0; j <= i-1; j++ ) {
				if(ball[i] == ball[j]) {i--; break;}
			}
		}
	}

}
