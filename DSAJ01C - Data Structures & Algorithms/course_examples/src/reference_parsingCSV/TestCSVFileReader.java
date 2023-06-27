package reference_parsingCSV;

/**
 * Reads an input file and creates an array of temperatures.
 */
public class TestCSVFileReader
{
	/**
	 * Creates an object of type TemperaturesCSVFileReader to read an input file
	 * in which stores temperatures in Comma Separated Value (CSV) format.
	 * @param args  Not used.
	 */
	public static void main(String[] args)
	{
		// TODO: Test on different input files and share your output in RUN.txt
		// Note: This requires manually changing your test file and
		//       adding a comment in your RUN.txt clarifying the output of which test file
		//       you have pasted.
		// The path and name of the input file
		final String filename = "resources/example_csv_input/temperatures01.csv";
		//final String filename = "resources/example_csv_input/temperatures_invalid01.csv";
		//final String filename = "resources/example_csv_input/temperatures_invalid02.csv";
		
		// Now, try reading from the input file
		TemperaturesCSVReader reader;

		// parses a CSV file
		reader = new TemperaturesCSVReader(filename);
		
		// Get the data parsed
		MonthlyTemperature temperatures[] = reader.getTemperatures();

		// Iterate over the data
		for(int currentMonth = 0; currentMonth < temperatures.length; currentMonth++)
		{
			System.out.println(temperatures[currentMonth]);
		}
	}
}
