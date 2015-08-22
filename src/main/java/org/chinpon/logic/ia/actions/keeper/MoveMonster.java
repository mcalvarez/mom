package org.chinpon.logic.ia.actions.keeper;

import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.model.entities.Character;
import org.chinpon.model.entities.Room;

public class MoveMonster extends PlayerAction {
	private Character character;
	private Room room;
	
	public MoveMonster(Character character, Room room) {
		this.character = character;
		this.room = room;
	}
	
	public void execute() {
		this.getGameBoard().move(character, room);
	}
}
