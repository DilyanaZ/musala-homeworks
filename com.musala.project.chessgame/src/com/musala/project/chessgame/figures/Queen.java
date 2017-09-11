package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Board;
import com.musala.project.chessgame.board.Position;

public class Queen extends AbstractFigure {

	public Queen(Position initalPosition, Color color) {
		super(initalPosition, color);
	}

	@Override
	public boolean isPositionPossible(Position position) {

		Board board = Board.getInstance();

		int rightDiagonal = currentPosition.getX() - currentPosition.getY();
		int leftDiagonal = currentPosition.getX() + currentPosition.getY();

		if (currentPosition.getX() != position.getX() && currentPosition.getY() != position.getY()
				&& (position.getX() - position.getY()) != rightDiagonal
				&& (position.getX() + position.getY()) != leftDiagonal) {
			// Illegal move for Queen figure. Neither X nor Y are the same;
			return false;
		} else if (currentPosition.getY() == position.getY()) {
			// Same Y, so move along X.
			return checkMoveX(board, position);
		} else if (currentPosition.getX() == position.getX()) {
			// Same X, so move along Y.
			return checkMoveY(board, position);
		} else if ((position.getX() - position.getY()) == rightDiagonal) {
			return checkMoveRightDiagonal(board, position);
		} else {
			return checkMoveLeftDiagonal(board, position);
		}
	}
}
