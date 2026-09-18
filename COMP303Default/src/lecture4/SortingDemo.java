package lecture4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDemo {

    static List<String> MONTHS = new ArrayList<>(List.of("January", "March", "February", "april", "may"));

    public static void main(String[] args) {
        Collections.sort(MONTHS, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        });

        System.out.println(MONTHS);
    }
}
