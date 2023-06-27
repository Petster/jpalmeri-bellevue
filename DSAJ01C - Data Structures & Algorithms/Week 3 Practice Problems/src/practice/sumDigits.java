package practice;

import java.util.Scanner;

public class sumDigits {
    public static int sumDigits(int x) {
        if(x == 0) {
            return 0;
        }
        System.out.print(x % 10 + (String.valueOf(x).length() > 1 ? " + " : " = "));
        return (x % 10) + sumDigits(x / 10);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to calculate");
        int num = input.nextInt();
        System.out.println(sumDigits(num));
    }
}
