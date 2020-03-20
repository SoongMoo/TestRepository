import java.util.Scanner;
//DAO  // Controller
public class BankApplication {
	static Scanner sc = new Scanner(System.in);
	static Account[] ac = new Account[10];
	int i [] = new int[3];
	static int arrayNum = 0; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		while(run) {
			System.out.println(
					"1.계좌번호 | 2.계좌목록 | "
					+ "3.예금 | 4.출금 | 5.종료 ");
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
			case 1: 
				System.out.print("계좌번호 : ");
				String ano = sc.nextLine();
				System.out.print("계좌주 : ");
				String name = sc.nextLine();
				System.out.print("초기입금금액 : ");
				int money = Integer.parseInt(sc.nextLine());
				createAccount(ano,name,money);
				break;
			case 2: // 계좌출력
				accountList();
				break;
			case 3: // 입금
				deposit();
				break;
			case 4: 
				withDraw();
				break;
			case 5: run = false;
				break;
			}
		}
	}
	public static void deposit() {
		System.out.println("--------------");
		System.out.println("예금");
		System.out.println("--------------");
		System.out.print("계좌번호  : ");
		String ano2 = sc.nextLine();
		System.out.println("예금액 : ");
		int depositMoney = Integer.parseInt(sc.nextLine());
		Account acaa = findAccount(ano2);
		int result1 = acaa.getBalance() + depositMoney;
		acaa.setBalance(result1);
	}
	public static void accountList() {
		for(int i = 0; i < ac.length ; i++) {
			if(ac[i] != null) {
				System.out.println(ac[i].getAccountNo() +"\t"
						+ ac[i].getOwner() + "\t" +
						ac[i].getBalance());
			}else break;
		}
	}
	public static void createAccount(String ano,String name,
			int money) {
		ac[arrayNum] = new Account(ano,name,money);
		arrayNum++;
		System.out.println("계좌가 생성되었습니다.");
	}
	public static void withDraw() {
		System.out.println("-----------------------");
		System.out.println("출금");
		System.out.println("-----------------------");
		System.out.print("계좌번호 : ");
		String ano11 = sc.nextLine();
		System.out.print("출금금액 : ");
		int withDrawMoney = Integer.parseInt(sc.nextLine());
		// findAccount ==> 계좌를 찾자.
		// i = 0인 이유는 배열의 인덱스(요소번호)가 0으로 시작하므로
		Account a = findAccount(ano11);
		int result = a.getBalance() - withDrawMoney;  // ac[i].getBalance()
		a.setBalance(result);
	}
	public static Account findAccount(String ano1) {
		Account acc = null;
		int result = 0;
		for(int i = 0; i <= 9 ; i++) {
			if(ac[i] != null) {
				if(ac[i].getAccountNo().equals(ano1)) {
					acc = ac[i];
				}
			}else break;
		}
		return acc;
	}
}








