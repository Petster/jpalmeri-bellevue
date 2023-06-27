/*
    Jason Palmeri
    5/24/21
    Assignment 1
    Read from file 2 arrays and date.
*/

import java.io.FileReader;
import java.io.BufferedReader;

public class Read {    
    public static void main(String[] args) throws Exception {
        FileReader datafile = new FileReader("jpalmeri_datafile.dat");

        BufferedReader reader = new BufferedReader(datafile);
        String line = reader.readLine();

        int i = 0;

        while(line != null) {
            switch(i) {
                case 0:
                    System.out.println("Date: " + line);
                    line = reader.readLine();
                    break;
                case 1:
                    System.out.println("Int Array:");
                    break;
                case 7:
                    System.out.println("Double Array:");
                default:
                    System.out.println(line);
                    line = reader.readLine();
                    break;
            }
            //System.out.println(line);
            i++;
        }
        reader.close();

    }
}
