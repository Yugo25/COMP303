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
package designbook.chapter8;

/**
 * Sample observer of ObservableCardStack. Counts the number of
 * cards pushed on a stack.
 */
public class Counter implements CardStackObserver {
	private int aCount = 0;

	@Override
	public void pushed(Card pCard) {
		aCount++;
		System.out.println("PUSH Counter=" + aCount);
	}

	@Override
	public void popped(Card pCard) {
		aCount--;
		System.out.println("POP Counter=" + aCount);
		if (aCount == 0) {
			System.out.println("Last card popped!");
		}
	}

	@Override
	public void cleared() {
		aCount = 0;
		System.out.println("CLEAR Counter=" + aCount);
	}
}