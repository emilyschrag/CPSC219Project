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
    
  
    
    @FXML
    void enterInfo(ActionEvent enterInfoEvent) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	//Create the container that will hold everything else in this scene
    	VBox userInfoContainer = new VBox(20);
    	Label titleLabel = new Label("Enter your information!");
    	
    	//container for entering name
    	HBox nameContainer = new HBox(10);
    	Label nameLabel = new Label("Enter your name");
    	nameContainer.getChildren().addAll(nameLabel, nameTextField);
    	//String userName = new String(nameTextField.getText());
    	
    	//container for entering age 
    	HBox ageContainer = new HBox(10);
    	Label ageLabel = new Label("Enter your Age");
    	ageContainer.getChildren().addAll(ageLabel, ageChoiceBox);
    	ageChoiceBox.getItems().addAll("0-9", "10-19", "20-29", "30-39", "40,49", "50-59", "60-69", "70-79", "80-89", "90-99");
    	//String userAge = ageChoiceBox.getValue();
    	
    	//container for entering sex 
    	HBox sexContainer = new HBox(10);
    	Label sexLabel = new Label("Enter your Sex");
    	sexContainer.getChildren().addAll(sexLabel, sexChoiceBox);
    	sexChoiceBox.getItems().addAll("Male", "Female", "Prefer not to Say");
    //	String userSex = sexChoiceBox.getValue();
    	
    	//container for entering height 
    	HBox heightContainer = new HBox(10);
    	
    	Label heightLabel = new Label("Enter your height in cm");
    	heightContainer.getChildren().addAll(heightLabel, heightTextField);
    //	String userHeight = heightTextField.getText();
    	
    	//container for entering weight 
    	HBox weightContainer = new HBox(10);
    	Label weightLabel = new Label("Enter your weight in kg");
    	weightContainer.getChildren().addAll(weightLabel, weightTextField);
    	//String userWeight = weightTextField.getText();
    	
    	//done button to take user back to main scene when information is entered
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	// add all components to main container
    	userInfoContainer.getChildren().addAll(titleLabel, nameContainer, ageContainer, sexContainer, heightContainer, weightContainer, doneButton);
    	//create a new scene that holds the main container
    	Scene infoScene = new Scene(userInfoContainer, 300, 325);
    	//set the scene to the info scene when the enterInfo action is initiated
    	applicationStage.setScene(infoScene);
    }
    
    @FXML
    void toSleepIntermediate(ActionEvent sleepIntermediateEvent) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	//Create the container that will hold everything else in this scene
    	VBox sleepIntContainer = new VBox(10);
    	
    	//container that has the button that takes you to the sleep data scene
    	HBox sleepGoalButtonContainer = new HBox(10);
    	Label sleepLabel = new Label("Enter your sleep goal");
    	Button toSleepGoal = new Button("Enter");
    	
    		//create the sleepGoal Scene
    		VBox sleepGoalContainer = new VBox(10);
    	
    		HBox enterSleepGoal = new HBox(5);
    		Label enterSleepGoalLabel = new Label("Enter your sleep goal");
    		Label hourLabel = new Label("Hour");
    		Label minuteLabel = new Label("Minute");
    		Label printSleepGoal = new Label("Your sleep goal: ");
    	
    		hourChoiceBox.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
    		minuteChoiceBox.getItems().addAll(0,5,10,15,20,25,30,35,40,45,50,55);
    		
    		//Done Button on sleep goal scene to take user to sleep data scene
    		Button doneButton = new Button("Done");
    	
    		enterSleepGoal.getChildren().addAll(hourLabel, hourChoiceBox, minuteLabel, minuteChoiceBox);
    		sleepGoalContainer.getChildren().addAll(enterSleepGoalLabel, enterSleepGoal, printSleepGoal, doneButton);
    		Scene sleepGoalScene = new Scene(sleepGoalContainer);
    		//the enter takes you to the sleep goal scene
    		toSleepGoal.setOnAction(toSleepGoalEvent -> applicationStage.setScene(sleepGoalScene));
    		
    			//create the sleepData Scene
    			VBox sleepDataContainer = new VBox(10);
    		
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
    		
    			Label printSleep = new Label("PRINT SLEEP AMOUNT HERE: ");
    			metSleepGoalInfo.setText("Print sleep goal here");
    		
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    		
    		
    			sleepDataContainer.getChildren().addAll(bedtimeLabel, bedtimeContainer, waketimeLabel, waketimeContainer, calculateSleep, printSleep, metSleepGoalInfo, doneButton2);
    			Scene sleepDataScene = new Scene(sleepDataContainer);
    			doneButton.setOnAction(doneEvent -> applicationStage.setScene(sleepDataScene));
    		
    		sleepGoalButtonContainer.getChildren().addAll(sleepLabel, toSleepGoal);
    	
    	//back button
    	Button backButton = new Button("Back");
    	backButton.setOnAction(backEvent -> applicationStage.setScene(mainScene));
    	
    	//add components to main container
    	sleepIntContainer.getChildren().addAll(sleepGoalButtonContainer, backButton);
    	//create a new scene that holds the main container 
    	Scene sleepIntermediateScene = new Scene(sleepIntContainer);
    	//set the scene to the sleep intermediate scene
    	applicationStage.setScene(sleepIntermediateScene);
    	
//    	int sleepHour = hourChoiceBox.getValue();
//		int sleepMinute = minuteChoiceBox.getValue();
//		int sleepHour2 = hourChoiceBox2.getValue();
//		int sleepMinute2 = minuteChoiceBox2.getValue();
//		String sleepAMPM = ampmChoiceBox.getValue();
//		int sleepHour3 = hourChoiceBox3.getValue();
//		int sleepMinute3 = minuteChoiceBox3.getValue();
//		String sleepAMPM2 = ampmChoiceBox2.getValue();
//		
		//create sleep objects
    }

    @FXML
    void toFoodIntermediate(ActionEvent foodIntermediateEvent) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	//Create the container that will hold everything else in this scene
    	VBox foodIntContainer = new VBox(10);
    	
    	//container that has the button that takes you to the food data scene
    	HBox foodGoalButtonContainer = new HBox(10);
    	Label foodLabel = new Label("Enter your food goal");
    	Button toFoodGoal = new Button("Enter");
    	foodGoalButtonContainer.getChildren().addAll(foodLabel, toFoodGoal);
    	
    	//back button
    	Button backButton = new Button("Back");
    	backButton.setOnAction(backEvent -> applicationStage.setScene(mainScene));
    	
    	//add components to main container
    	foodIntContainer.getChildren().addAll(foodGoalButtonContainer, backButton);
    	Scene foodIntermediateScene = new Scene(foodIntContainer);
    	applicationStage.setScene(foodIntermediateScene);
    	
    		//create the food goal scene
    		VBox foodGoalContainer = new VBox(10);
    		
    		HBox weightGoalContainer = new HBox(10);
    		Label weightGoalLabel = new Label("What is your dietary goal?");
    		weightGoalContainer.getChildren().addAll(weightGoalLabel, weightGoalChoiceBox);
    		
    		//String foodWeightGoal = weightGoalChoiceBox.getValue();
    		
    		HBox printWeightGoal = new HBox(10);
    		Label printCaloriesInfo = new Label("Based on your provided physical characteristics, you should comsume ");
    		Label printCalories = new Label(" num here ");
    		Label caloriesLabel = new Label("calories");
    		printWeightGoal.getChildren().addAll(printCaloriesInfo, printCalories, caloriesLabel);
    		
    		Button doneButton = new Button("Done");
    		
    		foodGoalContainer.getChildren().addAll(weightGoalContainer, printWeightGoal, doneButton);
    		Scene foodGoalScene = new Scene(foodGoalContainer);
    		toFoodGoal.setOnAction(toFoodGoalEvent -> applicationStage.setScene(foodGoalScene));
    			
    			//create the food data scene 
    			VBox foodDataSceneContainer = new VBox(10);
    			
    			Label caloriesEnterLabel = new Label("How many calories have you consumed?");
    			//String foodCalories = enterCalories.getText();
    			
    		    metFoodGoalInfo.setText("print if goal met");
    			
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    			
    			foodDataSceneContainer.getChildren().addAll(caloriesEnterLabel, enterCalories,  metFoodGoalInfo, doneButton2);
    			Scene foodDataScene = new Scene(foodDataSceneContainer);
        		doneButton.setOnAction(doneEvent -> applicationStage.setScene(foodDataScene));    	
    }

    @FXML
    void toExpensesIntermediate(ActionEvent expensesIntermediateEvent) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	//Create the container that will hold everything else in this scene
    	VBox exIntContainer = new VBox(10);
    	
    	//container that has the button that takes you to the food data scene
    	HBox exGoalButtonContainer = new HBox(10);
    	Label exLabel = new Label("Enter your spending goal");
    	Button toExGoal = new Button("Enter");
    	exGoalButtonContainer.getChildren().addAll(exLabel, toExGoal);
    	
    	//back button
    	Button backButton = new Button("Back");
    	backButton.setOnAction(backEvent -> applicationStage.setScene(mainScene));
    	
    	//add components to main container
    	exIntContainer.getChildren().addAll(exGoalButtonContainer, backButton);
    	Scene exIntermediateScene = new Scene(exIntContainer);
    	applicationStage.setScene(exIntermediateScene);
    	
    		//create the expenses goal scene
    		VBox exGoalWholeContainer = new VBox(10);
    		
    		HBox exGoalContainer = new HBox(10);
    		Label exGoalLabel = new Label("Spending Goal");
    		exGoalContainer.getChildren().addAll(exGoalLabel, exGoalTextField );
    		
    		Button doneButton = new Button("Done");
    	
    		exGoalWholeContainer.getChildren().addAll(exGoalContainer,  doneButton);
    		Scene exGoalScene = new Scene(exGoalWholeContainer);
    		toExGoal.setOnAction(toExGoalEvent -> applicationStage.setScene(exGoalScene));

    			//create the expenses data scene 
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
    			calculateSpent.setOnAction(calculateSpentEvent -> applicationStage.setScene(mainScene));
    		
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    					
    			dataSceneContainer.getChildren().addAll(moneySpentLabel, foodContainer, entertainmentContainer, groceriesContainer, otherContainer, calculateSpent, doneButton2);
    			Scene exDataScene = new Scene(dataSceneContainer);
    			doneButton.setOnAction(doneEvent -> applicationStage.setScene(exDataScene));
    }

    @FXML
    void toExerciseIntermediate(ActionEvent toExerciseIntermediateScene) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	//Create the container that will hold everything else in this scene
    	VBox exerciseIntContainer = new VBox(10);
    	
    	//container that has the button that takes you to the exercise data scene
    	HBox exerciseGoalButtonContainer = new HBox(10);
    	Label exerciseLabel = new Label("Enter your step goal");
    	Button toExerciseGoal = new Button("Enter");
    	exerciseGoalButtonContainer.getChildren().addAll(exerciseLabel, toExerciseGoal);
    	
    	//back button
    	Button backButton = new Button("Back");
    	backButton.setOnAction(backEvent -> applicationStage.setScene(mainScene));
    	
    	//add components to main container
    	exerciseIntContainer.getChildren().addAll(exerciseGoalButtonContainer, backButton);
    	Scene exerciseIntermediateScene = new Scene(exerciseIntContainer);
    	applicationStage.setScene(exerciseIntermediateScene);
    	
    		//create the exercise goal scene
			VBox exerciseGoalWholeContainer = new VBox(10);
		
			HBox stepsGoalContainer = new HBox(10);
			Label stepsGoalLabel = new Label("What is your step goal?");
			Label stepsLabel = new Label("Steps");
			stepsGoalContainer.getChildren().addAll(stepsGoalLabel, stepsGoalTextField, stepsLabel);
		
			Button doneButton = new Button("Done");
			doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
	
			exerciseGoalWholeContainer.getChildren().addAll(stepsGoalContainer,  doneButton);
			Scene exerciseGoalScene = new Scene(exerciseGoalWholeContainer);
			toExerciseGoal.setOnAction(toExerciseGoalEvent -> applicationStage.setScene(exerciseGoalScene));

				//create the exercise data scene
				VBox exerciseDataWholeContainer = new VBox(10);
				
				HBox stepsDataContainer = new HBox(10);
				Label stepsDataLabel = new Label("Number of steps");
				stepsDataContainer.getChildren().addAll(stepsDataLabel, stepsDataTextField);
				String exerciseStepsData = stepsDataTextField.getText();
				if (exerciseStepsData != "") {
					stepsData = Integer.parseInt(exerciseStepsData);}
				
				Button calculateButton = new Button("Calculate");
				Button doneButton2 = new Button("Done");
				doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));		

				exerciseDataWholeContainer.getChildren().addAll(stepsDataContainer, calculateButton, metExerciseGoalInfo, doneButton2);
				Scene exerciseDataScene = new Scene(exerciseDataWholeContainer);
				doneButton.setOnAction(toExerciseDataScene -> applicationStage.setScene(exerciseDataScene));
				calculateButton.setOnAction(calculateEvent -> applicationStage.setScene(mainScene));
    }

    @FXML
    void toWaterIntermediate(ActionEvent toWaterIntermediateEvent) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	//Create the container that will hold everything else in this scene
    	VBox waterIntContainer = new VBox(10);
    	
    	//container that has the button that takes you to the water data scene
    	HBox waterGoalButtonContainer = new HBox(10);
    	Label waterLabel = new Label("Enter your water goal (in mL)");
    	
    	Button toWaterGoal = new Button("Enter");
    	waterGoalButtonContainer.getChildren().addAll(waterLabel, toWaterGoal);
    	
    	//back button
    	Button backButton = new Button("Back");
    	backButton.setOnAction(backEvent -> applicationStage.setScene(mainScene));
    	
    	//add components to main container
    	waterIntContainer.getChildren().addAll(waterGoalButtonContainer, backButton);
    	Scene waterIntermediateScene = new Scene(waterIntContainer);
    	applicationStage.setScene(waterIntermediateScene);
    		
    		//create water goal scene
    		VBox waterGoalWholeContainer = new VBox(10);
		
    		HBox waterGoalContainer = new HBox(10);
    		Label waterGoalLabel = new Label("What is your water goal?");
    		Label mLLabel = new Label("mL");
    		waterGoalContainer.getChildren().addAll(waterGoalLabel, waterGoalTextField, mLLabel);
    		//String waterGoal =  waterGoalTextField.getText();
    		
	
			Button doneButton = new Button("Done");

			waterGoalWholeContainer.getChildren().addAll(waterGoalContainer, doneButton);
			Scene waterGoalScene = new Scene(waterGoalWholeContainer);
			toWaterGoal.setOnAction(toWaterGoalEvent -> applicationStage.setScene(waterGoalScene));


    			//create water data scene
    			VBox waterDataWholeContainer = new VBox(10);
		
    			HBox waterDataContainer = new HBox(10);
    			Label waterDataLabel = new Label("How much water did you drink (in mL)?");
    			waterDataContainer.getChildren().addAll(waterDataLabel, waterDataTextField, mLLabel);
    			//String waterData = waterDataTextField.getText();
    			
    	
	
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent -> applicationStage.setScene(mainScene));


    			waterDataWholeContainer.getChildren().addAll(waterDataContainer, metWaterGoalInfo, doneButton2);
    			Scene waterDataScene = new Scene(waterDataWholeContainer);
    			doneButton.setOnAction(doneEvent -> applicationStage.setScene(waterDataScene));
    }

    @FXML
    void getDailyScore(ActionEvent toDailyScoreEvent) {
    	//Set the original scene to mainScene
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
    	
    	//Expenses
    	if (foodTextField.getText() != "")
    		foodData = Integer.parseInt(foodTextField.getText());
    	else 
    		foodData = 0;
    	if (entertainmentTextField.getText() != "")
    		entData = Integer.parseInt(entertainmentTextField.getText());
    	else 
    		entData = 0;
    	if (groceriesTextField.getText() != "")
    		grocData = Integer.parseInt(groceriesTextField.getText());
    	else 
    		grocData = 0;
    	if (otherTextField.getText() != "")
    		otherData = Integer.parseInt(otherTextField.getText());
    	else
    		otherData = 0;
    	
    	spendingData = foodData + entData + grocData + otherData;
    	if (exGoalTextField.getText() != "")
    		spendingGoal = Integer.parseInt(exGoalTextField.getText());
    	else
    		spendingGoal = 0;
    	
    	if (spendingData == 0 || spendingGoal ==0) {
    		metExpensesGoalInfo.setText("no info entered"); }
    	else {
    		Habit expensesHabit = new Habit(spendingData, spendingGoal);
    		expensesHabit.calculateGrade();
    		spendingGrade = expensesHabit.getGrade();
    		metExpensesGoalInfo.setText("Spending Grade " + spendingGrade);
    	}
//    	System.out.println(spendingGoal);
//    	System.out.println(spendingData);
//    	System.out.println(spendingGrade);
    	
    	
    	//Water
    	if (waterGoalTextField.getText() != "") {
    		waterGoal = Integer.parseInt(waterGoalTextField.getText()); }
    	else waterGoal = 0;
    	if (waterDataTextField.getText() != "") {
    		waterData = Integer.parseInt(waterDataTextField.getText());}
    	else {
    		waterData = 0;
    	}
    	
    	if (waterData == 0 || waterGoal == 0) {
    	metWaterGoalInfo.setText("No info entered");
    	} else {
    	Habit waterHabit = new Habit(waterData, waterGoal);
    	waterHabit.calculateGrade();
    	waterGrade = waterHabit.getGrade();
    	metWaterGoalInfo.setText("Water Grade: " + waterGrade); }
    	
//    	System.out.println(waterGoal);
//    	System.out.println(waterData);
//    	System.out.println(waterGrade);
//    	
    	
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
    	else {
    	Habit stepsHabit = new Habit(stepsData, stepsGoal);
    	stepsHabit.calculateGrade();
    	stepsGrade = stepsHabit.getGrade();
    	metExerciseGoalInfo.setText("Step Grade:" + stepsGrade); }
   
//    	System.out.println(stepsGoal);
//    	System.out.println(stepsData);
//    	System.out.println(stepsGrade);
    	
    	//Calculate dailyScore
    	double dailyScore = 0;
    	if (waterGrade != 0)
    		dailyScore += waterGrade;
    	if (stepsGrade != 0)
    		dailyScore += stepsGrade;
    	if (spendingGoal != 0)
    		dailyScore += spendingGoal;
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

