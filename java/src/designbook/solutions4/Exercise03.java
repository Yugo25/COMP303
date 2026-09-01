/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2026 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import designbook.chapter4.Rank;
import designbook.chapter4.Suit;

public class Exercise03 {

	// Use as a tester for the comparisons with jokers
	public static void main(String[] args) {
		
		Card3 whiteJoker = new Card3(true);
		Card3 blackJoker = new Card3(false);
		assert whiteJoker.compareTo(blackJoker) < 0;
		assert whiteJoker.compareTo(whiteJoker) == 0;
		Deck3 deck = new Deck3();
		while (!deck.isEmpty()) {
			Card3 card = deck.draw();
			if (!card.isJoker()) {
				assert card.compareTo(whiteJoker) < 0;
				assert card.compareTo(blackJoker) < 0;
			}
		}
		IO.println("Done");
	}
}

class Card3 implements Comparable<Card3> {

	private enum Joker {
		WHITE, BLACK
	}

	private final Optional<Rank> aRank;
	private final Optional<Suit> aSuit;
	private final Optional<Joker> aJoker;

	/**
	 * Creates a new card object that is not a joker
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card3(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = Optional.of(pRank);
		aSuit = Optional.of(pSuit);
		aJoker = Optional.empty();
	}

	/**
	 * Constructs a joker
	 * @param pIsWhite True for a white joker, false for a black one.
	 */
	public Card3(boolean pIsWhite) {
		aRank = Optional.empty();
		aSuit = Optional.empty();
		if (pIsWhite) {
			aJoker = Optional.of(Joker.WHITE);
		}
		else {
			aJoker = Optional.of(Joker.BLACK);
		}
	}

	public boolean isJoker() {
		return aJoker.isPresent();
	}

	public boolean isWhiteJoker() {
		return aJoker.isPresent() && aJoker.get() == Joker.WHITE;
	}

	public boolean isBlackJoker() {
		return aJoker.isPresent() && aJoker.get() == Joker.BLACK;
	}

	/**
	 * @return The rank of the card.
	 * @pre !isJoker();
	 */
	public Rank rank() {
		return aRank.get();
	}

	/**
	 * @return The suit of the card.
	 * @pre !isJoker()
	 */
	public Suit suit() {
		return aSuit.get();
	}

	@Override
	public int compareTo(Card3 pCard) {
		if (isJoker() && pCard.isJoker()) {
			return aJoker.get().compareTo(pCard.aJoker.get());
		}
		else if (isJoker() && !pCard.isJoker()) {
			return 1;
		}
		else if (!isJoker() && pCard.isJoker()) {
			return -1;
		}
		else {
			return aRank.get().compareTo(pCard.aRank.get());
		}
	}
}

/**
 * Represents a deck of playing cards. Simple version that includes the jokers.
 */
class Deck3 {

	private List<Card3> aCards = new ArrayList<>();

	/**
	 * Creates a new deck of 54 cards, shuffled.
	 */
	public Deck3() {
		shuffle();
	}

	/**
	 * Reinitializes the deck with all 54 cards, and shuffles them.
	 */
	public void shuffle() {
		aCards.clear();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				aCards.add(new Card3(rank, suit));
			}
		}
		aCards.add(new Card3(true));
		aCards.add(new Card3(false));
		Collections.shuffle(aCards);
	}

	/**
	 * Draws a card from the deck: removes the card from the top of the deck and
	 * returns it.
	 * 
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card3 draw() {
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
	}

	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty() {
		return aCards.isEmpty();
	}
}