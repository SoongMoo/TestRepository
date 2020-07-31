package testSpringBoot.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Alias("reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
	private Long commentNo;
	private String cuserId;
	private Long replyNo;
	private String ruserId;
	
	private String replyContent;
	private Timestamp regDate;
}
