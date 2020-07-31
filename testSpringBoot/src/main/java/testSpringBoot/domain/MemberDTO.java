package testSpringBoot.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Alias("memdto")
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO  implements Serializable{
	String userId ;
	String userPw  ; 
	String userName;
	Timestamp userBirth;
	String userGender;
	String userAddr;
	String userPh1;
	String userPh2;
	String userEmail;
	Timestamp userRegist;
	String joinOk;
	String INTEREST;
}
