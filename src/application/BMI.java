package application;

public class BMI extends Habit {

private int calsIn;
private int calsWanted;
	
public BMI (int calsConsumed, int calsRequired) {
	super (calsConsumed, calsRequired);
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

