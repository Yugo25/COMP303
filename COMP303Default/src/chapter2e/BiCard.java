package chapter2e;

public class BiCard {
    public boolean aIsRed = false; 
    private boolean aIsSharp = false; // true if the suit shape has a sharp angle
    private boolean aBi1 = false;
    private boolean aBi2 = false;
    private boolean aBi3 = false;
    private boolean aBi4 = false;

    /*
    * Create a new Card object
    *
    * @param pSuit The suit of the card
    * @param pRank The rank of the card
    * @pre pSuit != null
    * @pre pRank != null
    */
    public BiCard(Suit pSuit, Rank pRank) {
        assert pSuit != null && pRank != null;
        fromSuit(pSuit);
        fromRank(pRank);
    }

    /**
     * Initialise the filed from a suit
     * @param pSuit the suit to be transformed
     */
    private void fromSuit(Suit pSuit) {
        if (pSuit == Suit.DIAMONDS || pSuit == Suit.HEARTS) {
            aIsRed = true;
        }
        if (pSuit == Suit.DIAMONDS || pSuit == Suit.SPADES) {
            aIsSharp = true;
        }
    }

    /**
     * Initialise the filed from a rank
     * @param pRank the rank to be transformed
     */
    private void fromRank(Rank pRank) {
        int value = pRank.ordinal();

        aBi1 = (value % 2 == 1);
        value /= 2;
        aBi2 = (value % 2 == 1);
        value /= 2;
        aBi3 = (value % 2 == 1);
        value /=2;
        aBi4 = (value % 2 == 1);
    }

    public Suit suit() {
        if (aIsRed) {
            if (aIsSharp) {
                return Suit.DIAMONDS;
            } else {
                return Suit.HEARTS;
            }
        } else {
            if (aIsSharp) {
                return Suit.SPADES;
            } else {
                return Suit.CLUBS;
            }
        }
    }

    public Rank rank() {
        int value = 0;
        if (aBi1) {
            value += 1;
        }
        if (aBi2) {
            value += 2;
        }
        if (aBi3) {
            value += 4;
        }
        if (aBi4) {
            value += 8;
        }
        return Rank.values()[value];

    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank(), suit());
    }
}
