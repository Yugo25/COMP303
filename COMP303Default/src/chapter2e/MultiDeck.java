package chapter2e;

import java.util.List;
import java.util.ArrayList;

public class MultiDeck {
    private Deck[] aDecks;

    /**
     * 
     * @param pNumberOfDecks
     * @pre pNumberOfDeck > 0
     */
    public MultiDeck(int pNumberOfDecks) {
        assert pNumberOfDecks > 0;
        aDecks = new Deck[pNumberOfDecks];
        for (int i = 0; i < pNumberOfDecks; i++) {
            aDecks[i] = new Deck();
        }
    }

    /* 
    public MultiDeck(MultiDeck pMultiDeck) {
        aDecks = pMultiDeck.aDecks;
    } */

    public MultiDeck (MultiDeck pMultiDeck) {
        assert pMultiDeck != null;
        aDecks = new Deck[pMultiDeck.aDecks.length];
        for (int i = 0 ; i < aDecks.length; i++) {
            aDecks[i] = new Deck(pMultiDeck.aDecks[i]);
        }
    }
}
