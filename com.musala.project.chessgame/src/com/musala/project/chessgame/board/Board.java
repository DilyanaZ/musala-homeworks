package com.musala.project.chessgame.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.musala.project.chessgame.figures.Bishop;
import com.musala.project.chessgame.figures.Color;
import com.musala.project.chessgame.figures.Figure;
import com.musala.project.chessgame.figures.King;
import com.musala.project.chessgame.figures.Knight;
import com.musala.project.chessgame.figures.Pawn;
import com.musala.project.chessgame.figures.Queen;
import com.musala.project.chessgame.figures.Rook;

//Singleton pattern

public class Board {

	private static Board instance;
	private Map<Position, Figure> figuresOnBoard = new HashMap<>();
	private Figure selectedFigure;
	private boolean gameOver = false;

	private Board() {

	}

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}

	public Map<Position, Figure> getFiguresOnBoard() {
		return Collections.unmodifiableMap(figuresOnBoard);
	}

	// Select a figure to be moved. Return true if operation is successful. Return
	// false otherwise
	public boolean selectFigure(Position position, Color color) {
		if (gameOver) {
			System.out.println("Cannot select figure. Start a new game");
			return false;
		}

		if (selectedFigure != null) {
			System.out.println("You have already selected a figure, please deseletc it first");
			return false;
		}

		Figure figure = figuresOnBoard.get(position);
		if (figure == null) {
			System.out.println("There is no figure on the selected position");
			return false;
		}

		if (figure.getColor() != color) {
			System.out.println("Can not move figure of this color");
			return false;
		}

		selectedFigure = figure;
		System.out.println("You have selected: " + figure);
		return true;
	}

	public Position getSelectedFigurePosition() {
		if (selectedFigure == null) {
			return null;
		}

		return selectedFigure.getCurrentPosition();
	}

	// Deselect figure. New figure has to be selected afterwards
	public boolean deselectFigure() {
		if (gameOver) {
			System.out.println("Cannot deselect figure. Start a new game");
			return false;
		}
		selectedFigure = null;
		return true;
	}

	public boolean moveFigureToPosition(Position newPosition) {
		if (gameOver) {
			System.out.println("Cannot move figure. Start a new game");
			return false;
		}

		// Check if there is a selected figure
		if (selectedFigure == null) {
			System.out.println("You have to select a figure first.");
			return false;
		}

		// Check if the selected figure is able to move to the selected position
		if (!selectedFigure.isPositionPossible(newPosition)) {
			System.out.println("Cannot move to the selected position.");
			return false;
		}

		Figure figureOnNewPosition = figuresOnBoard.get(newPosition);

		if (figureOnNewPosition != null) {
			// There is a figure on the selected position.
			// Check it.
			if (figureOnNewPosition.getColor() == selectedFigure.getColor()) {
				System.out.println("Cannot take a figure of the same color.");
				return false;
			}

			System.out.println("You will take figure " + figureOnNewPosition);
			moveFigure(newPosition);

			if (figureOnNewPosition instanceof King) {
				// Opponents king has being taken
				// Game over.
				System.out.println("Game Over.");
				gameOver = true;
			}
			return true;
		}

		// New position is empty. Just move.
		moveFigure(newPosition);
		return true;
	}

	private void moveFigure(Position newPosition) {
		// Remove selected figure from its position
		figuresOnBoard.remove(selectedFigure.getCurrentPosition());

		// Put selected figure on its new position
		figuresOnBoard.put(newPosition, selectedFigure);

		System.out.println("Figure " + selectedFigure + " is moved to " + newPosition);
		selectedFigure = null;
	}

	public void placeFiguresForNewGame() {
		figuresOnBoard.clear();
		selectedFigure = null;

		// Put white figures on board
		Rook whiteRook1 = new Rook(new Position(0, 0), Color.WHITE);
		figuresOnBoard.put(whiteRook1.getCurrentPosition(), whiteRook1);

		Knight whiteKnight1 = new Knight(new Position(1, 0), Color.WHITE);
		figuresOnBoard.put(whiteKnight1.getCurrentPosition(), whiteKnight1);

		Bishop whiteBishop1 = new Bishop(new Position(2, 0), Color.WHITE);
		figuresOnBoard.put(whiteBishop1.getCurrentPosition(), whiteBishop1);

		Queen whiteQueen = new Queen(new Position(3, 0), Color.WHITE);
		figuresOnBoard.put(whiteQueen.getCurrentPosition(), whiteQueen);

		King whiteKing = new King(new Position(4, 0), Color.WHITE);
		figuresOnBoard.put(whiteKing.getCurrentPosition(), whiteKing);

		Bishop whiteBishop2 = new Bishop(new Position(5, 0), Color.WHITE);
		figuresOnBoard.put(whiteBishop2.getCurrentPosition(), whiteBishop2);

		Knight whiteKnight2 = new Knight(new Position(6, 0), Color.WHITE);
		figuresOnBoard.put(whiteKnight2.getCurrentPosition(), whiteKnight2);

		Rook whiteRook2 = new Rook(new Position(7, 0), Color.WHITE);
		figuresOnBoard.put(whiteRook2.getCurrentPosition(), whiteRook2);

		for (int i = 0; i <= 7; i++) {
			Pawn whitePawn = new Pawn(new Position(i, 1), Color.WHITE);
			figuresOnBoard.put(whitePawn.getCurrentPosition(), whitePawn);
		}

		// Put black figures on board
		Rook blackRook1 = new Rook(new Position(0, 7), Color.BLACK);
		figuresOnBoard.put(blackRook1.getCurrentPosition(), blackRook1);

		Knight blackKnight1 = new Knight(new Position(1, 7), Color.BLACK);
		figuresOnBoard.put(blackKnight1.getCurrentPosition(), blackKnight1);

		Bishop blackBishop1 = new Bishop(new Position(2, 7), Color.BLACK);
		figuresOnBoard.put(blackBishop1.getCurrentPosition(), blackBishop1);

		Queen blackQueen = new Queen(new Position(3, 7), Color.BLACK);
		figuresOnBoard.put(blackQueen.getCurrentPosition(), blackQueen);

		King blackKing = new King(new Position(4, 7), Color.BLACK);
		figuresOnBoard.put(blackKing.getCurrentPosition(), blackKing);

		Bishop blackBishop2 = new Bishop(new Position(5, 7), Color.BLACK);
		figuresOnBoard.put(blackBishop2.getCurrentPosition(), blackBishop2);

		Knight blackKnight2 = new Knight(new Position(6, 7), Color.BLACK);
		figuresOnBoard.put(blackKnight2.getCurrentPosition(), blackKnight2);

		Rook blackRook2 = new Rook(new Position(7, 7), Color.BLACK);
		figuresOnBoard.put(blackRook2.getCurrentPosition(), blackRook2);

		for (int i = 0; i <= 7; i++) {
			Pawn blackPawn = new Pawn(new Position(i, 6), Color.BLACK);
			figuresOnBoard.put(blackPawn.getCurrentPosition(), blackPawn);
		}
	}
}
