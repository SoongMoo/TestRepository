
public class Test12Ex {
	static int i = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dd = 10.0;
		             // ����, ������
		int z = test(dd); //x test(dd) ---ȣ���Լ�
		System.out.println(z);
	}				// �Ű�����, ������
	public static int test(double a) { // ��ȣ���Լ�
		int x = 0;
		if(a == 10.0) x = i;
		return x;
	}

}
