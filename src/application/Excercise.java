package application;

import java.util.ArrayList;
/**
 * Class used to calculate everything in the Exercise scene, including the weekly grade for exercise
 * @author 14039
 *
 */

//instance variables
public class Excercise {
	private ArrayList<String> goal;
	private ArrayList<String> completed;
	private double grade = 0.0;
	
	/**
	 * Constructor
	 * @param excerciseGoal List of exercises the user wants to complete, the elements in the list are added by the user
	 * @param excerciseCompleted List of exercises the user has completed.
	 */
	public Excercise (ArrayList<String> excerciseGoal, ArrayList<String> excerciseCompleted) {
		goal = excerciseGoal;
		completed = excerciseCompleted;
	}
	/**
	 * Method used to calculate the grade, takes the size of the completed exercise list and compares it to the size of the
	 * Goal exercises list to compute the grade.
	 * @return void
	 */
	public void calculate() {
		grade =  (double)(completed.size()) / (double)(goal.size()) * 100.0;
	}
	
	/**
	 * Getter method for the grade
	 * @return grade
	 */
	public double getGrade() {
		return grade;
	}
}
