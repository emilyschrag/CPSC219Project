package application;

public class Expenses extends Habit {
	// instance variables
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

		public String calculateTotal() {
			String returnTotal;
			if (food == 0.0 && groceries == 0.0 && other == 0.0 && entertainment == 0.0) {
				total = 0.0;
				returnTotal = Double.toString(total);
			}
			else {
				total = food + groceries + other + entertainment;
				returnTotal = Double.toString(total);
			}
			return returnTotal;
		}
		public void calculateGrade(String total1, String goalAsString) {
			super.setGoal(goalAsString);
			super.setValue(total1);
			super.calculateGrade();
		}
		
		
		double getTotal() {
			return total;
		}
		
		String setFood(String foodAsString) {
			String errorMessage = "";
			ErrorCheck foodCheck = new ErrorCheck();
		
			if (foodCheck.isValid(foodAsString))
				food = Double.parseDouble(foodAsString);
			else {
				errorMessage = foodCheck.getMessage(foodAsString);
				food = 0.0;
			}
			return errorMessage;
		}

		String setGroc(String grocAsString) {
			String errorMessage = "";
			ErrorCheck grocCheck = new ErrorCheck();
		
			if (grocCheck.isValid(grocAsString))
				groceries = Double.parseDouble(grocAsString);
			else {
				errorMessage = grocCheck.getMessage(grocAsString);
				groceries = 0.0;
			}
			return errorMessage;
		}
		
		String setEnt(String entAsString) {
			String errorMessage = "";
			ErrorCheck entCheck = new ErrorCheck();
		
			if (entCheck.isValid(entAsString))
				entertainment = Double.parseDouble(entAsString);
			else {
				errorMessage = entCheck.getMessage(entAsString);
				entertainment = 0.0;
			}
			return errorMessage;
		}
		
		String setOther(String otherAsString) {
			String errorMessage = "";
			ErrorCheck otherCheck = new ErrorCheck();
		
			if (otherCheck.isValid(otherAsString))
				other = Double.parseDouble(otherAsString);
			else {
				errorMessage = otherCheck.getMessage(otherAsString);
				other = 0.0;
			}
			return errorMessage;
		}
		
}
		
		
	
