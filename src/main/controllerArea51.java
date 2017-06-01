package main;

import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * Sample Skeleton for 'area51.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class controllerArea51 {

	@FXML // fx:id="buttonScene"
    private GridPane buttonScene; // Value injected by FXMLLoader

	@FXML // fx:id="exit"
    private Button exit; // Value injected by FXMLLoader

    public void close(){
    	Stage stage = (Stage) exit.getScene().getWindow();
	    stage.close();
	    main.browserInteraction.close();
    }

    @FXML
    public void initialize() {
    	List<WebElement> folder = main.browserInteraction.sharedFolder();
    	int k = 0, col = 0, row = 0;
    	while(k < folder.size()){
    		WebElement shared = folder.get(k);
    		if(!shared.getText().equalsIgnoreCase("")){
    			Button button = new Button();
                button.setText(shared.getText());
                button.setOnAction((event) -> {
                    shared.click();
                });
                if(col < 3){
                	this.buttonScene.addColumn(col, button);
                    col++;
                } else{
                	col = 0;
                	this.buttonScene.addRow(row, button);
                	row++;
                }
    		}
    		k++;
    	}
    	this.buttonScene.setAlignment(Pos.CENTER);
    }
}
