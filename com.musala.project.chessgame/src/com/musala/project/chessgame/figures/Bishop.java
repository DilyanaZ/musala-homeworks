package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Board;
import com.musala.project.chessgame.board.Position;

public class Bishop extends AbstractFigure {

	public Bishop(Position initalPosition, Color color) {
		super(initalPosition, color);
	}

	@Override
	public boolean isPositionPossible(Position position) {
		Board board = Board.getInstance();

		int rightDiagonal = currentPosition.getX() - currentPosition.getY();
		int leftDiagonal = currentPosition.getX() + currentPosition.getY();

		if ((position.getX() - position.getY()) != rightDiagonal
				&& (position.getX() + position.getY()) != leftDiagonal) {
			// Illegal move for Bishop figure. Neither X nor Y are the same;
			return false;
		} else if ((position.getX() - position.getY()) == rightDiagonal) {
			return checkMoveRightDiagonal(board, position);
		} else {
			return checkMoveLeftDiagonal(board, position);
		}

	}

}
