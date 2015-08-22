package org.chinpon.logic;

import java.util.List;
import java.util.Map;
import java.util.Observer;

import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.logic.ia.PlayerType;
import org.chinpon.logic.state.GameState;
import org.chinpon.model.entities.Card;
import org.chinpon.model.entities.CardType;
import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.Player;
import org.chinpon.model.entities.Weapon;
import org.chinpon.util.Direction;

public interface IAppLogic {
	void createNewGame();
	void start();
	void setHistory(Integer idHistory);
	Map<String, Player> getPlayers();
	String addPlayer(String nickName, PlayerType playerType);
	List<Card> getCards(String idPlayer, CardType cardType);
	void setCards(String idPlayer, List<Card> cards);
	void move(String idPlayer, Direction direction);
	void attack(String idPlayer, Character character, Weapon weapon);
	void examine(String idPlayer);
	void passTurn(String idPlayer);
	void exit(String idPlayer);
	List<PlayerAction> getPlayerActions(String idPlayer);
	GameBoard getGameBoard();
	GameState getGameState();
	void addObserver(Observer obs);
}
