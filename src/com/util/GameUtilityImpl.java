package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bean.Card;
import com.bean.Deck;
import com.bean.Player;
import com.bean.Rank;
import com.bean.Suit;

//Override and implement all the methods of GameUtility Interface here 
public class GameUtilityImpl implements GameUtility {

	@Override
	public Deck getCardDeck() {

		Set<Card> cards = new HashSet<Card>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card c = new Card(rank, suit);
				cards.add(c);
			}
		}

		Deck d = new Deck();
		d.setCards(cards);

		return d;
	}

	@Override
	public Map<Player, Set<Card>> distributeCards(Deck deck, int noOfPlayers, int noOfCards) {

		Set<Card> cards = deck.getCards();

		List<Card> cardsList = new ArrayList<Card>();

		cardsList.addAll(cards);

		Map<Player, Set<Card>> playerCards = new HashMap<Player, Set<Card>>();

		for (int i = 1; i <= noOfPlayers; i++) {
			Collections.shuffle(cardsList);

			int count = 0;
			Set<Card> distributedCard = new HashSet<Card>();

			while (count < noOfCards) {
				distributedCard.add(cardsList.get(count));
				count++;

			}
			playerCards.put(Player.valueOf("PLAYER_" + i), distributedCard);

			cardsList.removeAll(distributedCard);
			distributedCard = null;
		}

		return playerCards;
	}

	@Override
	public Map<Player, Integer> playCards(Map<Player, Set<Card>> cardsMap) {

		Map<Player, Integer> playerResult = new HashMap<Player, Integer>();

		int count = 1;
		for (Map.Entry<Player, Set<Card>> entry : cardsMap.entrySet()) {
			int sum = 0;
			for (Card value : entry.getValue()) {
				sum += value.getRank().getValue();
			}

			playerResult.put(Player.valueOf("PLAYER_" + count), sum);
			count++;
		}

		return playerResult;
	}

	@Override
	public Set<Player> declareWinner(Map<Player, Integer> result) {

		Set<Player> player = new HashSet<Player>();
		int high = 0;

		for (Map.Entry<Player, Integer> entry : result.entrySet()) {

			if (high < entry.getValue()) {
				high = entry.getValue();
			}
		}

		for (Map.Entry<Player, Integer> entry : result.entrySet()) {
			if (high == entry.getValue()) {
				player.add(entry.getKey());
			}
		}

		return player;

	}

}
