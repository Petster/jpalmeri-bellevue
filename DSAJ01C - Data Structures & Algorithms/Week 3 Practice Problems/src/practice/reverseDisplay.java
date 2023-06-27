package practice;

import java.util.List;

public class reverseDisplay {
    public static void reverseDisplay(String x) {
        if(x.length() == 0) {
            return;
        }

        System.out.print(x.substring(x.length()-1, x.length()));
        reverseDisplay(x.substring(0, x.length() -1));
    }
    public static void reverseDisplayRevised(String x) {
        reverseDisplay(x, x.length());
    }
    public static void reverseDisplay(String x, int high) {
        if(high == 0) {
            return;
        }

        System.out.print(x.charAt(high-1));
        reverseDisplay(x, high-1);
    }
    public static void main(String[] args) {
        reverseDisplay("Hello");
        System.out.println();
        reverseDisplayRevised("Hello World");
    }
}
