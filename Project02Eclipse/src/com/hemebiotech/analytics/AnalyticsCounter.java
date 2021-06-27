package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {	
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();
		
		WriteResultsInFile writer = new WriteResultsInFile("Project02Eclipse/result.out", symptoms);
		
		writer.countSymptomsAndWriteFile();
		
		System.out.println("end");
	}
}
