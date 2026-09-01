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
package designbook.chapter3;

import java.util.Comparator;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class also implements the Comparable interface and
 * compares cards by rank, with an undefined order for cards of the same rank.
 * The class also includes a static factory method to create Comparator
 * objects that can compare cards according to their rank.
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

	@Override
	public int compareTo(Card pCard) {
		return aRank.compareTo(pCard.aRank);
	}
	
	/**
	 * Sample static factory method to create a comparator capable
	 * of comparing cards by rank.
	 * 
	 * @return The created comparator.
	 */
	public static Comparator<Card> createByRankComparator() {
		return new Comparator<Card>() {
			@Override
			public int compare(Card pCard1, Card pCard2) { 
				return pCard1.aRank.compareTo(pCard2.aRank);
			}
		};
	}
}