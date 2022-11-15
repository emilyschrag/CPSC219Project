package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
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
    private Label overallScore = new Label(" ");
    private TextField nameTextField = new TextField();
    private ChoiceBox<Integer> ageChoiceBox = new ChoiceBox();
    private ChoiceBox<Integer> sexChoiceBox = new ChoiceBox();
    private TextField heightTextField = new TextField();
    private TextField weightTextField = new TextField();
    private ChoiceBox<Integer> hourChoiceBox = new ChoiceBox();
    private ChoiceBox<Integer> minuteChoiceBox = new ChoiceBox();
    private ChoiceBox<Integer> hourChoiceBox2 = new ChoiceBox();
    private ChoiceBox<Integer> minuteChoiceBox2 = new ChoiceBox();
    private ChoiceBox<Integer> hourChoiceBox3 = new ChoiceBox();
    private ChoiceBox<Integer> minuteChoiceBox3 = new ChoiceBox();
    private ChoiceBox<Integer> ampmChoiceBox = new ChoiceBox();
    private ChoiceBox<Integer> ampmChoiceBox2 = new ChoiceBox();
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
 
    
    @FXML
    void enterInfo(ActionEvent enterInfo) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	//Create the container that will hold everything else in this scene
    	VBox userInfoContainer = new VBox(20);
    	Label titleLabel = new Label("Enter your information!");
    	
    	//container for entering name
    	HBox nameContainer = new HBox(10);
    	Label nameLabel = new Label("Enter your name");
    	nameContainer.getChildren().addAll(nameLabel, nameTextField);
    	String userName = new String(nameTextField.getText());
    	
    	//container for entering age 
    	HBox ageContainer = new HBox(10);
    	Label ageLabel = new Label("Enter your Age");
    	ageContainer.getChildren().addAll(ageLabel, ageChoiceBox);
    	int userAge = ageChoiceBox.getValue();
    	
    	//container for entering sex 
    	HBox sexContainer = new HBox(10);
    	Label sexLabel = new Label("Enter your Sex");
    	sexContainer.getChildren().addAll(sexLabel, sexChoiceBox);
    	int userSex = sexChoiceBox.getValue();
    	
    	//container for entering height 
    	HBox heightContainer = new HBox(10);
    	
    	Label heightLabel = new Label("Enter your height in cm");
    	heightContainer.getChildren().addAll(heightLabel, heightTextField);
    	String userHeight = heightTextField.getText();
    	
    	//container for entering weight 
    	HBox weightContainer = new HBox(10);
    	Label weightLabel = new Label("Enter your weight in kg");
    	weightContainer.getChildren().addAll(weightLabel, weightTextField);
    	String userWeight = weightTextField.getText();
    	
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
    void toSleepIntermediate(ActionEvent sleepIntermediate) {
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
    	
    		int sleepHour = hourChoiceBox.getValue();
    		int sleepMinute = minuteChoiceBox.getValue();
    		
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
    		
    			int sleepHour2 = hourChoiceBox2.getValue();
    			int sleepMinute2 = minuteChoiceBox2.getValue();
    			int sleepAMPM = ampmChoiceBox.getValue();
    			
    			Label waketimeLabel = new Label("What time did you wake up?");
    		
    			HBox waketimeContainer = new HBox(5);
    			Label hourLabel3 = new Label("Hour");
    			Label minuteLabel3 = new Label("Minute");
    			Label ampmLabel2 = new Label("AM/PM");
    			waketimeContainer.getChildren().addAll(hourLabel3, hourChoiceBox3, minuteLabel3, minuteChoiceBox3, ampmLabel2, ampmChoiceBox2);
    		
    			int sleepHour3 = hourChoiceBox3.getValue();
    			int sleepMinute3 = minuteChoiceBox3.getValue();
    			int sleepAMPM2 = ampmChoiceBox2.getValue();
    			
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
    		
    		String foodWeightGoal = weightGoalChoiceBox.getValue();
    		
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
    			String foodCalories = enterCalories.getText();
    			
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
    		String expensesGoal = exGoalTextField.getText();
    		
    		Label printExGoal = new Label("print spending goal here");
    		
    		Button doneButton = new Button("Done");
    	
    		exGoalWholeContainer.getChildren().addAll(exGoalContainer, printExGoal, doneButton);
    		Scene exGoalScene = new Scene(exGoalWholeContainer);
    		toExGoal.setOnAction(toExGoalEvent -> applicationStage.setScene(exGoalScene));

    			//create the expenses data scene 
    			VBox dataSceneContainer = new VBox(10);
    			
    			Label moneySpentLabel = new Label("Money spent today");
    			HBox foodContainer = new HBox(10);
    			Label foodLabel = new Label("Food");
    			foodContainer.getChildren().addAll(foodLabel, foodTextField);
    			String expensesFood = foodTextField.getText();
    			
    			HBox entertainmentContainer = new HBox(10);
    			Label entertainmentLabel = new Label("Entertainment");
    			entertainmentContainer.getChildren().addAll(entertainmentLabel, entertainmentTextField);
    			String expensesEnt = entertainmentTextField.getText();
    			
    			HBox groceriesContainer = new HBox(10);
    			Label groceriesLabel = new Label("Groceries");
    			groceriesContainer.getChildren().addAll(groceriesLabel, groceriesTextField);
    			String expensesGroceries =groceriesTextField.getText();
    			
    			HBox otherContainer = new HBox(10);
    			Label otherLabel = new Label("Other");
    			otherContainer.getChildren().addAll(otherLabel, otherTextField);
    			String expensesOther = otherTextField.getText();
    			
    			Button calculateSpent = new Button("Calculate");
    			
    			Label printSpent = new Label("Print amount spent here");
    			metExpensesGoalInfo.setText("Print if goal met here");
    			
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    					
    			dataSceneContainer.getChildren().addAll(moneySpentLabel, foodContainer, entertainmentContainer, groceriesContainer, otherContainer, calculateSpent, printSpent,metExpensesGoalInfo, doneButton2);
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
			String exerciseStepsGoal = stepsGoalTextField.getText();
			
			Label printStepsGoal = new Label("print step goal here");
	;
		
			Button doneButton = new Button("Done");
			doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
	
			exerciseGoalWholeContainer.getChildren().addAll(stepsGoalContainer, printStepsGoal, doneButton);
			Scene exerciseGoalScene = new Scene(exerciseGoalWholeContainer);
			toExerciseGoal.setOnAction(toExerciseGoalEvent -> applicationStage.setScene(exerciseGoalScene));

				//create the exercise goal data scene
				VBox exerciseDataWholeContainer = new VBox(10);
				
				HBox stepsDataContainer = new HBox(10);
				Label stepsDataLabel = new Label("Number of steps");
				stepsDataContainer.getChildren().addAll(stepsDataLabel, stepsDataTextField);
				String exerciseStepsData = stepsDataTextField.getText();
				
				Button calculateButton = new Button("Calculate");
				
				Label printAllData = new Label("print data here");
				metExerciseGoalInfo.setText("print goal info here");
				
				Button doneButton2 = new Button("Done");
				doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
				
				exerciseDataWholeContainer.getChildren().addAll(stepsDataContainer, calculateButton, printAllData, metExerciseGoalInfo, doneButton2);
				Scene exerciseDataScene = new Scene(exerciseDataWholeContainer);
				doneButton.setOnAction(toExerciseDataScene -> applicationStage.setScene(exerciseDataScene));
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
    		String waterGoal =  waterGoalTextField.getText();
    		
			Label printWaterGoal = new Label("print water goal here");
	
			Button doneButton = new Button("Done");

			waterGoalWholeContainer.getChildren().addAll(waterGoalContainer, printWaterGoal, doneButton);
			Scene waterGoalScene = new Scene(waterGoalWholeContainer);
			toWaterGoal.setOnAction(toWaterGoalEvent -> applicationStage.setScene(waterGoalScene));


    			//create water data scene
    			VBox waterDataWholeContainer = new VBox(10);
		
    			HBox waterDataContainer = new HBox(10);
    			Label waterDataLabel = new Label("How much water did you drink (in mL)?");
    			waterDataContainer.getChildren().addAll(waterDataLabel, waterDataTextField, mLLabel);
    			String waterData = waterDataTextField.getText();
    			
    			Label printWaterData = new Label("print water amount here");
    			metWaterGoalInfo.setText("print goal info here");
	
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent -> applicationStage.setScene(mainScene));


    			waterDataWholeContainer.getChildren().addAll(waterDataContainer, printWaterData, metWaterGoalInfo, doneButton2);
    			Scene waterDataScene = new Scene(waterDataWholeContainer);
    			doneButton.setOnAction(doneEvent -> applicationStage.setScene(waterDataScene));
    }


    @FXML
    void getDailyScore(ActionEvent toDailyScoreEvent) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	
    	VBox dailyScoreAll = new VBox(10);
    	Label dailyScore = new Label("Your daily Score!");
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	HBox overallScoreContainer = new HBox(5);
    	Label printOverallScore = new Label("Your overall score is ");
    	Label yayLabel = new Label("! Good Job!!");
    	overallScoreContainer.getChildren().addAll(printOverallScore, overallScore, yayLabel);
    	
    	if (metSleepGoalInfo.getText() == " ")
    		metSleepGoalInfo.setText("no info entered");
    	if (metFoodGoalInfo.getText() == " ")
    		metFoodGoalInfo.setText("no info entered");
    	if (metExpensesGoalInfo.getText() == " ")
    		metExpensesGoalInfo.setText("no info entered");
    	if (metExerciseGoalInfo.getText() == " ")
    		metExerciseGoalInfo.setText("no info entered");
    	if (metWaterGoalInfo.getText() == " ")
    		metWaterGoalInfo.setText("no info entered");
    	dailyScoreAll.getChildren().addAll(dailyScore, metSleepGoalInfo,  metFoodGoalInfo, metExpensesGoalInfo, metExerciseGoalInfo, metWaterGoalInfo, overallScoreContainer, doneButton);
    	
    	Scene scoreScene = new Scene(dailyScoreAll);
    	applicationStage.setScene(scoreScene);
    }

}

