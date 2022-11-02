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
    void enterInfo(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	
    	VBox userInfoContainer = new VBox();
    	HBox nameContainer = new HBox();
    	Label nameLabel = new Label("Enter your name");
    	TextField nameTextField = new TextField();
    	nameContainer.getChildren().addAll(nameLabel, nameTextField);
    	
    	HBox ageContainer = new HBox();
    	Label ageLabel = new Label("Enter your Age");
    	ChoiceBox ageChoiceBox = new ChoiceBox();
    	ageContainer.getChildren().addAll(ageLabel, ageChoiceBox);
    	
    	HBox sexContainer = new HBox();
    	Label sexLabel = new Label("Enter your Sex");
    	ChoiceBox sexChoiceBox = new ChoiceBox();
    	sexContainer.getChildren().addAll(sexLabel, sexChoiceBox);
    	
    	HBox heightContainer = new HBox();
    	Label heightLabel = new Label("Enter your height in cm");
    	TextField heightTextField = new TextField();
    	heightContainer.getChildren().addAll(heightLabel, heightTextField);
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel = new Label("Enter your weight in kg");
    	TextField weightTextField = new TextField();
    	weightContainer.getChildren().addAll(weightLabel, weightTextField);
    	
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	userInfoContainer.getChildren().addAll(nameContainer, ageContainer, sexContainer, heightContainer, weightContainer);
    	Scene infoScene = new Scene(userInfoContainer);
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

