package org.chinpon.model.dao;

import org.chinpon.model.entities.GameBoard;

public interface GameBoardDAO {
	void save(GameBoard gameBoard);
	void update(GameBoard gameBoard);
	GameBoard get(int id);
	boolean delete(int id);
}
