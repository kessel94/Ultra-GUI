package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	public MainController mainController;
	public static Stage subStage;
	
	@Override
	public void start(Stage mainStage) throws IOException{
		mainStage.setTitle("Ultra GUI");
        
		mainStage.setScene(
            createScene(
                loadMainPane()
            )
        );
		setStage(mainStage);
		mainStage.show();
    }
	public static Stage getStage(){
		
		return subStage;
		
	}
	private void setStage(Stage stage){
		
		subStage = stage;
		
	}
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        Pane mainPane = (Pane) loader.load(
            getClass().getResourceAsStream(
                NavigatorController.MAIN
            )
        );
        mainController = loader.getController();
 
        NavigatorController.setMainController(mainController);
        //NavigatorController.loadPane(NavigatorController.WELCOMETAB);
        
        return mainPane;
    }
  
    private Scene createScene(Pane mainPane) {
        
    	Scene scene = new Scene(mainPane);
 
        return scene;
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
