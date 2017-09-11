package com.musala.project.chessgame;

import com.musala.project.chessgame.board.Board;
import com.musala.project.chessgame.board.Position;
import com.musala.project.chessgame.figures.Color;

public class Game {

	private Board board = Board.getInstance();
	private Color currentPlayerColor;
	private PlayerState currentPlayerState;

	public Game() {
		startNewGame();
	}

	public void startNewGame() {
		currentPlayerColor = Color.WHITE;
		currentPlayerState = PlayerState.IDLE;
		board.placeFiguresForNewGame();
	}

	public void clickPosition(int x, int y) {
		if (currentPlayerState == PlayerState.IDLE) {
			if (board.selectFigure(new Position(x, y), currentPlayerColor)) {
				// Figure successfully selected.
				currentPlayerState = PlayerState.FIGURE_SELECTED;
			}
			return;
		}

		if (currentPlayerState == PlayerState.FIGURE_SELECTED) {
			Position clickedPosition = new Position(x, y);
			Position selectedFigurePosition = board.getSelectedFigurePosition();

			if (selectedFigurePosition == null) {
				// Should not happen ever!!!
				return;
			}

			if (selectedFigurePosition.equals(clickedPosition)) {
				// Already selected figure is clicked again
				if (board.deselectFigure()) {
					currentPlayerState = PlayerState.IDLE;
				}
				return;
			} else {
				if (board.moveFigureToPosition(clickedPosition)) {
					currentPlayerState = PlayerState.MOVE_COMPLETE;
					switchUser();
				}
				return;
			}
		}
	}

	private void switchUser() {
		if (currentPlayerState != PlayerState.MOVE_COMPLETE) {
			System.out.println("Cannot switch user. Move must be finished.");
			return;
		}

		// Switch color
		currentPlayerColor = currentPlayerColor == Color.WHITE ? Color.BLACK : Color.WHITE;
		System.out.println("Now player with " + currentPlayerColor + " must move.");
		currentPlayerState = PlayerState.IDLE;
	}

}
