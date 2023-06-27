package reference_parsingCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * An object of type FileReader parses a input file which stores months and
 * temperatures in the following Comma Separated Values (CSV) format:
 * Historic Average High Temperatures...
 * [month],[year]
 */
public class TemperaturesCSVReader 
{	
	private final int NUM_MONTHS = 12;
	private MonthlyTemperature[] temperatures = null;
	private int year;

	/**
	 * Receives the name of the file (including directory path information) from the caller.
	 * Sets the parsed data to temperatures.
	 *
	 * @param filename
	 */
	public TemperaturesCSVReader(String filename)
	{		
        // Instantiates a File object given a file path
		File infile = new File(filename);

		// Creates an object of type from the input file.
		Scanner input = null;
		try
		{
			input = new Scanner(infile);

			// Parses the temperatures read from the input file.
			temperatures = parseInput(input);

			// close the file when all data has been read
			input.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Converts the lines from the data file into an array of MonthlyTemperature objects.
	 * @param source The file to be scanned. 
	 * @return  The array of parsed temperatures.
	 * @throws NumberFormatException  If the format of the year(s) list is invalid.
	 * @throws ArrayIndexOutOfBoundsException  If the specified month does not exist.
	 */
	private MonthlyTemperature[] parseInput(Scanner source)
	{
		MonthlyTemperature [] temperatures = new MonthlyTemperature[NUM_MONTHS] ;

		String header = source.nextLine();
		// Assume the first row is the title of the file
		if (header.contains("Historic Average"))
		{	
			// Note: For now we just print the title of the data
			System.out.println(header);
		}
		
		header = source.nextLine();
		// Assume the second row is the source of the data
		if (header.contains("Source"))
		{	
			// Note: For now we just print the source
			System.out.println(header);
		}
		
		header = source.nextLine();
		// Assume the third row is the year for the data
		if (header.contains("Year"))
		{	
			String [] tokens = header.split(",");
			String tmp = tokens[1];

			// May throw NumberFormatException, for when the second token is not a valid year due
			// to a badly formated file.
			// Note: Assume an invalid year is anything that cannot be parsed into an int value.
			try
			{
				year = Integer.parseInt(tmp);
			}
			catch(NumberFormatException exc)
			{
				System.err.println("Warning: Malformed line at " + header);
			}
		}

        // Parses the data portion of the file
		while (source.hasNextLine()) 
		{
			String line = source.nextLine();

	        // Tokenize the String by commas "," and store into an array.
	        // for more details see Javadocs:
	        // https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/String.html#split(java.lang.String)
			String [] tokens = line.split(",");
			
			// The first token is the month.
			String month = tokens[0];

			// The second token is the temperature(s).
			String parsedTemperature = tokens[1];

			int temperature;
			// May throw a NumberFormatException, for when the second token is not a valid format due
			// to a badly formated file.
			// Note: Assume an invalid year is anything that cannot be parsed into an int value
			try
			{
				temperature = Integer.parseInt(parsedTemperature);
			}
			catch(NumberFormatException exc)
			{
				System.err.println("Warning: Malformed line at " + header);
				continue;
			}

			// Instantiates a new object to store the temperature and the associated year and month.
			MonthlyTemperature currentMonth = new MonthlyTemperature(year,month, temperature);

			// Stores the temperature in the index representing the month.
			switch(month)
			{
			case "January": 
				temperatures[0] = currentMonth;
				break;
			case "February": 
				temperatures[1] = currentMonth;
				break;
			case "March": 
				temperatures[2] = currentMonth;
				break;
			case "April": 
				temperatures[3] = currentMonth;
				break;
			case "May": 
				temperatures[4] = currentMonth;
				break;
			case "June": 
				temperatures[5] = currentMonth;
				break;
			case "July": 
				temperatures[6] = currentMonth;
				break;
			case "August": 
				temperatures[7] = currentMonth;
				break;
			case "September": 
				temperatures[8] = currentMonth;
				break;
			case "October": 
				temperatures[9] = currentMonth;
				break;
			case "November": 
				temperatures[10] = currentMonth;
				break;
			case "December": 
				temperatures[11] = currentMonth;
				break;
			}
		}
		return temperatures;
	}

	/**
	 * Getter method for the temperatures.
	 * @return An array of temperatures.
	 */
	public MonthlyTemperature[] getTemperatures()
	{
		return temperatures;
	}
}
