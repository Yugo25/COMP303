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
package designbook.chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * A CardSource decorator that memorizes cards drawn from the
 * source.
 */
public class MemorizingDecorator implements CardSource {
	
	private CardSource aElement;
	private List<Card> aDrawnCards = new ArrayList<>();

	public MemorizingDecorator(CardSource pCardSource) {
		aElement = pCardSource;
	}

	@Override
	public boolean isEmpty() {
		return aElement.isEmpty();
	}

	@Override
	public Card draw() {
		// 1. Delegate the original request to the decorated object
		Card card = aElement.draw();
		// 2. Implement the decoration
		aDrawnCards.add(card);
		return card;
	}

	@Override
	public CardSource copy() {
		MemorizingDecorator copy = new MemorizingDecorator(aElement.copy());
		copy.aDrawnCards = new ArrayList<>(aDrawnCards);
		return copy;
	}
}