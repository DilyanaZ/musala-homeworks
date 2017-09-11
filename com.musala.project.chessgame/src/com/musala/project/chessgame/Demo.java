package com.musala.project.chessgame;

public class Demo {

	public static void main(String[] args) {
		Game game = new Game();
		game.startNewGame();

		//select white figure
		game.clickPosition(0, 1);
		//move it
		game.clickPosition(0, 2);

		//Select another white figure.
		//cannot select white figure. This will result in sysout
		game.clickPosition(1, 1);
		
		//Select black Knight
		game.clickPosition(1, 7);
		//move it
		game.clickPosition(2, 5);
		
		//click empty field
		game.clickPosition(5, 2);
		

	}
}
