/*
    Jason Palmeri
    Assignment 4
    1/9/22
    Checks if string one contains word from string two, and if string two contains word from word one
*/
import java.util.Scanner;

public class App {

    static String checkString(String one, String two) {
        String oneLower = one.toLowerCase();
        String twoLower = two.toLowerCase();

        String result = "";
        String result2 = "";

        //check 1
        if(oneLower.contains(twoLower)) {
            result = "'" + twoLower + "' was found in '" + oneLower + "'";
        } else {
            result = "'" + twoLower + "' was not found in '" + oneLower + "'";
        }

        //check 2
        if(twoLower.contains(oneLower)) {
            result2 = "'" + oneLower + "' was found in '" + twoLower + "'";
        } else {
            result2 = "'" + oneLower + "' was not found in '" + twoLower + "'";
        }

        String finalS = result + "\n" + result2;

        return finalS;
    }

    public static void main(String[] args) {
       Scanner string1 = new Scanner(System.in);
       Scanner string2 = new Scanner(System.in);

       System.out.println("Enter First String:");
       String userString1 = string1.nextLine();

       System.out.println("Enter Second String:");
       String userString2 = string2.nextLine();

       System.out.println("------------------------");
       System.out.println(checkString(userString1, userString2));
    }
}
