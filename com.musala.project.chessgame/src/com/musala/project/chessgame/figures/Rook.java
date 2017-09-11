package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Board;
import com.musala.project.chessgame.board.Position;

public class Rook extends AbstractFigure {

	public Rook(Position initalPosition, Color color) {
		super(initalPosition, color);
	}

	@Override
	public boolean isPositionPossible(Position position) {

		Board board = Board.getInstance();

		if (currentPosition.getX() != position.getX() && currentPosition.getY() != position.getY()) {
			// Illegal move for Rook figure. Neither X nor Y are the same;
			return false;
		} else if (currentPosition.getY() == position.getY()) {
			//Same Y, so move along X.
			return checkMoveX(board, position);
		} else {
			//Same X, so move along Y.
			return checkMoveY(board, position);
		}

	}

}
