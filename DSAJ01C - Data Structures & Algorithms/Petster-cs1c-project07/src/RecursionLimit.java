import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * A class for testing the performance of FHsort's quicksort algorithm
 *
 * @author Jason Palmeri
 */
public class RecursionLimit {
    /**
     * The main method contains an Outer loop, middle loop and inner loop to test the functionality
     * of several sized arrays from 20,000 to 10,000,000
     *
     * Creates an array of random numbers, clones it, sorts it and repeats that 3 times to get an average time (in nanoseconds)
     *
     * Finally, it exports the data to type RecursionData and puts that into an ArrayList which gets ported to ExcelReader
     * */
    public static void main(String[] args) throws IOException {
        // Set default values
        int recursionStart = 2;
        int recursionMax = 300;
        int recursionIncrement = 2;
        int testTrials = 3;
        int[] arraySizes = {
                20000,
                30000,
                40000,
                50000,
                60000,
                70000,
                80000,
                90000,
                100000,
                200000,
                300000,
                400000,
                500000,
                600000,
                700000,
                800000,
                900000,
                1000000,
                2000000,
                3000000,
                4000000,
                5000000,
                6000000,
                7000000,
                8000000,
                9000000,
                10000000
        };
        long startTime, avgTime, estTime;

        // final results array for ExcelReader
        ArrayList<RecursionData> results = new ArrayList<>();

        // outer loop goes through all arraySizes and creates an array of empty values with that value
        for(int i = 0; i < arraySizes.length; i++) {
            System.out.println("---\nStarting Size " + arraySizes[i] + " | " + LocalTime.now());
            Integer[] randArray = new Integer[arraySizes[i]];
            // place random integers inside the array
            for(int j = 0; j < arraySizes[i]; j++) {
                randArray[j] = (int) (Math.random() * 100) + 1; //(int) (Math.random() * Integer.MAX_VALUE);
            }
            // begin recursion testing, starting from 2 while less than 300 going up by 2
            for(int k = recursionStart; k <= recursionMax; k += recursionIncrement) {
                FHsort.setRecursionLimit(k);
                avgTime = 0;
                // inner loop clones the array (we have to do this test 3 times so we want to clone it without touching the original array)
                // start timer and quickSort
                for(int n = 0; n < testTrials; n++) {
                    Integer[] temp = randArray.clone();
                    startTime = System.nanoTime();
                    FHsort.quickSort(temp);
                    estTime = System.nanoTime() - startTime;
                    avgTime += estTime;
                }
                // get the average time and add to results array
                avgTime /= 3;
                //System.out.println(arraySizes[i] + ", " + k + ", " + avgTime + "ns");
                results.add(new RecursionData(arraySizes[i], k, avgTime));
            }
            System.out.println("Completed Size " + arraySizes[i] + " | " + LocalTime.now() + "\n---\n");
        }
        // create the ExcelReader and create a file
        ExcelReader write = new ExcelReader();
        write.createFile(results);
        System.out.println("\nRecursionLimit Finished");
    }
}
