package Model.DTO;

import java.util.Date;

// �����͸� �����ϱ� ���� Ŭ������ ���� �־�� �ϴ���?
public class Member {
	// �� ������ ������? ==> ��� �ʵ�
	// ��� �ʵ忡 �ʱ�ȭ? ==> ������
	// ��� �ʵ��� ���� �����ϰų� �����ֱ� ���ؼ� setter, getter
	// ��� �ʵ��� ���� �����ϱ� ���� �޼��尡 �ʿ�����?(�ʿ信 ����)
	String memberNum;
	String memberName;
	Date memberBir; // �������
	String memberPh1; // ����ó1
	String memberPh2; // ����ó2 // ����
	String email; // �ʼ�
	String addr; // �ּ� // �ʼ�
	int gender; // 1: 2000�⵵ ����(�̸�)�� ����, 2: 2000�⵵ ����(2000 �̸�)�� ����
	            // 3: 2000�⵵ ����(�̻�)�� ����, 4: 2000�⵵ ����(2000 �̻�)�� ����
	            // �ʼ�
	String regeDate;
	
	public Member() {}
	// �������� �Ű� ������ 4���̹Ƿ� �����ڸ� ������ �� ���ڰ� 4������ �Ѵ�
	public Member(String memberName, Date memberBir, String memberPh1, String memberPh2, 
			String email, String addr, int gender, String regeDate) {
		this.addr = addr;
		this.email = email;
		this.gender = gender;
		this.memberBir = memberBir;
		this.memberName = memberName;
		this.memberPh1 = memberPh1;
		this.memberPh2 = memberPh2;
		this.regeDate = regeDate;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = "HK-" + memberNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getMemberBir() {
		return memberBir;
	}
	public void setMemberBir(Date memberBir) {
		this.memberBir = memberBir;
	}
	public String getMemberPh1() {
		return memberPh1;
	}
	public void setMemberPh1(String memberPh1) {
		this.memberPh1 = memberPh1;
	}
	public String getMemberPh2() {
		return memberPh2;
	}
	public void setMemberPh2(String memberPh2) {
		this.memberPh2 = memberPh2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getRegeDate() {
		return regeDate;
	}
	public void setRegeDate(String regeDate) {
		this.regeDate = regeDate;
	}
}
