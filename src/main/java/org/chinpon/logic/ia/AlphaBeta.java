package org.chinpon.logic.ia;

import java.util.List;

import org.chinpon.model.entities.GameBoard;

public abstract class AlphaBeta {
	public abstract IPlayer getMaximizingPlayer();
	
	public int alphaBeta(Node node, int depth, int alpha, int beta, IPlayer player) {
		/*if (depth == 0 || isTerminal(node)) {
			return heuristicScore(node);
		}
		
		// Get copy of the current gameBoard
		GameBoard auxGB = new GameBoard(node.getGameBoard());
		
		
		
		// Get a copy of the current player
		IPlayer auxPlayer = auxGB.getPlayer(player);
		IA auxPlayerIA = auxPlayer.getIA();
		auxPlayerIA.setGameBoard(auxGB);
		
		List<PlayerAction> actions = auxPlayerIA.getActionNodes();
		if (getMaximizingPlayer().getIdCharacter().equals(auxPlayer.getIdCharacter())) {
			for (PlayerAction action:actions) {
				auxGB.execute(action);
				Node nodeAux = new Node(node.getHistory(), auxGB);
				
				node.setNext(new NodeAction(action, nodeAux));
				nodeAux.setPrevious(new NodeAction(null, node));
				
				// Test with this node
				alpha = Math.max(alpha, alphaBeta(nodeAux, depth - 1, alpha, beta, auxPlayerIA.getRival()));
				
				if (beta <= alpha) {
					break;
				}
			}
			return alpha;
		} else {
			for (PlayerAction action:actions) {
				auxGB.execute(action);
				Node nodeAux = new Node(node.getHistory(), auxGB);
				
				node.setNext(new NodeAction(action, nodeAux));
				
				beta = Math.max(beta, alphaBeta(nodeAux, depth - 1, alpha, beta, player));
				
				if (beta <= alpha) {
					break;
				}
			}
			return beta;
		}*/
		return 1;
	}
	
	public abstract int heuristicScore(Node node);
	public abstract boolean isTerminal(Node node);
}
