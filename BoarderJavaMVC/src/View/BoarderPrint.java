package View;

import DTO.BoarderDTO;

public class BoarderPrint {
	public void print(BoarderDTO bd) {
		System.out.println(bd.getId()
				+"\t"+bd.getTitle()+"\t"+bd.getContent());
	}
}
