package org.chinpon.logic.ia;

import java.util.LinkedList;
import java.util.List;

import org.chinpon.logic.ia.actions.keeper.SummonMonster;
import org.chinpon.model.entities.Character;
import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.Hero;
import org.chinpon.model.entities.History;
import org.chinpon.model.entities.Keeper;
import org.chinpon.model.entities.Monster;
import org.chinpon.model.entities.Room;

public class KeeperMind extends AlphaBeta implements IA {
	private History history;
	private GameBoard gameBoard;
	private Keeper keeper;
	private IPlayer rival;
	private int ALPHA_INI = Integer.MIN_VALUE;
	private int BETA_INI = Integer.MAX_VALUE;
	private int DEPTH_INI = 3;
	
	public KeeperMind(History history, GameBoard gameBoard, Keeper keeper) {
		this.history = history;
		this.gameBoard = gameBoard;
		this.setKeeper(keeper);
	}

	public PlayerAction think() {
		Node currentNode = new Node(history, gameBoard);
		
		alphaBeta(currentNode, DEPTH_INI, ALPHA_INI, BETA_INI, keeper);
		
		return currentNode.getNext().getAction();
	}

	public List<PlayerAction> getActionNodes() {
		List<PlayerAction> children = new LinkedList<PlayerAction>(); 
		
		// TODO Movement step
		for (Hero hero:this.gameBoard.getHeroes()) {
			children.add(new SummonMonster(hero.getCharacter().getRoom()));
		}
			
		// TODO Action step
		/*for (Monster monster:this.gameBoard.getHeroes()) {
			children.add(new SummonMonster(monster.getRoom()));
		}*/
		
		// TODO Drop items
		
		// TODO Attack a monster
		
		// TODO Explore
		
		return children;
	}

	public IPlayer getRival() {
		// TODO Auto-generated method stub
		// create a player coalicion of all heroes
		
		//HeroMind hero = new HeroMind();
		
		return rival;
	}

	@Override
	public IPlayer getMaximizingPlayer() {
		return keeper;
	}

	@Override
	public int heuristicScore(Node node) {
		int score = 0;
		for (Monster monster:node.getGameBoard().getMonsters()) {
			score++;
		}
		// TODO Check distance between a monster and a hero
		
		return score;
	}

	@Override
	public boolean isTerminal(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setRival(IPlayer player) {
		this.rival = player;
	}

	public Keeper getKeeper() {
		return keeper;
	}

	public void setKeeper(Keeper keeper) {
		this.keeper = keeper;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	
}
