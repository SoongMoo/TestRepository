
public class TestEx {
	static int iArray[] = new int[] {1,2,3,4,5};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y = 4;
		int z = test(y);
		System.out.println(z);
		System.out.println(iArray[3]);
	}
	public static int test(int yy) {
		int i = 0;
		for(int i1 = 0; i1 < iArray.length ; i1++) {
			if(iArray[i1] == yy) i = iArray[i1];
		}
		return i;
	}

}
