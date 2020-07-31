package testSpringBoot.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import testSpringBoot.domain.MemberDTO;
@Component
@Repository
public interface LoginMapper {
	public  MemberDTO   getSelectUser(MemberDTO member)throws Exception;
}
