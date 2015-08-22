package org.chinpon.logic.ia.actions.hero;

import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.model.entities.Character;
import org.chinpon.model.entities.Room;

public class Move extends PlayerAction {
	private Character character;
	private Room room;
	
	public Move(Character character, Room room) {
		this.character = character;
		this.room = room;
	}
	
	public void execute() {
		this.getGameBoard().move(character, room);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Move action --> ");
		sb.append(room.getName());
		return sb.toString();
	}
}
