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
import java.util.Optional;

/**
 * See section 9.5.
 *
 */
public interface CardSelectionStrategy {
	
	/**
	 * Select an instance of Card from pCards.
	 * 
	 * @param pCards
	 *            list of cards to choose from.
	 * @pre pCards != null && !pCards.isEmpty()
	 * @post If RETURN.isPresent(), pCards.contains(RETURN.get())
	 */
	Optional<Card> select(List<Card> pCards);

	static Optional<Card> first(List<Card> pCards) {
		return Optional.of(pCards.get(0));
	}

	static Optional<Card> lowestBlackCard(List<Card> pCards) { 
		return null; // This is a stub
	}

	 static Optional<Card> highestFaceCard(List<Card> pCards) { 
		return null; // This is a stub
	}
}