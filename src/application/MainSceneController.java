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
	    //Start of User info
	    private ChoiceBox<String> ageChoiceBox = new ChoiceBox();
	    private ChoiceBox<String> sexChoiceBox = new ChoiceBox();
	    private TextField heightTextField = new TextField();
	    private TextField weightTextField = new TextField();
	    private ChoiceBox<String> activityChoiceBox = new ChoiceBox();
	    //End of User Info
	    private ChoiceBox<Integer> hourChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> hourChoiceBox2 = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox2 = new ChoiceBox();
	    private ChoiceBox<Integer> hourChoiceBox3 = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox3 = new ChoiceBox();
	    private ChoiceBox<String> ampmChoiceBox2 = new ChoiceBox();
	    private ChoiceBox<String> weightGoalChoiceBox = new ChoiceBox();
	  //  private TextField exGoalTextField = new TextField();
	    private TextField foodTextField = new TextField();
	    private TextField entertainmentTextField = new TextField();
	    private TextField groceriesTextField = new TextField();
	    private TextField otherTextField = new TextField();
	    private TextField stepsGoalTextField = new TextField();
	    private TextField waterGoalTextField = new TextField();
	    private TextField waterDataTextField = new TextField();
	    private TextField stepsDataTextField = new TextField();

	    
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
	    
	   // private String total;
	    
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
    
    void createExpensesHabit(String goalAsString, String foodAsString, String entAsString, String grocAsString, String otherAsString) {
    	errorLabel.setText("");
     	goalLabel.setText("");
     	Expenses spend = new Expenses();
     	errorLabel.setText(spend.setFood(foodAsString));
     	errorLabel.setText(spend.setGroc(grocAsString));
     	errorLabel.setText(spend.setOther(otherAsString));
     	errorLabel.setText(spend.setEnt(entAsString));
     	spend.calculateGrade(spend.calculateTotal(), goalAsString);
     	spendGrade = spend.getGrade();
     	weightedSpendGrade = spend.getWeightedGrade();
     	if (spendGrade > 100.0) goalLabel.setText("You have surpassed your spending goal.");
     	else if (spendGrade == 100) goalLabel.setText("Congradulations! You have reached your spending goal.");
     	else goalLabel.setText(String.format("you have completed %.0f"
  				
  				+ "%% of your spending goal", spendGrade)); 
    }
    
    void createStepsHabit(String dataAsString, String goalAsString) {
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Habit step = new Habit(); 
    	errorLabel.setText(step.setGoal(goalAsString));
    	errorLabel.setText(step.setValue(dataAsString));
    	step.calculateGrade();
    	stepGrade = step.getGrade();
    	weightedStepGrade = step.getWeightedGrade();
    	if (step.getGrade() == 100) goalLabel.setText("Congradulations! You have reached your exercise goal.");
    	else if (step.getGrade() > 100) goalLabel.setText("Congradulations! You have surpassed your exercise goal.");
    	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your exercise goal", stepGrade));
    }
    /*
     *     void createFoodHabit(String dataAsString, String goalAsString) {
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
     */


    
    
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
    
    
/*
 *       void createExpenseHabit(String dataAsString, String goalAsString) {
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Habit expense = new Habit(); 
    	errorLabel.setText(expense.setGoal(goalAsString));
    	errorLabel.setText(expense.setValue(dataAsString));
    	expense.calculateGrade();
    	expenseGrade = expense.getGrade();
    	weightedExpenseGrade = expense.getWeightedGrade();
    	if (expense.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your expense goal.");
    	else if (expense.getGrade() > 100) goalLabel.setText("Congratulations! You have surpassed your expense goal.");
    	else goalLabel.setText(String.format("you have completed %.0f"
				+ "%% of your expense goal", stepGrade));
    }  
 */

    
    
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
    	errorLabel.setText("");
    	goalLabel.setText("");
    	Scene mainScene = applicationStage.getScene();
    	HBox exGoalContainer = new HBox(10);
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
 
    	calculateSpent.setOnAction(calculateEvent -> createExpensesHabit(exGoalTextField.getText(), foodTextField.getText() , entertainmentTextField.getText(), groceriesTextField.getText(), otherTextField.getText())); 
    	dataSceneContainer.getChildren().addAll(exGoalContainer, moneySpentLabel, foodContainer, entertainmentContainer,groceriesContainer, otherContainer, calculateSpent,  errorLabel, goalLabel, doneButton);

    	Scene expensesScene = new Scene(dataSceneContainer);
    	applicationStage.setScene(expensesScene);
    }

    @FXML
    void toExercise(ActionEvent toExerciseScene) {
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
    	
    	HBox overallScoreContainer = new HBox(5);
     	Label printOverallScore = new Label(String.format("Your overall score is %.02f" + "%%", dailyScore));
     	Label yayLabel = new Label("! Good Job!!");
     	overallScoreContainer.getChildren().addAll(printOverallScore, yayLabel);

    	dailyScoreAll.getChildren().addAll(dailyScoreLabel, metSleepGoalInfo,  metFoodGoalInfo, metExpensesGoalInfo, metExerciseGoalInfo, metWaterGoalInfo, overallScoreContainer, doneButton);
    	Scene scoreScene = new Scene(dailyScoreAll);
    	applicationStage.setScene(scoreScene);
    	
    	
    }

}

