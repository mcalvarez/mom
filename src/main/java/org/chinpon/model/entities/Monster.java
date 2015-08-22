package org.chinpon.model.entities;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class Monster extends Character {
	MosterType type;
	int awareness;
	int horrorRating;
	SpecialAttack specialAtack;
	
	public Monster() {
		
	}
	
	public Monster(Monster monster) {
		try {
			BeanUtils.copyProperties(this, monster);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

enum MosterType {
	GREEN, RED 
}