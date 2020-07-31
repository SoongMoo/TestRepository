package testSpringBoot.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Alias("replyUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyUserDTO {
	ReplyDTO replyDTO;  // 1
	MemberDTO memberDTO; // 1
}
