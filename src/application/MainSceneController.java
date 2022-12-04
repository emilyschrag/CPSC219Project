package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
    private TextField nameTextField = new TextField();
    private ChoiceBox<String> ageChoiceBox = new ChoiceBox();
    private ChoiceBox<String> sexChoiceBox = new ChoiceBox();
    private TextField heightTextField = new TextField();
    private TextField weightTextField = new TextField();
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
   
   void createWaterHabit(String dataAsString, String goalAsString) {
   	errorLabel.setText("");
   	goalLabel.setText("");
   	Habit water = new Habit(); 
   	errorLabel.setText(water.setGoal(goalAsString));
   	errorLabel.setText(water.setValue(dataAsString));
   	water.calculateGrade();
   	waterGrade = water.getGrade();
   	weightedWaterGrade = water.getWeightedGrade();
   	if (water.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your water intake goal.");
   	else if (water.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your water intake goal.");
   	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your water intake goal", waterGrade));
   }
   
   void createExpenseHabit(String dataAsString, String goalAsString) {
	   errorLabel.setText("");
   	goalLabel.setText("");
   	Habit spend = new Habit(); 
   	errorLabel.setText(spend.setGoal(goalAsString));
   	errorLabel.setText(spend.setValue(dataAsString));
   	spend.calculateGrade();
   	spendGrade = spend.getGrade();
   	weightedSpendGrade = spend.getWeightedGrade();
   	if (spend.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your spending goal.");
   	else if (spend.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your spending goal.");
   	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your spending goal", foodGrade));
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
    
    void createFoodHabit(String dataAsString, String goalAsString) {
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Habit food = new Habit(); 
    	errorLabel.setText(food.setGoal(goalAsString));
    	errorLabel.setText(food.setValue(dataAsString));
    	food.calculateGrade();
    	foodGrade = food.getGrade();
    	weightedFoodGrade = food.getWeightedGrade();
    	if (food.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your calorie goal.");
    	else if (food.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your calorie goal.");
    	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your calorie goal", foodGrade));
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
    	Label weightGoalLabel = new Label("What is your calorie goal?");
    	TextField weightGoalTextField = new TextField();
    	weightGoalContainer.getChildren().addAll(weightGoalLabel, weightGoalTextField);
    	VBox foodDataSceneContainer = new VBox(10);
    	Label caloriesEnterLabel = new Label("How many calories have you consumed?");
    	TextField enterCalories = new TextField();
    	Button calculateButton = new Button("Calculate");
    	calculateButton.setOnAction(calculateEvent -> createFoodHabit(weightGoalTextField.getText(), enterCalories.getText()));
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));	
    	foodDataSceneContainer.getChildren().addAll(weightGoalContainer, caloriesEnterLabel, enterCalories, calculateButton, errorLabel, goalLabel, doneButton);
    	Scene foodScene = new Scene(foodDataSceneContainer);
        applicationStage.setScene(foodScene);
    }

    @FXML
    void toExpenses(ActionEvent expensesEvent) {
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Scene mainScene = applicationStage.getScene();
    	HBox exGoalContainer = new HBox(10);
   		Label exGoalLabel = new Label("Spending Goal");
   		TextField exGoalTextField = new TextField();
   		exGoalContainer.getChildren().addAll(exGoalLabel, exGoalTextField );
   		
   		VBox dataSceneContainer = new VBox(10);
    	HBox exDataContainer = new HBox(10);
   		Label exDataLabel = new Label("Money Spent:");
   		TextField exDataTextField = new TextField();
   	
   		Button calculateSpent = new Button("Calculate");
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));				
    	calculateSpent.setOnAction(calculateEvent -> createExpenseHabit(exGoalTextField.getText(),exDataTextField.getText()));
    	dataSceneContainer.getChildren().addAll(exGoalContainer, exDataContainer, exDataLabel, exDataTextField, calculateSpent,  errorLabel, goalLabel, doneButton);
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
		//workoutCompletedChoiceBox.getItems().addAll("Chest", "Legs", "Back", "Core" ,  "Shoulders", "Arms", "Push", "Pull", "Cardio");
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
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Scene mainScene = applicationStage.getScene();
    	HBox waterGoalContainer = new HBox(10);
    	Label waterGoalLabel = new Label("What is your water goal?");
    	Label mLLabel = new Label("mL");
    	waterGoalContainer.getChildren().addAll(waterGoalLabel, waterGoalTextField, mLLabel);
    	VBox waterDataWholeContainer = new VBox(10);
    	HBox waterDataContainer = new HBox(10);
    	Label waterDataLabel = new Label("How much water did you drink (in mL)?");
    	waterDataContainer.getChildren().addAll(waterDataLabel, waterDataTextField, mLLabel);
   		Button doneButton = new Button("Done");
   		Button calculateButton = new Button("Calculate");
   		waterDataWholeContainer.getChildren().addAll(waterGoalContainer, waterDataContainer,calculateButton, errorLabel, goalLabel, doneButton);
   		Scene waterScene = new Scene(waterDataWholeContainer);
   		calculateButton.setOnAction(calculateEvent -> createWaterHabit(waterDataTextField.getText(), waterGoalTextField.getText()));
   		doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
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