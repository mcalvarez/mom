package org.chinpon.model.entities;

public class Character {
	private Integer idCharacter;
	private String name;
	private Room room;
	private int damage;
	private int health;
	private Player player;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public Integer getIdCharacter() {
		return idCharacter;
	}
	public void setIdCharacter(Integer idCharacter) {
		this.idCharacter = idCharacter;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}
