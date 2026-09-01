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
package designbook.chapter8;

/**
 * Sample observer of ObservableCardStack. Detects when an ace is pushed onto
 * the stack. Two of the callbacks are unnecessary and purposefully not 
 * overridden.
 */
public class AceDetector implements CardStackObserver {

	@Override
	public void pushed(Card pCard) {
		if (pCard.getRank() == Rank.ACE) {
			System.out.println("Ace detected!");
		}
	}
}