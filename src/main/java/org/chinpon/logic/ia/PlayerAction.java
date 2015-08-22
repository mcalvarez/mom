package org.chinpon.logic.ia;

import org.chinpon.model.entities.GameBoard;

public abstract class PlayerAction {
	private GameBoard gameBoard = null;
	
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public abstract void execute();
}
