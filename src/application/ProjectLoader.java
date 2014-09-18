package application;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
public class ProjectLoader {





	public  String MAIN = "main.fxml";
	public  String WELCOMETAB = "welcometab.fxml";
	public  String PROJECT_PAGE = "projectpage.fxml";
	public  String ABOUT_PAGE = "aboutpage.fxml";
	public  String HELP_PAGE = "helppage.fxml";
	
	
	public  MainController mainController;

	public  void setMainController(MainController mainController) {
		//NavigatorController.mainController = mainController;
		
	}
    public  void loadPane(String fxml) {
        try {
            mainController.setNode(
                FXMLLoader.load(
                    NavigatorController.class.getResource(
                        fxml
                    )
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
