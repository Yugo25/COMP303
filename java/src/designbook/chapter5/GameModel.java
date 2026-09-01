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
package designbook.chapter5;

/*
 * Sample class under test.
 */
public class GameModel implements GameModelView {
	
	private static GameModel INSTANCE = new GameModel();
	
	private PlayingStrategy aPlayingStrategy;
	
	public static GameModel instance() {
		return INSTANCE;
	}
	
	public void tryToAutoPlay() {
		aPlayingStrategy.computeNextMove(this);
	}
}