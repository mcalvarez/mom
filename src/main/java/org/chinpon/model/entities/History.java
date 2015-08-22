package org.chinpon.model.entities;

import java.util.LinkedList;
import java.util.List;

public class History {
	private String name;
	private String description;
	private GameBoard gameBoard;
	private List<Objective> objectives;
	
	public History() {
		this.objectives = new LinkedList<Objective>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GameBoard getGameBoard() {
		return gameBoard;
	}
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	public List<Objective> getObjectives() {
		return objectives;
	}
	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}
}
