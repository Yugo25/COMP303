package lecture4;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

public class Client {

    public static void main(String[] args) {

        /* 
        List<Card> cards = Deck.createFullShuffled().getCards();
        Collections.sort(cards); */
        Card highest = highest(Deck.createFullShuffled());
        System.out.println(highest);
    }

    /**
     * 
     * @param pDeck
     * @return the highest card in the deck
     */
    public static Card highest(Iterable<Card> pIterable) {
        Card result = new Card(Rank.values()[0], Suit.values()[0]);
        Iterator<Card> iterator = pIterable.iterator();
        for (Card card : pIterable) {
            if (card.compareTo(result) > 0) {
                result = card;
            }
        }
        return result;
    }
}