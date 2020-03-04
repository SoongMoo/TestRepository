package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BDTO implements Serializable {
	Integer a1;
	Integer b1;
	Integer b2;
	public Integer getA1() {
		return a1;
	}
	public void setA1(Integer a1) {
		this.a1 = a1;
	}
	public Integer getB1() {
		return b1;
	}
	public void setB1(Integer b1) {
		this.b1 = b1;
	}
	public Integer getB2() {
		return b2;
	}
	public void setB2(Integer b2) {
		this.b2 = b2;
	}
	
}
