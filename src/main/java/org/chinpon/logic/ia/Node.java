package org.chinpon.logic.ia;

import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.History;

public class Node {
	private History history;
	private GameBoard gameBoard;
	private NodeAction previous;
	private NodeAction next;
	
	public Node(History history, GameBoard gameBoard) {
		this.history = history;
		this.gameBoard = gameBoard;
	}
	
	public History getHistory() {
		return history;
	}
	public void setHistory(History history) {
		this.history = history;
	}
	public GameBoard getGameBoard() {
		return gameBoard;
	}
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public NodeAction getPrevious() {
		return previous;
	}

	public void setPrevious(NodeAction previous) {
		this.previous = previous;
	}

	public NodeAction getNext() {
		return next;
	}

	public void setNext(NodeAction next) {
		this.next = next;
	}
}
