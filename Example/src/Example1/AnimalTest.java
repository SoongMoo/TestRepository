package Example1;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dolphin dolphin = new Dolphin();
		Swan swan = new Swan();
		dolphin.setName("����");
		swan.setName("����");
		dolphin.setGender("����");
		swan.setGender("����");
		
		System.out.println("�̸� : " + dolphin.getName());
		System.out.println("���� : " + dolphin.getGender());
		
	}
}
