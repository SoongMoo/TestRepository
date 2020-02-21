
public class EncryptTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pw = 10;
		int i = pw^2^7^8; // 암호화
		System.out.println(i); // 암호문 
		// System.out.println(i^8^7^2); //복호화
		
		int pw1 =10;
		int y = pw1^2^7^8; // 암호문
		System.out.println(i == y);
		
	}

}
