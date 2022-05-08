package CapstoneRedoV1.CapstoneRedoV1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AuthPaneController  implements Initializable  {


	@FXML
	TextField userTextField;
	@FXML
	TextField passwordTextField;
	@FXML
	Button GoButton;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML
	public void startAuthentication() throws IOException {
			App.setRoot("tableWindow");
	}
	
	public String getUser() {
		return userTextField.getText();
	}
	
	public String getPassword() {
		return passwordTextField.getText();
	}
	
}
