package org.chinpon.logic.ia;

public class NodeAction {
	PlayerAction action;
	Node node;

	public NodeAction(PlayerAction action, Node node) {
		this.action = action;
		this.node = node;
	}

	public PlayerAction getAction() {
		return action;
	}

	public void setAction(PlayerAction action) {
		this.action = action;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	
}
