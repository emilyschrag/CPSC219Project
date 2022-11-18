package application;

public class Expenses extends Habit {

	//instance variables
	private int foodSpent;
	private int groceriesSpent;
	private int entertainmentSpent;
	private int otherSpent;
	

	
	
	public Expenses (int expenseFood, int expenseGroceries, int expenseEntertainment, int expenseOther) {
		foodSpent = expenseFood;
		groceriesSpent = expenseGroceries;
		entertainmentSpent = expenseEntertainment;
		otherSpent = expenseOther;
	}
	
	public void calculateSpent() {
		double totalSpent = 0.0;
		if (totalSpent >=0){
			totalSpent = foodSpent + groceriesSpent + entertainmentSpent + otherSpent;
		}

	}
	
	
	

	


	
	
	
	
	
	
	
	
}
