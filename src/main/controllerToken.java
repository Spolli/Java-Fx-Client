/**
 * Sample Skeleton for 'token.fxml' Controller Class
 */

package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class controllerToken {

    @FXML // fx:id="exit"
    private Button exit; // Value injected by FXMLLoader

    @FXML // fx:id="warning"
    private Label warning; // Value injected by FXMLLoader

    @FXML // fx:id="reset"
    private Button reset; // Value injected by FXMLLoader

    @FXML // fx:id="login"
    private Button login; // Value injected by FXMLLoader

    @FXML // fx:id="disclaimer"
    private Label disclaimer; // Value injected by FXMLLoader

    @FXML // fx:id="token"
    private PasswordField token; // Value injected by FXMLLoader

    @FXML
    public void initialize() {
    	this.disclaimer.setText(" Wait for token to change, then enter the new tokencode:");
    	this.token.setPromptText("Enter new Token");
    }
    
    public void close(){
    	Stage stage = (Stage) exit.getScene().getWindow();
	    stage.close();
	    main.browserInteraction.close();
    }
    
    public void onEnter(){
    	logon();
    }
    
    public void logon(){
    	if(this.token.getText().length() == 6){
    		main.browserInteraction.takeToken(this.token.getText());
    		try{
				main.browserInteraction.existsLink("Accept");
			}
			catch(Exception e){
				if(!main.browserInteraction.isName("_F5_challenge")){
					if(main.browserInteraction.isID("credentials_table_postheader")){
						this.warning4.setText("The username or password is not correct. Please try again.");
						reset();
						return;
					} else{
						Stage stage = (Stage) login.getScene().getWindow();
					    stage.close();
					    main.browserInteraction.close();
					}
				}
			}
    		Stage stage1 = (Stage) this.login.getScene().getWindow();
		    stage1.close();
			try{
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("decide.fxml"));
		        Parent root1 = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setTitle("Eula");
		        stage.setResizable(false);
		        stage.setScene(new Scene(root1));  
		        stage.show();
		    }
			catch(Exception e1){
				main.browserInteraction.close();
			}
    	} else{
    		this.warning.setText("Invalid Token!");
    	}
    }
    
    public void reset(){
    	this.token.setText("");
    }
    
    public void clearWarning(){
    	this.warning.setText("");
    }
}