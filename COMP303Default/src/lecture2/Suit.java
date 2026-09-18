package lecture2;

public enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADE;

    public Suit next() {
        return Suit.values()[(this.ordinal() + 1) % Suit.values().length];
    }

    @Override
    public String toString() {
        return name().substring(0, 1) + name().substring(1).toLowerCase();
    }
}
