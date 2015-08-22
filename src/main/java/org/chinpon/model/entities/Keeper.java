package org.chinpon.model.entities;

import org.chinpon.logic.ia.IA;
import org.chinpon.logic.ia.KeeperMind;
import org.chinpon.logic.ia.IPlayer;

public class Keeper extends Character implements IPlayer {
	private Integer idKeeper;
	private KeeperMind keeperMind;
	
	public Keeper() {
		
	}
	
	public Keeper(KeeperMind keeperMind) {
		this.keeperMind = keeperMind;
	}

	public Integer getIdKeeper() {
		return idKeeper;
	}

	public void setIdKeeper(Integer idKeeper) {
		this.idKeeper = idKeeper;
	}
	
	public void setIA(KeeperMind keeperMind) {
		this.keeperMind = keeperMind;
	}

	public IA getIA() {
		// TODO Auto-generated method stub
		return keeperMind;
	}
}
