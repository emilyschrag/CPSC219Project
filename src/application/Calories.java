package application;

public class Calories extends Habit {

private int calsIn;

	
public Calories (int calsConsumed) {
	super ();
	calsIn = calsConsumed;

}

int getCalories () {
	return calsIn;
}

int setCalories (int myCalories) {
	return this.calsIn = myCalories;
}


	
}

