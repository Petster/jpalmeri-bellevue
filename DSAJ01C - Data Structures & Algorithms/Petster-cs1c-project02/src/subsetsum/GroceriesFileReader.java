package subsetsum;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * An object of type GroceriesFileReader class creates a file reader for plain text documents with
 * comma delimited values
 *
 * @author Foothill College, Jason Palmeri
 */
public class GroceriesFileReader {
    /**
     * readFile method, reads file based on provided filePath
     * and parses the data into an ArrayList
     * @param filePath user provided path of data to parse
     */
    public ArrayList<Double> readFile(String filePath) {
        ArrayList<Double> groceryList = new ArrayList<>();

        try {
            File listFile = new File(filePath);
            Scanner scanner = new Scanner(listFile);
            while(scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                double price = Double.parseDouble(data[1]);
                groceryList.add(price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return groceryList;
    }
}
