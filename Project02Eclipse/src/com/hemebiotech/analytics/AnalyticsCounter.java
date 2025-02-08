package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class used to analyze and format symptom data. It provides methods for:
 * <ul>
 * <li>Retrieving a raw list of symptoms from a source file.</li>
 * <li>Counting the occurrences of symptoms in a Map.</li>
 * <li>Sorting symptoms alphabetically.</li>
 * <li>Saving the results to a file.</li>
 * </ul>
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Initializes a new instance of AnalyticsCounter.
	 * 
	 * @param symptomReader Reader used to retrieve symptom data.
	 * @param symptomWriter Writer used to save results to a file.
	 */
	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
		this.reader = symptomReader;
		this.writer = symptomWriter;
	}

	/**
	 * Retrieves the raw list of symptoms from the source file.
	 * 
	 * @return A list containing the names of symptoms (with duplicates).
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Counts the number of occurrences of each symptom in the provided list.
	 * 
	 * @param symptoms A raw list of symptoms to analyze.
	 * @return A Map containing each symptom and its number of occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	/**
	 * Sorts symptoms alphabetically.
	 * 
	 * @param symptoms A Map containing symptoms and their number of occurrences.
	 * @return A Map sorted alphabetically by keys (symptoms).
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		List<String> sortedKeys = new ArrayList<>(symptoms.keySet());
		Collections.sort(sortedKeys);

		Map<String, Integer> sortedSymptoms = new LinkedHashMap<>();
		for (String key : sortedKeys) {
			sortedSymptoms.put(key, symptoms.get(key));
		}
		return sortedSymptoms;
	}

	/**
	 * Saves the results (counted and sorted symptoms) to a file.
	 * 
	 * @param symptoms A Map containing the sorted symptoms and their frequency.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}