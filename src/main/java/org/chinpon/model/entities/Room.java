package org.chinpon.model.entities;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class Room {
	private int id;
	private RoomType roomType;
	private String name;
	private String description;
	private boolean explored;
	private boolean closed;
	private List<Card> cards;
	private List<Room> contiguous;
	private List<Effect> effects;
	private List<Hero> heros;
	private List<Monster> monsters;
	
	public Room() {
		setCards(new LinkedList<Card>());
		setContiguous(new LinkedList<Room>());
		setHeros(new LinkedList<Hero>());
		setMonsters(new LinkedList<Monster>());
		explored = false;
	}
	
	public Room(Room room) {
		try {
			BeanUtils.copyProperties(this, room);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setCards(new LinkedList<Card>());
		for (Card card:room.getCards()) {
			getCards().add(new Card(card));
		}
		setHeros(new LinkedList<Hero>());
		for (Hero hero:room.getHeros()) {
			getHeros().add(new Hero(hero));
		}
		setMonsters(new LinkedList<Monster>());
		for (Monster monster:room.getMonsters()) {
			getMonsters().add(new Monster(monster));
		}
	}

	public Room copy() {
		return new Room(this);
	}
	
	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Room> getContiguous() {
		return contiguous;
	}

	public void setContiguous(List<Room> contiguous) {
		this.contiguous = contiguous;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Hero> getHeros() {
		return heros;
	}

	public void setHeros(List<Hero> heros) {
		this.heros = heros;
	}

	public List<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(List<Monster> monsters) {
		this.monsters = monsters;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}
