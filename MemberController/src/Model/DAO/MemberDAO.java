package Model.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.DTO.Member;

// Data Access Object
// 데이터를 접근하기 위한 메서드나 변수가 있는 곳
public class MemberDAO {
	// Object는 어떤 클래스로 만들었진 객체든 모두 받을 수 있는 상위 클래스이다
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public void execute(Object obj) {
		
	}
	public void createMember(Object[] objs, Object obj) {
		Member m = (Member)obj;
		Member [] members = (Member[])objs;
		for (int i = 0; i <= members.length; i++) {
			if (members[i] == null) {
				m.setMemberNum("HK-" + Integer.toString(i+1)); // 회원 번호 앞에 HK-를 덧붙임
				m.setRegeDate(sdf.format(new Date())); // 등록 날짜를 문자열로 변환
				members[i] = m;
				break;
			}
		}
	}
	public Member setMember() throws ParseException {
		System.out.println("회원 이름을 작성하세요.");
		String memberName = sc.nextLine();
		
		System.out.println("회원 생년월일을 yyyy-mm-dd 형태로 작성하세요.");
		Date memberBir = sdf.parse(sc.nextLine());
		
		System.out.println("회원 성별을 작성하시오.");
		int gender = Integer.parseInt(sc.nextLine());
		
		System.out.println("회원 연락처 1을 작성하시오.");
		String memberPh1 = sc.nextLine();
		
		System.out.println("회원 연락처 2를 작성하시오.");
		String memberPh2 = sc.nextLine();
		if (memberPh2.trim().equals("")) memberPh2 = null;
		
		System.out.println("회원 이메일을 작성하시오.");
		String email = sc.nextLine();
		
		System.out.println("회원 주소를 작성하시오.");
		String addr = sc.nextLine();
		return new Member(memberName, memberBir, memberPh1, memberPh2, 
				email, addr, gender, sdf.format(new Date()));
	}
	public Member viewMember(Object[] objs, Object obj) {
		Member[] members = (Member[])objs;
		Member m = (Member)obj;
		Member member = null;
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) { // NullPointerException 에러 방지
				if (members[i].getMemberNum().indexOf(m.getMemberNum()) != -1) {
					member = members[i];
					break;
				}
			} else break; // members[i] == null이면 찾지 말고 탈출
		}
		return member;
	}
	public Member memberNameSearch(Object[] objs, Object obj) {
		Member[] members = (Member[])objs;
		Member m = (Member)obj;
		Member member = null;
		for(int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				try {
					if(members[i].getMemberName()
							.indexOf(m.getMemberName()) != -1) {
						member = members[i];
						break;
					}
				}catch(NullPointerException e) { }
			} else break;
		}
		return member;
	}
	public Member memberPhSearch(Object[] objs, Object obj) {
		Member[] members = (Member[])objs;
		Member m = (Member)obj;
		Member member = null;
		for(int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				try {
				if(members[i].getMemberPh1().
						indexOf(m.getMemberPh1()) != -1 ||
				members[i].getMemberPh2().indexOf(m.getMemberPh1()) != -1) {
					member = members[i];
					break;
				}
				}catch(Exception e) {}
			} else break;
		}
		return member;
	}
	public Member memberNumSearch(Object[] objs, Object obj) {
		Member[] members = (Member[])objs;
		Member m = (Member)obj;
		Member member = null;
		for(int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				if(members[i].getMemberNum().indexOf(m.getMemberNum()) != -1) {
					member = members[i];
					break;
				}
			} else break;
		}
		return member;
	}
	public Member memberBirSearch(Object[] objs, Object obj) {
		Member[] members = (Member[])objs;
		Member m = (Member)obj;
		Member member = null;
		String membersDate;
		String mDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				membersDate = sdf.format(members[i].getMemberBir());
				mDate = sdf.format(m.getMemberBir());
				if(membersDate.indexOf(mDate) != -1) {
					member = members[i];
					break;
				}
			} else break;
		}
		return member;
	}
	public Member regeDateSearch(Object[] objs, Object obj) {
		Member[] members = (Member[])objs;
		Member m = (Member)obj;
		Member member= null;
		//System.out.println(m.getRegeDate());
		for (int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				try {
					if (members[i].getRegeDate()
							.indexOf(m.getRegeDate()) != -1) {
						member = members[i];
						break;
					}
				} catch (NullPointerException e) {}
			} else break;
		}
		return member;
	}
}
