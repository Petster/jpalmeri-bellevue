/*
    Jason Palmeri
    Assignment 5
    1/9/22
    Calculates a math equation through a loop
*/
public class App {
    public static void main(String[] args) {

       double x = 3;
       double finalN = 1;
       System.out.println("Running Low to High Loop...");
       while(x <= 99) {
        finalN += 1/x;
        //System.out.println("x is " + x + "\n num is " + finalN);
        x += 2;
       }
       System.out.println("Lower to Higher Result = " + finalN);

       finalN = 1;
       x = 99;
       System.out.println("Running High to Low Loop...");
       while(x >= 3) {
        finalN += 1/x;
        //System.out.println("x is " + x + "\n num is " + finalN);
        x -= 2;
       }
       System.out.println("Higher to Lower Result = " + finalN);
    }
}
