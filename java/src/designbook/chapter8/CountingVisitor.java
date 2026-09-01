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
 * A visitor to compute the total number of cards in a card 
 * source.
 */
public class CountingVisitor extends AbstractCardSourceVisitor {
	
	private int aCount = 0;
	
	@Override
	public void visitDeck(Deck pDeck) {
		for (Card card : pDeck) {
			aCount++;
		}
	}

	@Override
	public void visitCardSequence(CardSequence pCardSequence) {
		aCount += pCardSequence.size();
	}
	
	public int getCount() { 
		return aCount; 
	}
	
	public void reset() {
		aCount = 0;
	}
}