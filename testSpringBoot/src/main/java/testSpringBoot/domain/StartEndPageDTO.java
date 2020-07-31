package testSpringBoot.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Alias("startEnd")
public class StartEndPageDTO {
	Long startPage;
	Long endPage;
	String userId;
	String num;
}
