package testSpringBoot.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileName {
	String originalfileName;
	String storeFileName;
	String fileSize;
}
