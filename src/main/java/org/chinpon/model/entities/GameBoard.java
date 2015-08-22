package org.chinpon.model.entities;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.apache.commons.beanutils.BeanUtils;
import org.chinpon.logic.ia.IPlayer;
import org.chinpon.logic.ia.PlayerAction;

public class GameBoard extends Observable {
	private IPlayer currentPlayer;
	private Map<RoomType, Room> rooms = null;
	private List<Hero> heroes = null;
	private List<Monster> monsters = null;
	private Keeper keeper = null;
	private Map<Integer, List<ProfileCard>> profileCards;
	
	public GameBoard() {
		this.rooms = new HashMap<RoomType, Room>();
		this.setHeroes(new LinkedList<Hero>());
		this.setMonsters(new LinkedList<Monster>());
		this.setProfileCards(new HashMap<Integer, List<ProfileCard>>());
	}
	
	public GameBoard(GameBoard gameBoard) {
		this();
		try {
			BeanUtils.copyProperties(this, gameBoard);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setRooms(new HashMap<RoomType, Room>());
		for(Room room:gameBoard.getRooms().values()) {
			rooms.put(room.getRoomType(), new Room(room));
		}
		setHeroes(new LinkedList<Hero>());
		for (Hero hero:gameBoard.getHeroes()) {
			getHeroes().add(new Hero(hero));
		}
		setMonsters(new LinkedList<Monster>());
		for (Monster monster:gameBoard.getMonsters()) {
			getMonsters().add(new Monster(monster));
		}
	}
	
	public Room getRoom(RoomType roomType) {
		return rooms.get(roomType);
	}
	
	public IPlayer getPlayer(IPlayer player) {
		if (player instanceof Hero) {
			Hero heroAux = (Hero) player;
			Hero heroOut = null;
			for (Hero hero:this.heroes) {
				if (heroAux.getIdHero() == heroAux.getIdHero()) { 
					heroOut = hero;
					break; 
				}
			}
			return heroOut;
		} else {
			return keeper;
		}
	}
	
	public void execute(PlayerAction action) {
		action.execute();
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(str);

		// Show characteres
		
		// Show rooms
		for (Room room: rooms.values()) {
			str.append("Room -> ").append(room.getName()).append("\n");
			str.append("Hero:");
			for (Hero hero:room.getHeros()) {
				str.append(hero.getName()).append(",");
			}
			str.append("\n");
			str.append("Contiguous: \n");
			for (Room contiguous: room.getContiguous()) {
				str.append(contiguous.getName());
				str.append(",");
			}
			str.append("\n");
		}
		
		return str.toString();
	}
	
	public boolean move(Character character, Room room) {
		room.setExplored(true);
		
		// Remove character from old room
		Room oldRoom = character.getRoom();
		if (oldRoom != null)
			oldRoom.getHeros().remove(oldRoom);
		
		Room roomAux = this.getRoom(room.getRoomType());
		character.setRoom(room);
		roomAux.getHeros().add((Hero)(character.getPlayer()));
		
		return true;
	}

	public Map<RoomType, Room> getRooms() {
		return rooms;
	}

	public void setRooms(Map<RoomType, Room> rooms) {
		this.rooms = rooms;
	}

	public List<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}

	public List<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(List<Monster> monsters) {
		this.monsters = monsters;
	}

	public Keeper getKeeper() {
		return keeper;
	}

	public void setKeeper(Keeper keeper) {
		this.keeper = keeper;
	}

	public IPlayer getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(IPlayer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Map<Integer, List<ProfileCard>> getProfileCards() {
		return profileCards;
	}

	public void setProfileCards(Map<Integer, List<ProfileCard>> profileCards) {
		this.profileCards = profileCards;
	}
}
