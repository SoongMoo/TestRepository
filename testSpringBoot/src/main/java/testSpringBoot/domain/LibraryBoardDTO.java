package testSpringBoot.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Alias("libboard")
@AllArgsConstructor
@NoArgsConstructor
public class LibraryBoardDTO {
	Integer boardNum;
	String userId;
	String boardName;
	String boardPass;
	String boardSubject;
	String boardContent;
	Timestamp boardDate;
	String ipAddr;
	Integer readCount;
	String originalFileName;
	String storeFileName;
	String fileSize;
}
