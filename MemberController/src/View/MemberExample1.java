package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import Controller.MemberController;
import Model.DTO.Member;

public class MemberExample1 {
	static Scanner sc = new Scanner(System.in);
	static MemberController mc = new MemberController();
	static Member[] members = new Member[10]; //이게 DB라고 가정하고 코딩함
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		boolean stop = false;
		while(!stop) {
			System.out.println("1.회원 등록 | 2.회원 리스트 | 3.회원 검색 | "
					+ "4.회원정보 보기 | 5.종료");
			int selectNum = 0;
			while(true) {
				try {
					selectNum = Integer.parseInt(sc.nextLine());
					break;
				}catch(NumberFormatException e) {
					System.out.println("숫자를 입력하세요.");
				}
			}
			switch (selectNum) {
			case 1:
				Member member = setMember(); // 입력한 값
				mc.doProcess(selectNum, members, member); // DB와 입력한 값을 넘김
				break;
			case 2: // 게시판을 이 클래스를 이용해서 저장했으므로 목록 보기도 이 클래스에서 처리
				listMember();
				break;
			case 3:
				searchMember();
				break;
			case 4: // 기존 BoarderExample.class에 있던 함수를 여러 개로 쪼개서 일부를 이 클래스에 둠.
				Member member1 = viewMember(); // case 1에 이미 member가 있으므로 다른 이름 사용
                                            // 다른 방법:
				                            // switch문 밖에 member를 생성해서 case 1, 4에서 재활용
				mc.doProcess(selectNum, members, member1);
				Member member2 = mc.getMember();
				print(member2);
				break;
			case 5:
				stop = true;
				break;
			default:
				break;
			}
		}
	}
	
	public static void searchMember() {
		// 제목, 내용, 글쓴이, 날짜, 제목+내용
		
		System.out.println("11.이름 | 12.연락처 | 13.회원 번호 | 14.생년월일 | 15.등록일");
		int num = 0;
		while(true) {
			try {
				num = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
		Member member = new Member();
		switch(num) {
		case 11:
			System.out.print("검색할 이름을 입력하세요: ");
			String memberName = sc.nextLine();
			if(memberName.trim().equals("")) memberName = null;
			member.setMemberName(memberName);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		case 12:
			System.out.print("검색할 연락처를 입력하세요: ");
			String memberPh = null;
			memberPh = sc.nextLine();
			if(memberPh.trim().equals("")) memberPh = null;
			member.setMemberPh1(memberPh);
			member.setMemberPh2(memberPh);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		case 13:
			System.out.print("검색할 회원 번호를 입력하세요: ");
			String memberNum = sc.nextLine();
			member.setMemberNum(memberNum);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		case 14:
			System.out.print("검색할 생년월일을 yyyy-mm-dd 형식으로 입력하세요: ");
			Date  memberBir = null;
			while(true) {
				try {
					memberBir = sdf.parse(sc.nextLine());
					break;
				}catch(ParseException e) {
					System.out.println("형식에 일치 하지 않습니다.");
				}
			}
			member.setMemberBir(memberBir);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		case 15:
			System.out.print("검색할 등록일을 yyyy-mm-dd 형식으로 입력하세요: ");
			String regeDate = null;
			regeDate = sc.nextLine();
			if(regeDate.trim().equals("")) regeDate = null;
			member.setRegeDate(regeDate);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		default:
			return; // 번호가 틀리면 함수를 종료한다.
		}
	}
	
	public static Member setMember()  {
		System.out.println("회원 이름을 작성하세요.");
		String memberName = null;
		do {
			memberName = sc.nextLine();
		if(memberName.trim().equals(""))
			System.out.println("회원 이름을 다시 작성하세요");
		}while(memberName.trim().equals(""));	
		
		System.out.println("회원 생년월일을 yyyy-mm-dd 형태로 작성하세요.");
		Date memberBir = null;
		while(true) {
			try {
				memberBir = sdf.parse(sc.nextLine());
				break;
			}catch(java.text.ParseException e) {
				System.out.println("날짜형식이 잘 못 되었습니다.");
			}
		}
		System.out.println("회원 성별을 작성하시오.");
		Integer gender = null;
		while(true) {
			try {
				gender = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException | NullPointerException e) {
				System.out.println("정수값을 입력하세요.");
			}
		}
		System.out.println("회원 연락처 1을 작성하시오.(필수)");
		String memberPh1  = null;
		while(true) {
			memberPh1 = sc.nextLine();
			if(memberPh1.trim().equals("")) 
				System.out.println("회원 연락처 1을 작성하시오...");
			else break;
		}
		System.out.println("회원 연락처 2를 작성하시오.");
		String memberPh2 = sc.nextLine();
		if (memberPh2.trim().equals("")) memberPh2 = null;
		
		System.out.println("회원 이메일을 작성하시오.");
		String regExp = "\\w+@\\w+\\.\\w(\\.\\w+)?";
		boolean result = false;
		String email = null; 
		while(true) {
			email = sc.nextLine();
			result =  Pattern.matches(regExp, email);
			if(!result) System.out.println("형식에 맞지 않습니다.");
			else break;
		}
		System.out.println("회원 주소를 작성하시오.");
		String addr = sc.nextLine();
		return new Member(memberName, memberBir, memberPh1, memberPh2, 
				email, addr, gender, sdf.format(new Date()));
	}
	
	public static void listMember() {
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {
				System.out.print("번호: " + members[i].getMemberNum() + "\t");
				System.out.print("이름: " + members[i].getMemberName() + "\t");
				System.out.print("생년월일: " + members[i].getMemberBir() + "\n");
				System.out.print("등록일: " + members[i].getRegeDate() + "\n");
				System.out.print("연락처1: " + members[i].getMemberPh1() + "\n");
			} else break;
		}
	}
	
	public static Member viewMember() {
		System.out.print("보시려는 회원 번호를 입력하세요: ");
		String memberNum = sc.nextLine();
		Member member = new Member();
		member.setMemberNum(memberNum);
		return member;
	}
	
	public static void print(Member member) {
		if (member != null) {
			System.out.println("번호: " + member.getMemberNum());
			System.out.println("이름: " + member.getMemberName());
			System.out.println("성별: " + member.getGender());
			System.out.println("이메일: " + member.getEmail());
			System.out.println("연락처1: " + member.getMemberPh1());
			System.out.println("연락처2: " + member.getMemberPh2());
			System.out.println("등록일: " + member.getRegeDate());
			//System.out.println("생년월일: " + member.getMemberBir());
			String memberBir = sdf.format(member.getMemberBir());
			System.out.println("생년월일: " + memberBir);
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
}
