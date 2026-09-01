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

import designbook.chapter4.Deck;

class GameModel {

	private static final GameModel INSTANCE = new GameModel();

	private final Deck aDeck = new Deck();

	public static GameModel instance() {
		return INSTANCE;
	}

	private GameModel() {}
	
	public void newGame() {
		aDeck.shuffle();
	}
}

public class Exercise09 {

	public static void main(String[] args) {
		GameModel.instance().newGame();
		// ... Other operations on GameModel
	}
}