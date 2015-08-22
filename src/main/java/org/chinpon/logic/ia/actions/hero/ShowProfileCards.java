package org.chinpon.logic.ia.actions.hero;

import java.util.List;

import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.model.entities.Character;
import org.chinpon.model.entities.ProfileCard;

public class ShowProfileCards extends PlayerAction {
	private Character character;
	private List<ProfileCard> profileCards;

	public ShowProfileCards(Character character) {
		this.character = character;
	}

	public void execute() {
		profileCards = this.getGameBoard().getProfileCards().get(this.character.getIdCharacter());
	}

	public List<ProfileCard> getProfileCards() {
		return profileCards;
	}
	
	public String toString() {
		return "ShowProfileCards";
	}
}
