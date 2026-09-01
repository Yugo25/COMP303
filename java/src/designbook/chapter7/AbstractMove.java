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
package designbook.chapter7;

/**
 * Root class for all moves that require a reference
 * to the GameModel. Method perform() fulfills the role
 * of the Template Method in an application of the Template
 * Method design pattern.
 */
public abstract class AbstractMove implements Move {
	
	protected final GameModel aModel;
	
	protected AbstractMove(GameModel pModel) {
		aModel = pModel;
	}
	
	@Override
	public final void perform() {
		aModel.push(this);
		execute();
		log();
	}
	
	protected abstract void execute();
	
	private void log() {
		System.out.println(getClass().getName());
	}
}