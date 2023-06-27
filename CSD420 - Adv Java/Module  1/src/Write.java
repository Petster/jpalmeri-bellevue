/*
    Jason Palmeri
    5/24/21
    Assignment 1
    Write 2 arrays and date to a file
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Write {
    public static int[] createArray() {
        Random rand = new Random();

        int[] myNums = new int[5];

        for(int i = 0; i < 5; i++) {
            myNums[i] = rand.nextInt(100);
        }

        return myNums;
    }

    public static double[] createDoubleArray() {
        Random rand = new Random();

        double[] myNums = new double[5];

        for(int i = 0; i < 5; i++) {
            myNums[i] = rand.nextDouble(100);
        }

        return myNums;
    }

    public static String createDate() {
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        Date theDate = new Date();

        String newDate = df.format(theDate);

        return newDate;
    }
    
    public static void main(String[] args) throws Exception {

        int[] intNums = createArray();
        double[] doubleNums = createDoubleArray();
        String date = createDate();
        File datafile = new File("jpalmeri_datafile.dat");

        PrintWriter writer = new PrintWriter(datafile);
        writer.println(date);

        for(int i = 0; i < intNums.length; i++) {
            writer.println(intNums[i]);
        }

        for(int i = 0; i < doubleNums.length; i++) {
            writer.println(doubleNums[i]);
        }

        writer.close();
    }
}
