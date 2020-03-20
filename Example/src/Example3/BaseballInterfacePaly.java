package Example3;

public class BaseballInterfacePaly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseballUser user = new BaseballUser();
		BaseballCom com = new BaseballCom();
		
		com.play();
		int [] comBall = com.getBall();
		int count =0;
		do {
			user.play();
			int [] userBall = user.getBall();
			int strike = 0, ball =0;
			for(int i = 0; i < comBall.length ; i++) {
				for(int j = 0; j < userBall.length ; j++) {
					if(i == j && comBall[i] == userBall[j])strike++;
					else if(i != j && comBall[i] == userBall[j])ball++;
				}
			}
			System.out.println(strike + "스트라이크 " + ball + " 볼");
			count ++;
		}while(count <= 9);
	}

}
