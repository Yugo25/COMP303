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
package designbook.solutions4;

import java.util.Comparator;
import designbook.chapter4.Card;

public class Exercise04 {
	public static void main(String[] args) {
		Game game = new Game();
	}
}

class Game {

	private static final Comparator<Card> NULL_COMPARATOR = new Comparator<Card>() {
		public int compare(Card pCard1, Card pCard2) {
			return 0;
		}
	};

	private Comparator<Card> aComparator = NULL_COMPARATOR;
}