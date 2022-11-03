package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.awt.Insets;

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
    void toSleepIntermediate(ActionEvent event) {
    	Scene sleepIntermediateScene = new Scene(new Label("Placeholder"));
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

