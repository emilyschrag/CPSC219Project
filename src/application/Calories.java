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
private String weightGoal;

//CONSTANTS

/*
 * Constants needed for BMR formula as found on:https://www.verywellfit.com/how-many-calories-do-i-need-each-day-2506873
 * 
 * MALE/FEMALE FORMULA
 * For women, BMR = 655.1 + (9.563 x weight in kg) + (1.850 x height in cm) - (4.676 x age in years)
 *For men, BMR = 66.47 + (13.75 x weight in kg) + (5.003 x height in cm) - (6.755 x age in years)
 *
 */

static final double daysInWeek = 7;

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
	weightGoal = "";
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
		AMR = (BMR*sedentaryAmrFactor);
	} else if (activityLevel == "Lightly Active") {
		AMR = (BMR*lightAmrFactor);
	} else if (activityLevel == "Moderately Active") {
		AMR = (BMR*moderateAmrFactor);
	} else if (activityLevel == "Active") {
		AMR = (BMR*activeAmrFactor);
	} else if (activityLevel == "Very Active") {
		AMR = (BMR*veryActiveAmrFactor);
	}
	
	return AMR;
}

public double calculateCals() {
	if (weightGoal =="Lose Weight") {
		calories = (AMR*daysInWeek) - (calorieDiffOnePound * daysInWeek);
	} else if (weightGoal =="Maintain Weight") {
		calories = (AMR*daysInWeek);
	} else if (weightGoal == "Gain Weight") {
		calories = (AMR*daysInWeek) + (calorieDiffOnePound * daysInWeek);
	}
	return calories;
}

/*
 * public double calculateCalsLoss () {
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
 */





double getCalories () {
	return calories;
}

String setCalories (String caloriesAsString) {
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

//Setting user info variables to use for calculations

String setAge(String ageAsString) {
	String errorMessage = "";
	ErrorCheck ageCheck = new ErrorCheck();

	if (ageCheck.isValid(ageAsString))
		age = Integer.parseInt(ageAsString);
	else {
		errorMessage = ageCheck.getMessage(ageAsString);
		age = 0;
	}
	return errorMessage;
}

String setSex(String sexAsString) {
	String errorMessage = "";
	ErrorCheck sexCheck = new ErrorCheck();

	if (sexCheck.isValid(sexAsString))
		sex = (sexAsString);
	else {
		errorMessage = sexCheck.getMessage(sexAsString);
		sex = "";
	}
	return errorMessage;
}

String setHeight(String heightAsString) {
	String errorMessage = "";
	ErrorCheck heightCheck = new ErrorCheck();

	if (heightCheck.isValid(heightAsString))
		height = Integer.parseInt(heightAsString);
	else {
		errorMessage = heightCheck.getMessage(heightAsString);
		height = 0;
	}
	return errorMessage;
}

String setWeight(String weightAsString) {
	String errorMessage = "";
	ErrorCheck weightCheck = new ErrorCheck();

	if (weightCheck.isValid(weightAsString))
		weight = Integer.parseInt(weightAsString);
	else {
		errorMessage = weightCheck.getMessage(weightAsString);
		weight = 0;
	}
	return errorMessage;
}

String setActivity(String activityAsString) {
	String errorMessage = "";
	ErrorCheck activityCheck = new ErrorCheck();

	if (activityCheck.isValid(activityAsString))
		activityLevel = (activityAsString);
	else {
		errorMessage = activityCheck.getMessage(activityAsString);
		activityLevel = "";
	}
	return errorMessage;
}

String setWeightGoal(String weightGoalAsString) {
	String errorMessage = "";
	ErrorCheck weightGoalCheck = new ErrorCheck();

	if (weightGoalCheck.isValid(weightGoalAsString))
		weightGoal = (weightGoalAsString);
	else {
		errorMessage = weightGoalCheck.getMessage(weightGoalAsString);
		weightGoal = "";
	}
	return errorMessage;
}



}