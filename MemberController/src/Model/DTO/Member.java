package Model.DTO;

import java.util.Date;

// 데이터를 저장하기 위한 클래스가 뭐가 있어야 하는지?
public class Member {
	// 뭘 저장할 것인지? ==> 멤버 필드
	// 멤버 필드에 초기화? ==> 생성자
	// 멤버 필드의 값을 변경하거나 보내주기 위해서 setter, getter
	// 멤버 필드의 값을 가공하기 위한 메서드가 필요한지?(필요에 따라서)
	String memberNum;
	String memberName;
	Date memberBir; // 생년월일
	String memberPh1; // 연락처1
	String memberPh2; // 연락처2 // 선택
	String email; // 필수
	String addr; // 주소 // 필수
	int gender; // 1: 2000년도 이전(미만)인 남자, 2: 2000년도 이전(2000 미만)인 여자
	            // 3: 2000년도 이후(이상)인 남자, 4: 2000년도 이후(2000 이상)인 여자
	            // 필수
	String regeDate;
	
	public Member() {}
	// 생성자의 매개 변수가 4개이므로 생성자를 실행할 때 인자가 4개여야 한다
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
