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
					"1.���¹�ȣ | 2.���¸�� | "
					+ "3.���� | 4.��� | 5.���� ");
			System.out.print("����> ");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
			case 1: 
				System.out.print("���¹�ȣ : ");
				String ano = sc.nextLine();
				System.out.print("������ : ");
				String name = sc.nextLine();
				System.out.print("�ʱ��Աݱݾ� : ");
				int money = Integer.parseInt(sc.nextLine());
				createAccount(ano,name,money);
				break;
			case 2: // �������
				accountList();
				break;
			case 3: // �Ա�
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
		System.out.println("����");
		System.out.println("--------------");
		System.out.print("���¹�ȣ  : ");
		String ano2 = sc.nextLine();
		System.out.println("���ݾ� : ");
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
		System.out.println("���°� �����Ǿ����ϴ�.");
	}
	public static void withDraw() {
		System.out.println("-----------------------");
		System.out.println("���");
		System.out.println("-----------------------");
		System.out.print("���¹�ȣ : ");
		String ano11 = sc.nextLine();
		System.out.print("��ݱݾ� : ");
		int withDrawMoney = Integer.parseInt(sc.nextLine());
		// findAccount ==> ���¸� ã��.
		// i = 0�� ������ �迭�� �ε���(��ҹ�ȣ)�� 0���� �����ϹǷ�
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








