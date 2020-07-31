package testSpringBoot.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryBoardCommand {
	@NotEmpty(message = "이름을 입력해주세요!")
	String boardName;
	@NotEmpty(message = "비밀번호를 입력해주세요!")
	String boardPass;
	@NotEmpty(message = "제목을 입력해주세요!")
	String boardSubject;
	String boardContent;
	MultipartFile [] report;
}
