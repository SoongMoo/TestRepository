package testSpringBoot.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Alias("reNewPw")
@AllArgsConstructor
@NoArgsConstructor
public class UserPwChangeDTO {
	String userId;
	String userPw;
	String newUserPw;
}
