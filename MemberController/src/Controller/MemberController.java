package Controller;

import Model.DTO.Member;

public class MemberController {
	Action ac = null;
	Member member = null;
	public void doProcess(int num, Object[] objs, Object obj) {
		if(num == 1) {
			ac = new MemberCreate();
			ac.execute(objs, obj);
		} else if(num == 2) {
			ac = new MemberList();
			ac.execute(objs, obj);
		} else if(num == 3) {
			ac = new SearchMember();
			ac.execute(objs, obj);
		} else if(num == 4) {
			ac = new ViewMember();
			ac.execute(objs, obj);
			ViewMember v = (ViewMember)ac;
			member = v.getMember(); // 밑에 있음
		//System.out.println("11.이름 | 12.연락처 | 13.회원 번호 | 14.생년월일 | 15.등록일");
		} else if (num == 11) {
			ac = new MemberNameSearch();
			ac.execute(objs, obj);
			MemberNameSearch mns = (MemberNameSearch)ac;
			member = mns.getMember();
		} else if (num == 12) {
			ac = new MemberPhSearch();
			ac.execute(objs, obj);
			MemberPhSearch mps = (MemberPhSearch)ac;
			member = mps.getMember();
		} else if (num == 13) {
			ac = new MemberNumSearch();
			ac.execute(objs, obj);
			MemberNumSearch mns = (MemberNumSearch)ac;
			member = mns.getMember();
		} else if (num == 14) {
			ac = new MemberBirSearch();
			ac.execute(objs, obj);
			MemberBirSearch mbs = (MemberBirSearch)ac;
			member = mbs.getMember();
		} else if (num == 15) {
			ac = new RegeDateSearch();
			ac.execute(objs, obj);
			RegeDateSearch ss = (RegeDateSearch)ac;
			member = ss.getMember();
		}
	}
	public Member getMember() { // doProcess(...)의 else if(num==4)에서 사용
		return member;
	}
}
