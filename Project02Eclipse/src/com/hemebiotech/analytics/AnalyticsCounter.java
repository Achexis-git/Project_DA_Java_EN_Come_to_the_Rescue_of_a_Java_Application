package com.hemebiotech.analytics;

import java.util.List;

/**
 * Main class
 * 
 * @version 2.0
 * @author Alexis Rouvroy
 *
 */
public class AnalyticsCounter {

	/**
	 * Main method that create and use two objects :
	 * <ul>
	 * <li>First class read the symptoms file and create a list of Strings</li>
	 * <li>Second class count the occurrences and write the result on a file</li>
	 * </ul>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();

		WriteResultsInFile writer = new WriteResultsInFile("Project02Eclipse/result.out", symptoms);

		writer.countSymptomsAndWriteFile();

		System.out.println("The end");
	}
}
