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

import designbook.chapter9.Suit.Color;

/**
 * Used to demonstrate how to use references to static method.
 * See corresponding client code in class Samples.
 */
public class CardUtils {
	public static boolean hasBlackSuit(Card pCard) {
		return pCard.getSuit().getColor() != Color.BLACK;
	}
}