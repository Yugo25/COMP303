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
 * Simple visitor that prints all cards in the source, in
 * no specified order.
 */
public class PrintVisitor implements CardSourceVisitor {
	
	public static void main(String[] args) {
		PrintVisitor visitor = new PrintVisitor();
		Deck deck = new Deck();
		deck.accept(visitor);
	}
	
	@Override
	public void visitCompositeCardSource(CompositeCardSource pCompositeCardSource) {
		for (CardSource source : pCompositeCardSource) {
			source.accept(this);
		}
	}

	@Override
	public void visitDeck(Deck pDeck) {
		for (Card card : pDeck) {
			System.out.println(card);
		}
	}

	@Override
	public void visitCardSequence(CardSequence pCardSequence) {
		for (int i = 0; i < pCardSequence.size(); i++) {
			System.out.println(pCardSequence.get(i));
		}
	}
}