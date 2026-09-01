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
 * An object that observes a CardStack. Design with push data flow.
 */
public interface CardStackObserver {
	default void pushed(Card pCard) {}
	default void popped(Card pCard) {}
	default void cleared() {}
}