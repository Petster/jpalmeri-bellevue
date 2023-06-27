package week02_part01;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        String line = "When Harry Met Sally X Wild Beast X La Femme Nikita X Back To The Future X";
        List<String> wordAsList = Arrays.asList(line.split("\\s* \\s*"));
        FHarrayList<String> myStrings = new FHarrayList<>(wordAsList);
        ListIterator<String> iter = myStrings.listIterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("--------------------");

        while(iter.hasPrevious()) {
            System.out.println(iter.previous());
        }

        System.out.println("--------------------");

        while(iter.hasNext()) {
            String temp = iter.next();
            if(temp.equals("X")) {
                iter.set("Q");
            }
        }

        iter = myStrings.listIterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
