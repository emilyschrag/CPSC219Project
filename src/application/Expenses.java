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
	
	
    	
		String setGoal(String goalAsString) {
			String errorMessage = "";
			ErrorCheck goalCheck = new ErrorCheck();
		
			if (goalCheck.isValid(goalAsString))
				goal = Double.parseDouble(goalAsString);
			else {
				errorMessage = goalCheck.getMessage(goalAsString);
				goal = 0.0;
			}
			return errorMessage;
		}
		
		
		
}
		
		
	
