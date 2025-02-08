package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of a symptom reader that reads symptoms from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * Creates an instance to read a file containing symptom data.
	 * 
	 * @param filepath The path to the source file.
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads the specified file and returns a raw list of symptoms, where each line
	 * in the file corresponds to one symptom.
	 * 
	 * @return A list of symptoms (might contain duplicates).
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();

		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					result.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}