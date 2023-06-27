import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A class for reading and writing Excel files
 * Exports Excel files using Y-M-D-H-M-S format (2023-06-07-13-30-50.xlsx)
 *
 * @author Jason Palmeri
 */
public class ExcelReader {
    /**
     * Creates a new Excel file from an arraylist of Recursion Data
     * Creates a Sheet titles 'Results' which holds to data
     *
     * @param data an ArrayList of RecursionData
     * @return 'true' if the file is creates and 'false' otherwise
     */
    public boolean createFile(ArrayList<RecursionData> data) throws IOException {
        // sets the date format to exported name
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();

        // creates a new workbook and adds a "Results" sheet to it
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Results");

        XSSFSheet spreadsheet = workbook.getSheetAt(0);

        // initialize the headers
        int rowNum = 1;
        XSSFRow header = spreadsheet.createRow(0);
        header.createCell(0).setCellValue("Array Size");
        header.createCell(1).setCellValue("Current Increment");
        header.createCell(2).setCellValue("Average Time");

        // go through each RecursionData in the array and maps it to the correct row
        for (RecursionData x : data) {
            XSSFRow row = spreadsheet.createRow(rowNum++);

            Cell cellArraySize = row.createCell(0);
            cellArraySize.setCellValue(x.getArraySize());

            Cell cellCurrentIncrement = row.createCell(1);
            cellCurrentIncrement.setCellValue(x.getRecursionIncrement());

            Cell cellAverageTime = row.createCell(2);
            cellAverageTime.setCellValue(x.getAvgTime());

        }

        // outputs the file to resources using the date format as the name and returns true if successful
        try (FileOutputStream out = new FileOutputStream("resources/" + dtf.format(now) + ".xlsx")) {
            workbook.write(out);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
