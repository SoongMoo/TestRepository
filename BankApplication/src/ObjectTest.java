
public class ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac = new Account("1111","이숭무",10000);
		Account ac1 =  null;
		System.out.println(ac.getBalance());
		System.out.println(ac.getOwner());
		ac1 = ac;
		System.out.println(ac1.getBalance());
		System.out.println(ac1.getOwner());
		ac1.setOwner("유근학");
		System.out.println(ac.getOwner());
		Account ac2 =  null;
		ac2 = ac1;
		ac2.setBalance(10);
		System.out.println(ac.getBalance());
		System.out.println(ac1.getBalance());
	}

}
