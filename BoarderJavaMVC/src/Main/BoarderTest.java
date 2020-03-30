package Main;

import Controller.BoarderController;

public class BoarderTest {
	public static void main(String [] args) {
		BoarderController bc = 
				BoarderController.getInstance();
		bc.execute("main",null);
	}
}
