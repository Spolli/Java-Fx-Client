package main;

import main.utility.Data;

/**
 * Sample Skeleton for 'logon.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controllerLogon {

	@FXML // fx:id="pin"
    private PasswordField pin; // Value injected by FXMLLoader

    @FXML // fx:id="warning1"
    private Label warning1; // Value injected by FXMLLoader

    @FXML // fx:id="logon"
    private Button logon; // Value injected by FXMLLoader

    @FXML // fx:id="warning2"
    private Label warning2; // Value injected by FXMLLoader

    @FXML // fx:id="warning3"
    private Label warning3; // Value injected by FXMLLoader

    @FXML // fx:id="warning4"
    private Label warning4; // Value injected by FXMLLoader

    @FXML // fx:id="reset"
    private Button reset; // Value injected by FXMLLoader

    @FXML // fx:id="pwd"
    private PasswordField pwd; // Value injected by FXMLLoader

    @FXML // fx:id="sso"
    private TextField sso; // Value injected by FXMLLoader

    @FXML
    public void initialize() {
        this.sso.setPromptText("Enter SSO");
        this.pwd.setPromptText("Enter Password");
        this.pin.setPromptText("Enter Pin + Rsa Token");
    }

    public void clearSSO(){
    	this.warning1.setText("");
    }

    public void clearPin(){
    	this.warning3.setText("");
    }

    public void clearPwd(){
    	this.warning2.setText("");
    }

    public void reset(){
    	this.sso.setText("");
    	this.pwd.setText("");
    	this.pin.setText("");
    	this.warning2.setText("");
    	this.warning1.setText("");
    	this.warning3.setText("");
    }

    public void onEnter(){
    	logon();
    }

	public void logon(){
    	Data temp = new Data();
    	if(temp.setSso(this.sso.getText())){
    		if(temp.setPwd(this.pwd.getText())){
    			if(temp.setPin(this.pin.getText())){
    				main.browserInteraction.login(temp);
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
								Stage stage = (Stage) logon.getScene().getWindow();
							    stage.close();
							    main.browserInteraction.close();
							}
						} else{

						}
					}
					Stage stage1 = (Stage) this.logon.getScene().getWindow();
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
        			this.warning3.setText("Your Pin is incorrect!");
        		}
    		} else{
    			this.warning2.setText("Your Password is incorrect!");
    		}
    	} else{
    		this.warning1.setText("Your SSO is incorrect!");
    	}
   	}
 }
