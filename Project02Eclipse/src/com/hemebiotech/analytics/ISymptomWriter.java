package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Output class allowing to save the number of symptoms occurrences in a file
 * 
 * @version 1.0
 * @author Alexis Rouvroy
 *
 */

public interface ISymptomWriter {
	
	/**
	 * Take the list of symptoms, count them, and write the result in a file.
	 * <ul>
	 * <li>First method used count the symptoms</li>
	 * <li>Second method write the result in a file</li>
	 * </ul>
	 * 
	 * @see WriteResultsInFile#symptoms
	 * @see WriteResultsInFile#filepath
	 * 
	 * @see WriteResultsInFile#writeDictionnary()
	 * @see WriteResultsInFile#writeFile(Map)
	 */
	void countSymptomsAndWriteFile();

}
