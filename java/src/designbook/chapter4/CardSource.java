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
 * Represents an entity from which it is possible to obtain cards.
 * This version supports the Null Object pattern.
 */
public interface CardSource {
	
	CardSource NULL = new CardSource() {
		@Override
		public boolean isEmpty() { 
			return true; 
		}
		
		@Override
		public Card draw() { 
			assert !isEmpty(); 
			return null; 
		}
		
		@Override
		public boolean isNull() { 
			return true; 
		}
	};
	
	/**
	 * Returns a card from the source.
	 *
	 * @return The next available card.
	 * @pre !isEmpty()
	 */
	Card draw();
	
	/**
	 * @return True if there is no card in the source.
	 */
	boolean isEmpty();
	
	/**
	 * @return True if this instance is a null card source.
	 */
	default boolean isNull() { 
		return false; 
	}
}