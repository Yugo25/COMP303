package chapter2e;

import java.util.List;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {

        List<Card> cards = new ArrayList<>();

        while (cards.size() < 10) {
            Card card = Card.random();
            if (card.getRank().ordinal() < Rank.JACK.ordinal()) {
                cards.add(card);
            }
        }

        int sum = 0;
        for (Card card : cards) {
            sum += card.getRank().ordinal() + 1;
        }

        System.out.println("Result : " + sum);

    }
}
