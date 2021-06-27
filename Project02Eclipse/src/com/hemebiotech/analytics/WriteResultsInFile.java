package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.IOException;

public class WriteResultsInFile {
	private String filepath;
	private List<String> symptoms;

	public WriteResultsInFile(String filepath, List<String> symptoms) {
		this.filepath = filepath;
		this.symptoms = symptoms;

		// Maybe create the dictionnary directly in the constructor ?
	}

	public void writeFile() {
		Map<String, Integer> dictSymptoms = writeDictionnary();
		writeFile(dictSymptoms);
	}

	private Map<String, Integer> writeDictionnary() {
		Map<String, Integer> dictSymptoms = new TreeMap<String, Integer>();
		String symptom = "";

		for (int i = 0; i < symptoms.size(); i++) {
			symptom = symptoms.get(i);
			if (dictSymptoms.containsKey(symptom)) { // If the symptom is already in the dictionnary
				dictSymptoms.put(symptom, dictSymptoms.get(symptom) + 1); // add 1 to the corresponding value
			} else { // add a new key and set the value to 1
				dictSymptoms.put(symptom, 1);
			}
		}
		
		return dictSymptoms;
	}

	private void writeFile(Map<String, Integer> dictSymptoms) {
		
		if (filepath != null) {
			try {
				FileWriter writer = new FileWriter(filepath);
				
				String key;
				Integer value;
				
				for (Map.Entry<String, Integer> entry : dictSymptoms.entrySet()) {
					key = entry.getKey();
					value = entry.getValue();
					writer.write(key + ": " + value + "\n");
				}	
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}








