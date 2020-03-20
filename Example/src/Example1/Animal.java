package Example1;
/*
 * 1. 기본적으로 나이와 이름, 그리고 성별을 저장할 수 있는 멤버 변수들을 가지는
   Animal이라는 클래스를 정의하고 이를 상속받는 수영을 잘 하는 Dolphin과 
     하늘을 나는 Swan클래스를 정의하고 이름과 같은 속성들을 출력하라!
 */
public class Animal {
	int age;
	String name, gender;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}