public class App {
    public static void main(String[] args) throws Exception {
        double test = 4 * ( 1.0 - 1.0 / 3.0 + 1.0 / 5.0 - 1.0 / 7.0 + 1.0 / 9.0 - 1.0 / 11.0 + 1.0 / 13.0 );
        int testTwo = 4 * ( 1 - 1 / 3 + 1 / 5 - 1 / 7 + 1 / 9 - 1 / 11 + 1 / 13 );

        System.out.println(test);
        System.out.println(testTwo);

        /*
        the different between the first and second line
        is that the first one is going to output a double,
        while the second one outputs an int

        I believe that the first one gives a better result
        because it gives you the actual answer as the problem
        contains division of things like 1/3, 1/5, and 1/9
        */
    }
}
