package lecture2;

public class Client {
        public static void main(String[] args) {

        // Create a random card
        Card card = new Card(-1, Suit.CLUBS);
        /* 
        int card = RANDOM.nextInt(52); // This is PRIMITIVE OBSESSION
            Design has to be easy to understand
            Primitive Obessesion, no one can understand
         */


        // Print a string representation of the card
        System.out.println(card);

        // Select the next card in the sequence
        Card next = card.next(); // This is PRIMITIVE OBSESSION
        System.out.println(next);
    }
}
