package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		/*
		Map<String, Integer> compteSymptomes = new HashMap<String, Integer>();
		readFile(compteSymptomes);
		
		writeResult(compteSymptomes);
		*/
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();
		
		WriteResultsInFile writer = new WriteResultsInFile("Project02Eclipse/result.out", symptoms);
		
		writer.writeFile();
		
		System.out.println("end");
		
		/*
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0; // set i to 0
		int headCount = 0; // counts headaches
		while (line != null) {
			i++; // increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			} else if (line.equals("rush")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
		*/
		
	}

	private static void readFile(Map<String, Integer> compteSymptomes) {
		try {
			// 1) Ouvrir le fichier
			BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));

			// 2) Créer le dictionnaire avec les symptômes

			// 3) Boucle qui parcours reader
			String line = reader.readLine();

			while (line != null) {
				// Si le symptome est dans le dictionnaire on incrémente la valeur, sinon on
				// l'ajoute et initialise à 1
				if (compteSymptomes.containsKey(line)) {
					compteSymptomes.put(line, compteSymptomes.get(line) + 1);
				} else {
					compteSymptomes.put(line, 1);
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) { // gestion si problème lors de l'ouverture ou fermeture du fichier
			e.printStackTrace();
		}
	}
	
	private static void writeResult(Map<String, Integer> compteSymptomes) {
		try {
			FileWriter writer = new FileWriter("Project02Eclipse/result.out");
			// Symptoms in alphabetical order
			Map<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(compteSymptomes);
			
			String key;
			Integer value;
			for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
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
