package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface defining a writer to save symptoms and their occurrences to a
 * source.
 */
public interface ISymptomWriter {

	/**
	 * Writes symptom data to a medium in a defined format.
	 * 
	 * @param symptoms A Map containing symptoms and their number of occurrences.
	 */
	void writeSymptoms(Map<String, Integer> symptoms);
}