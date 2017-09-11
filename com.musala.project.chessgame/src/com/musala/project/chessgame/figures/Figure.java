package com.musala.project.chessgame.figures;

import com.musala.project.chessgame.board.Position;

public interface Figure {

	public boolean isPositionPossible(Position position);
	
	public Position getCurrentPosition();
	
	public void changeCurrentPosition(Position position);

	public Color getColor();
}
