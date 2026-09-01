/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2026 by Mathieu Nassif and Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.chapter9;

import java.util.List;
import java.util.function.Function;

/**
 * Demonstration code for the Strategy pattern applied
 * using functional-style design. See Section 9.5.
 */
public class AutoPlayer {
	private Function<List<Card>, Card> aSelectionStrategy;

	public AutoPlayer(Function<List<Card>, Card> pSelectionStrategy) {
		aSelectionStrategy = pSelectionStrategy;
	}

	public void play() {
		Card selected = aSelectionStrategy.apply(getCards());
		/* ... */
	}

	// Gets the cards to supply to the strategy
	private List<Card> getCards() { 
		return null; // this is a stub
	}
}