package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
    
    
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter("result.out")) {
            
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String symptom = entry.getKey(); // Récupérer le nom du symptôme
                int count = entry.getValue();    // Récupérer la quantité du symptôme
                
                writer.write(symptom + ": " + count + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // exceptions ecriture fichier
        }
    }
}