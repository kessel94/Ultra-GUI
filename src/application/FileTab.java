package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class FileTab extends Tab{
	
	
	public void start() {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("filetab.fxml"));
		fxml.setRoot(this);
		fxml.setController(this);
		try {
			fxml.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
