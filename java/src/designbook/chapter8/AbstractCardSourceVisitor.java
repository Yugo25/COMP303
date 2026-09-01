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

public class AbstractCardSourceVisitor implements CardSourceVisitor {
	@Override
	public void visitCompositeCardSource(CompositeCardSource pCompositeCardSource) {
		for (CardSource source : pCompositeCardSource) {
			source.accept(this);
		}
	}

	@Override
	public void visitDeck(Deck pDeck)
	{}

	@Override
	public void visitCardSequence(CardSequence pCardSequence)
	{}
}