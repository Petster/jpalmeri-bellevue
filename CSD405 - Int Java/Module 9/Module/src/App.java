/*
    Jason Palmeri
    4/02/2022
    Assignment9
    Demonstrate Lambda Expressions
*/

import java.util.ArrayList;

interface StringFunction {
    String run(String str);
}

public class App {
    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("\n---------------\nArray Printing using Lambda\n---------------");
        //create array add numbers
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(1);
        num.add(5);
        num.add(9);
        num.add(3);
        num.add(6);
        num.add(0);

        //display numbers using lambda expression
        num.forEach((n) -> {System.out.print(n + " ");});

        System.out.println("\n---------------\nInterface Method using Lambda\n---------------");
        //create instances of StringFunction using lambda expressions
        StringFunction ex = (s) -> s + "!";
        StringFunction qu = (s) -> s + "?";
        //print using printFormatted method
        printFormatted("Hello", ex);
        printFormatted("How are you", qu);

    }
}
