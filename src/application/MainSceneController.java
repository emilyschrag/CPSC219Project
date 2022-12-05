package application;

//import required packages
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;

public class MainSceneController {
	Stage applicationStage;
	 @FXML
	    //initialize all the things we need the data from in more than one section
	    private DatePicker todaysDatePicker;
	    private Label metSleepGoalInfo = new Label(" ");
	    private Label metFoodGoalInfo = new Label(" ");
	    private Label metExpensesGoalInfo = new Label(" ");
	    private Label metExerciseGoalInfo = new Label(" ");
	    private Label metWaterGoalInfo = new Label(" ");
	    private Label errorLabel = new Label("");
	    private Label goalLabel = new Label("");
	    private Label waterDataLabel = new Label("");
	    private Label waterGoalLabel = new Label("");
	    private TextField nameTextField = new TextField();
	    private ChoiceBox<String> ageChoiceBox = new ChoiceBox();
	    private ChoiceBox<String> sexChoiceBox = new ChoiceBox();
	    private TextField heightTextField = new TextField();
	    private TextField weightTextField = new TextField();
	    private ChoiceBox<String> activityChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> hourChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> hourChoiceBox2 = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox2 = new ChoiceBox();
	    private ChoiceBox<String> weightGoalChoiceBox = new ChoiceBox();
	    private ChoiceBox<String> workoutGoalChoiceBox = new ChoiceBox();
	    private ChoiceBox<String> workoutCompletedChoiceBox = new ChoiceBox();
	    private TextField exGoalTextField = new TextField();
	    private TextField foodTextField = new TextField();
	    private TextField entertainmentTextField = new TextField();
	    private TextField groceriesTextField = new TextField();
	    private TextField otherTextField = new TextField();
	    private TextField waterGoalTextField = new TextField();
	    private TextField waterDataTextField = new TextField();
	    private TextField stepsDataTextField = new TextField();
	    private ArrayList<String> workoutGoalList = new ArrayList<String>();
	    private ArrayList<String> workoutCompletedList = new ArrayList<String>();
	    private ArrayList<String>dailyWaterList = new ArrayList<String>();
	    private HBox waterDataContainer = new HBox(10);
	    private HBox waterGoalContainer = new HBox(10);
	    private String age;
	    private String sex;
	    private String height;
	    private String weight;
	    private String activityLevel;
	    private int index = 0;
	    private double waterGrade;
	    private double foodGrade;
	    private double spendGrade;
	    private double stepGrade;
	    private double sleepGrade;
	    private double weightedWaterGrade;
	    private double weightedFoodGrade;
	    private double weightedSpendGrade;
	    private double weightedStepGrade;
	    private double weightedSleepGrade;
	    private String[] days = {" Tuesday", " Wednesday", " Thursday", " Friday", " Saturday", " Sunday"};
	    private Label caloriesEnterLabel = new Label("");
	    private HBox weightGoalContainer = new HBox(10);
	    private ArrayList<String> dailyCalorieList = new ArrayList <String>();
    	private Label calorieInputLabel = new Label ("");
    	private HBox calorieDataContainer = new HBox(10);
    	Calories food = new Calories();

	   
	    @FXML
	    	void enterInfo(ActionEvent enterInfoEvent) {
	    	//Set the original scene to mainScene
	    	Scene mainScene = applicationStage.getScene();
	    	
	    	//Create the container that will hold everything else in this scene
	    	VBox userInfoContainer = new VBox(20);
	    	Label titleLabel = new Label("Enter your information!");
	    	
	    	//container for entering age 
	    	HBox ageContainer = new HBox(10);
	    	Label ageLabel = new Label("Enter your Age");
	    	TextField ageTextField = new TextField();
	    	ageContainer.getChildren().addAll(ageLabel, ageTextField);
	    	String userAge = ageTextField.getText();

	    	//container for entering sex 
	    	HBox sexContainer = new HBox(10);
	    	Label sexLabel = new Label("Enter your Sex");
	    	ChoiceBox sexChoiceBox = new ChoiceBox();
	    	sexContainer.getChildren().addAll(sexLabel, sexChoiceBox);
	    	sexChoiceBox.getItems().addAll("Male", "Female");
	    	String userSex = (String) sexChoiceBox.getValue();

	    	//container for entering height 
	    	HBox heightContainer = new HBox(10);

	    	Label heightLabel = new Label("Enter your height in cm");
	    	TextField heightTextField = new TextField();
	    	heightContainer.getChildren().addAll(heightLabel, heightTextField);
	    	String userHeight = heightTextField.getText();

	    	//container for entering weight 
	    	HBox weightContainer = new HBox(10);
	    	Label weightLabel = new Label("Enter your weight in kg");
	    	TextField weightTextField = new TextField();
	    	weightContainer.getChildren().addAll(weightLabel, weightTextField);
	    	String userWeight = weightTextField.getText();
	    	
	    	//container for entering activity level
	    	HBox activityContainer = new HBox(10);
	    	Label activityLabel = new Label("Enter your Activity Level");
	    	ChoiceBox activityChoiceBox = new ChoiceBox();
	    	activityContainer.getChildren().addAll(activityLabel, activityChoiceBox);
	    	activityChoiceBox.getItems().addAll("Sedentary", "Lightly Active","Moderately Active","Active","Very Active");
	    	String userActivity = (String) activityChoiceBox.getValue();

	    	//done button to take user back to main scene when information is entered
	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent -> userInfoDone(ageTextField.getText(),(String)sexChoiceBox.getValue(),heightTextField.getText(),
	    			weightTextField.getText(),(String)activityChoiceBox.getValue(), mainScene));
	    	
	    	// add all components to main container
	    	userInfoContainer.getChildren().addAll(titleLabel, ageContainer, sexContainer, heightContainer, weightContainer, activityContainer, doneButton);
	    	//create a new scene that holds the main container
	    	Scene infoScene = new Scene(userInfoContainer, 300, 325);
	    	//set the scene to the info scene when the enterInfo action is initiated
	    	applicationStage.setScene(infoScene);
	    } 
	    
//END USER INFO
	    void userInfoDone (String ageAsString, String sexAsString , String heightAsString, String weightAsString, String activityAsString, Scene mainScene) {
	    	age = ageAsString;
	    	sex = sexAsString;
	    	height = heightAsString;
	    	weight = weightAsString;
	    	activityLevel = activityAsString;
	    	applicationStage.setScene(mainScene);
	    }

	    void dailyCalorieData (String dailyData) {
	    	if (index == 6) calorieDataContainer.getChildren().removeAll(calorieDataContainer.getChildren());
	   
	    	if (index < 6) {
	    		dailyCalorieList.add(dailyData);
	    		calorieInputLabel.setText("How many calories did you consume on" + days[index] + "?");
	    	}
	   
	    	index++;
	  
	    	food.setCalorieData(dailyCalorieList);
	    	food.total();
	    	foodGrade = food.getGrade();
	    	if (foodGrade < 100)
	    		weightedFoodGrade = foodGrade * 0.2;
	    	else if (foodGrade >= 100)
	    		weightedFoodGrade = 20.0;
	   
	    	goalLabel.setText(String.format("you have completed %.0f"
	    			+ "%% of your calories goal", foodGrade));
	    }
	
/**
 * 	    
 * @param goalHour
 * @param goalMinute
 * @param valueHour
 * @param valueMinute
// */
	    void createSleepHabit (double goalHour, double goalMinute, double valueHour, double valueMinute) {
		    errorLabel.setText("");
		    goalLabel.setText("");
	   	    Habit sleep = new Habit();
	   	    sleep.setSleepGoal(goalHour, goalMinute);
	 	    sleep.setSleepValue(valueHour, valueMinute);
	   	    sleep.calculateGrade();
	 	    sleepGrade = sleep.getGrade();
	 	    if (sleepGrade <100)
	 	    	weightedSleepGrade = sleepGrade * 0.2;
	 	    else if (sleepGrade >=100)
	 	    	weightedSleepGrade = 20.0;
	 	    if  (sleep.getGrade() > 100) goalLabel.setText("Congratulations! You have surpassed your sleep goal.");
	 	    else if (sleep.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your sleep goal.");
	 	    else goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your sleep goal", sleepGrade));
	   }
	   
	   void addDailyWater(String waterIntake, String waterGoal) {
		   waterGoalContainer.getChildren().removeAll(waterGoalContainer.getChildren());
		   waterGoalLabel.setText("Your water goal for the week is " + waterGoal + "L" );
		   waterGoalContainer.getChildren().addAll(waterGoalLabel);
		   
		   if (index == 6) {
			   dailyWaterList.add(waterIntake);
			   waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
		   }
			   
		   if (index < 6) {
			   dailyWaterList.add(waterIntake);
			   waterDataLabel.setText("How much water did you drink on" + days[index] + "?");
		   }
		   
		   index++;
		  
		   Water drink = new Water(waterGoal, dailyWaterList);
		   drink.total();
		   waterGrade = drink.getGrade();
		   weightedWaterGrade = waterGrade * 0.2;
		   
		   goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your water goal", waterGrade)); 
	   }
	   
	   void waterDoneButton(Scene mainScene) {
		   waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
		   applicationStage.setScene(mainScene);
		   
	   }
	   
	    void createExpensesHabit(String goalAsString, String foodAsString, String entAsString, String grocAsString, String otherAsString) {
	    	errorLabel.setText("");
	     	goalLabel.setText("");
	     	Expenses spend = new Expenses();
	     	errorLabel.setText(spend.setFood(foodAsString));
	      	errorLabel.setText(spend.setGroc(grocAsString));
	      	errorLabel.setText(spend.setOther(otherAsString));
	      	errorLabel.setText(spend.setEnt(entAsString));
	      	errorLabel.setText(spend.setGoal(goalAsString));
	      	spend.calculateGrade(spend.calculateTotal(), goalAsString);
	      	spendGrade = spend.getGrade();
	      	if (spendGrade < 100)
	      		weightedSpendGrade = spendGrade * 0.2;
	      	else if (spendGrade >= 100)
	      		weightedSpendGrade = 20.0;
	      	if (spend.getTotal()>spend.getGoal()) goalLabel.setText("You have surpassed your spending goal.");
	      	else if (spendGrade == 100) goalLabel.setText("Congradulations! You have reached your spending goal.");
	      	else goalLabel.setText(String.format("you have completed %.0f"
	  				+ "%% of your spending goal", spendGrade)); 
	    }

	   
	   void addWorkoutGoal(String workoutGoal) {
		   errorLabel.setText("");
		   boolean valid = true;
		    
		   if (workoutGoalList.size() == 0) {
			   workoutGoalList.add(workoutGoal);
		   
		   }else{ 
			   
			   for (int index = 0; index <= (workoutGoalList.size() - 1); index++) {
				   if (workoutGoalList.get(index).equals(workoutGoal)) {
					   errorLabel.setText("This workout has already been added");
					   valid = false;
					   }
			   }
			   
			   if (valid == true)workoutGoalList.add(workoutGoal);
		   }
		   
		   for (int index = 0; index <= (workoutGoalList.size() - 1); index++) {
				   System.out.println(workoutGoalList.get(index));
		   }
		   
		   workoutCompletedChoiceBox.getItems().addAll(workoutGoal);
		   
	   }
	   
	   void addWorkoutCompleted(String workoutCompleted) {
		   workoutCompletedList.add(workoutCompleted);
		   for (int index = 0; index <= (workoutCompletedList.size() - 1); index++) {
			   System.out.println(workoutCompletedList.get(index));
		   }
		   
	   }
	   
	    void createExerciseHabit(ArrayList<String> goal, ArrayList<String> completed) {
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	Excercise workouts = new Excercise(goal, completed); 
	    	workouts.calculate();
	    	stepGrade = workouts.getGrade();
	    	if (stepGrade < 100)
	    		weightedStepGrade = stepGrade * 0.2;
	    	else if (stepGrade >= 100)
	    		weightedStepGrade = 20.0;
	    	if (workouts.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your exercise goal.");
	    	else if (workouts.getGrade() > 100) goalLabel.setText("Congratulations! You have surpassed your exercise goal.");
	    	else goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your exercise goal", stepGrade));
	    }
	    
	    void createFoodHabit(String weightGoalAsString) {
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	food.setActivity(activityLevel);
	    	food.setAge(age);
	    	food.setWeightGoal(weightGoalAsString);
	    	food.setHeight(height);
	    	food.setSex(sex);
	    	food.setWeight(weight);
	    	food.calculateBMR();
	    	food.calculateAMR();
	    	food.calculateCals();
	    	double myCalories = food.getCalories();
	    	
	    	if (myCalories == 0) caloriesEnterLabel.setText("No goal entered");
	    	else caloriesEnterLabel.setText("Based on your given Physical data and dietary goal, \nyou should consume: \n"
	    				+ myCalories +" calories weekly \n"
	    				+ myCalories/7 + " calories daily");
	    	caloriesEnterLabel.setMinHeight(100);
	    }
	    
	    @FXML
	    void toSleep(ActionEvent sleepEvent) {
	    	Scene mainScene = applicationStage.getScene();
	       	VBox sleepContainer = new VBox(10);
	       	sleepContainer.setMinHeight(200);
	       	sleepContainer.setMinWidth(300);
	    	HBox enterSleepGoal = new HBox(5);
	    	Label enterSleepGoalLabel = new Label("Enter your sleep goal");
	    	Label hourLabel = new Label("Hour");
	    	Label minuteLabel = new Label("Minute");
	    	hourChoiceBox.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
	    	minuteChoiceBox.getItems().addAll(0,5,10,15,20,25,30,35,40,45,50,55);
	    	enterSleepGoal.getChildren().addAll(hourLabel, hourChoiceBox, minuteLabel, minuteChoiceBox);
	    	Label bedtimeLabel = new Label("How much sleep did you get?");
	    	HBox bedtimeContainer = new HBox(5);
	    	Label hourLabel2 = new Label("Hour");
	    	Label minuteLabel2 = new Label("Minute");
	    	bedtimeContainer.getChildren().addAll(hourLabel2, hourChoiceBox2, minuteLabel2, minuteChoiceBox2);
	    	hourChoiceBox2.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12);
	        minuteChoiceBox2.getItems().addAll(0,5,10,15,20,25,30,35,40,45,50,55);
	        Button calculateSleep = new Button("Calculate");
	        calculateSleep.setOnAction(calculateEvent -> createSleepHabit(hourChoiceBox.getValue(), minuteChoiceBox.getValue(), hourChoiceBox2.getValue(), minuteChoiceBox2.getValue()));
	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
	    	sleepContainer.getChildren().addAll(enterSleepGoalLabel, enterSleepGoal, bedtimeLabel, bedtimeContainer, calculateSleep, errorLabel, goalLabel, doneButton);
	    	Scene sleepScene = new Scene(sleepContainer);
	    	applicationStage.setScene(sleepScene);
	    }

	    @FXML
	    void toFood(ActionEvent foodEvent) {
	    	index = 0;
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	Scene mainScene = applicationStage.getScene();
	    	Label weightGoalLabel = new Label("What is your dietary goal?");
	    
	    	ChoiceBox<String> weightGoalChoiceBox = new ChoiceBox<String>();
	    	weightGoalChoiceBox.getItems().addAll("Lose Weight","Maintain Weight","Gain Weight");
	    	
	    	Button setWeightGoalButton = new Button ("Set Goal");
	    	
	    	
	    	weightGoalContainer.getChildren().addAll( weightGoalChoiceBox,setWeightGoalButton);
	    	VBox foodDataSceneContainer = new VBox(10);
	    	foodDataSceneContainer.setMinHeight(320);
	    	foodDataSceneContainer.setMinWidth(300);
	    	caloriesEnterLabel.setText("");
	    	
	    	
	    	setWeightGoalButton.setOnAction(calorieCalc -> createFoodHabit (weightGoalChoiceBox.getValue()));
	    	
	    	
	    	calorieInputLabel.setText("How many calories consumed on Monday?");
	    	TextField enterCalories = new TextField();
	    	Button dataCalorieButton = new Button ("Enter");
	    	dataCalorieButton.setOnAction(enterAction -> dailyCalorieData (enterCalories.getText())  );
	    	
	    	calorieDataContainer.getChildren().addAll(enterCalories,dataCalorieButton);

	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent2 -> caloriesDoneButton(mainScene));
	    	
	    	foodDataSceneContainer.getChildren().addAll(weightGoalLabel, weightGoalContainer, caloriesEnterLabel,calorieInputLabel,  calorieDataContainer, errorLabel, goalLabel, doneButton);

	    	Scene foodScene = new Scene(foodDataSceneContainer);
	        applicationStage.setScene(foodScene);
	       
	    }
	    
	    void caloriesDoneButton(Scene scene) {
	    	calorieDataContainer.getChildren().removeAll(calorieDataContainer.getChildren());
	    	weightGoalContainer.getChildren().removeAll(weightGoalContainer.getChildren());
	    	applicationStage.setScene(scene);
	    }
	    
	    @FXML
	    void toExpenses(ActionEvent expensesEvent) {
	     	//set the error and goal labels to blank
	     	errorLabel.setText("");
	     	goalLabel.setText("");

	     	//set the scene to the main scene
	     	Scene mainScene = applicationStage.getScene();

	     	//create the visual parts of the expenses scene
	     	HBox exGoalContainer = new HBox(10);
	     	exGoalContainer.setMinWidth(300);
	    	Label exGoalLabel = new Label("Spending Goal");
	    	TextField exGoalTextField = new TextField();
	    	exGoalContainer.getChildren().addAll(exGoalLabel, exGoalTextField );

	     	VBox dataSceneContainer = new VBox(10);		
	     	Label moneySpentLabel = new Label("Money spent today");
	     	HBox foodContainer = new HBox(10);
	    	TextField foodTextField = new TextField();
	    	Label foodLabel = new Label("Food");
	    	foodContainer.getChildren().addAll(foodLabel, foodTextField);		
	    	HBox entertainmentContainer = new HBox(10);
	    	TextField entertainmentTextField = new TextField();
	    	Label entertainmentLabel = new Label("Entertainment");
	    	entertainmentContainer.getChildren().addAll(entertainmentLabel, entertainmentTextField);		
	    	HBox groceriesContainer = new HBox(10);
	    	TextField groceriesTextField = new TextField();
	    	Label groceriesLabel = new Label("Groceries");
	    	groceriesContainer.getChildren().addAll(groceriesLabel, groceriesTextField);		
	    	HBox otherContainer = new HBox(10);
	     	TextField otherTextField = new TextField();
	     	Label otherLabel = new Label("Other");
	     	otherContainer.getChildren().addAll(otherLabel, otherTextField);

	    	Button calculateSpent = new Button("Calculate");
	     	Button doneButton = new Button("Done");
	     	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));	 		


	     	//give the done button action
	     	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));	 

	     	//give the calculate button action
	     	calculateSpent.setOnAction(calculateEvent -> createExpensesHabit(exGoalTextField.getText(), foodTextField.getText() , entertainmentTextField.getText(), groceriesTextField.getText(), otherTextField.getText())); 


	     	//create the expenses scene and set it
	     	dataSceneContainer.getChildren().addAll(exGoalContainer, moneySpentLabel,
	     			foodContainer, entertainmentContainer,groceriesContainer, 
	     			otherContainer, calculateSpent,  errorLabel, goalLabel, doneButton);
	     	Scene expensesScene = new Scene(dataSceneContainer);
	     	applicationStage.setScene(expensesScene);
	     }

	    @FXML
	    void toExercise(ActionEvent toExerciseScene) {
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	Scene mainScene = applicationStage.getScene();
			HBox stepsGoalContainer = new HBox(10);
			Label exerciseGoalLabel = new Label("What workouts do you want to complete this week?");
			workoutGoalChoiceBox.getItems().addAll("Chest", "Legs", "Back", "Core" ,  "Shoulders", "Arms", "Push", "Pull", "Cardio");
			Button workoutGoalAddButton = new Button("Add");
			workoutGoalAddButton.setOnAction(addEvent1 -> addWorkoutGoal(workoutGoalChoiceBox.getValue()));
			stepsGoalContainer.getChildren().addAll(exerciseGoalLabel, workoutGoalChoiceBox, workoutGoalAddButton);
			VBox exerciseDataWholeContainer = new VBox(10);
			HBox stepsDataContainer = new HBox(10);
			Label stepsDataLabel = new Label("What workouts have you completed this week?");
			Button workoutCompletedAddButton = new Button("Add");
			workoutCompletedAddButton.setOnAction(addEvent2 -> addWorkoutCompleted(workoutCompletedChoiceBox.getValue()));
			stepsDataContainer.getChildren().addAll(stepsDataLabel, workoutCompletedChoiceBox, workoutCompletedAddButton);
			Button calculateButton = new Button("Calculate");
			Button doneButton = new Button("Done");
		   	calculateButton.setOnAction(calculateEvent -> createExerciseHabit(workoutGoalList, workoutCompletedList));
		   	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));		
			exerciseDataWholeContainer.getChildren().addAll(stepsGoalContainer, stepsDataContainer, calculateButton, errorLabel,  goalLabel, doneButton);
			Scene exerciseScene = new Scene(exerciseDataWholeContainer);
			applicationStage.setScene(exerciseScene);
	    }

	    @FXML
	    void toWater(ActionEvent toWaterEvent) {
	    	index = 0;
	    	waterGoalContainer.getChildren().removeAll(waterGoalContainer.getChildren());
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	Scene mainScene = applicationStage.getScene();
	    	waterGoalLabel.setText("What is your water goal for the week?");
	    	Label mLLabel = new Label("L");
	    	waterGoalContainer.getChildren().addAll(waterGoalTextField, mLLabel);
	    	VBox waterDataWholeContainer = new VBox(10);
	    	waterDataWholeContainer.setMinWidth(300);
	    	waterDataLabel.setText("How much water did you drink on Monday?");
	    	Label literLabel = new Label("L");
	    	Button addDailyButton = new Button("Add");
	    	addDailyButton.setOnAction(addevent -> addDailyWater(waterDataTextField.getText(), waterGoalTextField.getText()));
	    	waterDataContainer.getChildren().addAll(waterDataTextField, literLabel, addDailyButton);
	   		Button doneButton = new Button("Done");
	   		waterDataWholeContainer.getChildren().addAll(waterGoalLabel, waterGoalContainer,
	   				waterDataLabel, waterDataContainer, errorLabel, goalLabel, doneButton);
	   		Scene waterScene = new Scene(waterDataWholeContainer);
	   		doneButton.setOnAction(doneEvent -> waterDoneButton(mainScene));
	   		applicationStage.setScene(waterScene);
	    }

	    @FXML
	    void getDailyScore(ActionEvent toDailyScoreEvent) {
	    	Scene mainScene = applicationStage.getScene();
	    	VBox dailyScoreAll = new VBox(10);
	    	Label dailyScoreLabel = new Label("Your daily Score!");
	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
	    
	    	metExerciseGoalInfo.setText(String.format("you have completed %.02f"
					+ "%% of your exercise goal", stepGrade));
	    	metWaterGoalInfo.setText(String.format("you have completed %.02f"
					+ "%% of your water goal", waterGrade));
	    	metFoodGoalInfo.setText(String.format("you have completed %.02f"
					+ "%% of your food goal", foodGrade));
	    	metSleepGoalInfo.setText(String.format("you have completed %.02f"
					+ "%% of your sleep goal", sleepGrade));
	    	metExpensesGoalInfo.setText(String.format("you have completed %.02f"
					+ "%% of your spending goal", spendGrade));
	    	
	    	//Calculate dailyScore
	    	double dailyScore = 0.0;
	    	dailyScore = weightedStepGrade + weightedSpendGrade + weightedWaterGrade +
	    			weightedFoodGrade + weightedSleepGrade;
	    	
	    	HBox overallScoreContainer = new HBox(5);
	    	Label printOverallScore = new Label(String.format("Your overall score is %.02f" + "%%", dailyScore));
	    	Label yayLabel = new Label("! Good Job!!");
	    	overallScoreContainer.getChildren().addAll(printOverallScore, yayLabel);
	    	
	    	dailyScoreAll.getChildren().addAll(dailyScoreLabel, metSleepGoalInfo,  metFoodGoalInfo, metExpensesGoalInfo, metExerciseGoalInfo, metWaterGoalInfo, overallScoreContainer, doneButton);
	    	Scene scoreScene = new Scene(dailyScoreAll);
	    	applicationStage.setScene(scoreScene);
	    }

	}