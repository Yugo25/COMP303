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
package designbook.chapter4;

/**
 * Stub for a GameModel class that is an application
 * of the Singleton design pattern.
 */
public class GameModel {
	
	private static final GameModel INSTANCE = new GameModel();
	
	private GameModel() {}
	
	public static GameModel instance() { 
		return INSTANCE; 
	}
}