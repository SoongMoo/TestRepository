package Model.DTO;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
public class CommentRepliesDTO  implements Serializable{
	private CommentDTO commentDTO; // 1
	private List<ReplyDTO> replies; // n
	
	public CommentDTO getCommentDTO() {
		return commentDTO;
	}
	public void setCommentDTO(CommentDTO commentDTO) {
		this.commentDTO = commentDTO;
	}
	public List<ReplyDTO> getReplies() {
		return replies;
	}
	public void setReplies(List<ReplyDTO> replies) {
		this.replies = replies;
	}
}
