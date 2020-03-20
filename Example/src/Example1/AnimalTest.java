package Example1;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dolphin dolphin = new Dolphin();
		Swan swan = new Swan();
		dolphin.setName("돌고래");
		swan.setName("백조");
		dolphin.setGender("남자");
		swan.setGender("여자");
		
		System.out.println("이름 : " + dolphin.getName());
		System.out.println("성별 : " + dolphin.getGender());
		
	}
}
