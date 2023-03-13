package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TodayResultSceneController {
	
    @FXML
    private TextArea resultText;

    public void setResult(String result) {
    	
    	resultText.setWrapText(true);
    	
        if (resultText != null) {
            resultText.setText(result);
            
        } else {
        	resultText.setText("No Data Found");
        }
    }

}
