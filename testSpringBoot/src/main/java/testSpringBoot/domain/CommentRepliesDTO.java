package testSpringBoot.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Alias("commentReplies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRepliesDTO {
	private CommentDTO commentDTO; // 1
	private List<ReplyDTO> replies; // n
}
