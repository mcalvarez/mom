package org.chinpon.logic;

import org.chinpon.model.entities.Room;
import org.chinpon.model.entities.Weapon;
import org.chinpon.util.Direction;

public interface IMaster {
	void move(Character character, Direction direction);
	void attack(Character giver, Character reciver, Weapon weapon);
	void examine(Character character, Room room);
	void passTurn(Character character);
}
