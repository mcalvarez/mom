package org.chinpon.logic;

import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.Room;
import org.chinpon.model.entities.Weapon;
import org.chinpon.util.Direction;

public class Master implements IMaster {
	private GameBoard gameBoard = null;
	
	public Master(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public void move(Character character, Direction direction) {
//		if (gameBoard.testMove()) {
//			gameBoard.move(direction);
//		}
	}

	public void attack(Character giver, Character reciver, Weapon weapon) {
		// TODO Auto-generated method stub
		
	}

	public void examine(Character character, Room room) {
		// TODO Auto-generated method stub
		
	}

	public void passTurn(Character character) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
