package org.chinpon.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.chinpon.logic.config.GameConfig;
import org.chinpon.logic.ia.PlayerAction;
import org.chinpon.logic.ia.PlayerFactory;
import org.chinpon.logic.ia.PlayerType;
import org.chinpon.logic.ia.actions.hero.Move;
import org.chinpon.logic.state.GameState;
import org.chinpon.model.entities.Card;
import org.chinpon.model.entities.CardType;
import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.Hero;
import org.chinpon.model.entities.History;
import org.chinpon.model.entities.Objective;
import org.chinpon.model.entities.Player;
import org.chinpon.model.entities.Room;
import org.chinpon.model.entities.RoomType;
import org.chinpon.model.entities.Weapon;
import org.chinpon.util.Direction;

public class AppLogic extends Observable implements IAppLogic {
	private GameConfig gameConfig;
	private History history;
	private GameBoard gameBoard;
	private Map<String, Player> players;
	private GameState gameState;
	
	public AppLogic() {
		this.gameConfig = new GameConfig(); 
		this.players = new HashMap<String, Player>();
	}

	public void setHistory(Integer idHistory) {
		history = new History();
		history.setName("The fall of the house Linch");

		gameBoard = new GameBoard();
		history.setGameBoard(gameBoard);

		Objective obj1 = new Objective();
		obj1.setIdObjective(1);
		obj1.setText("Description1");

		Objective obj2 = new Objective();
		obj2.setIdObjective(2);
		obj2.setText("Description2");

		history.getObjectives().add(obj1);
		history.getObjectives().add(obj2);

		Room ceremonies1 = new Room();
		ceremonies1.setId(1);
		ceremonies1.setRoomType(RoomType.CEREMONIES1);
		ceremonies1.setName("Ceremonis1");

		Room ceremonies2 = new Room();
		ceremonies2.setId(1);
		ceremonies2.setRoomType(RoomType.CEREMONIES2);
		ceremonies2.setName("Ceremonis2");

		Card card1 = new Card();
		card1.setIdCard(1);
		card1.setName("Clue 1");
		card1.setType(CardType.EXPLORATION);

		Card card2 = new Card();
		card2.setIdCard(2);
		card2.setName("Door custodied");
		card2.setType(CardType.LOCK);

		ceremonies2.getCards().add(card1);
		ceremonies2.getCards().add(card2);

		Room room2 = new Room();
		room2.setId(2);
		room2.setRoomType(RoomType.BASEMENT);
		room2.setName("Basement");

		Card card3 = new Card();
		card3.setIdCard(3);
		card3.setName("Nada de interes");
		card3.setType(CardType.EXPLORATION);

		Card card4 = new Card();
		card4.setIdCard(4);
		card4.setName("Pruebas inquietantes");
		card4.setType(CardType.LOCK);

		Card card5 = new Card();
		card5.setIdCard(4);
		card5.setName("Cortocircuito");
		card5.setType(CardType.LOCK);

		room2.getCards().add(card3);
		room2.getCards().add(card4);
		room2.getCards().add(card5);

		Room trasteroBasement = new Room();
		trasteroBasement.setId(3);
		trasteroBasement.setRoomType(RoomType.STORAGE_ROOM);
		trasteroBasement.setName("Trastero basement");

		Room restRoom = new Room();
		restRoom.setId(4);
		restRoom.setRoomType(RoomType.REST_ROOM);
		restRoom.setName("Rest room");

		Room secretPassage = new Room();
		secretPassage.setId(5);
		secretPassage.setRoomType(RoomType.SECRET_PASSAGE);
		secretPassage.setName("Secret passage");

		Room study = new Room();
		study.setId(6);
		study.setRoomType(RoomType.STUDY);
		study.setName("Study");

		Room abism = new Room();
		abism.setId(7);
		abism.setRoomType(RoomType.ABISM);
		abism.setName("Abism");

		Room crypt = new Room();
		crypt.setId(8);
		crypt.setRoomType(RoomType.CRYPT);
		crypt.setName("Crypt");

		Room kitchen = new Room();
		kitchen.setId(9);
		kitchen.setRoomType(RoomType.KITCHEN);
		kitchen.setName("Cocina");

		Room dinnerRoom1 = new Room();
		dinnerRoom1.setId(10);
		dinnerRoom1.setRoomType(RoomType.DINNING_ROOM1);
		dinnerRoom1.setName("Comedor1");

		Room dinnerRoom2 = new Room();
		dinnerRoom2.setId(11);
		dinnerRoom2.setRoomType(RoomType.DINNING_ROOM2);
		dinnerRoom2.setName("Comedor2");

		Room vestibuloLeftDown = new Room();
		vestibuloLeftDown.setId(12);
		vestibuloLeftDown.setRoomType(RoomType.HALL_LD);
		vestibuloLeftDown.setName("Vestibulo LeftDown");

		Room vestibuloCenter = new Room();
		vestibuloCenter.setId(13);
		vestibuloCenter.setRoomType(RoomType.HALL_LD);
		vestibuloCenter.setName("Vestibulo Center");

		Room vestibuloRightDown = new Room();
		vestibuloRightDown.setId(14);
		vestibuloRightDown.setRoomType(RoomType.HALL_RD);
		vestibuloRightDown.setName("Vestibulo RightDown");

		Room vestibuloLeftUp = new Room();
		vestibuloLeftUp.setId(15);
		vestibuloLeftUp.setRoomType(RoomType.HALL_LU);
		vestibuloLeftUp.setName("Vestibulo LeftUp");

		Room vestibuloRightUp = new Room();
		vestibuloRightUp.setId(16);
		vestibuloRightUp.setRoomType(RoomType.HALL_RU);
		vestibuloRightUp.setName("vestibulo RightUp");

		ceremonies1.getContiguous().add(ceremonies2);
		ceremonies2.getContiguous().add(ceremonies1);

		kitchen.setClosed(true);
		ceremonies2.getContiguous().add(kitchen);
		kitchen.getContiguous().add(ceremonies2);

		kitchen.getContiguous().add(trasteroBasement);
		trasteroBasement.getContiguous().add(kitchen);

		kitchen.getContiguous().add(dinnerRoom1);
		dinnerRoom1.getContiguous().add(kitchen);

		dinnerRoom1.getContiguous().add(dinnerRoom2);
		dinnerRoom2.getContiguous().add(dinnerRoom1);

		dinnerRoom2.getContiguous().add(vestibuloLeftDown);
		vestibuloLeftDown.getContiguous().add(dinnerRoom2);
		
		gameBoard.getRooms().put(RoomType.CEREMONIES1, ceremonies1);
		gameBoard.getRooms().put(RoomType.CEREMONIES2,ceremonies2);
		gameBoard.getRooms().put(RoomType.KITCHEN, kitchen);
		gameBoard.getRooms().put(RoomType.STORAGE_ROOM, trasteroBasement);
		gameBoard.getRooms().put(RoomType.DINNING_ROOM1, dinnerRoom1);
		gameBoard.getRooms().put(RoomType.DINNING_ROOM2, dinnerRoom2);
		gameBoard.getRooms().put(RoomType.HALL_LD, vestibuloLeftDown);
	}
	
	public void createNewGame() {
		gameState = GameState.CREATED;
	}
	
	public void start() {
		gameState = GameState.SETUP;
	}

	public String addPlayer(String nickName, PlayerType playerType) {
		// Generate ID
		Player player = PlayerFactory.getInstance(playerType.SOR);
		player.setIdPlayer(Integer.toString(players.size()));
		players.put(player.getIdPlayer(), player);
		player.setName(nickName);
		player.setGameBoard(gameBoard);
		
		// Move character to start room
		Room room = gameBoard.getRoom(RoomType.HALL_LD);
		PlayerAction move = new Move(player.getCharacter(), room);
		move.setGameBoard(gameBoard);
		gameBoard.execute(move);
		
		// Add Player to GameBoard
		gameBoard.getHeroes().add((Hero)player);
		
		return player.getIdPlayer();
	}
	
	

	public void move(String idPlayer, Direction direction) {
		//Move move = new Move();
		
	}

	public void attack(String idPlayer, Character character, Weapon weapon) {
		// TODO Auto-generated method stub
		
	}

	public void examine(String idPlayer) {
		// TODO Auto-generated method stub
		
	}

	public void passTurn(String idPlayer) {
		// TODO Auto-generated method stub
		
	}

	public void exit(String idPlayer) {
		// TODO Auto-generated method stub
		
	}

	public List<Card> getCards(String idPlayer, CardType cardType) {
		
		return null;
	}

	public void setCards(String idPlayer, List<Card> cards) {
		// TODO Auto-generated method stub
		
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public List<PlayerAction> getPlayerActions(String idPlayer) {
		Player player = players.get(idPlayer);
		return player.getPlayerActions();
	}
	
	public Map<String, Player> getPlayers() {
		return players;
	}
}
