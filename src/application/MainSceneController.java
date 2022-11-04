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
    void toFoodIntermediate(ActionEvent event) {
    	Scene foodIntermediateScene = new Scene(new Label("Placeholder"));
    	applicationStage.setScene(foodIntermediateScene);
    	
    }

    @FXML
    void toExpensesIntermediate(ActionEvent event) {
    	Scene expensesIntermediateScene = new Scene(new Label("Placeholder"));
    	applicationStage.setScene(expensesIntermediateScene);
    	
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

