package application;

public class Expenses extends Habit {
	//set instance variables
		private double food;
		private double entertainment;
		private double groceries;
		private double other;
		private double total;
		
		//default constructor sets all values to 0
		public Expenses() {
			other = 0.0;
			food = 0.0;
			entertainment = 0.0;
			groceries = 0.0;
			total = 0.0;
		}

/**
 * 		
 * @return
 */
		public String calculateTotal() {
			String returnTotal;
				total = food + groceries + other + entertainment;
				if (total == 0.0) total= 1;
				returnTotal = Double.toString(total);
			return returnTotal;
		}

/**
 * 		
 * @param total1
 * @param goalAsString
 */
		public void calculateGrade(String total1, String goalAsString) {
			
			super.setGoal(total1);
			super.setValue(goalAsString);
			super.calculateGrade();
		}
		
		//getter for the calculated total
		double getTotal() {
			return total;
		}
		
		//setter for the food variable using the ErrorCheck class
		String setFood(String foodAsString) {
			//set the error message to empty 
			String errorMessage = "";
			
			//create ErrorCheck object
			ErrorCheck foodCheck = new ErrorCheck();
		
			//set the entered value if it is valid; if not print the appropriate error message
			//and set the value to 0
			if (foodCheck.isValid(foodAsString))
				food = Double.parseDouble(foodAsString);
			else {
				errorMessage = foodCheck.getMessage(foodAsString);
				//food = 0.0;
			}
			return errorMessage;
		}

		//setter for the grocery variable using the ErrorCheck class
		String setGroc(String grocAsString) {
			//set the error message to empty 
			String errorMessage = "";
			
			//create ErrorCheck object
			ErrorCheck grocCheck = new ErrorCheck();
		
			//set the entered value if it is valid; if not print the appropriate error message
			//and set the value to 0
			if (grocCheck.isValid(grocAsString))
				groceries = Double.parseDouble(grocAsString);
			else {
				errorMessage = grocCheck.getMessage(grocAsString);
				//groceries = 0.0;
			}
			return errorMessage;
		}
		
		//setter for the entertainment variable using the ErrorCheck class
		String setEnt(String entAsString) {
			//set the error message to empty 
			String errorMessage = "";
			
			//create ErrorCheck object
			ErrorCheck entCheck = new ErrorCheck();
		
			//set the entered value if it is valid; if not print the appropriate error message
			//and set the value to 0
			if (entCheck.isValid(entAsString))
				entertainment = Double.parseDouble(entAsString);
			else {
				errorMessage = entCheck.getMessage(entAsString);
				//entertainment = 0.0;
			}
			return errorMessage;
		}
		
		//setter for the other variable using the ErrorCheck class
		String setOther(String otherAsString) {
			//set the error message to empty
			String errorMessage = "";
			
			//create errorcheck object
			ErrorCheck otherCheck = new ErrorCheck();
		
			//set the entered value if it is valid; if not print the appropriate error message
			//and set the value to 0
			if (otherCheck.isValid(otherAsString))
				other = Double.parseDouble(otherAsString);
			else {
				errorMessage = otherCheck.getMessage(otherAsString);
				//other = 0.0;
			}
			return errorMessage;
		}	
}
		
		
	
