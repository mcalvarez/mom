package org.chinpon.logic.ia;

import org.chinpon.model.entities.Character;
import org.chinpon.model.entities.Hero;
import org.chinpon.model.entities.Player;

public class PlayerFactory {
	public static Player getInstance(PlayerType playerType) {
		Player player = null;
		switch (playerType) {
		case SOR:
			player = new Hero();
			// TODO add special Cards
			// TODO use IA
			
			//HeroMind heroMind = new HeroMind();
			//player.setIa(heroMind);
			Character c = new Character();
			c.setPlayer(player);
			player.setCharacter(c);
		case GUNMAN:
			break;
		case KEEPER:
			break;
		default:
			break;
		}
		System.out.println("test");
		return player;
	}
}
