package application;

public class Habit {

	// instance variables
	private int score;
	private int goal;
	private double grade;
	
	//default constructor sets all values to 0
	public Habit () {
		setScore(0);
		setGoal(0);
		setGrade(0);
	}
	
	//constructor takes inputs for score and goal and sets grade to 0
	public Habit (int inputScore, int inputGoal) {
		setScore(inputScore);
		setGoal(inputGoal);
		setGrade(0);
	}
	
	//calculates grade
	public void calculateGrade() {
		setGrade(getScore() / getGoal());
	}

	
	int getScore() {
		return score;
	}

	void setScore(int newScore) {
		this.score = newScore;
	}

	int getGoal() {
		return goal;
	}

	void setGoal(int newGoal) {
		this.goal = newGoal;
	}

	double getGrade() {
		return grade;
	}

	void setGrade(double newGrade) {
		this.grade = newGrade;
	}
	
	
}
