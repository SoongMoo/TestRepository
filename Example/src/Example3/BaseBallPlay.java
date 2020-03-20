package Example3;

public class BaseBallPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseBall com = new BaseBall();
		BaseBall user = new BaseBall();
		com.comPlay();
		int [] comball = com.getBaseball();
		int count = 0;
		do {
			user.userPlay();
			int [] userball = user.getBaseball();
			int strike = 0, ball = 0;
			for(int i = 0; i < comball.length ; i++) {
				for(int j = 0; j < userball.length ; j++ ) {
					if(i == j && comball[i] == userball[j])strike++;
					else if(i != j && comball[i] == userball[j])ball++;
				}
			}
			System.out.println(strike + "스트라이크 " + ball + " 볼");
			count++;
		}while(count <= 9);
		
		
		
	}

}
