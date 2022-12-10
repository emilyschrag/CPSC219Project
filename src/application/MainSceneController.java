package application;

//import required packages
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import java.awt.Font;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.text.FontWeight;

public class MainSceneController {
	Stage applicationStage;
	 @FXML
	    //initialize all the things we need the data from in more than one section
	    private Label metSleepGoalInfo = new Label(" ");
	    private Label metFoodGoalInfo = new Label(" ");
	    private Label metExpensesGoalInfo = new Label(" ");
	    private Label metExerciseGoalInfo = new Label(" ");
	    private Label metWaterGoalInfo = new Label(" ");
	    private Label errorLabel = new Label("");
	    private Label goalLabel = new Label("");
	    private Label waterDataLabel = new Label("");
	    private Label waterGoalLabel = new Label("");
	    private TextField nameTextField = new TextField();
	    private ChoiceBox<String> ageChoiceBox = new ChoiceBox();
	    private ChoiceBox<String> sexChoiceBox = new ChoiceBox();
	    private TextField heightTextField = new TextField();
	    private TextField weightTextField = new TextField();
	    private ArrayList<String>dailyWaterList = new ArrayList<String>();
	    private ArrayList<String>sleepDataList = new ArrayList<String>();
    	private HBox enterSleepGoal = new HBox(5);
    	private Label enterSleepGoalLabel = new Label("");
    	private Label bedtimeLabel = new Label("");
    	private HBox bedtimeContainer = new HBox(5);
	    private ChoiceBox<String> activityChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> hourChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox = new ChoiceBox();
	    private ChoiceBox<Integer> hourChoiceBox2 = new ChoiceBox();
	    private ChoiceBox<Integer> minuteChoiceBox2 = new ChoiceBox();
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
	    private HBox waterDataContainer = new HBox(10);
	    private HBox waterGoalContainer = new HBox(10);
	    private String age;
	    private String sex;
	    private String height;
	    private String weight;
	    private String activityLevel;
	    private int index = 0;
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
	    private String[] days = {" Tuesday", " Wednesday", " Thursday", " Friday", " Saturday", " Sunday"};
	    private Label caloriesEnterLabel = new Label("");
	    private HBox weightGoalContainer = new HBox(10);
	    private ArrayList<String> dailyCalorieList = new ArrayList <String>();
    	private Label calorieInputLabel = new Label ("");
    	private HBox calorieDataContainer = new HBox(10);
    	private Calories food = new Calories();
    	private Boolean isEmpty = true;
    	private VBox foodDataSceneContainer = new VBox(10);
    	private Scene foodScene = new Scene(foodDataSceneContainer,375,400);
    	private VBox userInfoContainer = new VBox(20);
    	private Scene infoScene = new Scene(userInfoContainer, 350, 350);
    	private String activityAsString;
    	private String sexAsString;
	    @FXML
    	void enterInfo(ActionEvent enterInfoEvent) {
    	//Set the original scene to mainScene
    	Scene mainScene = applicationStage.getScene();
    	

    	
    	//Create the container that will hold everything else in this scene
    	userInfoContainer.getChildren().removeAll(userInfoContainer.getChildren());
    	userInfoContainer.setMinHeight(450);
    	userInfoContainer.setMinWidth(400);

    	userInfoContainer.setPadding(new Insets(5,7.5,7.5,7.5));
    	

    	Label titleLabel = new Label("Enter your information!");

    	titleLabel.setStyle("-fx-font-weight: bold");
    	
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
    	
    	
    	if(sexChoiceBox.getValue() != null) {
    	sexAsString = (String)sexChoiceBox.getValue();
    	}else {
    		sexAsString = "";
    	}
    	
    	
    	if(activityChoiceBox.getValue() != null) {
    	activityAsString = (String)activityChoiceBox.getValue();
    	}else {
    		sexAsString = "";
    	}
    	
    	
    	//done button to take user back to main scene when information is entered
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> userInfoDone(ageTextField.getText(),sexAsString,heightTextField.getText(),
    			weightTextField.getText(),activityAsString, mainScene));
    	
    	// add all components to main container
    	userInfoContainer.getChildren().addAll(titleLabel, ageContainer, sexContainer, heightContainer, weightContainer, activityContainer,errorLabel, doneButton);
    	//create a new scene that holds the main container
    	
    	//set the scene to the info scene when the enterInfo action is initiated
    	applicationStage.setScene(infoScene);
    	
    	
    	
    	if (!((userAge==""||userAge==null) && (userSex==""||userSex==null) && (userHeight==""||userHeight==null) && (userWeight==""||userWeight==null) && (userActivity==""||userActivity==null))) {
    		isEmpty = false;
    	  }else if(((userAge==""||userAge==null) && (userSex==""||userSex==null) && (userHeight==""||userHeight==null) && (userWeight==""||userWeight==null) && (userActivity==""||userActivity==null))) {
    		  isEmpty = true;
    	  }
    	
    } 
    
//END USER INFO
    void userInfoDone (String ageAsString, String sexAsString , String heightAsString, String weightAsString, String activityAsString, Scene mainScene) {
      	
    	errorLabel.setText("");
    	ErrorCheck infoCheck = new ErrorCheck();
      	if(infoCheck.isValid(ageAsString) && infoCheck.isValid(heightAsString) && infoCheck.isValid(weightAsString) && infoCheck.isValid(activityLevel) && infoCheck.isValid(sexAsString)) {
      		
      		age = ageAsString;
        	sex = sexAsString;
        	height = heightAsString;
        	weight = weightAsString;
        	activityLevel = activityAsString;
        	applicationStage.setScene(mainScene);
        	
        	
        	
        	  	if (!((ageAsString==""||ageAsString==null) && (sexAsString==""||sexAsString==null) && (heightAsString==""||heightAsString==null) && (weightAsString==""||weightAsString==null) && (activityAsString==""||activityAsString==null))) {
        		isEmpty = false;
        	  }else if(((ageAsString==""||ageAsString==null) && (sexAsString==""||sexAsString==null) && (heightAsString==""||heightAsString==null) && (weightAsString==""||weightAsString==null) && (activityAsString==""||activityAsString==null))) {
        		  isEmpty = true;
        	  }
        	 
      	}else {
      		if(!infoCheck.isValid(ageAsString)) {
      			errorLabel.setStyle("-fx-text-fill: red;");
      			errorLabel.setText(infoCheck.getMessage(ageAsString));
      		}else if(!infoCheck.isValid(heightAsString)) {
      			errorLabel.setStyle("-fx-text-fill: red;");
      			errorLabel.setText(infoCheck.getMessage(heightAsString));
      		}else if(!infoCheck.isValid(weightAsString))
      			errorLabel.setStyle("-fx-text-fill: red;");
      		errorLabel.setText(infoCheck.getMessage(weightAsString));
      		
      	}
    
      	
    	
    	 
    
    	
    	
    	
    	
    }
    

    
    

    void dailyCalorieData (String dailyData) {
    	
    		
    	
    	 ErrorCheck foodCheck = new ErrorCheck();
		  
	       if (foodCheck.isValid(dailyData)) {
		    		errorLabel.setText("");	
		   if (index == 6) {
			   dailyCalorieList.add(dailyData);
			   calorieDataContainer.getChildren().removeAll(calorieDataContainer.getChildren());
		   }				   
		   if (index < 6) {
			   dailyCalorieList.add(dailyData);
			   calorieInputLabel.setText("How many calories consumed on" + days[index] + "?");
		   }
		   index++;
		   
	       }else {
	    	   errorLabel.setStyle("-fx-text-fill: red;");
	    		errorLabel.setText(foodCheck.getMessage(dailyData));
	    		
 		}
		   if(foodCheck.isValid(dailyData)) {
	       food.setCalorieData(dailyCalorieList);
	       food.total();
	       
		   foodGrade = food.getGrade();
  
		   if (foodGrade == 100) {
			   foodGrade = 100;
				goalLabel.setText("you have completed your food goal for the week"); 
			}else if (foodGrade < 100)	{
				goalLabel.setText(String.format("you have completed %.0f"
						+ "%% of your food goal", foodGrade));
			}else if (foodGrade > 100 && foodGrade < 200) {
				foodGrade = 100 - (foodGrade - 100);
				goalLabel.setText(String.format("you have completed %.0f"
						+ "%% of your food goal", foodGrade));
			}else {
				foodGrade = 0.0;
				goalLabel.setText(String.format("you have completed %.0f"
						+ "%% of your food goal", foodGrade));
			}
			weightedFoodGrade = sleepGrade * 0.2;
			goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");

		   }
		  
    }
	
/**
 * 	    
 * @param goalHour
 * @param goalMinute
 * @param valueHour
 * @param valueMinute
// */	    
	    //start of current shay sleep stuff
	    void createSleepHabit (String sleepGoal, String SleepData) {
	    	ErrorCheck sleepCheck = new ErrorCheck();				
	    	if (sleepCheck.isValid(sleepGoal)) {
	    		errorLabel.setText("");
	    		enterSleepGoal.getChildren().removeAll(enterSleepGoal.getChildren());
	    		enterSleepGoalLabel.setText("Your sleep goal for the week is " + sleepGoal + " hours" );
	    		if (sleepCheck.isValid(SleepData)) {
		    		errorLabel.setText("");
	    			if (index == 6) {
					   sleepDataList.add(SleepData);
					   bedtimeContainer.getChildren().removeAll(bedtimeContainer.getChildren());
				   }   
				   if (index < 6) {
					   sleepDataList.add(SleepData);
					   bedtimeLabel.setText("How much sleep did you get on" + days[index] + "?");
				   }
				   index++;
	    		}else {
	    			errorLabel.setStyle("-fx-text-fill: red;");
		    		errorLabel.setText(sleepCheck.getMessage(SleepData));
		    		goalLabel.setText("");
	    		}
	    			Water sleep = new Water(sleepGoal, sleepDataList);
	    			sleep.total();
	    			sleepGrade = sleep.getGrade();

	    			
	    			if (sleepGrade >= 100) {
	    				sleepGrade = 100;
	    				goalLabel.setText("you have completed your sleep goal for the week"); 
	    			}else if (sleepGrade < 100)	{
	    				goalLabel.setText(String.format("you have completed %.0f"
								+ "%% of your sleep goal", sleepGrade));
	    			}
	    			weightedSleepGrade = sleepGrade * 0.2;

	    			goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");
	    	}else {
	    		errorLabel.setStyle("-fx-text-fill: red;");
	    		errorLabel.setText(sleepCheck.getMessage(sleepGoal));
	    	}
	   }
	    
	    void sleepDoneButton(Scene mainScene) {
	    	enterSleepGoal.getChildren().removeAll(enterSleepGoal.getChildren());
	    	bedtimeContainer.getChildren().removeAll(bedtimeContainer.getChildren());
			applicationStage.setScene(mainScene);  
		   }
	   // end of current shay sleep stuff
	 
	    
	    //start of shay current water 
	    void addDailyWater(String waterIntake, String waterGoal) {
			   ErrorCheck waterCheck = new ErrorCheck();
			   if (waterCheck.isValid(waterGoal)) {
		    		errorLabel.setText("");
		    		waterGoalContainer.getChildren().removeAll(waterGoalContainer.getChildren());
		    		waterGoalLabel.setText("Your water goal for the week is " + waterGoal + "L" );
		       if (waterCheck.isValid(waterIntake)) {
			    		errorLabel.setText("");	
			   if (index == 6) {
				   dailyWaterList.add(waterIntake);
				   waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
			   }				   
			   if (index < 6) {
				   dailyWaterList.add(waterIntake);
				   waterDataLabel.setText("How much water did you drink on" + days[index] + "?");
			   }
			   index++;
		       }else {
		    	   errorLabel.setStyle("-fx-text-fill: red;");
		    		errorLabel.setText(waterCheck.getMessage(waterIntake));
	   		}
			   Water drink = new Water(waterGoal, dailyWaterList);
			   drink.total();
			   waterGrade = drink.getGrade();

			   if (waterGrade >= 100) {
				   waterGrade = 100;
   				goalLabel.setText("you have completed your water goal for the week"); 
   			}else if (waterGrade < 100)	{
   				goalLabel.setText(String.format("you have completed %.0f"
							+ "%% of your water goal", waterGrade));
   			}
   			weightedWaterGrade = waterGrade * 0.2;
   			goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");

		    	}
		   }
		   
		   void waterDoneButton(Scene mainScene) {
			   waterGoalContainer.getChildren().removeAll(waterGoalContainer.getChildren());
			   waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
			   applicationStage.setScene(mainScene);   
		   }
		   //end of shay current water
		   
	   //updated emily exoenses everything worjks
	    void createExpensesHabit(String goalAsString, String foodAsString, String entAsString, String grocAsString, String otherAsString) {
	    	errorLabel.setText("");
	     	goalLabel.setText("");
	     	Expenses spend = new Expenses();
	     	spend.setEnt(entAsString);
	     	spend.setFood(foodAsString);
	     	spend.setGroc(grocAsString);
	     	spend.setOther(otherAsString);
	      	spend.calculateGrade(spend.calculateTotal(), goalAsString);
	      	spendGrade = spend.getGrade();
	      	 if (((spend.setGoal(goalAsString)) != "") || ((spend.setFood(foodAsString)) != "") ||((spend.setGroc(grocAsString)) != "")
	      			 ||((spend.setOther(otherAsString)) != "") ||((spend.setEnt(entAsString)) != ""));{ 
	      		goalLabel.setText("");
	     		if ((spend.setGroc(grocAsString)) != ""); 
	     		errorLabel.setStyle("-fx-text-fill: red;");
			 		errorLabel.setText(spend.setGroc(grocAsString)); 
			 	if ((spend.setOther(otherAsString)) != "") 
			 		errorLabel.setStyle("-fx-text-fill: red;");
			 		errorLabel.setText(spend.setOther(otherAsString));
			 	if ((spend.setEnt(entAsString)) != "")
			 		errorLabel.setStyle("-fx-text-fill: red;");
			 		errorLabel.setText(spend.setEnt(entAsString));
				if ((spend.setGoal(goalAsString)) != "") 
					errorLabel.setStyle("-fx-text-fill: red;");
		     		errorLabel.setText(spend.setGoal(goalAsString));
				if ((spend.setFood(foodAsString)) != "")
					errorLabel.setStyle("-fx-text-fill: red;");
	     			errorLabel.setText(spend.setFood(foodAsString));}
	      	
	      			if (spendGrade >= 100) {
	      				spendGrade = 100;
	    				goalLabel.setText("You have reached your spending goal."); 
	    			}else if (spendGrade < 100)	{
	    				goalLabel.setText(String.format("you have completed %.0f"
	    		  				+ "%% of your spending goal", spendGrade));
	    			}
	      			weightedSpendGrade = spendGrade * 0.2;
	    			goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;"); 
	      			 
	      			 
	      			 
	      	if (spend.getGoal() == 0)
	      		goalLabel.setText("");
	      	if ((spend.setOther(otherAsString)) != "")
	      		goalLabel.setText("");
	      	if ((spend.setEnt(entAsString)) != "")
	      		goalLabel.setText("");
	      	if ((spend.setGroc(grocAsString)) != "")
	      		goalLabel.setText("");
	      	if ((spend.setFood(foodAsString)) != "")
	      		goalLabel.setText("");
	    }
	    //end of expe
	    
	    //start updated exercise
	    void addWorkoutGoal(String workoutGoal) {
			   errorLabel.setText("");
			   boolean valid = true;   
			   for (int index = 0; index <= (workoutGoalList.size() - 1); index++) {   
				   if (workoutGoalList.get(index).equals(workoutGoal)) valid = false; 
				   if (valid == false) {
					   index = 100;
					   errorLabel.setStyle("-fx-text-fill: red;");
					   errorLabel.setText("This workout has already been added");
						}
				   }
			   if (valid == true) {
				   workoutGoalList.add(workoutGoal);
				   workoutCompletedChoiceBox.getItems().addAll(workoutGoal);
			   }
		   }
		   
		   
		   void addWorkoutCompleted(String workoutCompleted) {
			   errorLabel.setText("");
			   boolean valid = true;  
			   for (int index = 0; index <= (workoutCompletedList.size() - 1); index++) {
				   if (workoutCompletedList.get(index).equals(workoutCompleted)) valid = false;
				   if (valid == false) {
					   index = 100;
					   errorLabel.setStyle("-fx-text-fill: red;");
					   errorLabel.setText("This workout has already been added");
				   }
			   } 
			   if (valid == true) {
				   workoutCompletedList.add(workoutCompleted);
				   workoutCompletedChoiceBox.getItems().removeAll(workoutCompleted);
			   }  
		   }
		   
		    void createExerciseHabit(ArrayList<String> goal, ArrayList<String> completed) {
		    	errorLabel.setText("");
		    	goalLabel.setText("");
		    	Excercise workouts = new Excercise(goal, completed); 
		    	workouts.calculate();
		    	stepGrade = workouts.getGrade();
		    	if (stepGrade < 100)
		    		weightedStepGrade = stepGrade * 0.2;
		    	else if (stepGrade >= 100)
		    		weightedStepGrade = 20.0;
		    	if(goal.isEmpty() || completed.isEmpty()) {
		    		errorLabel.setStyle("-fx-text-fill: red;");
		    		errorLabel.setText("Must input workout");
		    	}else {
		    		goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");
		    	if (workouts.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your exercise goal.");
		    	
		    	
		    	else if (workouts.getGrade() > 100) goalLabel.setText("Congratulations! You have surpassed your exercise goal.");
		    	else goalLabel.setText(String.format("you have completed %.0f"
						+ "%% of your exercise goal", stepGrade)); goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");
		    }
		    }
		    //end updated exercise 
		    
		    void createFoodHabit(String weightGoalAsString) {
		    	errorLabel.setText("");
		    	goalLabel.setText("");
		    	food.setActivity(activityLevel);
		    	food.setAge(age);
		    	food.setWeightGoal(weightGoalAsString);
		    	food.setHeight(height);
		    	food.setSex(sex);
		    	food.setWeight(weight);
		    	food.calculateBMR();
		    	food.calculateAMR();
		    	food.calculateCals();
		    	double myCalories = food.getCalories();
		    	if (myCalories == 0) caloriesEnterLabel.setText("No goal entered");
		    	else caloriesEnterLabel.setText(String.format("Based on your given Physical data and dietary goal, \nyou should consume: \n" 
		    				+ "%.02f calories weekly \n" 
		    				+  "%.02f calories daily",myCalories,myCalories/7));
		    	caloriesEnterLabel.setMinHeight(100);
		    	caloriesEnterLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: blue");
		    }

	    
	    //updated to sleep
	    @FXML
	    void toSleep(ActionEvent sleepEvent) {
	    	index = 0;
	    	sleepDataList.clear();
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	Scene mainScene = applicationStage.getScene();
	       	VBox sleepContainer = new VBox(10);
	       	sleepContainer.setMinHeight(200);
	       	sleepContainer.setMinWidth(300);
	       	sleepContainer.setPadding(new Insets(10,10,10,10));
	       	enterSleepGoalLabel.setStyle("-fx-font-weight: bold");
	    	enterSleepGoalLabel.setText("Enter your sleep goal for the week");
	    	TextField sleepGoalTextField = new TextField();
	    	Label hourLabel = new Label("Hours");
	    	enterSleepGoal.getChildren().addAll(sleepGoalTextField, hourLabel);
	    	bedtimeLabel.setStyle("-fx-font-weight: bold");
	    	bedtimeLabel.setText("How many hours did you sleep on Monday?");
	    	TextField sleepDataTextField = new TextField();
	    	Label hourLabel2 = new Label("Hours");
	    	Button enterSleepButton = new Button("Enter");
	    	bedtimeContainer.getChildren().addAll(sleepDataTextField, hourLabel2, enterSleepButton);
	        enterSleepButton.setOnAction(calculateEvent -> createSleepHabit(sleepGoalTextField.getText(), sleepDataTextField.getText()));
	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent2 -> sleepDoneButton(mainScene));
	    	sleepContainer.getChildren().addAll(enterSleepGoalLabel, enterSleepGoal, bedtimeLabel, bedtimeContainer, errorLabel, goalLabel, doneButton);
	    	Scene sleepScene = new Scene(sleepContainer);
	    	applicationStage.setScene(sleepScene);
	    }
	    //end new to slepp

	    @FXML
 void toFood(ActionEvent foodEvent) {
	    	
	    	foodDataSceneContainer.getChildren().removeAll(foodDataSceneContainer.getChildren());
	    		    	
	    	index = 0;
	    	if(isEmpty == true) {
	    	   	Scene mainScene = applicationStage.getScene();
	    		
	    		errorLabel.setText("ENTER USER INFO FIRST");
	    		errorLabel.setStyle("-fx-text-fill: red;");
	    		
	    		VBox emptyInfoInputContainer = new VBox(10);
	    		emptyInfoInputContainer.setPadding(new Insets(10,10,10,10));
	    		Button emptyInfoButton = new Button ("Back to Main Scene");
	    		emptyInfoInputContainer.getChildren().addAll(errorLabel,emptyInfoButton);
	    		foodDataSceneContainer.getChildren().addAll(emptyInfoInputContainer);
	    		applicationStage.setScene(foodScene);
	    		
	    		emptyInfoButton.setOnAction(backToInfo -> applicationStage.setScene(mainScene));
	    		
	    	
	    	}else {
	    	
	    	errorLabel.setText("");
	    	
	    	
	    	goalLabel.setText("");
	    	Scene mainScene = applicationStage.getScene();
	    	
	    	Label weightGoalLabel = new Label("What is your dietary goal?");
	    	weightGoalLabel.setStyle("-fx-font-weight: bold");
	    
	    	ChoiceBox<String> weightGoalChoiceBox = new ChoiceBox<String>();
	    	weightGoalChoiceBox.getItems().addAll("Lose Weight","Maintain Weight","Gain Weight");
	    	
	    	Button setWeightGoalButton = new Button ("Set Goal");
	    	
	    	
	    	weightGoalContainer.getChildren().addAll( weightGoalChoiceBox,setWeightGoalButton);
	    	
	    	foodDataSceneContainer.setPadding(new Insets(10,10,10,10));
	    	foodDataSceneContainer.setMinHeight(330);
	    	foodDataSceneContainer.setMinWidth(300);
	    	caloriesEnterLabel.setText("");
	    	
	    	
	    	setWeightGoalButton.setOnAction(calorieCalc -> createFoodHabit (weightGoalChoiceBox.getValue()));
	    	
	    	calorieInputLabel.setStyle("-fx-font-weight: bold");
	    	calorieInputLabel.setText("How many calories consumed on Monday?");
	    	TextField enterCalories = new TextField();
	    	Button dataCalorieButton = new Button ("Enter");
	    	dataCalorieButton.setOnAction(enterAction -> dailyCalorieData (enterCalories.getText())  );
	    	
	    	calorieDataContainer.getChildren().addAll(enterCalories,dataCalorieButton);

	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent2 -> caloriesDoneButton(mainScene));
	    	
	    	foodDataSceneContainer.getChildren().addAll(weightGoalLabel, weightGoalContainer, caloriesEnterLabel,calorieInputLabel,  calorieDataContainer, errorLabel, goalLabel, doneButton);

	    	
	        applicationStage.setScene(foodScene);
	        
	    	}
	        
	    	}
	       
	    void caloriesDoneButton(Scene scene) {
	    	calorieDataContainer.getChildren().removeAll(calorieDataContainer.getChildren());
	    	weightGoalContainer.getChildren().removeAll(weightGoalContainer.getChildren());
	    	applicationStage.setScene(scene);
	    }
	    
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
	    	exGoalLabel.setStyle("-fx-font-weight: bold");
	    	TextField exGoalTextField = new TextField();
	    	exGoalContainer.getChildren().addAll(exGoalLabel, exGoalTextField );
	     	VBox dataSceneContainer = new VBox(10);	
	     	dataSceneContainer.setPadding(new Insets(10,10,10,10));
	     	Label moneySpentLabel = new Label("Money spent this week");
	     	moneySpentLabel.setStyle("-fx-font-weight: bold");
	     	HBox foodContainer = new HBox(10);
	    	TextField foodTextField = new TextField();
	    	Label foodLabel = new Label("Food");
	    	foodLabel.setStyle("-fx-font-weight: bold");
	    	foodContainer.getChildren().addAll(foodLabel, foodTextField);		
	    	HBox entertainmentContainer = new HBox(10);
	    	TextField entertainmentTextField = new TextField();
	    	Label entertainmentLabel = new Label("Entertainment");
	    	entertainmentLabel.setStyle("-fx-font-weight: bold");
	    	entertainmentContainer.getChildren().addAll(entertainmentLabel, entertainmentTextField);		
	    	HBox groceriesContainer = new HBox(10);
	    	TextField groceriesTextField = new TextField();
	    	Label groceriesLabel = new Label("Groceries");
	    	groceriesLabel.setStyle("-fx-font-weight: bold");
	    	groceriesContainer.getChildren().addAll(groceriesLabel, groceriesTextField);		
	    	HBox otherContainer = new HBox(10);
	     	TextField otherTextField = new TextField();
	     	Label otherLabel = new Label("Other");
	     	otherLabel.setStyle("-fx-font-weight: bold");
	     	otherContainer.getChildren().addAll(otherLabel, otherTextField);
	    	Button calculateSpent = new Button("Calculate");
	     	Button doneButton = new Button("Done");
	     	doneButton.setOnAction(doneEvent2 -> applicationStage.setScene(mainScene));	 		
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

	    
	    //updated exercise 
	    @FXML
	    void toExercise(ActionEvent toExerciseScene) {
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	workoutGoalList.clear();
	    	workoutCompletedList.clear();
	    	workoutCompletedChoiceBox.getItems().removeAll(workoutCompletedChoiceBox.getItems());
	    	Scene mainScene = applicationStage.getScene();
			HBox stepsGoalContainer = new HBox(10);
			Label exerciseGoalLabel = new Label("What workouts do you want to complete this week?");
			exerciseGoalLabel.setStyle("-fx-font-weight: bold");
			workoutGoalChoiceBox.getItems().addAll("Chest", "Legs", "Back", "Core" ,  "Shoulders", "Arms", "Push", "Pull", "Cardio");
			Button workoutGoalAddButton = new Button("Add");
			workoutGoalAddButton.setOnAction(addEvent1 -> addWorkoutGoal(workoutGoalChoiceBox.getValue()));
			stepsGoalContainer.getChildren().addAll(exerciseGoalLabel, workoutGoalChoiceBox, workoutGoalAddButton);
			VBox exerciseDataWholeContainer = new VBox(10);
			exerciseDataWholeContainer.setPadding(new Insets(10,10,10,10));
			HBox stepsDataContainer = new HBox(10);
			Label stepsDataLabel = new Label("What workouts have you completed this week?");
			stepsDataLabel.setStyle("-fx-font-weight: bold");
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
	    //end updated exercuse


	    
	    //updated to Watwe
	    @FXML
	    void toWater(ActionEvent toWaterEvent) {
	    	index = 0;
	    	errorLabel.setText("");
	    	goalLabel.setText("");
	    	dailyWaterList.clear();
	    	Scene mainScene = applicationStage.getScene();
	    	VBox waterDataWholeContainer = new VBox(10);
	    	waterDataWholeContainer.setPadding(new Insets(10,10,10,10));
	    	waterGoalLabel.setText("What is your water goal for the week?");
	    	waterGoalLabel.setStyle("-fx-font-weight: bold");
	    	Label mLLabel = new Label("L");
	    	waterGoalContainer.getChildren().addAll(waterGoalTextField, mLLabel);
	    	waterDataWholeContainer.setMinWidth(300);
	    	waterDataLabel.setText("How much water did you drink on Monday?");
	    	waterDataLabel.setStyle("-fx-font-weight: bold");
	    	Label literLabel = new Label("L");
	    	Button addDailyButton = new Button("Enter");
	    	addDailyButton.setOnAction(addevent -> addDailyWater(waterDataTextField.getText(), waterGoalTextField.getText()));
	    	waterDataContainer.getChildren().addAll(waterDataTextField, literLabel, addDailyButton);
	   		Button doneButton = new Button("Done");
	   		waterDataWholeContainer.getChildren().addAll(waterGoalLabel, waterGoalContainer,
	   				waterDataLabel, waterDataContainer, errorLabel, goalLabel, doneButton);
	   		Scene waterScene = new Scene(waterDataWholeContainer,350,250);
	   		
	   		doneButton.setOnAction(doneEvent -> waterDoneButton(mainScene));
	   		applicationStage.setScene(waterScene);
	    }
	   //end updated to water

	    //updated scoring 
	    @FXML
	    void getWeeklyScore(ActionEvent toWeeklyScoreEvent) {
	    	Scene mainScene = applicationStage.getScene();
	    	VBox weeklyScoreAll = new VBox(10);
	    	weeklyScoreAll.setPadding(new Insets(15,15,15,15));
	    	Label weeklyScoreLabel = new Label("Your Weekly Score!");
	    	weeklyScoreLabel.setStyle("-fx-font-weight: 900; -fx-font-size:16px;");
	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
	    
	    	metExerciseGoalInfo.setText(String.format("You Have Completed %.02f"
					+ "%% of your Exercise Goal", stepGrade));
	    	metWaterGoalInfo.setText(String.format("You Have Completed %.02f"
					+ "%% of your Water Goal", waterGrade));
	    	metFoodGoalInfo.setText(String.format("You Have Completed %.02f"
					+ "%% of your Food Goal", foodGrade));
	    	metSleepGoalInfo.setText(String.format("You Have Completed %.02f"
					+ "%% of your Sleep Goal", sleepGrade));
	    	metExpensesGoalInfo.setText(String.format("You Have Completed %.02f"
					+ "%% of your Spending Goal", spendGrade));
	    	metExerciseGoalInfo.setStyle("-fx-font-weight: bold");
	    	metWaterGoalInfo.setStyle("-fx-font-weight: bold");
	    	metFoodGoalInfo.setStyle("-fx-font-weight: bold");
	    	metSleepGoalInfo.setStyle("-fx-font-weight: bold");
	    	metExpensesGoalInfo.setStyle("-fx-font-weight: bold");
	    	//Calculate dailyScore
	    	double weeklyScore = 0.0;
	    	weeklyScore = weightedStepGrade + weightedSpendGrade + weightedWaterGrade +
	    			weightedFoodGrade + weightedSleepGrade;
	    	HBox overallScoreContainer = new HBox(5);
	    	Label printOverallScore = new Label(String.format("Your Overall Weekly Score is %.02f" + "%%", weeklyScore));
	    	printOverallScore.setStyle("-fx-font-weight: bold; -fx-text-fill:blue; -fx-font-size-16px;");
	    	Label yayLabel = new Label("! Good Job!");
	    	yayLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:blue; -fx-font-size-16px;");
	    	overallScoreContainer.getChildren().addAll(printOverallScore, yayLabel);
	    	weeklyScoreAll.getChildren().addAll(weeklyScoreLabel, metSleepGoalInfo,  metFoodGoalInfo, metExpensesGoalInfo, metExerciseGoalInfo, metWaterGoalInfo, overallScoreContainer, doneButton);
	    	Scene scoreScene = new Scene(weeklyScoreAll);
	    	applicationStage.setScene(scoreScene);
	    }
	    //end updated scoring 
	}