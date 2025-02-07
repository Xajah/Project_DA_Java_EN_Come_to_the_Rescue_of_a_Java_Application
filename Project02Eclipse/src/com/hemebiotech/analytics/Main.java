package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Veuillez saisir le chemin du fichier à lire : ");
            String filepathRead = scanner.nextLine();
            scanner.close();
        try {
            
            ISymptomWriter writer = new WriteSymptomDataToFile();
            ISymptomReader reader = new ReadSymptomDataFromFile(filepathRead);

            
            AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

            
            List<String> symptoms = analyticsCounter.getSymptoms();
            Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
            Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
            analyticsCounter.writeSymptoms(sortedSymptoms);

        } catch (Exception e) {
           
            System.out.println("Erreur : Impossible de lire le fichier spécifié. Vérifiez le chemin du fichier : " + filepathRead);
            
        }
    }
}
