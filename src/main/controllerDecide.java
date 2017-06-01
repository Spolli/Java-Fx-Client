package main;


/**
 * Sample Skeleton for 'decide.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controllerDecide {

    @FXML // fx:id="decline"
    private Button decline; // Value injected by FXMLLoader

    @FXML // fx:id="accept"
    private Button accept; // Value injected by FXMLLoader
    
    @FXML
    private Label disclaimer;
    
    @FXML
    private void initialize(){
    	this.disclaimer.setText("This system contains Highly Confidential information that cannot be disclosed outside of "
    			+ "the company without appropriate agreements in place to protect the confidently of the information. "
    			+ "Within the company, access to information is provided on a “need to know” basis. ");
    }
    
    public void accept(){
		main.browserInteraction.accept();
		try{
			main.browserInteraction.existsClass("caption");
		}
		catch(Exception e){
			Stage stage = (Stage) decline.getScene().getWindow();
		    stage.close();
		    main.browserInteraction.close();
		}
		Stage stage1 = (Stage) accept.getScene().getWindow();
	    stage1.close();
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("area51.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setTitle("Area51");
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    }
		catch(Exception e){
			Stage stage = (Stage) accept.getScene().getWindow();
		    stage.close();
		    main.browserInteraction.close();
		} 
    }

    public void decline(){
		Stage stage = (Stage) decline.getScene().getWindow();
	    stage.close();
	    main.browserInteraction.close();
    }
}
