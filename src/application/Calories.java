package application;

import java.util.ArrayList;

/**
 * Class used for calculating everything in the food scene as well as getting data from the user info scene
 * to do these calculations. Also calculates weekly grade
 * @author 14039
 *
 */
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

/**
 * Default constructor sets all instance variables to the default value (0 or empty string);
 */
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

/**
 * Calculates base metabolic rate using input from user info scene and formula constants from the harris benedict equation.
 * @return void
 */
public void calculateBMR() {
	if (sex == "Male") {
		BMR = maleBmrConstant + (maleWeightFactor * weight) + (maleHeightFactor * height) + (maleAgeFactor * age);
	} else if (sex =="Female") {
		BMR = femaleBmrConstant + (femaleWeightFactor * weight) + (femaleHeightFactor * height) + (femaleAgeFactor * age);
	}
}
/**
 * Calculates active metabolic rate, that is the amount of calories burned in a day based on activity level.
 * @return void
 */
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
/**
 * Calculates the number of calories you need to be consuming in a day in order to achieve the weight goal.
 * @return void
 */
public void calculateCals() {
	if (weightGoal =="Lose Weight") {
		calories = (AMR*daysInWeek) - (calorieDiffOnePound * daysInWeek);
	} else if (weightGoal =="Maintain Weight") {
		calories = (AMR*daysInWeek);
	} else if (weightGoal == "Gain Weight") {
		calories = (AMR*daysInWeek) + (calorieDiffOnePound * daysInWeek);
	}
}


/**
 * Getter method for calories
 * @return calories.
 */
double getCalories () {
	return calories;
}
/**
 * Setter method for calories.
 * @param caloriesAsString
 * @return errorMessage the error message corresponding to the invalid input or empty string if the input is valid.
 */
String setCalories (String caloriesAsString) {
	String errorMessage = "";
	//Creates error check object to validate user input
	ErrorCheck calorieCheck = new ErrorCheck();
	//If input is valid allow it, else default it to 0.
	if (calorieCheck.isValid(caloriesAsString))
		calories = Double.parseDouble(caloriesAsString);
	else {
		errorMessage = calorieCheck.getMessage(caloriesAsString);
		calories = 0.0;
	}
	return errorMessage;
}

//Getters and setters for all user info inputs

/**
 * 
 * @param ageAsString
 * @return errorMessage the error message corresponding to the invalid input or empty string if the input is valid.
 */
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

/**
 * sets sex from choice box in user info scene
 * @param sexAsString
 * @return Empty String 
 */
String setSex(String sexAsString) {
	sex= sexAsString;
	return "";
}

/**
 * sets height from input in user info scene
 * @param heightAsString
 * @return errorMessage the error message corresponding to the invalid input or empty string if the input is valid.
 */
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

/**
 * sets weight from input in user info scene
 * @param weightAsString
 * @return errorMessage the error message corresponding to the invalid input or empty string if the input is valid.
 */
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

/**
 * sets activity level from choice box in user info scene
 * @param activityAsString
 * @return empty string
 */
String setActivity(String activityAsString) {
	activityLevel = activityAsString;
	return "";
}

/**
 * Sets weight goal from choice box in food scene
 * @param weightGoalAsString
 * @return empty string
 */
String setWeightGoal(String weightGoalAsString) {
	weightGoal = weightGoalAsString;
	return "";
	}
/**
 * calorie list with daily inputs as input by the user in the food scene
 * @param data
 */
void setCalorieData(ArrayList <String> data) {
	calorieList = data;
}



/**
 * Total method used to sum the users daily calorie intake and get a total weekly amount.
 * Checks if the list has inputs in it. 
 * Runs a for loop that iterates through the elements in the list and calculates total calorie consumption.
 */
public void total() {
	
	
	if(calorieList != null) {
		weekTotal = 0;
	for (int index = 0; index <= (calorieList.size() - 1); index++) {
		
		weekTotal += Double.parseDouble(calorieList.get(index));
	}
	}
	
}

/**
 * Gets age variable
 * @return
 */
public int getAge () {
	return age;	
}
/**
 * gets weight variable
 * @return
 */
public int getWeight() {
	return weight;
}
/**
 * Gets height variable
 * @return
 */
public int getHeight() {
	return height;
}
/**
 * Gets Sex variable
 * @return
 */
public String getSex() {
	return sex;
}
/**
 * Gets activity variable
 * @return
 */
public String getActivity() {
	return activityLevel;
}
/**
 * Gets AMR variable
 * @return
 */
public double getAMR() {
	return AMR;
}
/**
 * Gets BMR Variable
 * @return
 */
public double getBMR () {
	return BMR;
}
/**
 * Gets weight goal
 * @return
 */
public String getWeightGoal () {
	return weightGoal;
}
/**
 * Calculation for the weekly score percentage grade.
 * @return the weekly grade
 */
public double getGrade() {
	return weekTotal/calories * 100;
}
}