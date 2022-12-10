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

	   
    	
    	/**
    	 * when the enterInfo button is pressed, the scene is switch to the user info Scene, 
    	 * and all the elements are added to the scene
    	 * 
    	 * @param enterInfoEvent event when enterInfo button is pressed
    	 */
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

    	//done button to take user back to main scene when information is entered
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> userInfoDone(ageTextField.getText(),(String)sexChoiceBox.getValue(),heightTextField.getText(),
    			weightTextField.getText(),(String)activityChoiceBox.getValue(), mainScene));
    	
    	// add all components to main container
    	userInfoContainer.getChildren().addAll(titleLabel, ageContainer, sexContainer, heightContainer, weightContainer, activityContainer,errorLabel, doneButton);
    	//create a new scene that holds the main container
    	
    	//set the scene to the info scene when the enterInfo action is initiated
    	applicationStage.setScene(infoScene);
    	
    	
    	//Checks if the user has entered values for all categories
    	if (!((userAge==""||userAge==null) && (userSex==""||userSex==null) && (userHeight==""||userHeight==null) && (userWeight==""||userWeight==null) && (userActivity==""||userActivity==null))) {
    		isEmpty = false;
    	  }else if(((userAge==""||userAge==null) && (userSex==""||userSex==null) && (userHeight==""||userHeight==null) && (userWeight==""||userWeight==null) && (userActivity==""||userActivity==null))) {
    		  isEmpty = true;
    	  }
    	
    } 
    
/**
 * when the done button is pressed in the user info screen this method cheeks that all inputs are valid.
 * if all  inputs are valid the scene is switched to the main scene,
 * if any inputs are invalid then an error message will appear and the scene will remain on the enterInfo Scene
 * 
 * @param ageAsString age inputed in enterInfo scene
 * @param sexAsString sex inputed in enterInfo scene
 * @param heightAsString height inputed in enterInfo scene
 * @param weightAsString weight inputed in enterInfo scene
 * @param activityAsString activity level inputed in enterInfo scene
 * @param mainScene the main scene
 */
    void userInfoDone (String ageAsString, String sexAsString , String heightAsString, String weightAsString, String activityAsString, Scene mainScene) {
      	//clears error label
    	errorLabel.setText("");
    	
    	//create new errrorCheck object
    	ErrorCheck infoCheck = new ErrorCheck();
      	// checks if all inputs are valid
    	if(infoCheck.isValid(ageAsString) && infoCheck.isValid(heightAsString) && infoCheck.isValid(weightAsString)) {
      		// set the global variables
      		age = ageAsString;
        	sex = sexAsString;
        	height = heightAsString;
        	weight = weightAsString;
        	activityLevel = activityAsString;
        	applicationStage.setScene(mainScene);
        	
        	
        	//Checks if the user has entered values for all categories
        	  	if (!((ageAsString==""||ageAsString==null) && (sexAsString==""||sexAsString==null) && (heightAsString==""||heightAsString==null) && (weightAsString==""||weightAsString==null) && (activityAsString==""||activityAsString==null))) {
        		isEmpty = false;
        	  }else if(((ageAsString==""||ageAsString==null) && (sexAsString==""||sexAsString==null) && (heightAsString==""||heightAsString==null) && (weightAsString==""||weightAsString==null) && (activityAsString==""||activityAsString==null))) {
        		  isEmpty = true;
        	  }
        	 
      	}else {
      		//if any inputs are invalid, sets the error label
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
    

    
    
/**
 * when the enter button is pressed in the food scene,
 *  this method checks if a value has been entered for daily calorie consumption
 *  if a valid value has been entered then the question prompt will be updated to the next day,
 *   and a new grade will be calculated and displayed.
 *   if an invalid input has been entered then an error message will be displayed and the prompt will remain the same
 * @param dailyData
 */
    void dailyCalorieData (String dailyData) {
    	
    		
    	//creates new errorCheck object
    	 ErrorCheck foodCheck = new ErrorCheck();
		  //checks if the input is valid and clears error label
	       if (foodCheck.isValid(dailyData)) {
		    		errorLabel.setText("");	
		   
		    // checks if the index is 6, meaning that all days have an input
		    if (index == 6) {
			   //adds the input to the list
		       dailyCalorieList.add(dailyData);
			   //removes the prompt label, text field, and button from the scene
		       calorieDataContainer.getChildren().removeAll(calorieDataContainer.getChildren());
		   }				   
		   //checks if the index is less than six
		    if (index < 6) {
		    	//adds the input to the list
		    	dailyCalorieList.add(dailyData);
			    //changes the prompt label to ask for the next input
		    	calorieInputLabel.setText("How many calories consumed on" + days[index] + "?");
		   }
		   // increment the index
		    index++;
		   
	       }else {
	    	  //sets the error message
	    	   errorLabel.setStyle("-fx-text-fill: red;");
	    		errorLabel.setText(foodCheck.getMessage(dailyData));
	    		
 		}
		   
	       //if the input is valid, the current food grade is calculated
	       if(foodCheck.isValid(dailyData)) {
	       food.setCalorieData(dailyCalorieList);
	       food.total();
	       
		   foodGrade = food.getGrade();
  
		   // depending on the grade, the appropriate goal message is printed
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
			//weighted food grade calculated
		    weightedFoodGrade = sleepGrade * 0.2;
			goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");

		   }
		  
    }
	
/**
 * when the enter button is pressed in the sleep scene, 
 * the inputs for sleep goal and sleep input are checked 	
 * if the sleep goal input is valid then the prompt for sleep goal is removed,
 * and the label is changed to show the inputed sleep goal.
 * if the input for sleep goal is invalid, then an error massage will display,
 * and the user will be prompted to enter the goal again
 * if the sleep data is valid then the user will be prompted
 * to input the next days sleep data until all days have been inputed,
 * and the grade will be calculated and displayed.
 * if the sleep data input is invalid then an error message will appear,
 * and the user will be prompted to re enter the data
 * 
 * @param sleepGoal users sleep goal for the week
 * @param SleepData users inputed sleep data for one day
 */	    
	    void createSleepHabit (String sleepGoal, String SleepData) {
	    	//creates new errorCheck object
	    	ErrorCheck sleepCheck = new ErrorCheck();				
	    	//checks is the sleep goal is valid 
	    	if (sleepCheck.isValid(sleepGoal)) {
	    		//clear error label and remove the prompt for sleep goal
	    		errorLabel.setText("");
	    		enterSleepGoal.getChildren().removeAll(enterSleepGoal.getChildren());
	    		//display entered sleep goal
	    		enterSleepGoalLabel.setText("Your sleep goal for the week is " + sleepGoal + " hours" );
	    		//checks if sleep data is valid
	    		if (sleepCheck.isValid(SleepData)) {
		    		//clears error label
	    			errorLabel.setText("");
	    			//checks is index is equal to 6, meaning all inputs have been entered
	    			if (index == 6) {
					   //sleep data is added to the sleep data list and the prompt to enter sleep data is removed
	    				sleepDataList.add(SleepData);
					   bedtimeContainer.getChildren().removeAll(bedtimeContainer.getChildren());
				   }   
				   //checks if the index is less than six, meaning not all inputs have been entered
	    			if (index < 6) {
	    				//sleep data is added to the sleep data list and the prompt is updated to the next day
					   sleepDataList.add(SleepData);
					   bedtimeLabel.setText("How much sleep did you get on" + days[index] + "?");
				   }
	    			// increment the index
	    			index++;
	    		}else {
	    			// if the is an invalid input, the error label is set
	    			errorLabel.setStyle("-fx-text-fill: red;");
		    		errorLabel.setText(sleepCheck.getMessage(SleepData));
		    		goalLabel.setText("");
	    		}
	    			
	    			//new water object is created
	    			Water sleep = new Water(sleepGoal, sleepDataList);
	    			//sleep grade calculated
	    			sleep.total();
	    			sleepGrade = sleep.getGrade();

	    			//depending on sleep grade, the appropriate error message is displayed
	    			if (sleepGrade >= 100) {
	    				sleepGrade = 100;
	    				goalLabel.setText("you have completed your sleep goal for the week"); 
	    			}else if (sleepGrade < 100)	{
	    				goalLabel.setText(String.format("you have completed %.0f"
								+ "%% of your sleep goal", sleepGrade));
	    			}
	    			//weighted sleep grade calculated
	    			weightedSleepGrade = sleepGrade * 0.2;
	    			//goal message displayed
	    			goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");
	    	}else {
	    		//error message displayed
	    		errorLabel.setStyle("-fx-text-fill: red;");
	    		errorLabel.setText(sleepCheck.getMessage(sleepGoal));
	    	}
	   }
	    
	    /**
	     * when the done button is pressed in the sleep scene,
	     *  all elements are removed from the scene to prevent duplication,
	     *  and the scene is switched back to the main scene
	     * @param mainScene 
	     */
	    void sleepDoneButton(Scene mainScene) {
	    	//removes all elements 
	    	enterSleepGoal.getChildren().removeAll(enterSleepGoal.getChildren());
	    	bedtimeContainer.getChildren().removeAll(bedtimeContainer.getChildren());
			//switches scene
	    	applicationStage.setScene(mainScene);  
		   }
	   // end of current shay sleep stuff
	 
	    
	    //start of shay current water 
	    
	    /***
	     * when the enter button is pressed in the water scene, 
	     * the inputs for water goal and water input are checked 	
	     * if the water goal input is valid then the prompt for water goal is removed,
	     * and the label is changed to show the inputed water goal.
	     * if the input for water goal is invalid, then an error massage will display,
	     * and the user will be prompted to enter the goal again
	     * if the water data is valid then the user will be prompted
	     * to input the next days water data until all days have been inputed,
	     * and the grade will be calculated and displayed.
	     * if the water data input is invalid then an error message will appear,
	     * and the user will be prompted to re enter the data
	     *  
	     * @param waterIntake users inputed water in take for one day
	     * @param waterGoal users inputed water goal for the week
	     */
	    void addDailyWater(String waterIntake, String waterGoal) {
			   ErrorCheck waterCheck = new ErrorCheck();
			  //checks if water goal is valid
			   if (waterCheck.isValid(waterGoal)) {
		    		// clears error label
				    errorLabel.setText("");
		    		// removes prompt to enter water goal
				    waterGoalContainer.getChildren().removeAll(waterGoalContainer.getChildren());
		    		//Displays entered water goal
				    waterGoalLabel.setText("Your water goal for the week is " + waterGoal + "L" );
		       
				    //checks if water in take is valid
				    if (waterCheck.isValid(waterIntake)) {
			    		// clears error label
				    	errorLabel.setText("");	
				    	//checks if the index is equal to six, meaning all inputs have been entered
				    	if (index == 6) {
				    		// add water intake to the sail water list
				    		dailyWaterList.add(waterIntake);
				    		// removes prompt to enter water intake
				    		waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
			   }
				//checks if the index is less than six, meaning not all inputs have been entered    	
			   if (index < 6) {
				   // add water intake to the sail water list
				   dailyWaterList.add(waterIntake);
				   // switches prompt to ask for next input
				   waterDataLabel.setText("How much water did you drink on" + days[index] + "?");
			   }
			   // Increment index by one
			   index++;
		       }else {
		    	   // Set error label
		    	   errorLabel.setStyle("-fx-text-fill: red;");
		    		errorLabel.setText(waterCheck.getMessage(waterIntake));
	   		}
			  //creates new water object
		       Water drink = new Water(waterGoal, dailyWaterList);
			   //calculates water grade
		       drink.total();
			   waterGrade = drink.getGrade();
			 
			   //depending on water grade, the appropriate error message is displayed
			   if (waterGrade >= 100) {
				   waterGrade = 100;
   				goalLabel.setText("you have completed your water goal for the week"); 
   			}else if (waterGrade < 100)	{
   				goalLabel.setText(String.format("you have completed %.0f"
							+ "%% of your water goal", waterGrade));
   			}
   			//calculates weighted water grade
			   weightedWaterGrade = waterGrade * 0.2;
   			   goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");

		    	}
		   }
	    
	    /**
	     * when the done button is pressed in the water scene,
	     *  all elements are removed from the scene to prevent duplication,
	     *  and the scene is switched back to the main scene
	     * @param mainScene 
	     */
		   void waterDoneButton(Scene mainScene) {
			   waterGoalContainer.getChildren().removeAll(waterGoalContainer.getChildren());
			   waterDataContainer.getChildren().removeAll(waterDataContainer.getChildren());
			   applicationStage.setScene(mainScene);   
		   }
		   //end of shay current water
		   
	   //updated emily exoenses everything worjks
	    
		   /**
		    * when the calculate button is pressed in the expense scene all inputs are checked.
		    * if all inputs are valid then the expense grade is displayed
		    * if any inputs are invalid then an error message appears
		    * 
		    * @param goalAsString expense goal
		    * @param foodAsString money spent on food
		    * @param entAsString money spent on entertainment
		    * @param grocAsString money spent on groceries
		    * @param otherAsString money spent on other
		    */
		   void createExpensesHabit(String goalAsString, String foodAsString, String entAsString, String grocAsString, String otherAsString) {
	    	//clears goal label and error label
			errorLabel.setText("");
	     	goalLabel.setText("");
	     	//create new expense object
	     	Expenses spend = new Expenses();
	     	//set all value of expense object
	     	spend.setEnt(entAsString);
	     	spend.setFood(foodAsString);
	     	spend.setGroc(grocAsString);
	     	spend.setOther(otherAsString);
	      	//calculate expense grade
	     	spend.calculateGrade(spend.calculateTotal(), goalAsString);
	      	spendGrade = spend.getGrade();
	      	 
	      	// checks is inputs are valid and sets error labels
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
	      	
	      			 //depending on expense grade, the appropriate error message is displayed
	      			if (spendGrade >= 100) {
	      				spendGrade = 100;
	    				goalLabel.setText("You have reached your spending goal."); 
	    			}else if (spendGrade < 100)	{
	    				goalLabel.setText(String.format("you have completed %.0f"
	    		  				+ "%% of your spending goal", spendGrade));
	    			}
	      			//calculates weighted expense grade
	      			weightedSpendGrade = spendGrade * 0.2;
	    			goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;"); 
	      			 
	      			 
	      	// clears goal label
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
	    
		   
		   /**
		    * when the add work out goal button is pressed in the exercise screen,
		    * this method checks if a value has been inputed
		    * if the input is valid then the inputed value is added to the completed choice box
		    * if the input is invalid then an error message is displayed
		    * @param workoutGoal 
		    */
		   void addWorkoutGoal(String workoutGoal) {
			   // clears error label
			   errorLabel.setText("");
			   //create new boolean
			   boolean valid = true;   
			   //loop through the work out goal list
			   for (int index = 0; index <= (workoutGoalList.size() - 1); index++) {   
				   //checks if work out goal is already in goal list
				   if (workoutGoalList.get(index).equals(workoutGoal)) valid = false; 
				   //if the workout goal is already in the goal list then an error label is displays
				   // and the loop is broken
				   if (valid == false) {
					   index = 100;
					   errorLabel.setStyle("-fx-text-fill: red;");
					   errorLabel.setText("This workout has already been added");
						}
				   }
			   // checks if valid equals true
			   if (valid == true) {
				   // adds workout goal to the goal list
				   workoutGoalList.add(workoutGoal);
				   // adds the goal list to the completed choice box
				   workoutCompletedChoiceBox.getItems().addAll(workoutGoal);
			   }
		   }
		   
		   /**
		    * when the add work out completed button is pressed in the exercise screen,
		    * this method checks if a value has been inputed
		    * if the input is valid then the inputed value is removed to the completed choice box
		    * if the input is invalid then an error message is displayed
		    * @param workoutCompleted
		    */
		   void addWorkoutCompleted(String workoutCompleted) {
			   //clears error label
			   errorLabel.setText("");
			   //creates new boolean
			   boolean valid = true;  
			   //loops through workout completed list
			   for (int index = 0; index <= (workoutCompletedList.size() - 1); index++) {
				   //if the value is already in the list valid is set to false
				   if (workoutCompletedList.get(index).equals(workoutCompleted)) valid = false;
				   // if valid equals false then the error message is displayed and the loop is broken
				   if (valid == false) {
					   index = 100;
					   errorLabel.setStyle("-fx-text-fill: red;");
					   errorLabel.setText("This workout has already been added");
				   }
			   } 
			   //if valid equals true then the value is added to the workout completed 
			   //list and all elements are removed from the choice box
			   if (valid == true) {
				   workoutCompletedList.add(workoutCompleted);
				   workoutCompletedChoiceBox.getItems().removeAll(workoutCompleted);
			   }  
		   }
		   
		   /**
		    * when the calculate button is pressed in the exercise scene
		    * the exercise grade is calculated
		    * 
		    * @param goal list of goal exercises 
		    * @param completed list of completed exercises
		    */
		    void createExerciseHabit(ArrayList<String> goal, ArrayList<String> completed) {
		    	//clears goal and error label
		    	errorLabel.setText("");
		    	goalLabel.setText("");
		    	//create new exercise object
		    	Excercise workouts = new Excercise(goal, completed); 
		    	//calculate exercise grade
		    	workouts.calculate();
		    	stepGrade = workouts.getGrade();
		    	//calculates weighted stepGrade
		    	if (stepGrade < 100)
		    		weightedStepGrade = stepGrade * 0.2;
		    	else if (stepGrade >= 100)
		    		weightedStepGrade = 20.0;
		    	//Displays error label
		    	if(goal.isEmpty() || completed.isEmpty()) {
		    		errorLabel.setStyle("-fx-text-fill: red;");
		    		errorLabel.setText("Must input workout");
		    	}else {
		    		//displays goal label
		    		goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");
		    	if (workouts.getGrade() == 100) goalLabel.setText("Congratulations! You have reached your exercise goal.");
		    	
		    	
		    	else if (workouts.getGrade() > 100) goalLabel.setText("Congratulations! You have surpassed your exercise goal.");
		    	else goalLabel.setText(String.format("you have completed %.0f"
						+ "%% of your exercise goal", stepGrade)); goalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:green; -fx-font-size-14px;");
		    }
		    }
		    //end updated exercise 
		    
		    
		    /**
		     * when the set goal button is pressed in the food scene
		     * the users calorie goal is calculates and displayed
		     * @param weightGoalAsString users weight goal
		     */
		    void createFoodHabit(String weightGoalAsString) {
		    	//clears error and goal label
		    	errorLabel.setText("");
		    	goalLabel.setText("");
		    	//sets all values for food object
		    	food.setActivity(activityLevel);
		    	food.setAge(age);
		    	food.setWeightGoal(weightGoalAsString);
		    	food.setHeight(height);
		    	food.setSex(sex);
		    	food.setWeight(weight);
		    	//calculates the calorie goal
		    	food.calculateBMR();
		    	food.calculateAMR();
		    	food.calculateCals();
		    	double myCalories = food.getCalories();
		    	
		    	// Displays the calorie goal
		    	if (myCalories == 0) caloriesEnterLabel.setText("No goal entered");
		    	else caloriesEnterLabel.setText(String.format("Based on your given Physical data and dietary goal, \nyou should consume: \n" 
		    				+ "%.02f calories weekly \n" 
		    				+  "%.02f calories daily",myCalories,myCalories/7));
		    	caloriesEnterLabel.setMinHeight(100);
		    	caloriesEnterLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: blue");
		    }

	    /**
	     * when the sleep button is pressed on the main scene the sleep scene is created
	     * @param sleepEvent
	     */
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

	    
	    /**
	     * when the food button is pressed on the main scene the food scene is created
	     * @param foodEvent
	     */
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
	    
	    /**
	     * when the done button is pressed in the food scene,
	     *  all elements are removed from the scene to prevent duplication,
	     *  and the scene is switched back to the main scene
	     * @param scene 
	     */
	    void caloriesDoneButton(Scene scene) {
	    	//clears all elements
	    	calorieDataContainer.getChildren().removeAll(calorieDataContainer.getChildren());
	    	weightGoalContainer.getChildren().removeAll(weightGoalContainer.getChildren());
	    	//switches scene
	    	applicationStage.setScene(scene);
	    }
	    
	    /**
	     * when the expenses button is pressed on the main scene the expenses scene is created
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

	    /**
	     * when the exercise button is pressed on the main scene the exercise scene is created
	     * @param toExerciseScene
	     */
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
	    
	    /**
	     * when the water button is pressed on the main scene the water scene is created
	     * @param toWaterEvent
	     */
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
	    
	    /**
	     * when the calculate weekly score  button is pressed in the main scene the weekly score scene is created
	     * and it calculates your weekly score
	     * @param toWeeklyScoreEvent
	     */
	    @FXML
	    void getWeeklyScore(ActionEvent toWeeklyScoreEvent) {
	    	Scene mainScene = applicationStage.getScene();
	    	VBox weeklyScoreAll = new VBox(10);
	    	weeklyScoreAll.setPadding(new Insets(15,15,15,15));
	    	Label weeklyScoreLabel = new Label("Your Weekly Score!");
	    	weeklyScoreLabel.setStyle("-fx-font-weight: 900; -fx-font-size:16px;");
	    	Button doneButton = new Button("Done");
	    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
	    
	    	//displays the grades for all habits
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
	}