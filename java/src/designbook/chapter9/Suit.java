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
 * Represents the suit of a playing card.
 */
public enum Suit {
	
	CLUBS, DIAMONDS, SPADES, HEARTS;
	
	public enum Color { RED, BLACK }
			
	/**
	 * @return The color of the suit.
	 */
	public Color getColor() {
		if (this == CLUBS || this == SPADES) {
			return Color.BLACK;
		}
		else {
			return Color.RED;
		}
	}
}
