package application;

public class Calories extends Habit {

private int calsIn;
private int calsWanted;
	
public Calories (int calsConsumed, int calsRequired) {
	super ();
	calsIn = calsConsumed;
	calsWanted = calsRequired;
}

int getCalories () {
	return calsIn;
}

int setCalories (int myCalories) {
	return this.calsIn = myCalories;
}


	
}

