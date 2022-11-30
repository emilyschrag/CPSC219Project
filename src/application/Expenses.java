package application;

public class Expenses {
	// instance variables
		private double food;
		private double entertainment;
		private double groceries;
		private double other;
		private double total;
		private double grade;
		private double goal;
		
		//default constructor sets all values to 0
		public Expenses() {
			other = 0.0;
			food = 0.0;
			entertainment = 0.0;
			groceries = 0.0;
			total = 0.0;
			grade = 0.0;
			goal = 0.0;
		}

		public double calculateTotal() {
			if (food == 0.0 || groceries == 0.0 || other == 0.0 || entertainment == 0.0) {
				total = 0.0;
			}
			else {
				total = food + groceries + other + entertainment;
			}
			return total;
		}
		public void calculateGrade(double total1) {
			total = total1;
			if (total == 0.0)
				grade =0.0;
			else {
				grade = total%goal ;
			}
		}
		
		double getGrade() {
			if (total>goal) grade = 100.0;
			return grade;
		}
		
		double getTotal() {
			return total;
		}
		
		double getGoal() {
			return goal;
		}
		
		
		public double getWeightedGrade() {
			if (grade > 100.0) grade = 100.0;
			return grade * 0.2;
		}
		
		String setFood(String foodAsString) {
			String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int counter = 0;
    	if (foodAsString == "") foodAsString = "0.0";
    	boolean validGrade = true;
    	for (char c : foodAsString.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number
    		if (!Character.isDigit(c)) {
    			
    			if (c != '.') {
    				validGrade = false;
    			}else{
    				counter++;
    				if (counter > 1){
        				validGrade = false;
        			}
    			}
    			
    				
    			if (validGrade == false) {
    				if (counter > 1) {
    					errorMessage = "Cannot have more than one period.";
    				}else {
    					errorMessage = "Don't include the character: " + c
    						+ ". Grade should be a number.";
    				}
    			}
    		
    			
    		}
    	}
    	
    	// Default project grade to 0. If valid number entered, convert user input to
    	// floating point number.
    	if (validGrade) {
    		food = Double.parseDouble(foodAsString);
    	}
    	
    	return errorMessage;
}
		String setGroc(String grocAsString) {
			String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int counter = 0;
    	if (grocAsString == "")grocAsString = "0.0";
    	boolean validGrade = true;
    	for (char c : grocAsString.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number
    		if (!Character.isDigit(c)) {
    			
    			if (c != '.') {
    				validGrade = false;
    			}else{
    				counter++;
    				if (counter > 1){
        				validGrade = false;
        			}
    			}
    			
    				
    			if (validGrade == false) {
    				if (counter > 1) {
    					errorMessage = "Cannot have more than one period.";
    				}else {
    					errorMessage = "Don't include the character: " + c
    						+ ". Grade should be a number.";
    				}
    			}
    		
    			
    		}
    	}
    	
    	// Default project grade to 0. If valid number entered, convert user input to
    	// floating point number.
    	if (validGrade) {
    		groceries = Double.parseDouble(grocAsString);
    	}
    	
    	return errorMessage;		
}
		
		String setEnt(String entAsString) {
			String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int counter = 0;
    	if (entAsString == "")entAsString = "0.0";
    	boolean validGrade = true;
    	for (char c : entAsString.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number
    		if (!Character.isDigit(c)) {
    			
    			if (c != '.') {
    				validGrade = false;
    			}else{
    				counter++;
    				if (counter > 1){
        				validGrade = false;
        			}
    			}
    			
    				
    			if (validGrade == false) {
    				if (counter > 1) {
    					errorMessage = "Cannot have more than one period.";
    				}else {
    					errorMessage = "Don't include the character: " + c
    						+ ". Grade should be a number.";
    				}
    			}
    		
    			
    		}
    	}
    	
    	// Default project grade to 0. If valid number entered, convert user input to
    	// floating point number.
    	if (validGrade) {
    		entertainment = Double.parseDouble(entAsString);
    	}
    	
    	return errorMessage;
		}
		

		String setOther(String otherAsString) {
			String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int counter = 0;
    	if (otherAsString == "")otherAsString = "0.0";
    	boolean validGrade = true;
    	for (char c : otherAsString.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number
    		if (!Character.isDigit(c)) {
    			
    			if (c != '.') {
    				validGrade = false;
    			}else{
    				counter++;
    				if (counter > 1){
        				validGrade = false;
        			}
    			}
    			
    				
    			if (validGrade == false) {
    				if (counter > 1) {
    					errorMessage = "Cannot have more than one period.";
    				}else {
    					errorMessage = "Don't include the character: " + c
    						+ ". Grade should be a number.";
    				}
    			}
    		
    			
    		}
    	}
    	
    	// Default project grade to 0. If valid number entered, convert user input to
    	// floating point number.
    	if (validGrade) {
    		other = Double.parseDouble(otherAsString);
    	}
    	
    	return errorMessage;
		}
		
		String setGoal(String goalAsString) {
			String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int counter = 0;
    	if (goalAsString == "") goalAsString = "0.0";
    	boolean validGrade = true;
    	for (char c : goalAsString.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number
    		if (!Character.isDigit(c)) {
    			
    			if (c != '.') {
    				validGrade = false;
    			}else{
    				counter++;
    				if (counter > 1){
        				validGrade = false;
        			}
    			}
    			
    				
    			if (validGrade == false) {
    				if (counter > 1) {
    					errorMessage = "Cannot have more than one period.";
    				}else {
    					errorMessage = "Don't include the character: " + c
    						+ ". Grade should be a number.";
    				}
    			}
    		
    			
    		}
    	}
    	
    	// Default project grade to 0. If valid number entered, convert user input to
    	// floating point number.
    	if (validGrade) {
    		goal = Double.parseDouble(goalAsString);
    	}
    	
    	return errorMessage;
}
		
}
		
		
	
