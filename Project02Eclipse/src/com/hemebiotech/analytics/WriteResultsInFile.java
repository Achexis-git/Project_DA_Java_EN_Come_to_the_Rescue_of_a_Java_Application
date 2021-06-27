package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class WriteResultsInFile {
	private String filepath;
	private List<String> symptoms;
	
	public WriteResultsInFile(String filepath, List<String> symptoms) {
		this.filepath = filepath;
		this.symptoms = symptoms;
	}
	
	public void writeFile() {
		Map<String, Integer> dictSymptoms = writeDictionnary();
	}
	
	private Map<String, Integer> writeDictionnary() {
		
	}
	
	private void writeFile(Map<String, Integer> dictSymptoms) {
		
	}
}
