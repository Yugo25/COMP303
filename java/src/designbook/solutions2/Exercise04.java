/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2025 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions2;

public class Exercise04 {

	public static void main(String[] args) {
		for (SuitWithColor suit : SuitWithColor.values()) {
			IO.println(suit.color());
		}
	}
}

enum SuitWithColor {
	
	CLUBS, DIAMONDS, SPADES, HEARTS;

	enum Color {
		RED, BLACK;
	}

	public Color color() {
		if (this == CLUBS || this == SPADES) {
			return Color.BLACK;
		}
		else {
			return Color.RED;
		}
	}
}