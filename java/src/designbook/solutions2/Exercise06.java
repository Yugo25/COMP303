/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2025 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions2;

public class Exercise06 {

	public static void main(String[] args) {
		CardWithNext card = new CardWithNext(RankWithNext.QUEEN, SuitWithNext.CLUBS);
		for (int i = 0; i < 10; i++) {
			IO.println(card);
			card = card.next();
		}
	}
}

enum SuitWithNext {
	CLUBS, DIAMONDS, SPADES, HEARTS;
	
	public SuitWithNext next() {
		return SuitWithNext.values()[(ordinal()+1) % SuitWithNext.values().length];
	}
}

enum RankWithNext {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	
	public RankWithNext next() {
		return RankWithNext.values()[(ordinal()+1) % RankWithNext.values().length];
	}
}

class CardWithNext {
	
	private RankWithNext aRank;
	private SuitWithNext aSuit;
	
	public CardWithNext(RankWithNext pRank, SuitWithNext pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	public CardWithNext next() {
		RankWithNext rank = aRank.next();
		SuitWithNext suit = aSuit;
		if (rank == RankWithNext.ACE) {
			suit = suit.next();
		}
		return new CardWithNext(rank, suit);
	}
	
	public RankWithNext rank() {
		return aRank;
	}
	
	public SuitWithNext suit() {
		return aSuit;
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s", aRank, aSuit);
	}
}