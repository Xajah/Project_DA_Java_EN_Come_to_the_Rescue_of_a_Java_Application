package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface defining a symptom reader. Any implementor must provide a method to
 * read and return a list of symptoms from a source.
 */
public interface ISymptomReader {

	/**
	 * Retrieves a list of symptoms from a defined source.
	 * 
	 * @return A list containing symptom names (might contain duplicates). If no
	 *         data is found, an empty list is returned.
	 */
	List<String> getSymptoms();
}