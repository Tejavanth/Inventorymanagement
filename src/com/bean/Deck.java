package com.bean;

import java.util.Set;

public class Deck {
	//has-a , Composition
	private Set<Card> cards;

	public Deck() {
		// TODO Auto-generated constructor stub
	}	

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + ", getCards()=" + getCards() + "]";
	}
	
	
}
