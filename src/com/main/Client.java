package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.bean.Card;
import com.bean.Deck;
import com.bean.Player;
import com.util.GameUtilityImpl;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//You can call the methods of GameUtilityImpl from here and test your code
		
		GameUtilityImpl gul = new GameUtilityImpl();
		
		Deck deck = new Deck();
		
		deck = gul.getCardDeck();

		Map<Player, Set<Card>> playerCards= new HashMap<Player, Set<Card>>();
		
		playerCards = gul.distributeCards(deck, 4, 5);
		System.out.println("Player Cards");
		for (Map.Entry<Player,Set<Card>> entry : playerCards.entrySet()) {
			System.out.println("Key : " + entry.getKey());
			for(Card value : entry.getValue()) {
				System.out.println(value);
			}
		}
		
		Map<Player, Integer> cardsValue= new HashMap<Player, Integer>();
		
		cardsValue = gul.playCards(playerCards);
		
		System.out.println("Cards Value******************");
		  for (Map.Entry<Player, Integer> entry : cardsValue.entrySet()) {
	            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	        }


		  Set<Player> player = gul.declareWinner(cardsValue);
		  
		  System.out.println("Winner Winner Chicken Dinner");
		  System.out.println(player);
		  
	}
}







