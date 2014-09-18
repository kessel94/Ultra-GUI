package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class TabController implements Initializable {
	Project Project;
	
	public void setProject(Project Project){
		this.Project = Project;
	}
	public void printProject(){
		System.out.print(Project.toString());
	}
	@FXML
	private TabPane tabHolder;
	@FXML
	private TextField filenameTF;
	@FXML
	public void addOnAction() throws IOException{
		if(filenameTF.getText().length() == 0) {
			filenameTF.setPromptText("give a file Name");
		
		}
		else{
			
			addTab(filenameTF.getText());
		}
	}
	@FXML
	public void removeOnAction() throws IOException{
		
		deleteTab();
		
	}
	public void addTab(String name) throws IOException{
		URL url = getClass().getResource("tablayout.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(url);
		fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
		tabHolder.getTabs().add((Tab) fxmlLoader.load(url.openStream()));
		((LayoutController)fxmlLoader.getController()).setProject(Project);
		((LayoutController)fxmlLoader.getController()).createFile("File");
		Project.PrintFiles();
		System.out.println("");
		int count = tabHolder.getTabs().size() - 1;
		Tab temp = tabHolder.getTabs().get(count);
		temp.setText(name);
		temp.setId(name);
		filenameTF.setText(null);
		
	}
	public void deleteTab() throws IOException{
		
		int count = tabHolder.getTabs().size() - 1;
		tabHolder.getTabs().remove(count);
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
