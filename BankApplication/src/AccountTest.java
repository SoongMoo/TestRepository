
public class AccountTest {
	static Account ac = new Account("1111","111",1000);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1000;
		Account bb = test(i);
	}
	public static Account test(int y) {
		Account aa = null;
		if(ac.getBalance() == y) aa = ac;
		return aa;
	}

}
