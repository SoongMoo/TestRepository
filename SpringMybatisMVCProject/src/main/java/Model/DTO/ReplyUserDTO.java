package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReplyUserDTO  implements Serializable{
	ReplyDTO replyDTO;  // 1
	MemberDTO memberDTO; // 1
	public ReplyDTO getReplyDTO() {
		return replyDTO;
	}
	public void setReplyDTO(ReplyDTO replyDTO) {
		this.replyDTO = replyDTO;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
}
