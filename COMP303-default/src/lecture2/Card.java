package lecture2;

import java.util.Random;

public class Card {
    private static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", 
    "King"};

    private int aRank;
    private Suit aSuit;

    public Card(int pRank, Suit pSuit) {
        aRank = pRank;
        aSuit = pSuit;
    }

    public Card next() {
        int newRank = (aRank + 1) % RANKS.length;
        Suit newSuit = aSuit;
        if (newRank == 0) {
            newSuit = newSuit.next();
        }
        return new Card(newRank, newSuit);
    }

    public String toString() {
        return "%s of %s".formatted(RANKS[this.aRank], this.aSuit);
    }

    public Card randomCard() {
        return new Card(RANDOM.nextInt(RANKS.length), Suit.values() [RANDOM.nextInt(Suit.values().length)]);
    }

    private static Random RANDOM = new Random();
}
