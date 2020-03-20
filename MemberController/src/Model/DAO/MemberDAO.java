package Model.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.DTO.Member;

// Data Access Object
// �����͸� �����ϱ� ���� �޼��峪 ������ �ִ� ��
public class MemberDAO {
	// Object�� � Ŭ������ ������� ��ü�� ��� ���� �� �ִ� ���� Ŭ�����̴�
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public void execute(Object obj) {
		
	}
	public void createMember(Object[] objs, Object obj) {
		Member m = (Member)obj;
		Member [] members = (Member[])objs;
		for (int i = 0; i <= members.length; i++) {
			if (members[i] == null) {
				m.setMemberNum("HK-" + Integer.toString(i+1)); // ȸ�� ��ȣ �տ� HK-�� ������
				m.setRegeDate(sdf.format(new Date())); // ��� ��¥�� ���ڿ��� ��ȯ
				members[i] = m;
				break;
			}
		}
	}
	public Member setMember() throws ParseException {
		System.out.println("ȸ�� �̸��� �ۼ��ϼ���.");
		String memberName = sc.nextLine();
		
		System.out.println("ȸ�� ��������� yyyy-mm-dd ���·� �ۼ��ϼ���.");
		Date memberBir = sdf.parse(sc.nextLine());
		
		System.out.println("ȸ�� ������ �ۼ��Ͻÿ�.");
		int gender = Integer.parseInt(sc.nextLine());
		
		System.out.println("ȸ�� ����ó 1�� �ۼ��Ͻÿ�.");
		String memberPh1 = sc.nextLine();
		
		System.out.println("ȸ�� ����ó 2�� �ۼ��Ͻÿ�.");
		String memberPh2 = sc.nextLine();
		if (memberPh2.trim().equals("")) memberPh2 = null;
		
		System.out.println("ȸ�� �̸����� �ۼ��Ͻÿ�.");
		String email = sc.nextLine();
		
		System.out.println("ȸ�� �ּҸ� �ۼ��Ͻÿ�.");
		String addr = sc.nextLine();
		return new Member(memberName, memberBir, memberPh1, memberPh2, 
				email, addr, gender, sdf.format(new Date()));
	}
	public Member viewMember(Object[] objs, Object obj) {
		Member[] members = (Member[])objs;
		Member m = (Member)obj;
		Member member = null;
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) { // NullPointerException ���� ����
				if (members[i].getMemberNum().indexOf(m.getMemberNum()) != -1) {
					member = members[i];
					break;
				}
			} else break; // members[i] == null�̸� ã�� ���� Ż��
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
