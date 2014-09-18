package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddKeyWindowController {
	
	@FXML
	private TextField keyNameTF;
	@FXML
	private TextArea keyDescriptTA;
	
	@FXML
	public void addOnAction(){
		
		if(!keyNameTF.getText().equalsIgnoreCase(null) && !keyDescriptTA.getText().equalsIgnoreCase(null)){
			
			ProjectPageController.setKeyName(keyNameTF.getText());
			ProjectPageController.setKeyDiscription(keyDescriptTA.getText());
			
		}
		ProjectPageController.closeKeyWindow();

	}
	@FXML
	public void cancelOnAction(){
		
		ProjectPageController.closeKeyWindow();
		//System.exit(0);
		//add close window method
	}
	
	
}
