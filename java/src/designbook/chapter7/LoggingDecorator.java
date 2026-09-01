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
 * Decorator that prints the card drawn on the console.
 */
public class LoggingDecorator extends AbstractDecorator {
	
	public LoggingDecorator(CardSource pElement) {
		super(pElement);
	}
	
	@Override
	public Card draw() {
		Card card = super.draw();
		System.out.println(String.format("Draws %s", card));
		return card;
	}
}