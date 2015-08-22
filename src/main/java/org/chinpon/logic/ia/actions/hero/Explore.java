package org.chinpon.logic.ia.actions.hero;

import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.model.entities.Card;
import org.chinpon.model.entities.Character;
import org.chinpon.model.entities.Room;

public class Explore extends PlayerAction {
	private Character character;
	private Room room;
	
	public Explore(Character character, Room room) {
		this.character = character;
		this.room = room;
	}
	
	public void execute() {
		for (Card card:room.getCards()) {
			System.out.println("descartar carta: " + card.getName());
		}
		room.setClosed(false);
		PlayerAction action = new Move(character, room);
		action.setGameBoard(this.getGameBoard());
		action.execute();
	}
}
