/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2022 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter2e;

/**
 * Represents the suit of a playing card.
 */
public enum Suit { 
	CLUBS, DIAMONDS, SPADES, HEARTS;

	public enum Color {
		RED, BLACK
	}

	public Color color() {
		if (this == CLUBS || this == SPADES) {
			return Color.BLACK;
		} else {
			return Color.RED;
		}
	}

	public Suit nextSuit() {
		return Suit.values()[(this.ordinal() + 1) % Suit.values().length];
	}
}
