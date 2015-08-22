package org.chinpon.logic.ia.actions.keeper;

import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.model.entities.Monster;
import org.chinpon.model.entities.Room;

public class SummonMonster extends PlayerAction {
	private Room room;
	
	public SummonMonster(Room room) {
		this.room = room;
	}
	
	@Override
	public void execute() {
		Monster m = new Monster();
		m.setRoom(room);
		this.getGameBoard().getMonsters().add(m);
	}
	
}
