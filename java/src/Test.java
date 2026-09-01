import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; 
import java.util.HashMap;

public class Test {

	private static final String TEXT = "Lorem ipsum dolor sit amet, "
			+ "consectetur adipiscing elit. Nunc quis tempor tellus. Nulla "
			+ "tincidunt pretium justo non finibus. Fusce quis bibendum ante. "
			+ "Vivamus a ex maximus, iaculis nunc eu, posuere augue. Vestibulum "
			+ "ante ipsum primis in faucibus orci luctus et ultrices posuere "
			+ "cubilia Curae; Nullam ut lorem metus. Vivamus consequat eros "
			+ "sed lorem rhoncus finibus. Sed porta euismod consequat. Etiam "
			+ "sodales accumsan nulla, non pretium ex tincidunt eget. Aliquam "
			+ "nibh erat, tristique vel augue sit amet, sodales sollicitudin leo. "
			+ "Mauris in arcu volutpat, efficitur erat imperdiet, finibus dolor. "
			+ "Vestibulum a dolor sed justo tempor elementum. Pellentesque eu "
			+ "tincidunt ex, et posuere orci. Phasellus non nibh non nibh pharetra "
			+ "lobortis. ";

    static List<String> words = new ArrayList<String>(Arrays.asList(TEXT.toLowerCase().split("[\\s,.]+")));

    static HashMap<String, Integer> counts = new HashMap<String, Integer>();

    static int max = 0;
    static String frequentWord = "";

    public static void main(String[] args) {
        makeCount();
        frequency();

        System.out.println("Most frequent: \"" + frequentWord + "\" (" +  max + " occurrences)");
    }

    static void makeCount() {
        for (String word : words) {
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word,1);
            }
        }
    }

    static void frequency() {
        for (String word : counts.keySet()) {
            int count = counts.get(word);
            if (count > max) {
                max = count;
                frequentWord = word;
            }
        }
    }
}