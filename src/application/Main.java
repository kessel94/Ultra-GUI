package application;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	@FXML private BorderPane BorderPane;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane Page = (BorderPane)FXMLLoader.load(Main.class.getResource("/application/main.fxml"));
			//BorderPane pageT = new BorderPane();
			
			TabManager tm = new TabManager();
			tm.start();
			Page.setCenter(tm);

			Scene scene = new Scene(Page);		
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
