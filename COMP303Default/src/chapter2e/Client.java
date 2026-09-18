package chapter2e;

public class Client {
    public static void main(String[] args) {
        Card card = new Card(Suit.CLUBS, Rank.ACE);

        System.out.println(card);
    }
}
