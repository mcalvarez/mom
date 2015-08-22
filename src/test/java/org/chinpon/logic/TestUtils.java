package org.chinpon.logic;

import static org.junit.Assert.assertTrue;

import org.chinpon.helper.AdapterMasterMind;
import org.chinpon.helper.GameBoardHelper;
import org.chinpon.logic.ia.HeroMind;
import org.chinpon.logic.ia.KeeperMind;
import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.model.entities.Card;
import org.chinpon.model.entities.CardType;
import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.Hero;
import org.chinpon.model.entities.History;
import org.chinpon.model.entities.Keeper;
import org.chinpon.model.entities.Objective;
import org.chinpon.model.entities.Room;
import org.chinpon.util.Dice;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtils {
	private static History history = null;
	private static Hero hero1 = null;
	private static Keeper keeper = null;

	@BeforeClass
	public static void createHistory() {
		
	}

	@Test
	public void testDices() {
		for (int i=0; i < 10; i++) {
			long number = Dice.getNumber();
			System.out.println("dice:" + number);
		}
	}

	@Test
	public void testCopyGameBoard() {

	}

	@Test
	public void heroPlayTest() {
		GameBoard currentGameBoard = new GameBoard(history.getGameBoard());
		currentGameBoard.getHeroes().add(hero1);
		HeroMind heroMind = new HeroMind(history, currentGameBoard, hero1);
		hero1.setIA(heroMind);
		//hero1.setIdCharacter(1);
		keeper = new Keeper();
		keeper.setIdCharacter(2);
		KeeperMind keeperMind = new KeeperMind(history, currentGameBoard, keeper);
		keeperMind.setRival(hero1);
		keeper.setIA(keeperMind);
		heroMind.setRival(keeper);
		currentGameBoard.setKeeper(keeper);

		int numExamined = 0;
		do {
			for (Room room : currentGameBoard.getRooms().values()) {
				if (room.isExplored())
					numExamined++;
			}

			// HeroMind hm = new HeroMind(history, currentGameBoard, hero1);
			HeroMind hm = (HeroMind) hero1.getIA();
			PlayerAction action = hm.think();

			// action.setGameBoard(currentGameBoard);
			currentGameBoard.execute(action);

			/*
			 * KeeperMind km = (KeeperMind)currentGameBoard.getKeeper().getIA();
			 * PlayerAction actionKeeper = km.think();
			 * 
			 * currentGameBoard.execute(actionKeeper)
			 */

			System.out.println(currentGameBoard.toString());
		} while (numExamined < 5);
	}

	@Test
	public void masterPlayTest() {
		GameBoard gameBoard = GameBoardHelper.createNewBoard(history);
		AdapterMasterMind masterMind = new AdapterMasterMind(gameBoard);

		masterMind.play();
	}

	@Test
	public void createGameBoardTest() {
		GameBoard gameBoard = history.getGameBoard();
		System.out.println(gameBoard.toString());
	}

	@Test
	public void startGameTest() {
		IAppLogic logic = new AppLogic();
		//assertTrue(logic.start());

	}

}
