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
	static Member[] members = new Member[10]; //�̰� DB��� �����ϰ� �ڵ���
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		boolean stop = false;
		while(!stop) {
			System.out.println("1.ȸ�� ��� | 2.ȸ�� ����Ʈ | 3.ȸ�� �˻� | "
					+ "4.ȸ������ ���� | 5.����");
			int selectNum = 0;
			while(true) {
				try {
					selectNum = Integer.parseInt(sc.nextLine());
					break;
				}catch(NumberFormatException e) {
					System.out.println("���ڸ� �Է��ϼ���.");
				}
			}
			switch (selectNum) {
			case 1:
				Member member = setMember(); // �Է��� ��
				mc.doProcess(selectNum, members, member); // DB�� �Է��� ���� �ѱ�
				break;
			case 2: // �Խ����� �� Ŭ������ �̿��ؼ� ���������Ƿ� ��� ���⵵ �� Ŭ�������� ó��
				listMember();
				break;
			case 3:
				searchMember();
				break;
			case 4: // ���� BoarderExample.class�� �ִ� �Լ��� ���� ���� �ɰ��� �Ϻθ� �� Ŭ������ ��.
				Member member1 = viewMember(); // case 1�� �̹� member�� �����Ƿ� �ٸ� �̸� ���
                                            // �ٸ� ���:
				                            // switch�� �ۿ� member�� �����ؼ� case 1, 4���� ��Ȱ��
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
		// ����, ����, �۾���, ��¥, ����+����
		
		System.out.println("11.�̸� | 12.����ó | 13.ȸ�� ��ȣ | 14.������� | 15.�����");
		int num = 0;
		while(true) {
			try {
				num = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���.");
			}
		}
		Member member = new Member();
		switch(num) {
		case 11:
			System.out.print("�˻��� �̸��� �Է��ϼ���: ");
			String memberName = sc.nextLine();
			if(memberName.trim().equals("")) memberName = null;
			member.setMemberName(memberName);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		case 12:
			System.out.print("�˻��� ����ó�� �Է��ϼ���: ");
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
			System.out.print("�˻��� ȸ�� ��ȣ�� �Է��ϼ���: ");
			String memberNum = sc.nextLine();
			member.setMemberNum(memberNum);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		case 14:
			System.out.print("�˻��� ��������� yyyy-mm-dd �������� �Է��ϼ���: ");
			Date  memberBir = null;
			while(true) {
				try {
					memberBir = sdf.parse(sc.nextLine());
					break;
				}catch(ParseException e) {
					System.out.println("���Ŀ� ��ġ ���� �ʽ��ϴ�.");
				}
			}
			member.setMemberBir(memberBir);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		case 15:
			System.out.print("�˻��� ������� yyyy-mm-dd �������� �Է��ϼ���: ");
			String regeDate = null;
			regeDate = sc.nextLine();
			if(regeDate.trim().equals("")) regeDate = null;
			member.setRegeDate(regeDate);
			mc.doProcess(num, members, member);
			member = mc.getMember();
			print(member);
			break;
		default:
			return; // ��ȣ�� Ʋ���� �Լ��� �����Ѵ�.
		}
	}
	
	public static Member setMember()  {
		System.out.println("ȸ�� �̸��� �ۼ��ϼ���.");
		String memberName = null;
		do {
			memberName = sc.nextLine();
		if(memberName.trim().equals(""))
			System.out.println("ȸ�� �̸��� �ٽ� �ۼ��ϼ���");
		}while(memberName.trim().equals(""));	
		
		System.out.println("ȸ�� ��������� yyyy-mm-dd ���·� �ۼ��ϼ���.");
		Date memberBir = null;
		while(true) {
			try {
				memberBir = sdf.parse(sc.nextLine());
				break;
			}catch(java.text.ParseException e) {
				System.out.println("��¥������ �� �� �Ǿ����ϴ�.");
			}
		}
		System.out.println("ȸ�� ������ �ۼ��Ͻÿ�.");
		Integer gender = null;
		while(true) {
			try {
				gender = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException | NullPointerException e) {
				System.out.println("�������� �Է��ϼ���.");
			}
		}
		System.out.println("ȸ�� ����ó 1�� �ۼ��Ͻÿ�.(�ʼ�)");
		String memberPh1  = null;
		while(true) {
			memberPh1 = sc.nextLine();
			if(memberPh1.trim().equals("")) 
				System.out.println("ȸ�� ����ó 1�� �ۼ��Ͻÿ�...");
			else break;
		}
		System.out.println("ȸ�� ����ó 2�� �ۼ��Ͻÿ�.");
		String memberPh2 = sc.nextLine();
		if (memberPh2.trim().equals("")) memberPh2 = null;
		
		System.out.println("ȸ�� �̸����� �ۼ��Ͻÿ�.");
		String regExp = "\\w+@\\w+\\.\\w(\\.\\w+)?";
		boolean result = false;
		String email = null; 
		while(true) {
			email = sc.nextLine();
			result =  Pattern.matches(regExp, email);
			if(!result) System.out.println("���Ŀ� ���� �ʽ��ϴ�.");
			else break;
		}
		System.out.println("ȸ�� �ּҸ� �ۼ��Ͻÿ�.");
		String addr = sc.nextLine();
		return new Member(memberName, memberBir, memberPh1, memberPh2, 
				email, addr, gender, sdf.format(new Date()));
	}
	
	public static void listMember() {
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {
				System.out.print("��ȣ: " + members[i].getMemberNum() + "\t");
				System.out.print("�̸�: " + members[i].getMemberName() + "\t");
				System.out.print("�������: " + members[i].getMemberBir() + "\n");
				System.out.print("�����: " + members[i].getRegeDate() + "\n");
				System.out.print("����ó1: " + members[i].getMemberPh1() + "\n");
			} else break;
		}
	}
	
	public static Member viewMember() {
		System.out.print("���÷��� ȸ�� ��ȣ�� �Է��ϼ���: ");
		String memberNum = sc.nextLine();
		Member member = new Member();
		member.setMemberNum(memberNum);
		return member;
	}
	
	public static void print(Member member) {
		if (member != null) {
			System.out.println("��ȣ: " + member.getMemberNum());
			System.out.println("�̸�: " + member.getMemberName());
			System.out.println("����: " + member.getGender());
			System.out.println("�̸���: " + member.getEmail());
			System.out.println("����ó1: " + member.getMemberPh1());
			System.out.println("����ó2: " + member.getMemberPh2());
			System.out.println("�����: " + member.getRegeDate());
			//System.out.println("�������: " + member.getMemberBir());
			String memberBir = sdf.format(member.getMemberBir());
			System.out.println("�������: " + memberBir);
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}
}
