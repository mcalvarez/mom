package org.chinpon.logic.ia;

import java.util.LinkedList;
import java.util.List;

import org.chinpon.logic.ia.actions.hero.Explore;
import org.chinpon.logic.ia.actions.hero.Move;
import org.chinpon.model.entities.Character;
import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.Hero;
import org.chinpon.model.entities.History;
import org.chinpon.model.entities.Room;

public class HeroMind extends AlphaBeta implements IA {
	private History history;
	private GameBoard gameBoard;
	private Hero hero;
	private int ALPHA_INI = Integer.MIN_VALUE;
	private int BETA_INI = Integer.MAX_VALUE;
	private int DEPTH_INI = 3;
	private IPlayer rival;
	
	public HeroMind() {
		
	}
	
	public HeroMind(History history, GameBoard gameBoard, Hero hero) {
		this.history = history;
		this.gameBoard = gameBoard;
		this.hero = hero;
	}
	
	public PlayerAction think() {
		Node currentNode = new Node(history, gameBoard);
		
		alphaBeta(currentNode, DEPTH_INI, ALPHA_INI, BETA_INI, hero);
		
		return currentNode.getNext().getAction();
	}

	public List<PlayerAction> getActionNodes() {
		List<PlayerAction> children = new LinkedList<PlayerAction>(); 
		Node currentNode = new Node(history, gameBoard);
		
		
		
		return children;
	}
	
	private PlayerAction moveStep(Node node, Hero hero, Room room) {
		/*PlayerAction moveAction = new Move(hero, room);
		moveAction.setGameBoard(gameBoard);
		return moveAction;*/
		return null;
	}
	

	@Override
	public int heuristicScore(Node node) {
		int explored = 0;
		for (Room room:node.getGameBoard().getRooms().values()) {
			if (room.isExplored()) explored++;
		}
		return explored;
	}

	@Override
	public boolean isTerminal(Node node) {
		int explored = 0;
		for (Room room:node.getGameBoard().getRooms().values()) {
			if (room.isExplored()) explored++;
		}
		return explored == node.getGameBoard().getRooms().size();
	}

	@Override
	public IPlayer getMaximizingPlayer() {
		return hero;
	}

	public IPlayer getRival() {
		return rival;
	}

	public void setRival(IPlayer player) {
		this.rival = player;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
}