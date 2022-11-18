package application;

public class Habit {

	// instance variables
	private int score;
	private int goal;
	private double grade;
	
	//default constructor sets all values to 0
//	public Habit () {
//		setScore(0);
//		setGoal(0);
//		setGrade(0);
//	}
	
	//constructor takes inputs for score and goal and sets grade to 0
	public Habit (int inputScore, int inputGoal) {
		if (inputScore > 0)
		score = (inputScore);
		else score = 0;
		if (inputGoal > 0)
		goal = (inputGoal);
		else goal = 0;
		grade = 0;
	}
	
	//calculates grade
	public void calculateGrade() {
		if (score != 0 && goal != 0)
			grade = ((double) score  / goal)*10;
		else grade = 0;
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
