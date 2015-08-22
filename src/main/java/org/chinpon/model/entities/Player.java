package org.chinpon.model.entities;

import java.util.List;

import org.chinpon.logic.ia.IA;
import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.logic.state.PlayerState;

public abstract class Player {
	private String idPlayer;
	private String name;
	private Character character;
	private GameBoard gameBoard;
	private IA ia;
	private PlayerState playerState;
	private List<PlayerAction> playerActions; 
	
	public Player() {
		this.setPlayerState(PlayerState.CREATED);
		this.setPlayerState(PlayerState.SETUP);
	}
	
	public abstract List<PlayerAction> getPlayerActions();
	
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public String getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(String idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IA getIa() {
		return ia;
	}
	public void setIa(IA ia) {
		this.ia = ia;
	}

	public PlayerState getPlayerState() {
		return playerState;
	}

	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
}
