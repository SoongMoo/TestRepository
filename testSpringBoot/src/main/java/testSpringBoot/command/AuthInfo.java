package testSpringBoot.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthInfo {
	private String id;
	private String email;
	private String name;
	private String pw;
}
