package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {
	
	
	
	private Stage subStage;
	@FXML
    private StackPane stackHolder;
	@FXML
	private StackPane stackHolderLeft;
	@FXML
	private ListView<String> listviewHolder;
	@FXML
	
	public static String fileName;
	public static String projectName;
	public static ObservableList<String> treeItemsL1 = FXCollections.observableArrayList();
	public static ObservableList<String> treeItemsL2 = FXCollections.observableArrayList();
	
 
    public void setNode(Node node) {
    	stackHolder.getChildren().setAll(node);
    }
    @FXML
    public void closeOnAction(){
    	
    	System.exit(0);
    	
    }
    @FXML
    public void propOnAction(){
    	
        NavigatorController.loadPane(NavigatorController.PROJECT_PAGE);
    	
    	
    }
    /*This method generates the tapPane and passes the 
     * parameter Project so its known in the tab controller
     * 
    */
    @FXML
    public void createProjectOnAction(){
    	try {
    		URL url = getClass().getResource("welcometab.fxml");
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(url);
    		fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
    		stackHolder.getChildren().clear();
    		stackHolder.getChildren().add((Node) fxmlLoader.load(url.openStream()));
    		
			Project Project = new Project("Project");
		
			((TabController)fxmlLoader.getController()).setProject(Project);
			((TabController)fxmlLoader.getController()).printProject();

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    @FXML
    public void helpOnAction(){
    	
        NavigatorController.loadPane(NavigatorController.HELP_PAGE);
    	
    	
    }
    @FXML
    public void aboutOnAction(){
    	
        NavigatorController.loadPane(NavigatorController.ABOUT_PAGE);
    	
    	
    }
    @FXML
    public void loadOnAction() throws IOException{
    	
    	subStage = Main.getStage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open File");
    	File file = fileChooser.showOpenDialog(subStage);
    	
    	if(file!= null){
    		
    		setFileName(file.getName());
    		
    		
    	}
    	
    }
    public void saveOnAction() throws IOException{
    	
    	subStage = Main.getStage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Save Project");
    	File file = fileChooser.showSaveDialog(subStage);
    	
    	if(file!= null){
    		
    		//Add save project code
    		
    	}
    	
    }
    @FXML
    public void openProjectOnAction() throws IOException{
    	
    	subStage = Main.getStage();
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	directoryChooser.setTitle("Open Project");
    	File file = directoryChooser.showDialog(subStage);
    	
    	if(file!= null){
    		
    		projectName = file.getName();
    		for(File f : file.listFiles()){
    			
    			treeItemsL1.add(f.getName());
    			
    			if(f.isDirectory()){
    				
    				for(File sub : f.listFiles()){
    					
    					treeItemsL2.add(f.getName() + sub.getName());
    					
    				}
    				
    			}
    			
    		}
    		createFileTree(file.getName());
    	}
    	
    }
    public void setFileName(String filename){

    	fileName = filename;
    	
    }
    public static String getFileName(){
    	
    	return fileName;
    	
    }
    public void createFileTree(String root){
    	
    	TreeItem<String> rootItem = new TreeItem<String>(root);
    	rootItem.setExpanded(true);
    	
    	for(int i = 0; i <treeItemsL1.size(); i++){
    		
    		TreeItem<String> itemL1 = new TreeItem<String>(treeItemsL1.get(i));
    		rootItem.getChildren().add(itemL1);
    		
    		for(int j = 0; j < treeItemsL2.size(); j++){
    			
    			if(treeItemsL2.get(j).startsWith(treeItemsL1.get(i))){
        			TreeItem<String> itemL2 = new TreeItem<String>(treeItemsL2.get(j).substring(treeItemsL1.get(i).length()));
        			itemL1.getChildren().add(itemL2);
    			}

    			
    		}
    		
    	}
    	TreeView<String> tree = new TreeView<String>(rootItem);
    	stackHolderLeft.getChildren().add(tree);
    	
    }
 
}
