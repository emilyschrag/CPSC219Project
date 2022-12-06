package application;

import java.util.ArrayList;

public class Water {

	private double goal;
	private ArrayList<String> waterInputs;
	private double weekTotal;
	private double grade;
	
	
	public Water (String watergoal, ArrayList<String> dailyInputs) {
		goal = Double.parseDouble(watergoal);
		waterInputs = dailyInputs;
		grade = 0;
	}
	
	public void total() {
		for (int index = 0; index <= (waterInputs.size() - 1); index++) {
			weekTotal += Double.parseDouble(waterInputs.get(index));
		}
	}
	
	public double getGrade() {
		return weekTotal / goal * 100;
	}
	
}
