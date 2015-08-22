package org.chinpon.model.entities;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.chinpon.logic.ia.HeroMind;
import org.chinpon.logic.ia.IA;
import org.chinpon.logic.ia.IPlayer;
import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.logic.ia.actions.hero.Explore;
import org.chinpon.logic.ia.actions.hero.Move;
import org.chinpon.logic.ia.actions.hero.ShowProfileCards;

public class Hero extends Player implements IPlayer {
	private Integer idHero;
	private HeroMind heroMind = null;

	public Hero() {

	}

	public Hero(Hero hero) {
		try {
			BeanUtils.copyProperties(this, hero);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hero(HeroMind heroMind) {
		this.heroMind = heroMind;
	}

	public Integer getIdHero() {
		return idHero;
	}

	public void setIdHero(Integer idHero) {
		this.idHero = idHero;
	}

	public void setIA(HeroMind heroMind) {
		this.heroMind = heroMind;
	}

	public IA getIA() {
		// TODO Auto-generated method stub
		return heroMind;
	}

	@Override
	public List<PlayerAction> getPlayerActions() {
		List<PlayerAction> playerActions = new ArrayList<PlayerAction>();
		
		switch (this.getPlayerState()) {
		case CREATED:
			break;
		case DEAD:
			break;
		case PLAYING:
			// Movement step
			for (Room room : getCharacter().getRoom().getContiguous()) {
				if (!room.isClosed())
					playerActions.add(moveStep(this, room));
				else
					playerActions.add(new Explore(this.getCharacter(), room));
			}

			// TODO Action step

			// TODO Drop items

			// TODO Attack a monster

			// TODO Explore
			
			break;
		case SETUP:
			// TODO Get Start Items Cards
			//playerActions.add(new ShowStartItemsCards(this.getCharacter()));
			
			playerActions.add(new ShowProfileCards(this.getCharacter()));
			break;
		case WAITING_TURN:
			break;
		default:
			break;
		
		}
		
		
		return playerActions;
	}
	
	private PlayerAction moveStep(Hero hero, Room room) {
		PlayerAction moveAction = new Move(getCharacter(), room);
		moveAction.setGameBoard(getGameBoard());
		return moveAction;
	}
}
