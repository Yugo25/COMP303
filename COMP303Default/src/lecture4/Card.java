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
package lecture4;

/**
 * Implementation of a playing card. This class yields immutable objects.
 */
public class Card implements Comparable<Card> {
	private Rank aRank;
	private Suit aSuit;
	
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
		aRank = pRank;
		aSuit = pSuit;
	}
	
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

	public boolean isBlack() {
		return (this.aSuit == Suit.DIAMONDS || this.aSuit == Suit.HEARTS);
	}

	@Override 
	public int compareTo(Card pOther) {
		if (getSuit() == pOther.getSuit()) {
			return getRank().compareTo(pOther.getRank());
		} else {
			return getSuit().compareTo(pOther.getSuit());
		}
	}

	public String toString() {
        return "%s of %s".formatted(getRank(), getSuit());
    }
}