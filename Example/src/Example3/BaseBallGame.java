package Example3;

import java.util.Scanner;

public class BaseBallGame {
	public static void main(String [] args) {
		int com1, com2, com3;
		int user1, user2, user3;
		com1 = (int)(Math.random() * 9);
		do {
			com2 = (int)(Math.random() * 9);
		}while(com1 == com2);
		while(true) {
			com3 = (int)(Math.random() * 9);
			if(com1 != com3 && com2 != com3) break;
		}
		
		Scanner sc = new Scanner(System.in);
		int count= 0;
		do {
			int strike = 0, ball = 0 ;
			System.out.println("첫 번째 숫자를 입력하세요.");
			user1 = Integer.parseInt(sc.nextLine());
			do {
				System.out.println("두 번째 숫자를 입력하세요.");
				user2 = Integer.parseInt(sc.nextLine());
			}while(user1 == user2);
			do {
				System.out.println("세 번째 숫자를 입력하세요.");
				user3 = Integer.parseInt(sc.nextLine());
			}while(user1 == user3 || user2 == user3);
			if(user1 == com1) strike++;
			if(user2 == com2) strike++;
			if(user3 == com3) strike++;
			if(user1 == com2) ball++;
			if(user1 == com3) ball++;
			if(user2 == com1) ball++;
			if(user2 == com3) ball++;
			if(user3 == com2) ball++;
			if(user3 == com1) ball++;
			//System.out.println(com1 + ", " + com2 + ", " + com3);
			System.out.println(strike + "스트라이크 " + ball + " 볼");
			if(strike == 3) break;
			count++;
		}while(count <= 9);
	}
}
