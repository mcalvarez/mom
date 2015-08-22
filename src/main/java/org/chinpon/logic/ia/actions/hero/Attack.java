package org.chinpon.logic.ia.actions.hero;

import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.model.entities.Hero;
import org.chinpon.model.entities.Monster;
import org.chinpon.util.Dice;

public class Attack extends PlayerAction {
	private Hero hero;
	private Monster monster;
	public Attack(Hero hero, Monster monster) {
		this.hero = hero;
		this.monster = monster;
	}
	
	@Override
	public void execute() {
		// Throw 
		long i = Dice.getNumber();
		System.out.println("i is " + i);
	}
}
