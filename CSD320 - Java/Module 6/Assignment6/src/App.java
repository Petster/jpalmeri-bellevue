/*
    Jason Palmeri
    Assignment 6
    1/16/22
    Nested Loops Pyramid
*/

public class App {
    public static void main(String[] args) {
        int multiplier = 1;
        int space = 18;
        for (int i = 1; i <= 7; ++i) {
            for (int j = space; j > i - 1; --j) {
                System.out.print(" ");
            }
            System.out.print(" ");
            for (int k = 1; k < multiplier; k=k*2) {
                System.out.print(k + " ");
            }
            for (int k = multiplier; k >= 1; k=k/2) {
                System.out.print(k + " ");
            }
            for (int j = space; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print("@");
            System.out.println();
            multiplier *= 2;
            //i spent so long trying to figure out how to get the @'s to line up, how should I have done this?
            if(space > 14) {
                space -= 1;
            } else {
                space -= 2;
            }
        }
    }
}
