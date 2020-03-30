package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.FileDTO;

public class FileDbUpload {
	public void boarderExecute(Object obj) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(
				"��� ���� �� ������ ���� ��θ� �����ּ���.");
		Scanner sc = new Scanner(System.in);
		String path =  sc.nextLine();
		List<FileDTO> list = (List<FileDTO>) obj;
		try {
			BufferedReader br = 
					new BufferedReader(
							new FileReader(path));
			String msg = null;
			while((msg = br.readLine()) != null ) {
				String [] str = msg.split(",|-|`");
				FileDTO fd = new FileDTO(
						str[0],str[1],str[2],str[3],
						str[4],str[5]);
				list.add(fd);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}