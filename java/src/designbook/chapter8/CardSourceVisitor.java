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
 * Defines the ability to visit all types of card sources in
 * a composite structure.
 */
public interface CardSourceVisitor {
	void visitCompositeCardSource(CompositeCardSource pCompositeCardSource);

	void visitDeck(Deck pDeck);

	void visitCardSequence(CardSequence pCardSequence);
}