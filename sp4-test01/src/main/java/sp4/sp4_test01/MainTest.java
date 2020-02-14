package sp4.sp4_test01;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeter gt = new Greeter();
		gt.setFormat("%s, 안녕하세요!");
		String msg = gt.greet("이숭무");
		System.out.println(msg);
	}
}
