package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader  loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream ("src/application/HabitTrackerView.fxml"));
			MainSceneController controller = (MainSceneController)loader.getController();
			controller.applicationStage = primaryStage;
			
			Scene scene = new Scene(root,300,330);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Habit Tracker");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
