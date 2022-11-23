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
	
	//constructor takes inputs for score and goal and sets grade to 0
//	public Habit (int inputScore, int inputGoal) {
//		if (inputScore > 0)
//		value = (inputScore);
//		else value = 0;
//		if (inputGoal > 0)
//		goal = (inputGoal);
//		else goal = 0;
//		grade = 0;
//	}
	
	//calculates grade
	public void calculateGrade() {
			grade =  value  / goal * 100;
	}

	public double getWeightedGrade() {
		return grade * 0.2;
	}
	
	double getGrade() {
		return grade;
	}
	
	String setGoal(String goalAsString) {
		String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int periodcounter = 0;
    	int commacounter = 0;
    	
    	boolean validGrade = true;
    	for (char c : goalAsString.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number
    	  	if (!Character.isDigit(c)) {
    			if (c != '.' && c != ',') {
    				validGrade = false;
    			}else if (c == '.'){
    				periodcounter++;
    				if (periodcounter > 1){
        				validGrade = false;
        			}
    			} else if (c == ',') {
    				commacounter++;
    				if (commacounter > 1) 
    					validGrade = false;
    			}
    				
    			if (validGrade == false) {
    				if (commacounter < 1) {
    				}
    				else if (periodcounter <1) {
    					
    				}
    				else if (commacounter > 1 || periodcounter >1) {
    					errorMessage = "Cannot have more than one period or comma.";
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
    		if (goalAsString.contains(",")) {
    			String goalString = goalAsString.replace(",", "");
    			goal = Double.parseDouble(goalString);
    		}else {
    		goal = Double.parseDouble(goalAsString);}
    	}
    	
    	return errorMessage;
	}
	
	String setValue(String valueAsString) {
		String errorMessage = ""; // start with assuming no error
		
		// Check that the user entered a numeric value
    	int commacounter = 0;
    	int periodcounter = 0;
    	
    	boolean validGrade = true;
    	for (char c : valueAsString.toCharArray()) {
    		// If any character is not a digit, set flag to false: it is not a number
    		if (!Character.isDigit(c)) {
    			
    			if (c != '.' && c != ',') {
    				validGrade = false;
    			}else if (c == '.'){
    				periodcounter++;
    				if (periodcounter > 1){
        				validGrade = false;
        			}
    			} else if (c ==',') {
    				commacounter++;
    				if (commacounter > 1)
    					validGrade = false;
    			}
    			
    				
    			if (validGrade == false) {
    				if (commacounter < 1) {
    					
    				}
    				else if (periodcounter < 1) {
    					
    				}
    				else if (periodcounter > 1 || commacounter >1) {
    					errorMessage = "Cannot have more than one period or comma.";
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
    		if (valueAsString.contains(",")) {
    			String valueString = valueAsString.replace(",", "");
    			value = Double.parseDouble(valueString);
    		}else 
    		value = Double.parseDouble(valueAsString);
    	}
    	
    	if (value < 0 || value > goal) {
    		errorMessage = String.format("Value should be between 0 and %d."
    				+ " Invalid  grade: %.02f", goal, value);
    		value = 0;
    	} 
    	
    	return errorMessage;
	}
}
