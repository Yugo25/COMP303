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
 * Represents an entity from which it is possible to obtain cards.
 * This version is visitable.
 */
public interface CardSource {
	/**
	 * Returns a card from the source.
	 *
	 * @return The next available card.
	 * @pre !isEmpty()
	 */
	Card draw();
	
	/**
	 * @return True if there is no card in the source.
	 */
	boolean isEmpty();
	
	/**
	 * Accepts a visitor for traversal into this structure.
	 * 
	 * @param pVisitor The visitor to accept
	 */
	void accept(CardSourceVisitor pVisitor);
}