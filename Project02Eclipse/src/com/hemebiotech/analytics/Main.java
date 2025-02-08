package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class - Entry point of the application. This class executes the program
 * by instantiating the necessary classes to read, process, and save the results
 * related to symptoms.
 */
public class Main {

	/**
	 * Main method of the program. This method:
	 * <ul>
	 * <li>Prompts the user to provide the path to the source file.</li>
	 * <li>Instantiates the main components (reading, processing, writing).</li>
	 * <li>Performs steps to read data, count symptoms, sort them alphabetically,
	 * and write the results to a file.</li> If an error occurs (e.g., the file path
	 * is not readable), an error message is displayed.
	 * </ul>
	 * 
	 * @param args The arguments passed via command line (not used in this
	 *             application).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the path to the file to read:");
		String filepathRead = scanner.nextLine();
		scanner.close();

		try {
			ISymptomWriter writer = new WriteSymptomDataToFile();
			ISymptomReader reader = new ReadSymptomDataFromFile(filepathRead);

			AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

			List<String> symptoms = analyticsCounter.getSymptoms();
			Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
			Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
			analyticsCounter.writeSymptoms(sortedSymptoms);

			System.out.println("Processing completed successfully!");
		} catch (Exception e) {
			System.err.println("Error: Unable to read the specified file. Please check the file path: " + filepathRead);
			e.printStackTrace();
		}
	}
}