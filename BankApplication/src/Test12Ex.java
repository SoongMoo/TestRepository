
public class Test12Ex {
	static int i = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dd = 10.0;
		             // 인자, 실인자
		int z = test(dd); //x test(dd) ---호출함수
		System.out.println(z);
	}				// 매개변수, 가인자
	public static int test(double a) { // 피호출함수
		int x = 0;
		if(a == 10.0) x = i;
		return x;
	}

}
