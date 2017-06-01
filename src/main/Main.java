package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	public static void main(String[] args) {
        Application.launch(Main.class, args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			Parent root = (Parent)fxmlLoader.load();		//load the .fxml file
	        Scene scene = new Scene(root);		//create a pane
	        stage.setTitle("Login");			//set a title to popup
	        stage.setResizable(false);
	        stage.setScene(scene);
	        stage.show();				//display the popup
		}
		catch(Exception e) {
			stage.close();
		}
	}	
}
