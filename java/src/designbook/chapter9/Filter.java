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
package designbook.chapter9;

/**
 * Functional interface used in Section 9.2.
 */
public interface Filter {
	
	/**
	 * @param pCard The card to test
	 * @return True if this filter accepts pCard
	 * @pre pCard != null
	 */
	boolean accept(Card pCard);
}