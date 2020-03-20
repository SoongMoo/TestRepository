package Example04;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,d,e,f;
		int count = 0 ;
		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("수량을 입력하세요.");
		num = Integer.parseInt(sc.nextLine());
		do {
			a = (int)(Math.random() * 45 ) +1;
			do {
				b = (int)(Math.random() * 45 ) +1;
			}while(a == b);
			do {
				c = (int)(Math.random() * 45 ) +1;
			}while(a == c || b == c);
			do {
				d = (int)(Math.random() * 45 ) +1;
			}while(a == d || b == d || c == d);
			do {
				e = (int)(Math.random() * 45 ) +1;
			}while(a == e || b == e || c == e || d == e);
			do {
				f = (int)(Math.random() * 45 ) +1;
			}while(a == f || b == f || c == f || d == f || e == f);
			System.out.println(a + "," + b + "," + c + "," + d +"," 
			                     + e +"," + f);
			count++;
		}while(count < num );
	}
}
