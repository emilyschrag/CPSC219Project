package application;

//import required packages
import javafx.fxml.FXML;
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
	    private Label errorLabel = new Label("");
	    private Label goalLabel = new Label("");

	    //Start of User info
	    private ChoiceBox<String> ageChoiceBox = new ChoiceBox();
	    private ChoiceBox<String> sexChoiceBox = new ChoiceBox();
	    private TextField heightTextField = new TextField();
	    private TextField weightTextField = new TextField();
	    //End of User Info
	    
	    //Start of sleep info
	    private Label metSleepGoalInfo = new Label(" ");
	    private ChoiceBox<Integer> hourChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> hourChoiceBox2 = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox2 = new ChoiceBox();
	    private double sleepGrade;
	    private double weightedSleepGrade;
	    //End of sleep info
	    
	    //Start of expenses Info
	    private Label metExpensesGoalInfo = new Label(" ");
	    private TextField foodTextField = new TextField();
	    private TextField entertainmentTextField = new TextField();
	    private TextField groceriesTextField = new TextField();
	    private TextField otherTextField = new TextField();
	    private double spendGrade;
	    private double weightedSpendGrade;
	    //End of expenses info
	    
	    //Start of water info
	    private Label metWaterGoalInfo = new Label(" ");
	    private TextField waterGoalTextField = new TextField();
	    private TextField waterDataTextField = new TextField();
	    private double waterGrade;
	    private double weightedWaterGrade;
	    //End of water info 
	    
	    //Start of food info 
	    private Label metFoodGoalInfo = new Label(" ");
	    private double foodGrade;
	    private double weightedFoodGrade;
	    //End of food info 
	    
	    //Start of exercise info 
	    private Label metExerciseGoalInfo = new Label(" ");
	    private TextField stepsGoalTextField = new TextField();
	    private TextField stepsDataTextField = new TextField();
	    private double stepGrade;
	    private double weightedStepGrade;
	    //End of exercise info
	 
	    
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
	    	
	    	//done button to take user back to main scene when information is entered
	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
	    	
	    	// add all components to main container
	    	userInfoContainer.getChildren().addAll(titleLabel, ageContainer, sexContainer, heightContainer, weightContainer, doneButton);
	    	
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
 */
	   void createSleepHabit (double goalHour, double goalMinute, double valueHour, double valueMinute) {
		    //set the error and goal labels to blank
		    errorLabel.setText("");
		    goalLabel.setText("");
		    
		    //create the sleep habit, set the goal and value, calculate and get the grade
	   	    Habit sleep = new Habit();
	   	    sleep.setSleepGoal(goalHour, goalMinute);
	 	    sleep.setSleepValue(valueHour, valueMinute);
	   	    sleep.calculateGrade();
	 	    sleepGrade = sleep.getGrade();
	 	    weightedSleepGrade = sleep.getWeightedGrade();
	 	    
	 	    //check the grade and choose what to print in the goal label
	 	    if (sleepGrade > 100) goalLabel.setText("Congratulations! You have surpassed your sleep goal.");
	 	    else if (sleep.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your sleep goal.");
	 	    else goalLabel.setText(String.format("you have completed %.0f"
					+ "%% of your sleep goal", sleepGrade));
	   }
    
/**
 * 	   
 * @param dataAsString
 * @param goalAsString
 */
    void createWaterHabit(String dataAsString, String goalAsString) {
    	//set the error and goal labels to blank
       	errorLabel.setText("");
       	goalLabel.setText("");
       	
        //create the water habit, set the goal and value, calculate and get the grade
       	Habit water = new Habit(); 
       	errorLabel.setText(water.setGoal(goalAsString));
       	errorLabel.setText(water.setValue(dataAsString));
       	water.calculateGrade();
       	waterGrade = water.getGrade();
       	weightedWaterGrade = water.getWeightedGrade();
       	
        //check the grade and choose what to print in the goal label
      	if (waterGrade > 100) goalLabel.setText("Congratulations! You have surpassed your water intake goal.");
       	else if (water.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your water intake goal.");
       	else goalLabel.setText(String.format("you have completed %.0f"
    				+ "%% of your water intake goal", waterGrade));
       }
  
/**
 *     
 * @param goalAsString
 * @param foodAsString
 * @param entAsString
 * @param grocAsString
 * @param otherAsString
 */
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

/**
 *     
 * @param dataAsString
 * @param goalAsString
 */
    void createStepsHabit(String dataAsString, String goalAsString) {
    	//set the error and goal labels to blank
    	errorLabel.setText("");
    	goalLabel.setText("");
    	
    	//create the steps habit, set the goal and value, calculate and get the grade
    	Habit step = new Habit(); 
    	errorLabel.setText(step.setGoal(goalAsString));
    	errorLabel.setText(step.setValue(dataAsString));
    	step.calculateGrade();
    	stepGrade = step.getGrade();
    	weightedStepGrade = step.getWeightedGrade();
    	
        //check the grade and choose what to print in the goal label
    	if (stepGrade > 100) goalLabel.setText("Congratulations! You have surpassed your exercise goal.");
    	else if (step.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your exercise goal.");
    	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your exercise goal", stepGrade));
    }

/**
 * 
 * @param dataAsString
 * @param goalAsString
 */
    void createFoodHabit(String dataAsString, String goalAsString) {
    	//set the error and goal labels to blank
    	errorLabel.setText("");
    	goalLabel.setText("");
    	
   	    //create the steps habit, set the goal and value, calculate and get the grade
    	Habit food = new Habit(); 
    	errorLabel.setText(food.setGoal(goalAsString));
    	errorLabel.setText(food.setValue(dataAsString));
    	food.calculateGrade();
    	foodGrade = food.getGrade();
    	weightedFoodGrade = food.getWeightedGrade();
    	
        //check the grade and choose what to print in the goal label
    	if (food.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your calorie goal.");
    	else if (food.getGrade() > 100) goalLabel.setText("Congratulations! You have surpassed your calorie goal.");
    	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your calorie goal", stepGrade));
    }

/**
 *    
 * @param sleepEvent
 */
    @FXML
    void toSleep(ActionEvent sleepEvent) {
    	//set the error and goal labels to blank
    	errorLabel.setText("");
    	goalLabel.setText("");
    	
    	//set the scene to the main scene
    	Scene mainScene = applicationStage.getScene();
    	
    	//create the visual components of the sleep scene
       	VBox sleepContainer = new VBox(10);
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
        
        //give the calculate button action
        calculateSleep.setOnAction(calculateEvent -> createSleepHabit(hourChoiceBox.getValue(), minuteChoiceBox.getValue(), hourChoiceBox2.getValue(), minuteChoiceBox2.getValue()));
    	Button doneButton = new Button("Done");
    	
    	//give the done button action
    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));
    	
    	//create the sleep scene and set it
    	sleepContainer.getChildren().addAll(enterSleepGoalLabel, enterSleepGoal, bedtimeLabel, bedtimeContainer, calculateSleep, errorLabel, goalLabel, doneButton);
    	Scene sleepScene = new Scene(sleepContainer);
    	applicationStage.setScene(sleepScene);
    }
    
/**
 *   
 * @param foodEvent
 */
    @FXML
    void toFood(ActionEvent foodEvent) {
    	//set the error and goal labels to blank
    	errorLabel.setText("");
    	goalLabel.setText("");
    	
    	//set the scene to the main scene
    	Scene mainScene = applicationStage.getScene();
    	
    	//create the visual parts of the food scene
    	HBox weightGoalContainer = new HBox(10);
    	Label weightGoalLabel = new Label("What is your dietary goal?");
    	ChoiceBox weightGoalChoiceBox = new ChoiceBox();
    	weightGoalChoiceBox.getItems().addAll("Lose Weight","Maintain Weight","Gain Weight");
    	weightGoalContainer.getChildren().addAll(weightGoalLabel, weightGoalChoiceBox);
    	VBox foodDataSceneContainer = new VBox(10);
    	Label caloriesEnterLabel = new Label("Based on your given Physical data and dietary goal, you should consume: \n"
    			+ " ____ calories weekly \n"
    			+ " ____ calories daily");
    	TextField enterCalories = new TextField();
    	Button calculateButton = new Button("Calculate");
    	
     	//give the calculate button action
    	calculateButton.setOnAction(calculateEvent -> createFoodHabit((String) weightGoalChoiceBox.getValue(), enterCalories.getText()));
    	Button doneButton = new Button("Done");
    	
    	//give the done button action
    	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));	
    	
    	//create the food scene and set it
    	foodDataSceneContainer.getChildren().addAll(weightGoalContainer, caloriesEnterLabel, enterCalories, calculateButton, errorLabel, goalLabel, doneButton);
    	Scene foodScene = new Scene(foodDataSceneContainer);
        applicationStage.setScene(foodScene);
    }
 
/**
 *     
 * @param expensesEvent
 */
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

/**
 * 
 * @param toExerciseScene
 */
    @FXML
    void toExercise(ActionEvent toExerciseScene) {
    	//set the error and goal labels to blank
    	errorLabel.setText("");
    	goalLabel.setText("");
    	
    	//set the scene to the exercise scene
    	Scene mainScene = applicationStage.getScene();
    	
    	//create the visual parts of the expenses scene
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
		
		//give the calculate button action
	   	calculateButton.setOnAction(calculateEvent -> createStepsHabit(stepsDataTextField.getText(), stepsGoalTextField.getText()));
	    
	   	//give the done button action
	   	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));		
		
	   	//create the exercise scene and set it
	   	exerciseDataWholeContainer.getChildren().addAll(stepsGoalContainer, stepsDataContainer, calculateButton, errorLabel,  goalLabel, doneButton);
		Scene exerciseScene = new Scene(exerciseDataWholeContainer);
		applicationStage.setScene(exerciseScene);
    }

/**
 *     
 * @param toWaterEvent
 */
    @FXML
    void toWater(ActionEvent toWaterEvent) {
    	//set the error and goal labels to blank
    	errorLabel.setText("");
    	goalLabel.setText("");
    	
    	//set the scene to the exercise scene
    	Scene mainScene = applicationStage.getScene();
    	
    	//create the visual parts of the water scene
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
     	
   		//give the calculate button action
   		calculateButton.setOnAction(calculateEvent -> createWaterHabit(waterDataTextField.getText(), waterGoalTextField.getText()));
   		
   		//give the done button action
   		doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
   		
   		//create the water scene and set it
   		waterDataWholeContainer.getChildren().addAll(waterGoalContainer, waterDataContainer,calculateButton, errorLabel, goalLabel, doneButton);
   		Scene waterScene = new Scene(waterDataWholeContainer);
   		applicationStage.setScene(waterScene);
    }

/**
 *     
 * @param toDailyScoreEvent
 */
    @FXML
    void getDailyScore(ActionEvent toDailyScoreEvent) {
    	//set the main scene
    	Scene mainScene = applicationStage.getScene();
    	
    	//create visual components of daily score scene
    	VBox dailyScoreAll = new VBox(10);
    	Label dailyScoreLabel = new Label("Your daily Score!");
    	Button doneButton = new Button("Done");
    	
    	//give the done button action
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	//set the labels to print the correct scores for each habit
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
    	
    	//add visual components to scene
    	HBox overallScoreContainer = new HBox(5);
     	Label printOverallScore = new Label(String.format("Your overall score is %.02f" + "%%", dailyScore));
     	Label yayLabel = new Label("! Good Job!!");
     	overallScoreContainer.getChildren().addAll(printOverallScore, yayLabel);
    	dailyScoreAll.getChildren().addAll(dailyScoreLabel, metSleepGoalInfo,  metFoodGoalInfo, metExpensesGoalInfo, metExerciseGoalInfo, metWaterGoalInfo, overallScoreContainer, doneButton);
    	Scene scoreScene = new Scene(dailyScoreAll);
    	applicationStage.setScene(scoreScene);	
    }

}

