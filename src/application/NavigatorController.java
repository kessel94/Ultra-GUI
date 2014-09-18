package application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class NavigatorController {

	public static final String MAIN = "main.fxml";
	public static final String WELCOMETAB = "welcometab.fxml";
	public static final String PROJECT_PAGE = "projectpage.fxml";
	public static final String ABOUT_PAGE = "aboutpage.fxml";
	public static final String HELP_PAGE = "helppage.fxml";
	
	
	private static MainController mainController;

	public static void setMainController(MainController mainController) {
		NavigatorController.mainController = mainController;
		
	}
    public static void loadPane(String fxml) {
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
