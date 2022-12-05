package application;

public class Habit {

	
	// instance variables
	private double value;
	private double goal;
	private double grade;
	
	//default constructor sets all values to 0
	public Habit () {
		value = 0.0;
		goal = 0.0;
		grade = 0.0;
	}
	
	//calculates grade
	public void calculateGrade() {
		if (value == 0.0 || goal == 0.0) grade = 0.0;
		else grade =  value  / goal * 100;
	}

	public double getWeightedGrade() {
		if (grade > 100.0) grade = 100.0;
		return grade * 0.2;
	}
	
	double getGrade() {
		return grade;
	}
	
	double getGoal() {
		return goal;
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
	
	String setValue(String valueAsString) {
		String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int counter = 0;
    	if (valueAsString == "") valueAsString = "0.0";
    	boolean validGrade = true;
    	for (char c : valueAsString.toCharArray()) {
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
    		value = Double.parseDouble(valueAsString);
    	}
    	
    	return errorMessage;
	}
	
	void setSleepGoal(double hour, double minutes) {
		hour = hour * 60;
		goal = hour + minutes;
	}
	
	void setSleepValue(double hour, double minutes) {
		hour = hour * 60;
		value = hour + minutes;
	
	}
}