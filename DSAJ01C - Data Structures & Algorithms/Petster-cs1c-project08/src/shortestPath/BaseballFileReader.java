package shortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * A File Reader Class for converting CSV lines to Connection Objects
 *
 * @author Jason Palmeri
 */
public class BaseballFileReader {
    /**
     * Parses csv text file and converts each line into a Connection object and
     * inserts it into an array
     *
     * @param filePath the file to parse
     * @return new ArrayList<Connection>
     */
    public ArrayList<Connection> readFile(String filePath) {
        ArrayList<Connection> baseballList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] temp = line.split(",");
                Connection con = new Connection(temp[0].trim(), temp[1].trim(), Integer.parseInt(temp[2].trim()));
                baseballList.add(con);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return baseballList;
    }
}
