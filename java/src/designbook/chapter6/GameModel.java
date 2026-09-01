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
package designbook.chapter6;

/**
 * Stub of a class that represents the state of a card game. 
 * Illustrates the use of the Prototype design pattern.
 */
public class GameModel {
	
	private final CardSource aCardSourcePrototype;
	
	// In a complete code base this field would be used.
	private CardSource aCardSource;
	
	public GameModel(CardSource pCardSourcePrototype) {
		aCardSourcePrototype = pCardSourcePrototype;
		newGame();
	}
	
	public void newGame() {
		aCardSource = aCardSourcePrototype.copy();
	}
}