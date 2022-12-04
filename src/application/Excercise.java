package application;

import java.util.ArrayList;

public class Excercise {

	private ArrayList<String> goal;
	private ArrayList<String> completed;
	private double grade = 0.0;
	
	public Excercise (ArrayList<String> excerciseGoal, ArrayList<String> excerciseCompleted) {
		goal = excerciseGoal;
		completed = excerciseCompleted;
	}
	
	public void calculate() {
		ArrayList<String> copiedList = goal;
		copiedList.retainAll(completed);
		grade = (double) (copiedList.size() /goal.size() * 100.0);
	}
	
	public double getGrade() {
		return grade;
	}
	
}
