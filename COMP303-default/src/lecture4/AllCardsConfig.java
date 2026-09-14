package lecture4;

public class AllCardsConfig implements DeckConfigurator {

    @Override
    public boolean accept(Card pCard) {
        return true;
    }

}
