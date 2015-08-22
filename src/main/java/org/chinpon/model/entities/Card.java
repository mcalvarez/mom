package org.chinpon.model.entities;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class Card {
	private Integer idCard;
	private String name;
	private String description;
	private CardType type;
	
	public Card() {
		
	}
	
	public Card(Card card) {
		try {
			BeanUtils.copyProperties(this, card);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*this.idCard = new Integer(card.idCard);
		this.name = new String(card.name);
		this.description = new String(card.description);
		this.type = card.type;*/
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
	public Integer getIdCard() {
		return idCard;
	}
	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
}