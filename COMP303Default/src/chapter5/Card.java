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
package chapter4;

import java.util.Objects;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class shows an application of the Flyweight design
 * pattern where the flyweight store is pre-initialized.
 */
public class Card {

	/* 
	public static void main(String[] args) {
		Set<Card> cards = new HashSet<>();
		Card card1 = new Card(Rank.ACE, Suit.CLUBS);
		Card card2 = new Card(Rank.ACE, Suit.CLUBS);
		cards.add(card1);
		IO.println(cards.contains(card2));
	}
	*/
	
	/*
	 * Implements the flyweight store as a bidimensional array. The 
	 * first dimension indexes the suits by the ordinal value of their enumerated type, 
	 * and the second dimension, the ranks. For example, to retrieve the two of clubs,
	 * we access CARDS[Suit.CLUBS.ordinal()][Rank.TWO.ordinal()]. 
	 */
	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];
	private static final Map<Suit, Map<Rank, Card>> aAllCards = new HashMap(); 
	
	private final Rank aRank;
	private final Suit aSuit;

	public static Card get(Rank pRank, Suit pSuit) {
		if (!aAllCards.containsKey(pSuit)) {
			aAllCards.put(pSuit, new HashMap<>());
		}
		Map<Rank, Card> inner = aAllCards.get(pSuit);
		if (!inner.containsKey(pRank)) {
			inner.put(pRank, new Card(pRank, pSuit));
		}
		return inner.get(pRank);
	}
	
	// Initialization of the flyweight store
	static {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	// Private constructor
	private Card( Rank pRank, Suit pSuit) {
		aRank = pRank;
		aSuit = pSuit;
	}
	
	
	/**
	 * @param pRank The rank of the requested card.
	 * @param pSuit The suit of the requested card.
	 * @return The unique Card instance with pRank and pSuit
	 * @pre pRank != null && pSuit != null
	 */
	/* 
	public static Card get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}
	*/
	
	/**
	 * @return The rank of the card.
	 */
	public Rank getRank() {
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit() {
		return aSuit;
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s", aRank, aSuit);
	}

	@Override 
	public int hashCode() {
		return Objects.hash(aRank, aSuit);
	}

	@Override 
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card card = (Card) obj;
		return aSuit == card.aSuit && aRank == card.aRank;
	}
}