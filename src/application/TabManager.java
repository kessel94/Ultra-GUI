package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabManager extends TabPane {
	
	public void start() {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("tabmanager.fxml"));
		fxml.setRoot(this);
		fxml.setController(this);
		try {
			FileTab tab1 = new FileTab();
			tab1.start();
			this.getTabs().add(tab1);
			fxml.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
