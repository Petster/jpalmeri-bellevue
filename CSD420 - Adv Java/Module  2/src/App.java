/*
    Jason Palmeri
    5/24/22
    Assignment 2
    create a recursive method
*/

public class App {
    public static double m(int i) {
        if (i <= 20) {
            //System.out.println(i + "+(" + i + "/" + (i + 1) + ")");
            return i + (i/m(i + 1));
          } else {
            return 0;
          }
    }

    public static void main(String[] args) throws Exception {
        double test1 = m(4);
        double test2 = m(9);
        double test3 = m(14);
       
        System.out.println(test1 + "\n-------------");
        System.out.println(test2 + "\n-------------");
        System.out.println(test3 + "\n-------------");
    }
}
