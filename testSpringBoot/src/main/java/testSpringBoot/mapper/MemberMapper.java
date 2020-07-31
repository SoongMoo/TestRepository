package testSpringBoot.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import testSpringBoot.domain.MemberDTO;
import testSpringBoot.domain.StartEndPageDTO;
import testSpringBoot.domain.UserPwChangeDTO;
@Component
@Repository
public interface MemberMapper {
	public Integer insertMember(MemberDTO dto)throws Exception;
	public Integer joinOkUpdate(MemberDTO memberDTO)throws Exception;
	public List<MemberDTO> getMemberList(StartEndPageDTO startEndPageDTO)throws Exception;
	public Integer getMemberCount()throws Exception;
	public Integer memberUpdate(MemberDTO dto)throws Exception;
	public Integer memberDelete(MemberDTO dto)throws Exception;
	public void userPwChange(UserPwChangeDTO dto)throws Exception;
}
