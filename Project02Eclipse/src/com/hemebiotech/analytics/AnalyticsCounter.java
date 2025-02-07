package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	
   public AnalyticsCounter(ISymptomReader symptomReader,ISymptomWriter symptomWriter) {
	   this.reader = symptomReader;
	   this.writer = symptomWriter;
	   
   };
   
   public List<String> getSymptoms() { 
	   List<String> symptoms = reader.GetSymptoms();
	   return symptoms;
   };
   
   public Map<String, Integer> countSymptoms(List<String> symptoms) {
	   Map<String, Integer> symptomCounts = new HashMap<>();
	    for (String symptom: symptoms) {
	    	//if already exist on map/
	    	
	    	if (symptomCounts.containsKey(symptom)) {
	    		symptomCounts.put(symptom, symptomCounts.get(symptom)+1);
	    	}
	    	//if not
	    		else {symptomCounts.put(symptom, 1);};}
	    		return symptomCounts;
	    	}
	    	

       
	   public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
	        // Convertir clés de la Map en liste triée
	        List<String> sortedKeys = new ArrayList<>(symptoms.keySet());
	        Collections.sort(sortedKeys); 

	        // Créer la nouvelle Map triée
	        Map<String, Integer> sortedSymptoms = new LinkedHashMap<>(); // LinkedHashMap pour conserver l'ordre
	        for (String key : sortedKeys) {
	            sortedSymptoms.put(key, symptoms.get(key)); // Remplir la nouvelle Map correctement triée
	        };

	        return sortedSymptoms;
	    }
	   
	   public void writeSymptoms(Map<String, Integer> symptoms) {
		   this.writer.writeSymptoms(symptoms);
	   }

       
   
	    
   
   
	
	
}
