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
package designbook.solutions5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import designbook.chapter5.Card;
import designbook.chapter5.Rank;
import designbook.chapter5.Suit;

public class Exercise08to10 {

	private static boolean invokeIsStraightFlush(PokerHand pHand) {
		try {
			Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
			method.setAccessible(true);
			return (boolean) method.invoke(pHand);
		}
		catch (ReflectiveOperationException e) {
			e.printStackTrace();
			fail();
			return false;
		}
	}
	
	@Test
	void testIsStraightFlush_True() {
		PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SIX, Suit.CLUBS));
		assertTrue(invokeIsStraightFlush(hand));
	}
	
	@Test
	void testIsStraightFlush_WrongSuit() {
		PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SIX, Suit.DIAMONDS));
		assertFalse(invokeIsStraightFlush(hand));
	}
	
	@Test
	void testIsStraightFlush_WrongRank() {
		PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SEVEN, Suit.CLUBS));
		assertFalse(invokeIsStraightFlush(hand));
	}
}

class PokerHand {

	private final List<Card> aCards;

	public PokerHand(Card... pCards) {
		assert pCards.length == 5;
		aCards = Arrays.asList(pCards);
		aCards.sort(new Comparator<Card>() {
			public int compare(Card pCard1, Card pCard2) {
				return pCard1.getRank().compareTo(pCard2.getRank());
			}
		});
	}

	private boolean isStraightFlush() {
		Suit suit = aCards.get(0).getSuit();
		Rank rank = aCards.get(0).getRank();
		Iterator<Card> iterator = aCards.iterator();
		iterator.next();
		while (iterator.hasNext()) {
			Card card = iterator.next();
			if (card.getSuit() != suit || card.getRank().ordinal() - rank.ordinal() != 1) {
				return false;
			}
			rank = card.getRank();
		}
		return true;
	}
}