/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2022 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions2;

import designbook.chapter2.Rank;
import designbook.chapter2.Suit;

public class Exercise01 {

	public static void main(String[] args) {
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				Card card = new Card(rank, suit);
				assert card.rank() == rank;
				assert card.suit() == suit;
				IO.println(card);
			}
		}
	}
}

/**
 * Implementation of a playing card. This class yields immutable objects. This
 * version is a facetious implementation with 6 Boolean values.
 */
class Card {

	private boolean aIsRed = false;
	private boolean aIsHighSuit = false;
	private boolean aRank1 = false;
	private boolean aRank2 = false;
	private boolean aRank3 = false;
	private boolean aRank4 = false;

	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		fromSuit(pSuit);
		fromRank(pRank);
	}

	/* Initialize the fields related to the suit */
	private void fromSuit(Suit pSuit) {
		if (pSuit == Suit.HEARTS || pSuit == Suit.DIAMONDS) {
			aIsRed = true;
		}
		if (pSuit == Suit.HEARTS || pSuit == Suit.SPADES) {
			aIsHighSuit = true;
		}
	}

	/* Initialize the fields related to the rank */
	private void fromRank(Rank pRank) {
		int value = pRank.ordinal();
		aRank1 = value % 2 == 1;
		value /= 2;
		aRank2 = value % 2 == 1;
		value /= 2;
		aRank3 = value % 2 == 1;
		value /= 2;
		aRank4 = value % 2 == 1;
		value /= 2;
	}

	/**
	 * @return The rank of the card.
	 */
	public Rank rank() {
		int value = 0;
		if (aRank4 == true) {
			value += 8;
		}
		if (aRank3 == true) {
			value += 4;
		}
		if (aRank2 == true) {
			value += 2;
		}
		if (aRank1 == true) {
			value += 1;
		}
		return Rank.values()[value];
	}

	/**
	 * @return The suit of the card.
	 */
	public Suit suit() {
		if (aIsRed) {
			if (aIsHighSuit) {
				return Suit.HEARTS;
			} else {
				return Suit.DIAMONDS;
			}
		} else {
			if (aIsHighSuit) {
				return Suit.SPADES;
			} else {
				return Suit.CLUBS;
			}
		}
	}

	@Override
	public String toString() {
		return String.format("%s of %s", rank(), suit());
	}
}