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
	    private ChoiceBox<Integer> hourChoiceBox3 = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox3 = new ChoiceBox();
	    private ChoiceBox<String> ampmChoiceBox2 = new ChoiceBox();
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

	 
	    
//USER INFO	     
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
	    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
	    	
	    	// add all components to main container
	    	userInfoContainer.getChildren().addAll(titleLabel, ageContainer, sexContainer, heightContainer, weightContainer, activityContainer, doneButton);
	    	//create a new scene that holds the main container
	    	Scene infoScene = new Scene(userInfoContainer, 300, 325);
	    	//set the scene to the info scene when the enterInfo action is initiated
	    	applicationStage.setScene(infoScene);
	    }    
//END USER INFO
	   
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
	 	    weightedSleepGrade = sleep.getWeightedGrade();
	 	    if (sleep.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your sleep goal.");
	 	    else if (sleep.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your sleep goal.");
	 	    else goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your sleep goal", sleepGrade));
	   }
	   
	   void addDailyWater(String waterIntake, String waterGoal) {
		   waterGoalContainer.getChildren().removeAll(waterGoalContainer.getChildren());
		   waterGoalLabel.setText("Your water goal for the week is " + waterGoal + "L" );
		   waterGoalContainer.getChildren().addAll(waterGoalLabel);
		   
		   if (index == 6) waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
			   
		   if (index < 6) {
			   dailyWaterList.add(waterIntake);
			   waterDataLabel.setText("How much water did you drink on" + days[index] + "?");
		   }
		   
		   index++;
		  
		   Water drink = new Water(waterGoal, dailyWaterList);
		   drink.total();
		   double waterGrade = drink.getGrade();
		   
		   goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your water goal", waterGrade));
		   //if (waterGrade == 100) goalLabel.setText("Congradulations! You have reached your sleep goal.");
		   //else if (waterGrade > 100) goalLabel.setText("Congradulations! You have surpassed your sleep goal.");
		   //else goalLabel.setText(String.format("you have completed %.0f"
					//+ "%% of your sleep goal", waterGrade));
		   
	   }
	   
	   void waterDoneButton(Scene mainScene) {
		   waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
		   applicationStage.setScene(mainScene);
		   
	   }
	   
	   void createExpensesHabit(String goalAsString, String foodAsString, String entAsString, String grocAsString, String otherAsString) {
	     	//set the error and goal labels to blank
	     	errorLabel.setText("");
	      	goalLabel.setText("");

	         //create the expenses habit, set the goal and value, calculate and get the grade
	      	Expenses spend = new Expenses();
	      	errorLabel.setText(spend.setFood(foodAsString));
	      	errorLabel.setText(spend.setGroc(grocAsString));
	     	errorLabel.setText(spend.setOther(otherAsString));
	     	errorLabel.setText(spend.setEnt(entAsString));
	      	spend.calculateGrade(spend.calculateTotal(), goalAsString);
	      	spendGrade = spend.getGrade();
	      	weightedSpendGrade = spend.getWeightedGrade();

	      	 //check the grade and choose what to print in the goal label
	      	if (spendGrade > 100.0) goalLabel.setText("You have surpassed your spending goal.");
	      	else if (spendGrade == 100) goalLabel.setText("Congratulations! You have reached your spending goal.");
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
	    	//errorLabel.setText(step.setGoal(goalAsString));
	    	//errorLabel.setText(step.setValue(dataAsString));
	    	workouts.calculate();
	    	stepGrade = workouts.getGrade();
	    	//weightedStepGrade = workouts.getWeightedGrade();
	    	if (workouts.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your exercise goal.");
	    	else if (workouts.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your exercise goal.");
	    	else goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your exercise goal", stepGrade));
	    }
	    
	    void createFoodHabit(String ageAsString, String sexAsString , String heightAsString, String weightAsString, String activityAsString, String weightGoalAsString ) {
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	Habit food = new Habit(); 
	    	//errorLabel.setText(food.setGoal(goalAsString));
	    	//errorLabel.setText(food.setValue(dataAsString));
	    	food.calculateGrade();
	    	//double myCalories = food.getCalories;
	    	foodGrade = food.getGrade();
	    	weightedFoodGrade = food.getWeightedGrade();
	    	if (food.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your calorie goal.");
	    	else if (food.getGrade() > 100) goalLabel.setText("Congratulations! You have surpassed your calorie goal.");
	    	else goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your calorie goal", stepGrade));
	    }
	    
	    @FXML
	    void toSleep(ActionEvent sleepEvent) {
	    	Scene mainScene = applicationStage.getScene();
	       	VBox sleepContainer = new VBox(10);
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
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	Scene mainScene = applicationStage.getScene();
	    	HBox weightGoalContainer = new HBox(10);
	    	Label weightGoalLabel = new Label("What is your dietary goal?");
	    
	    	ChoiceBox weightGoalChoiceBox = new ChoiceBox();
	    	weightGoalChoiceBox.getItems().addAll("Lose Weight","Maintain Weight","Gain Weight");
	    	
	    	Button setWeightGoalButton = new Button ("Set Goal");
	    	setWeightGoalButton.setOnAction(calorieCalc -> createFoodHabit (ageChoiceBox.getValue(),sexChoiceBox.getValue(),heightTextField.getText(),
	    			weightTextField.getText(),activityChoiceBox.getValue(), (String) weightGoalChoiceBox.getValue()));
	    	
	    	weightGoalContainer.getChildren().addAll(weightGoalLabel, weightGoalChoiceBox,setWeightGoalButton);
	    	VBox foodDataSceneContainer = new VBox(10);
	    	Label caloriesEnterLabel = new Label ("");
	    	
	    	/*Label caloriesEnterLabel = new Label("Based on your given Physical data and dietary goal, you should consume: \n"
	    	 *		+ " ____ calories weekly \n"
	    	 *		+ " ____ calories daily");
	    	 * 
	    	 */
	    	    	
	    	
	    	TextField enterCalories = new TextField();

	    	//Button calculateButton = new Button("Calculate");
	    	//calculateButton.setOnAction(calculateEvent -> createFoodHabit((String) weightGoalChoiceBox.getValue(), enterCalories.getText()));

	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));	

	    	foodDataSceneContainer.getChildren().addAll(weightGoalContainer, caloriesEnterLabel, enterCalories, errorLabel, goalLabel, doneButton);

	    	Scene foodScene = new Scene(foodDataSceneContainer);
	        applicationStage.setScene(foodScene);
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
	    	waterGoalContainer.getChildren().addAll(waterGoalLabel, waterGoalTextField, mLLabel);
	    	VBox waterDataWholeContainer = new VBox(10);
	    	waterDataLabel.setText("How much water did you drink on Monday?");
	    	Label literLabel = new Label("L");
	    	Button addDailyButton = new Button("Add");
	    	addDailyButton.setOnAction(addevent -> addDailyWater(waterDataTextField.getText(), waterGoalTextField.getText()));
	    	waterDataContainer.getChildren().addAll(waterDataLabel, waterDataTextField, literLabel, addDailyButton);
	   		Button doneButton = new Button("Done");
	   		waterDataWholeContainer.getChildren().addAll(waterGoalContainer, waterDataContainer, errorLabel, goalLabel, doneButton);
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
	    	//need to divide by number of habits with data

	    	
	    	HBox overallScoreContainer = new HBox(5);
	    	Label printOverallScore = new Label(String.format("Your overall score is %.02f" + "%%", dailyScore));
	    	Label yayLabel = new Label("! Good Job!!");
	    	overallScoreContainer.getChildren().addAll(printOverallScore, yayLabel);
	    	
	    	dailyScoreAll.getChildren().addAll(dailyScoreLabel, metSleepGoalInfo,  metFoodGoalInfo, metExpensesGoalInfo, metExerciseGoalInfo, metWaterGoalInfo, overallScoreContainer, doneButton);
	    	Scene scoreScene = new Scene(dailyScoreAll);
	    	applicationStage.setScene(scoreScene);
	    }

	}