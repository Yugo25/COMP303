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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 * 
 * This version of the Deck class also implements {@link CardSource}.
 * 
 * The Deck is also iterable: it fulfills the role of ConcreteIterable
 * in the Iterator design pattern.
 */
public class Deck implements CardSource, Iterable<Card> {
	
	private CardStack aCards = new CardStack();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck() {
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle() {
		List<Card> cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add( Card.get( rank, suit ));
            }
		}
		Collections.shuffle(cards);
		aCards = new CardStack(cards);
	}
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard) {
		assert pCard != null;
		aCards.push(pCard);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	@Override
	public Card draw() {
		assert !isEmpty();
		return aCards.pop();
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	@Override
	public boolean isEmpty() {
		return aCards.isEmpty();
	}
	
	@Override
	public CardSource copy() {
		Deck copy = new Deck();
		copy.aCards = new CardStack(aCards);
		return copy;
	}
	
	@Override
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}
	
	/**
	 * Sample command factory method.
	 * 
	 * @return A command to draw a card from the deck. 
	 */
	public Command createDrawCommand() {
		return new Command() {
			Card aDrawn = null;
	
			@Override
			public Optional<Card> execute() {
				aDrawn = draw();
				return Optional.of(aDrawn);
			}
	
			@Override
			public void undo() {
				aCards.push(aDrawn);
				aDrawn = null;
			}
		};
	}
}