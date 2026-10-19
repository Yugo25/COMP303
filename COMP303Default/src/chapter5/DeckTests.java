package chapter5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class DeckTests {
    private final Deck aDeck = new Deck();

    @Test
    void testIsEmpty_False() {
        assertFalse(aDeck.isEmpty());
    }

    private void clearDeck() {
        try {
            Field cardsField = Deck.class.getDeclaredField("aCards");
            cardsField.setAccessible(true);
            List<?> cards = (List<?>)cardsField.get(aDeck);
            cards.clear();
        } catch (ReflectiveOperationException e) {
            fail();
        }
    }

    @Test
    void testIsEmpty_True() {
        clearDeck();
        assertTrue(aDeck.isEmpty());
    }

    @Test
    void testDraw() {
        clearDeck();
        assertThrows(IllegalStateException.class, new Executable() {
            @Override 
            public void excute() throws Throwable {
                aDeck.draw();
            }
        });
    }

    @Test
    void testConfigurationDeck() {
        Stub stub = new Stub();
        new Deck(stub);
        assertTrue(stub.aTriggered);
    }

    public class Stub implements Predicate<Card> {
        private boolean aTriggered = false;

        @Override 
        public boolean test(Card t) {
            aTriggered =true;
            return true;
        }
    }
}
