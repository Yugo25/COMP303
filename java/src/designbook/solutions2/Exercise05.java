/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2025 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import designbook.chapter2.Rank;

public class Exercise05 {

	public static void main(String[] args) {
		Random random = new Random();
	    List<Card> cards = new ArrayList<>();
			
	    while (cards.size() < 10) {
	    	Card card = CardWithRandom.random();
	    	if (card.rank().ordinal() < Rank.JACK.ordinal()) {
	    		cards.add(card);
	    	}
	    }
			
	    int sum = 0;
	    for (Card card : cards) {
	    	sum += card.rank().ordinal() + 1;
	    }
	   
	    IO.println("Result: " + sum);
	}
}