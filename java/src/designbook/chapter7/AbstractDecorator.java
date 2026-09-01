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

public abstract class AbstractDecorator implements CardSource {
	
	private final CardSource aElement;
	
	protected AbstractDecorator(CardSource pElement) {
		aElement = pElement;
	}
	
	@Override
	public Card draw() {
		return aElement.draw();
	}

	@Override
	public boolean isEmpty() {
		return aElement.isEmpty();
	}
}