package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

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
    private ChoiceBox<String> ampmChoiceBox = new ChoiceBox();
    private ChoiceBox<String> ampmChoiceBox2 = new ChoiceBox();
    private ChoiceBox<String> weightGoalChoiceBox = new ChoiceBox();
    private TextField enterCalories = new TextField();
    private TextField exGoalTextField = new TextField();
    private TextField foodTextField = new TextField();
    private TextField entertainmentTextField = new TextField();
    private TextField groceriesTextField = new TextField();
    private TextField otherTextField = new TextField();
    private TextField stepsGoalTextField = new TextField();
    private TextField waterGoalTextField = new TextField();
    private TextField waterDataTextField = new TextField();
    private TextField stepsDataTextField = new TextField();
    private double stepsGrade;
    private int stepsGoal;
    private int stepsData;
    private double waterGrade;
    private int waterGoal;
    private int waterData;
    private int foodData;
    private int grocData;
    private int entData;
    private int otherData;
    private int spendingData;
    private int spendingGoal;
    private double spendingGrade;
    
    
    void createStepsHabit(String dataAsString, String goalAsString) {
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Habit step = new Habit(); 
    	errorLabel.setText(step.setGoal(goalAsString));
    	errorLabel.setText(step.setValue(dataAsString));
    	step.calculateGrade();
    	double stepGrade = step.getGrade();
    	if (step.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your exercise goal.");
    	else if (step.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your exercise goal.");
    	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your exercise goal", stepGrade));
    }
    
    void createWaterHabit(String dataAsString, String goalAsString) {
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Habit water = new Habit(); 
    	errorLabel.setText(water.setGoal(goalAsString));
    	errorLabel.setText(water.setValue(dataAsString));
    	water.calculateGrade();
    	double waterGrade = water.getGrade();
    	if (water.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your water intake goal.");
    	else if (water.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your water intake goal.");
    	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your exercise goal", waterGrade));
    }
    
    @FXML
    void enterInfo(ActionEvent enterInfoEvent) {
    	Scene mainScene = applicationStage.getScene();
    	VBox userInfoContainer = new VBox(20);
    	Label titleLabel = new Label("Enter your information!");
    	HBox nameContainer = new HBox(10);
    	Label nameLabel = new Label("Enter your name");
    	nameContainer.getChildren().addAll(nameLabel, nameTextField);
    	HBox ageContainer = new HBox(10);
    	Label ageLabel = new Label("Enter your Age");
    	ageContainer.getChildren().addAll(ageLabel, ageChoiceBox);
    	ageChoiceBox.getItems().addAll("0-9", "10-19", "20-29", "30-39", "40,49", "50-59", "60-69", "70-79", "80-89", "90-99");
    	HBox sexContainer = new HBox(10);
    	Label sexLabel = new Label("Enter your Sex");
    	sexContainer.getChildren().addAll(sexLabel, sexChoiceBox);
    	sexChoiceBox.getItems().addAll("Male", "Female", "Prefer not to Say");
    	HBox heightContainer = new HBox(10);
    	Label heightLabel = new Label("Enter your height in cm");
    	heightContainer.getChildren().addAll(heightLabel, heightTextField);
    	HBox weightContainer = new HBox(10);
    	Label weightLabel = new Label("Enter your weight in kg");
    	weightContainer.getChildren().addAll(weightLabel, weightTextField);
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	userInfoContainer.getChildren().addAll(titleLabel, nameContainer, ageContainer, sexContainer, heightContainer, weightContainer, doneButton);
    	Scene infoScene = new Scene(userInfoContainer, 300, 325);
    	applicationStage.setScene(infoScene);
    }
    
    @FXML
    void toSleepIntermediate(ActionEvent sleepIntermediateEvent) {
    	Scene mainScene = applicationStage.getScene();
       	VBox sleepContainer = new VBox(10);
    	HBox enterSleepGoal = new HBox(5);
    	Label enterSleepGoalLabel = new Label("Enter your sleep goal");
    	Label hourLabel = new Label("Hour");
    	Label minuteLabel = new Label("Minute");
    	hourChoiceBox.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
    	minuteChoiceBox.getItems().addAll(0,5,10,15,20,25,30,35,40,45,50,55);
    	enterSleepGoal.getChildren().addAll(hourLabel, hourChoiceBox, minuteLabel, minuteChoiceBox);
    	Label bedtimeLabel = new Label("What time did you go to bed?");
    	HBox bedtimeContainer = new HBox(5);
    	Label hourLabel2 = new Label("Hour");
    	Label minuteLabel2 = new Label("Minute");
    	Label ampmLabel = new Label("AM/PM");
    	bedtimeContainer.getChildren().addAll(hourLabel2, hourChoiceBox2, minuteLabel2, minuteChoiceBox2, ampmLabel, ampmChoiceBox);
    	hourChoiceBox2.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        minuteChoiceBox2.getItems().addAll(0,5,10,15,20,25,30,35,40,45,50,55);
        ampmChoiceBox.getItems().addAll("AM", "PM");
    	Label waketimeLabel = new Label("What time did you wake up?");
    	HBox waketimeContainer = new HBox(5);
    	Label hourLabel3 = new Label("Hour");
    	Label minuteLabel3 = new Label("Minute");
    	Label ampmLabel2 = new Label("AM/PM");
    	waketimeContainer.getChildren().addAll(hourLabel3, hourChoiceBox3, minuteLabel3, minuteChoiceBox3, ampmLabel2, ampmChoiceBox2);
    	hourChoiceBox3.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        minuteChoiceBox3.getItems().addAll(0,5,10,15,20,25,30,35,40,45,50,55);
        ampmChoiceBox2.getItems().addAll("AM", "PM");	
    	Button calculateSleep = new Button("Calculate");	
    	Label printSleep = new Label("Print sleep amount here");
    	metSleepGoalInfo.setText("Print sleep goal here");
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    	sleepContainer.getChildren().addAll(enterSleepGoalLabel, enterSleepGoal, bedtimeLabel, bedtimeContainer, waketimeLabel, waketimeContainer, calculateSleep, printSleep, metSleepGoalInfo, doneButton);
    	Scene sleepScene = new Scene(sleepContainer);
    	Button backButton = new Button("Back");
    	backButton.setOnAction(backEvent -> applicationStage.setScene(mainScene));
    	applicationStage.setScene(sleepScene);
    			

    }

    @FXML
    void toFoodIntermediate(ActionEvent foodIntermediateEvent) {
    	Scene mainScene = applicationStage.getScene();
    	VBox foodGoalContainer = new VBox(10);
    	HBox weightGoalContainer = new HBox(10);
    	Label weightGoalLabel = new Label("What is your dietary goal?");
    	weightGoalContainer.getChildren().addAll(weightGoalLabel, weightGoalChoiceBox);
    	HBox printWeightGoal = new HBox(10);
    	Label printCaloriesInfo = new Label("Based on your provided physical characteristics, you should comsume ");
    	Label printCalories = new Label(" num here ");
    	Label caloriesLabel = new Label("calories");
    	printWeightGoal.getChildren().addAll(printCaloriesInfo, printCalories, caloriesLabel);
    	foodGoalContainer.getChildren().addAll(weightGoalContainer, printWeightGoal);
    	VBox foodDataSceneContainer = new VBox(10);
    	Label caloriesEnterLabel = new Label("How many calories have you consumed?");
    	metFoodGoalInfo.setText("print if goal met");
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));	
    	foodDataSceneContainer.getChildren().addAll(weightGoalContainer, caloriesEnterLabel, enterCalories,  metFoodGoalInfo, doneButton);
    	Scene foodScene = new Scene(foodDataSceneContainer);
        applicationStage.setScene(foodScene);
    }

    @FXML
    void toExpensesIntermediate(ActionEvent expensesIntermediateEvent) {
    	Scene mainScene = applicationStage.getScene();
    	HBox exGoalContainer = new HBox(10);
   		Label exGoalLabel = new Label("Spending Goal");
   		exGoalContainer.getChildren().addAll(exGoalLabel, exGoalTextField );
    	VBox dataSceneContainer = new VBox(10);		
    	Label moneySpentLabel = new Label("Money spent today");
    	HBox foodContainer = new HBox(10);
    	Label foodLabel = new Label("Food");
    	foodContainer.getChildren().addAll(foodLabel, foodTextField);		
    	HBox entertainmentContainer = new HBox(10);
    	Label entertainmentLabel = new Label("Entertainment");
    	entertainmentContainer.getChildren().addAll(entertainmentLabel, entertainmentTextField);		
    	HBox groceriesContainer = new HBox(10);
    	Label groceriesLabel = new Label("Groceries");
    	groceriesContainer.getChildren().addAll(groceriesLabel, groceriesTextField);		
    	HBox otherContainer = new HBox(10);
    	Label otherLabel = new Label("Other");
    	otherContainer.getChildren().addAll(otherLabel, otherTextField);		
   		Button calculateSpent = new Button("Calculate");
  		Label printExpenses = new Label("Print amount here");		
   		metExpensesGoalInfo.setText("Print goal here");	
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));				
    	dataSceneContainer.getChildren().addAll(exGoalContainer, moneySpentLabel, foodContainer, entertainmentContainer, groceriesContainer, otherContainer, calculateSpent, printExpenses, metExpensesGoalInfo, doneButton);
    	Scene expensesScene = new Scene(dataSceneContainer);
    	applicationStage.setScene(expensesScene);
    }

    @FXML
    void toExerciseIntermediate(ActionEvent toExerciseIntermediateScene) {
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Scene mainScene = applicationStage.getScene();
		HBox stepsGoalContainer = new HBox(10);
		Label stepsGoalLabel = new Label("What is your step goal?");
		Label stepsLabel = new Label("Steps");
		stepsGoalContainer.getChildren().addAll(stepsGoalLabel, stepsGoalTextField, stepsLabel);
		VBox exerciseDataWholeContainer = new VBox(10);
		HBox stepsDataContainer = new HBox(10);
		Label stepsDataLabel = new Label("Number of steps");
		stepsDataContainer.getChildren().addAll(stepsDataLabel, stepsDataTextField);
		Button calculateButton = new Button("Calculate");
		Button doneButton = new Button("Done");
	   	calculateButton.setOnAction(calculateEvent -> createStepsHabit(stepsDataTextField.getText(), stepsGoalTextField.getText()));
	   	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));		
		exerciseDataWholeContainer.getChildren().addAll(stepsGoalContainer, stepsDataContainer, calculateButton, errorLabel,  goalLabel, doneButton);
		Scene exerciseScene = new Scene(exerciseDataWholeContainer);
		applicationStage.setScene(exerciseScene);
    }

    @FXML
    void toWaterIntermediate(ActionEvent toWaterIntermediateEvent) {
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
    
    	
    	//Sleep
    	if (metSleepGoalInfo.getText() == " ")
    		metSleepGoalInfo.setText("no info entered");
    	
    	//Food
    	if (metFoodGoalInfo.getText() == " ")
    		metFoodGoalInfo.setText("no info entered");
    
    	
    	//Water
    	if (waterGoalTextField.getText() != "") {
    		waterGoal = Integer.parseInt(waterGoalTextField.getText()); }
    	else waterGoal = 0;
    	if (waterDataTextField.getText() != "") {
    		waterData = Integer.parseInt(waterDataTextField.getText());}
    	else {
    		waterData = 0;
    	}
    	
    	
    	
    	
    	//Exercise 
    	if (stepsGoalTextField.getText() != "") {
    		stepsGoal = Integer.parseInt(stepsGoalTextField.getText());
    	}
    	else stepsGoal = 0;
    	if (stepsDataTextField.getText() != "") {
    		stepsData = Integer.parseInt(stepsDataTextField.getText());
    	}
    	else stepsData = 0;
    	
    	if (stepsGoal == 0 || stepsGoal ==0) {
    		metExerciseGoalInfo.setText("No info entered");
    	}
    	
    	//Calculate dailyScore
    	double dailyScore = 0;
    	if (waterGrade != 0)
    		dailyScore += waterGrade;
    	if (stepsGrade != 0)
    		dailyScore += stepsGrade;
    	if (spendingGoal != 0)
    		dailyScore += spendingGrade;
    	//need to divide by number of habits with data
    	dailyScore = dailyScore/3;
    	
    	HBox overallScoreContainer = new HBox(5);
    	Label printOverallScore = new Label("Your overall score is " + dailyScore);
    	Label yayLabel = new Label("! Good Job!!");
    	overallScoreContainer.getChildren().addAll(printOverallScore, yayLabel);
    	
    	dailyScoreAll.getChildren().addAll(dailyScoreLabel, metSleepGoalInfo,  metFoodGoalInfo, metExpensesGoalInfo, metExerciseGoalInfo, metWaterGoalInfo, overallScoreContainer, doneButton);
    	Scene scoreScene = new Scene(dailyScoreAll);
    	applicationStage.setScene(scoreScene);
    }

}

