package application;

/**
 * Habit class
 * Takes data, a goal and calculates a grade in the calculateGrade method.
 * Parent of the expense class.
 * @author 14039
 *
 */
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
	
	/**
	 * Method to calculate grade
	 * If data values or goal are the default value, the grade is also the default value
	 * Else, calculate the grade.
	 */
	public void calculateGrade() {
		if (value == 0.0 || goal == 0.0) grade = 0.0;
		else grade =  value / goal * 100;
	}
/**
 * Getter method for the grade
 * @return grade
 */
 	double getGrade() {
 		return grade;
 	}
/**
 * Getter method for the goal 
 * @return goal
 */
 	double getGoal() {
 		return goal;
 	}
/**
 * Setter method for goals
 * @param goalAsString
 * @return errorMessage the error message corresponding to the invalid input or empty string if the input is valid.
 */
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
/**
 * Setter method for data values.
 * @param valueAsString
 * @return errorMessage the error message corresponding to the invalid input or empty string if the input is valid.
 */
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
}