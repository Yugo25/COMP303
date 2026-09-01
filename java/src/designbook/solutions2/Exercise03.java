/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2019 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions2;

import java.util.Random;

import designbook.chapter2.Rank;
import designbook.chapter2.Suit;

public class Exercise03 {

	public static void main(String[] args) {
		System.out.println(CardWithRandom.random());
	}
}

class CardWithRandom {
	
	private Rank aRank;
	private Suit aSuit;
	private static Random aRandom = new Random();
	
	public CardWithRandom(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	public static Card random() {
		return new Card(Rank.values()[aRandom.nextInt(Rank.values().length)], 
				Suit.values()[aRandom.nextInt(Suit.values().length)]);
	}
	
	public Rank rank() {
		return aRank;
	}
	
	public Suit suit() {
		return aSuit;
	}
	
	public String toString() {
		return String.format("%s of %s", aRank, aSuit);
	}
}