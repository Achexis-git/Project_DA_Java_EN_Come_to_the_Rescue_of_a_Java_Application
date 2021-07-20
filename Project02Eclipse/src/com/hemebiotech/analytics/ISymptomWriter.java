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
	 * Takes the list of symptoms, counts them, and writes the result in a file.
	 * <ul>
	 * <li>First method used counts the symptoms</li>
	 * <li>Second method writes the result in a file</li>
	 * </ul>
	 * 
	 * @see WriteResultsInFile#symptoms
	 * @see WriteResultsInFile#filepath
	 * 
	 * @see WriteResultsInFile#createDictOfSymptoms()
	 * @see WriteResultsInFile#writeFile(Map)
	 */
	void countSymptomsAndWriteFile();

}
