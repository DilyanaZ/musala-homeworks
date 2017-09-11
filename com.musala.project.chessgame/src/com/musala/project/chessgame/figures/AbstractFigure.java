package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Board;
import com.musala.project.chessgame.board.Position;

public abstract class AbstractFigure implements Figure {

	protected Position currentPosition;
	private final Color color;

	public AbstractFigure(Position initalPosition, Color color) {
		currentPosition = initalPosition;
		this.color = color;
	}

	public void changeCurrentPosition(Position position) {
		currentPosition = position;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public Color getColor() {
		return this.color;
	}

	protected boolean checkMoveX(Board board, Position position) {
		for (Position figPosition : board.getFiguresOnBoard().keySet()) {
			if (figPosition.getY() == currentPosition.getY()) {
				// on the same Y level. Could be an obstacle.
				if (figPosition.getX() > currentPosition.getX() && figPosition.getX() < position.getX()
						|| figPosition.getX() < currentPosition.getX() && figPosition.getX() > position.getX()) {
					return false;
				}
			}
		}
		return true;
	}

	protected boolean checkMoveY(Board board, Position position) {
		for (Position figPosition : board.getFiguresOnBoard().keySet()) {
			if (figPosition.getX() == currentPosition.getX()) {
				// on the same X level. Could be an obstacle.
				if (figPosition.getY() > currentPosition.getY() && figPosition.getY() < position.getY()
						|| figPosition.getY() < currentPosition.getY() && figPosition.getY() > position.getY()) {
					// There is a figure on board between the selected one and the chosen position.
					return false;
				}
			}
		}
		return true;
	}

	protected boolean checkMoveRightDiagonal(Board board, Position position) {
		// Move along right diagonal.
		for (Position figPosition : board.getFiguresOnBoard().keySet()) {
			if (figPosition.getX() - figPosition.getY() == currentPosition.getX() - currentPosition.getY()) {
				// on the same diagonal. Could be an obstacle.
				if (figPosition.getX() > currentPosition.getX() && figPosition.getX() < position.getX()
						|| figPosition.getX() < currentPosition.getX() && figPosition.getX() > position.getX()) {
					// There is a figure on board between the selected one and the chosen position.
					return false;
				}
			}
		}
		return true;
	}

	protected boolean checkMoveLeftDiagonal(Board board, Position position) {
		for (Position figPosition : board.getFiguresOnBoard().keySet()) {
			if (figPosition.getX() + figPosition.getY() == currentPosition.getX() + currentPosition.getY()) {
				// on the same diagonal. Could be an obstacle.
				if (figPosition.getX() < currentPosition.getX() && figPosition.getX() > position.getX()
						|| figPosition.getX() > currentPosition.getX() && figPosition.getX() < position.getX()) {
					// There is a figure on board between the selected one and the chosen position.
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " on position " + getCurrentPosition() + ", of color " + color;
	}
}
