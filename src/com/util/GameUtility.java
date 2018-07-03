package com.util;

import java.util.Map;
import java.util.Set;

import com.bean.Card;
import com.bean.Deck;
import com.bean.Player;

public interface GameUtility {
	// Create and return a Deck.Deck is Collection of Cards with unique Rank and Suit
	Deck getCardDeck();
	
	// Distribute specified no of cards from the given Deck to the number of players 
	// Make sure every player will get unique cards only
	Map<Player,Set<Card>> distributeCards(Deck deck,int noOfPlayers,int noOfCards);
	
	// This method should sum up the Rank of all the cards distributed to each Player and store sum of cards along with Player name
	Map<Player,Integer> playCards(Map<Player,Set<Card>> cardsMap);
	
	// Now by reading the value associated with each player find the winner.
	// Player with the highest score will be the winner.
	// There can be more than 1 winner in case there is a tie(more than 1 player have same highest score). 
	Set<Player> declareWinner(Map<Player,Integer> result);

}
