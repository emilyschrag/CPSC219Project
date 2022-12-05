package application;

public class Habit {
	//set instance variables
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
		else grade =  value / goal * 100;
	}


 	double getGrade() {
 		return grade;
 	}

 	double getGoal() {
 		return goal;
 	}

	
	String setGoal(String goalAsString) {
		//set the error message to empty 
		String errorMessage = "";
				
		//create ErrorCheck object
		ErrorCheck goalCheck = new ErrorCheck();
		
		//set the entered value if it is valid; if not print the appropriate error message
		//and set the value to 0
		if (goalCheck.isValid(goalAsString))
			goal = Double.parseDouble(goalAsString);
		else {
			errorMessage = goalCheck.getMessage(goalAsString);
			goal = 0.0;
		}	
    	return errorMessage;
	}
	
	String setValue(String valueAsString) {
		//set the error message to empty 
		String errorMessage = "";
		
		//create ErrorCheck object
		ErrorCheck valueCheck = new ErrorCheck();
		
		//set the entered value if it is valid; if not print the appropriate error message
		//and set the value to 0
		if (valueCheck.isValid(valueAsString))
			value = Double.parseDouble(valueAsString);
		else {
			errorMessage = valueCheck.getMessage(valueAsString);
			value = 0.0;
		}	
    	return errorMessage;
	}
	
	//set the sleep goal
	void setSleepGoal(double hour, double minutes) {
		hour = hour * 60;
		goal = hour + minutes;
	}
	
	//set the sleep value 
	void setSleepValue(double hour, double minutes) {
		hour = hour * 60;
		value = hour + minutes;
	
	}
}