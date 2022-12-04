package application;

public class Calories extends Habit {

	// instance variables
	//note: INPUT weight is in KG
private int weight;
private int height;
private double calories;
private int age;
private double BMR;
private String sex;
private double AMR;
private String activityLevel;

//CONSTANTS

/*
 * Constants needed for BMR formula as found on:https://www.verywellfit.com/how-many-calories-do-i-need-each-day-2506873
 * 
 * MALE/FEMALE FORMULA
 * For women, BMR = 655.1 + (9.563 x weight in kg) + (1.850 x height in cm) - (4.676 x age in years)
 *For men, BMR = 66.47 + (13.75 x weight in kg) + (5.003 x height in cm) - (6.755 x age in years)
 *
 */

static final double maleBmrConstant = 66.47;
static final double maleWeightFactor = 13.75;
static final double maleHeightFactor = 5.003;
static final double maleAgeFactor = 6.755;

static final double femaleBmrConstant = 655.1;
static final double femaleWeightFactor = 9.563;
static final double femaleHeightFactor = 1.850;
static final double femaleAgeFactor = 4.676;

static final double sedentaryAmrFactor = 1.2;
static final double lightAmrFactor = 1.375;
static final double moderateAmrFactor = 1.55;
static final double activeAmrFactor = 1.725;
static final double veryActiveAmrFactor =1.9 ;


//This constant represents the number of daily calories needed to be cut/added in order to lose/gain 1 pound per week.
static final double calorieDiffOnePound = 500.0;


public Calories () {
	weight = 0;
	height = 0;
	calories = 0;
	BMR = 0;
	sex = "";
	activityLevel = "";
	AMR = 0;
}





public Double calculateBMR() {
	if (sex == "Male") {
		BMR = maleBmrConstant + (maleWeightFactor * weight) + (maleHeightFactor * height) + (maleAgeFactor * age);
	} else if (sex =="Female") {
		BMR = femaleBmrConstant + (femaleWeightFactor * weight) + (femaleHeightFactor * height) + (femaleAgeFactor * age);
	}

	return BMR;
}



public Double calculateAMR() {
	if (activityLevel =="Sedentary") {
		
	} else if (activityLevel == "Lightly Active") {
		AMR = (BMR*sedentaryAmrFactor);
	} else if (activityLevel == "Moderately Active") {
		AMR = (BMR*lightAmrFactor);
	} else if (activityLevel == "Active") {
		AMR = (BMR*moderateAmrFactor);
	} else if (activityLevel == "Very Active") {
		AMR = (BMR*veryActiveAmrFactor);
	}
	
	return AMR;
}


public double calculateCalsLoss () {
	calories = AMR - calorieDiffOnePound;
	return calories;
	
}

public double calculateCalsSame () {
	calories = AMR;
	return calories;
	
}

public double calculateCalsGain () {
	calories = AMR + calorieDiffOnePound;
	return calories;
	
}




double getCalories () {
	return calories;
}

/*
 * String setCalories (String caloriesAsString) {
	String errorMessage = "";
	ErrorCheck calorieCheck = new ErrorCheck();

	if (calorieCheck.isValid(caloriesAsString))
		calories = Double.parseDouble(caloriesAsString);
	else {
		errorMessage = calorieCheck.getMessage(caloriesAsString);
		calories = 0.0;
	}
	return errorMessage;
}
 */



	
}

