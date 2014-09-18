package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddRuleWindowController {
	
	@FXML
	private TextField ruleNameTF;
	@FXML
	private TextArea ruleDescriptTA;
	
	@FXML
	public void addOnAction(){
		
		if(!ruleNameTF.getText().equalsIgnoreCase(null) && !ruleDescriptTA.getText().equalsIgnoreCase(null)){
			
			ProjectPageController.setKeyName(ruleNameTF.getText());
			ProjectPageController.setKeyDiscription(ruleDescriptTA.getText());
			
		}
		ProjectPageController.closeRuleWindow();
		
	}
	@FXML
	public void cancelOnAction(){
		
		ProjectPageController.closeRuleWindow();
		//System.exit(0);
		//add close window method
	}
	
	
}