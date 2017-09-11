package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Position;

public class King extends AbstractFigure {

	public King(Position initalPosition, Color color) {
		super(initalPosition, color);
	}

	@Override
	public boolean isPositionPossible(Position position) {

		int moveByY = Math.abs(position.getY() - currentPosition.getY());
		int moveByX = Math.abs(position.getX() - currentPosition.getX());

		if (moveByY != 1 || moveByX != 1) {
			return false;
		}

		return false;
	}

}
