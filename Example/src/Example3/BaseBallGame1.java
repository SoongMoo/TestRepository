package Example3;

import java.util.Scanner;

public class BaseBallGame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] com = new int[3];
		int user [] = new int[3];
		/*
		com[0] = (int)(Math.random() * 9);
		do {
			com[1] = (int)(Math.random() * 9);
		}while(com[0] == com[1]);
		do {
			com[2] = (int)(Math.random() * 9);
		}while(com[0] == com[2] || com[0] == com[3]);
		*/
		for(int i = 0; i < com.length; i++) {
			com[i] = (int)(Math.random() * 9);
			for(int j = 0; j <= i-1; j++ ) {
				if(com[i] == com[j]) {i--; break;}
			}
		}
		Scanner sc = new Scanner(System.in);
		int count = 0;
		do {
			int strike =0, ball = 0;
			for(int i = 0; i < user.length; i++) {
				System.out.println( (i+1) + " 번째 숫자를 입력하세요.");
				user[i] = Integer.parseInt(sc.nextLine());
				for(int j = 0; j <= i-1; j++ ) {
					if(user[i] == user[j]) {i--; break;}
				}
			}
			for(int i = 0; i < com.length ; i++) {
				for(int j = 0; j < user.length ; j++) {
					if(i == j && com[i] == user[j]) strike++;
					else if(i != j && com[i] == user[j]) ball++;
				}
			}
			System.out.println(com[0] + ", " + com[1] + ", " + com[2]);
			System.out.println(strike + "스트라이크 " + ball + " 볼");
			count++;
		}while(count <= 9);
	}
}
