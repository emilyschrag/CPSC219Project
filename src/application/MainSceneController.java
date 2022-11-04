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
    private DatePicker todaysDatePicker;

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
    	TextField nameTextField = new TextField();
    	nameContainer.getChildren().addAll(nameLabel, nameTextField);
    	
    	//container for entering age 
    	HBox ageContainer = new HBox(10);
    	Label ageLabel = new Label("Enter your Age");
    	ChoiceBox ageChoiceBox = new ChoiceBox();
    	ageContainer.getChildren().addAll(ageLabel, ageChoiceBox);
    	
    	//container for entering sex 
    	HBox sexContainer = new HBox(10);
    	Label sexLabel = new Label("Enter your Sex");
    	ChoiceBox sexChoiceBox = new ChoiceBox();
    	sexContainer.getChildren().addAll(sexLabel, sexChoiceBox);
    	
    	//container for entering height 
    	HBox heightContainer = new HBox(10);
    	
    	Label heightLabel = new Label("Enter your height in cm");
    	TextField heightTextField = new TextField();
    	heightContainer.getChildren().addAll(heightLabel, heightTextField);
    	
    	//container for entering weight 
    	HBox weightContainer = new HBox(10);
    	Label weightLabel = new Label("Enter your weight in kg");
    	TextField weightTextField = new TextField();
    	weightContainer.getChildren().addAll(weightLabel, weightTextField);
    	
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
    		ChoiceBox hourChoiceBox = new ChoiceBox();
    		Label minuteLabel = new Label("Minute");
    		ChoiceBox minuteChoiceBox = new ChoiceBox();
    		Label printSleepGoal = new Label("Your sleep goal: ");
    	
    		//Done Button on sleep goal scene to take user to sleepdata scene
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
    			ChoiceBox hourChoiceBox2 = new ChoiceBox();
    			Label minuteLabel2 = new Label("Minute");
    			ChoiceBox minuteChoiceBox2 = new ChoiceBox();
    			Label ampmLabel = new Label("AM/PM");
    			ChoiceBox ampmChoiceBox = new ChoiceBox();
    			bedtimeContainer.getChildren().addAll(hourLabel2, hourChoiceBox2, minuteLabel2, minuteChoiceBox2, ampmLabel, ampmChoiceBox);
    		
    			Label waketimeLabel = new Label("What time did you wake up?");
    		
    			HBox waketimeContainer = new HBox(5);
    			Label hourLabel3 = new Label("Hour");
    			ChoiceBox hourChoiceBox3 = new ChoiceBox();
    			Label minuteLabel3 = new Label("Minute");
    			ChoiceBox minuteChoiceBox3 = new ChoiceBox();
    			Label ampmLabel2 = new Label("AM/PM");
    			ChoiceBox ampmChoiceBox2 = new ChoiceBox();
    			waketimeContainer.getChildren().addAll(hourLabel3, hourChoiceBox3, minuteLabel3, minuteChoiceBox3, ampmLabel2, ampmChoiceBox2);
    		
    			Button calculateSleep = new Button("Calculate");
    		
    			Label printSleep = new Label("PRINT SLEEP AMOUNT HERE: ");
    			Label metGoalInfo = new Label("PRINT GOAL MET INFO HERE: ");
    		
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    		
    		
    			sleepDataContainer.getChildren().addAll(bedtimeLabel, bedtimeContainer, waketimeLabel, waketimeContainer, calculateSleep, printSleep, metGoalInfo, doneButton2);
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
    		ChoiceBox weightGoalChoiceBox = new ChoiceBox();
    		weightGoalContainer.getChildren().addAll(weightGoalLabel, weightGoalChoiceBox);
    		
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
    			TextField enterCalories = new TextField();
    			
    			Label caloriesGoal = new Label("print if goal met");
    			
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    			
    			foodDataSceneContainer.getChildren().addAll(caloriesEnterLabel, enterCalories, caloriesGoal, doneButton2);
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
    		TextField exGoalTextField = new TextField();
    		exGoalContainer.getChildren().addAll(exGoalLabel, exGoalTextField );
    		
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
    			TextField foodTextField = new TextField();
    			foodContainer.getChildren().addAll(foodLabel, foodTextField);
    			
    			HBox entertainmentContainer = new HBox(10);
    			Label entertainmentLabel = new Label("Entertainment");
    			TextField entertainmentTextField = new TextField();
    			entertainmentContainer.getChildren().addAll(entertainmentLabel, entertainmentTextField);
    			
    			HBox groceriesContainer = new HBox(10);
    			Label groceriesLabel = new Label("Groceries");
    			TextField groceriesTextField = new TextField();
    			groceriesContainer.getChildren().addAll(groceriesLabel, groceriesTextField);
    			
    			HBox otherContainer = new HBox(10);
    			Label otherLabel = new Label("Other");
    			TextField otherTextField = new TextField();
    			otherContainer.getChildren().addAll(otherLabel, otherTextField);
    			
    			Button calculateSpent = new Button("Calculate");
    			
    			Label printSpent = new Label("Print amount spent here");
    			Label goalMet = new Label("Print if goal met here");
    			
    			Button doneButton2 = new Button("Done");
    			doneButton2.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    					
    			dataSceneContainer.getChildren().addAll(moneySpentLabel, foodContainer, entertainmentContainer, groceriesContainer, otherContainer, calculateSpent, printSpent, goalMet, doneButton2);
    			Scene exDataScene = new Scene(dataSceneContainer);
    			doneButton.setOnAction(doneEvent -> applicationStage.setScene(exDataScene));
    			

    }

    @FXML
    void toExerciseIntermediate(ActionEvent event) {
    	Scene exerciseIntermediateScene = new Scene(new Label("Placeholder"));
    	applicationStage.setScene(exerciseIntermediateScene);
    	
    }

    @FXML
    void toWaterIntermediate(ActionEvent event) {
    	Scene waterIntermediateScene = new Scene(new Label("Placeholder"));
    	applicationStage.setScene(waterIntermediateScene);
    	
    }


    @FXML
    void getDailyScore(ActionEvent event) {
    	Scene scoreScene = new Scene(new Label("Placeholder"));
    	applicationStage.setScene(scoreScene);
    	
    }

}

