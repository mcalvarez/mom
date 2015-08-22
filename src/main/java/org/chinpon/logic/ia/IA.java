package org.chinpon.logic.ia;

import java.util.List;

import org.chinpon.model.entities.GameBoard;

public interface IA {
	PlayerAction think();
	void setGameBoard(GameBoard gameBoard);
	List<PlayerAction> getActionNodes();
	void setRival(IPlayer player);
	IPlayer getRival();
}
