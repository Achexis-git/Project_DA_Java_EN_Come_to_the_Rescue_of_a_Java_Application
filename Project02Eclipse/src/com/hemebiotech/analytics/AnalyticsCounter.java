package com.hemebiotech.analytics;

import java.util.List;

/**
 * Main class
 * Reads "symptoms.txt", count the symptoms and write the result in "result.out"
 * 
 * @version 2.0
 * @author Alexis Rouvroy
 *
 */
public class AnalyticsCounter {

	/**
	 * Main method that creates and uses two objects :
	 * <ul>
	 * <li>First class reads the symptoms file and creates a list of Strings</li>
	 * <li>Second class counts the occurrences and writes the result in a file</li>
	 * </ul>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();

		ISymptomWriter writer = new WriteResultsInFile("Project02Eclipse/result.out", symptoms);

		writer.countSymptomsAndWriteFile();

		System.out.println("The end");
	}
}
