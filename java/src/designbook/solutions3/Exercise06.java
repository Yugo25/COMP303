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
package designbook.solutions3;

import java.util.Comparator;

import designbook.chapter3.Card;
import designbook.chapter3.Rank;
import designbook.chapter3.Suit;

public class Exercise06 {

	public static void main(String[] args) {
		Hand hand1 = new Hand(3);
		Hand hand2 = new Hand(3);
		hand1.add(new Card(Rank.ACE, Suit.CLUBS));
		UniversalComparator comparator = new UniversalComparator();
		IO.println(comparator.compare(hand1, hand2));
		comparator.setOrder(UniversalComparator.Order.DESCENDING);
		IO.println(comparator.compare(hand1, hand2));
	}
}

/**
 * Can compare hands in either increasing or decreasing number of cards. This is
 * not an example of good design, but the idea of the exercise is to think about
 * why that may be.
 */
class UniversalComparator implements Comparator<Hand> {

	public enum Order {
		ASCENDING, DESCENDING
	}

	private Order aOrder = Order.ASCENDING;

	/**
	 * Creates a comparator that compares in increasing size by default
	 */
	public UniversalComparator() {}

	/**
	 * @param pOrder Specifies the order
	 */
	public UniversalComparator(Order pOrder) {
		aOrder = pOrder;
	}

	@Override
	public int compare(Hand pHand1, Hand pHand2) {
		if (aOrder == Order.ASCENDING) {
			return pHand1.size() - pHand2.size();
		}
		else {
			return pHand2.size() - pHand1.size();
		}
	}

	/**
	 * @param pOrder The comparison order.
	 * @pre pOrder != null
	 */
	public void setOrder(Order pOrder) {
		aOrder = pOrder;
	}
}