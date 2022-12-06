package application;

import java.util.ArrayList;

public class Calories {

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
private double grade;
private ArrayList<String> calorieList;
private double weekTotal;

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
	age = 0;
	grade = 0;
}





public void calculateBMR() {
	if (sex == "Male") {
		BMR = maleBmrConstant + (maleWeightFactor * weight) + (maleHeightFactor * height) + (maleAgeFactor * age);
	} else if (sex =="Female") {
		BMR = femaleBmrConstant + (femaleWeightFactor * weight) + (femaleHeightFactor * height) + (femaleAgeFactor * age);
	}

}



public void calculateAMR() {
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
	
}

public void calculateCals() {
	
	if (weightGoal =="Lose Weight") {
		calories = (AMR*daysInWeek) - (calorieDiffOnePound * daysInWeek);
	} else if (weightGoal =="Maintain Weight") {
		calories = (AMR*daysInWeek);
	} else if (weightGoal == "Gain Weight") {
		calories = (AMR*daysInWeek) + (calorieDiffOnePound * daysInWeek);
	}

}



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
	sex= sexAsString;
	return "";

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
	activityLevel = activityAsString;
	return "";
}

String setWeightGoal(String weightGoalAsString) {
	weightGoal = weightGoalAsString;
	return "";
	}

void setCalorieData(ArrayList <String> data) {
calorieList = data;
}

public void total() {
	weekTotal = 0;
	for (int index = 0; index <= (calorieList.size() - 1); index++) {
		weekTotal += Double.parseDouble(calorieList.get(index));
	}
}


public int getAge () {
return age;	
}

public int getWeight() {
	return weight;
}

public int getHeight() {
	return height;
}

public String getSex() {
	return sex;
}

public String getActivity() {
	return activityLevel;
}

public double getAMR() {
	return AMR;
}

public double getBMR () {
	return BMR;
}

public String getWeightGoal () {
	return weightGoal;
}

public double getGrade() {
	return weekTotal/calories * 100;
}





}