package org.chinpon.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import org.chinpon.logic.AppLogic;
import org.chinpon.logic.IAppLogic;
import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.logic.ia.PlayerType;

public class CommandLineGUI implements Observer {
	private IAppLogic logic = null;
	private List<String> players;
	
	public CommandLineGUI() {
		logic = new AppLogic();
		logic.addObserver(this);
		players = new ArrayList<String>();
	}
	
	public static void main(String args[]) {
		CommandLineGUI gui = new CommandLineGUI();
		IAppLogic logic = gui.getLogic();
		
		logic.setHistory(1);
		logic.createNewGame();
		gui.players.add(logic.addPlayer("player 1", PlayerType.SOR));
		gui.players.add(logic.addPlayer("player 2", PlayerType.KEEPER));
		logic.start();
		try(Scanner sc = new Scanner(System.in)) {
			while (true) {
				// Show keyboard
				System.out.println(logic.getGameBoard().toString());
				
				System.out.println("Options--");
				
				// While GameBoard in Preparing state
				switch (logic.getGameState()) {
				case SETUP:
					// TODO customize
					gui.showSetupActions(gui.players.get(0));
					//gui.setupActions(option);
					break;
				case CREATED:
					break;
				case END:
					break;
				case PAUSE:
					break;
				default:
					break;
				}
				
				// Players Setup
				int option = sc.nextInt();
			}
		}
	}
	
	public void showSetupActions(String idPlayer) {
		for (PlayerAction playerAction:logic.getPlayerActions(idPlayer)) {
			System.out.println(playerAction.toString());
		}
	}
	
	public void setupActions(int option) {
		switch(option){
		case SetupActions.GET_TRAIT_CARD:
			// Choose a card
			
			
			break;
		}
	}

	public IAppLogic getLogic() {
		return logic;
	}

	public void update(Observable o, Object arg) {
		
		
	}
}

interface SetupActions {
	int GET_TRAIT_CARD = 0;
}
