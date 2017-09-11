package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Position;

public class Knight extends AbstractFigure {

	public Knight(Position initalPosition, Color color) {
		super(initalPosition, color);
	}

	@Override
	public boolean isPositionPossible(Position position) {

		boolean moveRight = (position.getX() == currentPosition.getX() + 2
				&& (position.getY() == currentPosition.getY() + 1 || position.getY() == currentPosition.getY() - 1));
		boolean moveLeft = (position.getX() == currentPosition.getX() - 2
				&& (position.getY() == currentPosition.getY() + 1 || position.getY() == currentPosition.getY() - 1));
		boolean moveUp = (position.getY() == currentPosition.getY() + 2
				&& (position.getX() == currentPosition.getX() + 1 || position.getX() == currentPosition.getX() - 1));
		boolean moveDown = (position.getY() == currentPosition.getY() - 2	
				&& (position.getX() == currentPosition.getX() + 1 || position.getX() == currentPosition.getX() - 1));
		
		if (!(moveRight || moveLeft || moveUp || moveDown)) {
			// Illegal move for Knight figure. Neither X nor Y are the same;
			return false;
		}

		return true;
	}

}
