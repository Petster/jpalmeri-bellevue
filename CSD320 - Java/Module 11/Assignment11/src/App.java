/*
    Jason Palmeri
    Assignment 11
    2/04/2022
    find largest number in one and two D arrays
    https://stackoverflow.com/questions/19648240/java-best-way-to-print-2d-array reference for printing array pretty
    
*/

import java.util.Arrays;
import java.util.Random; 

public class App {

    public static int [] locateLargest(double array[][]) {
        //set starting number to minimum a double can be
        double largestNum = Double.MIN_VALUE;
        int indexOne = 0;
        int indexTwo = 0;

        //find largest num and its index's
        for(int i = 0; i < 3; i++) {
            for(int j =0; j < 3; j++) {
                if(array[i][j] > largestNum) {
                    largestNum = array[i][j];
                    indexOne = i;
                    indexTwo = j;
                }
            }
        }

        //create return array
        int finalArray[] = {indexOne, indexTwo};

        return finalArray;
    }

    public static int [] locateLargest(int array[][]) {
        int largestNum = Integer.MIN_VALUE;
        int indexOne = 0;
        int indexTwo = 0;

        for(int i = 0; i < 3; i++) {
            for(int j =0; j < 3; j++) {
                if(array[i][j] > largestNum) {
                    largestNum = array[i][j];
                    indexOne = i;
                    indexTwo = j;
                }
            }
        }

        int finalArray[] = {indexOne, indexTwo};

        return finalArray;
    }

    public static int [] locateSmallest(double array[][]) {
        double smallestNum = Double.MAX_VALUE;
        int indexOne = 0;
        int indexTwo = 0;

        for(int i = 0; i < 3; i++) {
            for(int j =0; j < 3; j++) {
                if(array[i][j] > smallestNum) {
                    smallestNum = array[i][j];
                    indexOne = i;
                    indexTwo = j;
                }
            }
        }

        int finalArray[] = {indexOne, indexTwo};

        return finalArray;
    }

    public static int [] locateSmallest(int array[][]) {
        int smallestNum = Integer.MAX_VALUE;
        int indexOne = 0;
        int indexTwo = 0;

        for(int i = 0; i < 3; i++) {
            for(int j =0; j < 3; j++) {
                if(array[i][j] > smallestNum) {
                    smallestNum = array[i][j];
                    indexOne = i;
                    indexTwo = j;
                }
            }
        }

        int finalArray[] = {indexOne, indexTwo};

        return finalArray;
    }

    public static void main(String[] args) {
        Random randNum = new Random();
        int twoDInt[][] = new int[3][3];
        double twoDDouble[][] = new double[3][3];

        //fill two 3x3 arrays
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                twoDInt[i][j] = randNum.nextInt(500);
                twoDDouble[i][j] = randNum.nextDouble(500.00);
            }
        }

        //display 3x3 arrays
        System.out.println(Arrays.deepToString(twoDInt).replace("], ", "]\n"));
        System.out.println("");
        System.out.println(Arrays.deepToString(twoDDouble).replace("], ", "]\n"));
        System.out.println("");

        //apply functions
        System.out.print("Largest Double: ");
        int largestD[] = locateLargest(twoDDouble);
        for(int i = 0; i < largestD.length; i++) {
            System.out.print(largestD[i] + " ");
        }
        System.out.println("");
        System.out.print("Largest Int: ");
        int largestI[] = locateLargest(twoDInt);
        for(int i = 0; i < largestI.length; i++) {
            System.out.print(largestI[i] + " ");
        }
        System.out.println("");
        System.out.print("Smallest Double: ");
        int smallestD[] = locateSmallest(twoDDouble);
        for(int i = 0; i < smallestD.length; i++) {
            System.out.print(smallestD[i] + " ");
        }
        System.out.println("");
        System.out.print("Smallest Int: ");
        int smallestI[] = locateSmallest(twoDInt);
        for(int i = 0; i < smallestI.length; i++) {
            System.out.print(smallestI[i] + " ");
        }

    }
}
