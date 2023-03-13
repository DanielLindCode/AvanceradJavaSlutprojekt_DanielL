package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

	@FXML
	private TextField tfTitle;
	@FXML
	private TextField countryInput;
	@FXML
	private TextField cityInput;
	@FXML
	private Button goTodayWeather;

	@FXML
	private Button goTomorrowWeather;

	private ApiHandler apiHandler = new ApiHandler();
	
	@FXML
	private void goTodayWeather(ActionEvent event) throws IOException {
		
	    String city = cityInput.getText();
	    String country = countryInput.getText();
	    String result = apiHandler.getTodaysWeather(city, country);
	    
	    try {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TodayResultScene.fxml"));
	    	Parent root1 = (Parent) fxmlLoader.load();
	    	Stage stage = new Stage();
	    	
	    	stage.setTitle("Todays Weather");
	    	stage.setScene(new Scene(root1));
	    	stage.show();
	    	
	    	TodayResultSceneController todayResultSceneController = fxmlLoader.getController();
	    	todayResultSceneController.setResult(result);
	        
	    } catch (IOException e) {
	    	
	        e.printStackTrace();
	        System.out.println("Can not load new window");
	    }
	    
	}
	
	@FXML
	private void goTomorrowsWeather(ActionEvent event) throws IOException {
		
	    String city = cityInput.getText();
	    String country = countryInput.getText();
	    String result = apiHandler.getTomorrowsWeather(city, country);
	    	    
	    try {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TomorrowsResultScene.fxml"));
	    	Parent root2 = (Parent) fxmlLoader.load();
	    	Stage stage = new Stage();
	    	
	    	stage.setTitle("Tomorrows Weather");
	    	stage.setScene(new Scene(root2));
	    	stage.show();
	    	
	    	TomorrowsResultSceneController tomorrowsResultSceneController = fxmlLoader.getController();
	    	tomorrowsResultSceneController.setResult(result);
	        
	    } catch (IOException e) {
	    	
	        e.printStackTrace();
	        System.out.println("Can not load new window");
	    }
	    
	}
	
}
