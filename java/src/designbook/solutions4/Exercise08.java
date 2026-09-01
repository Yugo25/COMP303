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

import java.util.IdentityHashMap;
import java.util.Map;

import designbook.chapter4.Rank;
import designbook.chapter4.Suit;

class Card8 {

	private static final Map<Rank, Map<Suit, Card8>> CARDS = new IdentityHashMap<>();
	
	private Rank aRank;
	private Suit aSuit;
	
	public static Card8 get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		Map<Suit, Card8> innerMap = CARDS.getOrDefault(pRank, new IdentityHashMap<>());
		CARDS.putIfAbsent(pRank, innerMap);
		if (!innerMap.containsKey(pSuit)) {
			innerMap.put(pSuit, new Card8(pRank, pSuit));
		}
		return innerMap.get(pSuit);
	}

	private Card8(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}

	public Rank rank() {
		return aRank;
	}

	public Suit suit() {
		return aSuit;
	}
}

public class Exercise08 {

	public static void main(String[] args) {
		Card8 card1 = Card8.get(Rank.ACE, Suit.CLUBS);
		Card8 card2 = Card8.get(Rank.ACE, Suit.CLUBS);
		IO.println("Are they the same object? " + (card1 == card2));
	}
}