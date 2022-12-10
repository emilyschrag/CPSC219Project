package application;
/**
 * Class used for checking errors. This class is used throughout the entire
 * project and checks for conditions like spaces, blank inputs, multiple decimals
 * and alphabetic characters where they shouldn't be.
 *  
 * @author 14039
 *
 */
public class ErrorCheck {
	private String grade;
	
	//constructor
	public ErrorCheck() {
		grade = "0.0";
	}
	
	//set the grade to the value entered by the user
	public void setGrade(String grade1) {
		grade = grade1;
	}
	
	/**
	 * Boolean used to check for valid input.
	 * @param grade1
	 * @return
	 */
	public boolean isValid(String grade1) {
		int counter = 0;
		int counter2 = 0;
		// Check that the user entered a numeric value
		boolean validGrade = true;
		//Checks for spaces in user input.
		if (grade1 == "")
			validGrade = false;
			
		else
			grade = grade1;
		/*
		 * Checks for commas and decimal points, if there is more than 1 comma or period present, the
		 * input is invalid
		 */
		
		for (char c : grade.toCharArray()) {
			if (!Character.isDigit(c)) {
				if (c != '.' && c!= ',') {
					validGrade = false;
				}else if (c=='.'){
					counter++;
					if (counter > 1){
	    				validGrade = false;
	    			}
				}else if (c ==',') {
					counter2++;
					if (counter2>1) {
						validGrade = false;
					}
					
				}
			}
		}	
		return validGrade;	
	}
	
	/**
	 * getter method for the error message, conditional statements for all the different possible errors
	 * with their appropriate messages.
	 * @param grade1
	 * @return errorMessage If the input is valid returns empty string as an error message, if invalid shows appropriate error message
	 */
	public String getMessage(String grade1) {
		String errorMessage = "";
		// Check that the user entered a numeric value
		boolean validGrade = true;
		int counter = 0;
		int counter2 = 0;
		if (grade1 == "") {
			errorMessage = "Must enter input.";
			validGrade = false;
		}
		else {
			grade = grade1;
		
		for (char c : grade1.toCharArray()) {
			// If any character is not a digit, set flag to false: it is not a number
		  	if (!Character.isDigit(c)) {
				if (c != '.' && c!= ',') {
					validGrade = false;
				}else if (c=='.'){
					counter++;
					if (counter > 1){
	    				validGrade = false;
	    			}
				}else if (c ==',') {
					counter2++;
					if (counter2>1) {
						validGrade = false;
					}
				}
				if (validGrade == false) {
					if (counter > 1) {
						errorMessage = "Cannot have more than one period.";
					}else if (counter2 >1){
						errorMessage = "Cannot have more than one comma.";
					}	
					else {
						errorMessage = "Don't include the character: " + c
							+ ". Grade should be a number.";
					}
				}
					
		  	}
		}
		}
		return errorMessage;
	}
	
}
	
