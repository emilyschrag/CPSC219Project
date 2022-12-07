package application;

import java.util.ArrayList;

public class Water {
	private double goal;
	private ArrayList<String> waterInputs;
	private double weekTotal;
	private double grade;
	
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
	
	public void total() {
		for (int index = 0; index <= (waterInputs.size() - 1); index++) {
			weekTotal += Double.parseDouble(waterInputs.get(index));
		}
	}
	
	public double getGrade() {
		return weekTotal / goal * 100;
	}
}