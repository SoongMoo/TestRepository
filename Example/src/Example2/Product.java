package Example2;
/*
 * 2. 각 가전 제품들의 전기 소모량은 모두 다르다. 
 * 그러므로 특정 클래스에서 소모량을 정하고 상속을 줄 수도 없다. 
 * 이럴때 필요한 것이 추상 클래스인데 가전 제품들에 적용될 다음의 [조건]을 보고 
 * 추상 클래스를 정의해 보자!
 * [조건]
∙ 에너지 소모량을 저장하는 int형의 energe라는 변수
∙ 제품의 이름을 저장할 수 있는 productName이라는 변수
∙ energe값을 반환하는 메서드
∙ 제품의 이름을 반환하는 메서드
∙ 제품의 이름을 설정(변경)하는 메서드
∙ 에너지 소모량을 증가하는 electricMeter()추상 메서드
 */
// 추상클래스는 독자적으로 객체 생성할 수 없다.
public abstract class Product {
	int energe;
	String productName;
	public int getEnerge() {
		return energe;
	}
	public void setEnerge(int energe) {
		this.energe = energe;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public abstract void electricMeter();
}
