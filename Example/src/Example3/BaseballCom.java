package Example3;

public class BaseballCom implements BaseBallInterface{
	int [] ball = new int[3];
	public int[] getBall() {return ball;	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		for(int i = 0; i < ball.length; i++) {
			ball[i] = (int)(Math.random() * 9);
			for(int j = 0; j <= i-1; j++ ) {
				if(ball[i] == ball[j]) {i--; break;}
			}
		}
	}

}
