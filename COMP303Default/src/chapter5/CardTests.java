package chapter5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


public class CardTests {

    @ParameterizedTest
    @EnumSource(Rank.class)
    void testGet(Rank pRank) {
        for (Suit suit : Suit.values()) {
            Card card = Card.get(pRank, suit);
            assertSame(pRank, card.getRank());
            assertSame(suit, card.getSuit());
        }
    }

    @Test
    void testIsRedFaceCard() {
        assertFalse(Card.get(Rank.EIGHT, Suit.CLUBS).isRedFaceCard());
        assertFalse(Card.get(Rank.JACK, Suit.CLUBS).isRedFaceCard());
        assertFalse(Card.get(Rank.JACK, Suit.DIAMONDS).isRedFaceCard());
    }
}