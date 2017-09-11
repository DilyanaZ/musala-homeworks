package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Board;
import com.musala.project.chessgame.board.Position;

public class Pawn extends AbstractFigure {

	private boolean moved = false;

	public Pawn(Position initalPosition, Color color) {
		super(initalPosition, color);
	}

	@Override
	public void changeCurrentPosition(Position position) {
		moved = true;
		super.changeCurrentPosition(position);
	}

	@Override
	public boolean isPositionPossible(Position position) {

		Board board = Board.getInstance();

		if ((getColor() == Color.WHITE && position.getY() < currentPosition.getY())
				|| (getColor() == Color.BLACK && position.getY() > currentPosition.getY())) {
			// Cannot move backwards.
			return false;
		}

		if (position.getX() == currentPosition.getX()) {
			// Move straight

			int moveBy = Math.abs(position.getY() - currentPosition.getY());

			if (moved) {
				if (moveBy != 1) {
					return false;
				}
			} else {
				if (moveBy != 1 && moveBy != 2) {
					return false;
				}

				if (moveBy == 2) {
					if (currentPosition.getY() < position.getY()) {
						if (board.getFiguresOnBoard()
								.get(new Position(currentPosition.getX(), currentPosition.getY() + 1)) != null) {
							// cannot move over other figure;
							return false;
						}
					} else {
						if (board.getFiguresOnBoard()
								.get(new Position(currentPosition.getX(), currentPosition.getY() - 1)) != null) {
							// cannot move over other figure;
							return false;
						}
					}
				}
			}

			if (board.getFiguresOnBoard().get(position) != null) {
				// cannot move over other figure;
				return false;
			}

			return true;
		} else {
			// move diagonal

			int moveByY = Math.abs(position.getY() - currentPosition.getY());
			int moveByX = Math.abs(position.getX() - currentPosition.getX());

			if (moveByY != 1 || moveByX != 1) {
				return false;
			}

			return true;
		}

	}

}
