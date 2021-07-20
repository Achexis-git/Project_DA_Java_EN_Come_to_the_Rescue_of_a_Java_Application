package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h1>Counts symptoms and write them in a file</h1>
 * 
 * @version 1.0
 * @author Alexis Rouvroy
 *
 */

public class WriteResultsInFile implements ISymptomWriter {
	/**
	 * filepath to save the symptoms
	 * 
	 * @see WriteResultsInFile#writeFile(Map)
	 */
	private String filepath;

	/**
	 * List of symptoms
	 * 
	 * @see WriteResultsInFile#writeDictionnary()
	 */
	private List<String> symptoms;

	/**
	 * WriteResultsInFile constructor
	 * <p>
	 * At the construction, the filepath and the list of symptoms is given to the
	 * constructor
	 * </p>
	 * 
	 * @param filepath Save file path
	 * @param symptoms List of symptoms
	 * 
	 * @see WriteResultsInFile#filepath
	 * @see WriteResultsInFile#symptoms
	 */
	public WriteResultsInFile(String filepath, List<String> symptoms) {
		this.filepath = filepath;
		this.symptoms = symptoms;
	}

	@Override
	public void countSymptomsAndWriteFile() {
		// Counts the symptoms
		Map<String, Integer> dictSymptoms = createDictOfSymptoms();
		// Saves the result
		writeFile(dictSymptoms);
	}

	/**
	 * Creates a sorted dictionary
	 * <p>
	 * Each key is a symptom and the value associated is the number of occurrences
	 * of this symptom in the attribute "symptoms"
	 * </p>
	 * 
	 * @see WriteResultsInFile#symptoms
	 * @return The dictionary
	 */
	private Map<String, Integer> createDictOfSymptoms() {
		// Map containing the symptom as key and the number of occurrences as value
		Map<String, Integer> dictSymptoms = new TreeMap<String, Integer>();

		// Browses the list of symptoms
		for (String symptom : symptoms) {
			// If the symptom is already in dictSymptoms
			if (dictSymptoms.containsKey(symptom)) {
				// Adds 1 to the corresponding value
				dictSymptoms.put(symptom, dictSymptoms.get(symptom) + 1);
			} else {
				// Adds the new symptom as key and set the value to 1
				dictSymptoms.put(symptom, 1);
			}
		}

		return dictSymptoms;
	}

	/**
	 * Saves the content of the dictionary
	 * <p>
	 * Writes the content of the parameter in a file situated with the attribute
	 * "filepath"
	 * 
	 * @see WriteResultsInFile#filepath
	 * 
	 * @param dictSymptoms Dictionary with the symptom as key and the number of
	 *                     occurrences as values
	 */
	private void writeFile(Map<String, Integer> dictSymptoms) {
		if (filepath != null) {
			try (FileWriter writer = new FileWriter(filepath)){

				String key;
				Integer value;

				// Browses dictSymptoms
				for (Map.Entry<String, Integer> entry : dictSymptoms.entrySet()) {
					// For each dictionnary entry, we get the key and the value and write them down
					// on the file
					key = entry.getKey();
					value = entry.getValue();
					writer.write(key + ": " + value + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
