package application;

import java.util.ArrayList;
/**
 * Class used to calculate everything in the water scene, including the weekly grade.
 * @author 14039
 *
 */
public class Water {
	
	//instance variables
	
	private double goal;
	private ArrayList<String> waterInputs;
	private double weekTotal;
	private double grade;
	
	/**
	 * Constructor
	 * @param watergoal The users water consumption goal.
	 * @param dailyInputs A list that stores the user's daily water consumption
	 */
	public Water (String watergoal, ArrayList<String> dailyInputs) {
		if(watergoal=="") {
			goal = 0;
			
		}else {
		goal = Double.parseDouble(watergoal);
		}
		for (int index = 0; index <= (dailyInputs.size() - 1); index++) {
			if(dailyInputs.get(index) == "") dailyInputs.set(index, "0");
			
			
		}
		waterInputs = dailyInputs;
		grade = 0;
		
		
	}
	
	/**
	 * Method used to calculate the total amount of water drank in a week by summing
	 * the user's daily water consumption inputs.
	 * Runs a for loop that iterates through the elements in the list and calculates total water consumption.
	 */
	public void total() {
		for (int index = 0; index <= (waterInputs.size() - 1); index++) {
			weekTotal += Double.parseDouble(waterInputs.get(index));
		}
	}
	
	/**
	 * Calculation for the weekly score percentage grade.
	 * @return the weekly grade
	 */
	public double getGrade() {
		return weekTotal / goal * 100;
	}
}