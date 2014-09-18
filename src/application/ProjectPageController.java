package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ProjectPageController implements Initializable{
	
	private Stage subStage;
	@FXML
	private TextField projectFolderTF;
	@FXML
	private TextField maskPropFileTF;
	@FXML
	private TextField distPropFileTF;
	@FXML
	private TextField distOutputFolderTF;
	@FXML
	private TextField xmlOutputFolderTF;
	@FXML
	private ListView<String> distKeyLV;
	@FXML
	private ListView<String> maskRuleLV;
	
	static Stage newKeyWindow = new Stage();
	static Stage newRuleWindow = new Stage();
	private Parent root;
	public static String keyName;
	public static String keyDiscription;
	public static ObservableList<String> distkeylist = FXCollections.observableArrayList("postcode_key");
	public static ObservableList<String> maskrulelist = FXCollections.observableArrayList("adres_masker","name_masker","age_masker");
	
	@FXML
	public void addKeyAction(){
		
		try {
			root = FXMLLoader.load(getClass().getResource("addkeywindow.fxml"));
			newKeyWindow.setTitle("Add Key");
			newKeyWindow.setScene(new Scene(root, 400, 300));
			newKeyWindow.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	public void addRuleAction(){
			
			try {
				root = FXMLLoader.load(getClass().getResource("addrulewindow.fxml"));
				newRuleWindow.setTitle("Add Rule");
				newRuleWindow.setScene(new Scene(root, 400, 300));
				newRuleWindow.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	@FXML
	public void projectFolderAction(){
		
    	subStage = Main.getStage();
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	directoryChooser.setTitle("Choose Directory");
    	File file = directoryChooser.showDialog(subStage);
    	
    	if(file!= null){
    		
    		projectFolderTF.setText(file.getAbsolutePath());
    		
    	}
		
	}
	@FXML
	public void maskPropFileAction(){
		
    	subStage = Main.getStage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open File");
    	File file = fileChooser.showOpenDialog(subStage);
    	
    	if(file!= null){
    		
    		maskPropFileTF.setText(file.getAbsolutePath());
    		
    	}
		
	}
	@FXML
	public void distPropFileAction(){
		
    	subStage = Main.getStage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open File");
    	File file = fileChooser.showOpenDialog(subStage);
    	
    	if(file!= null){
    		
    		
    		distPropFileTF.setText(file.getAbsolutePath());
    	}
		
	}
	@FXML
	public void distFolderAction(){
		
    	subStage = Main.getStage();
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	directoryChooser.setTitle("Choose Directory");
    	File file = directoryChooser.showDialog(subStage);
    	
    	if(file!= null){
    		
    		distOutputFolderTF.setText(file.getAbsolutePath());
    		
    	}
		
	}
	@FXML
	public void xmlFolderAction(){
		
    	subStage = Main.getStage();
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	directoryChooser.setTitle("Choose Directory");
    	File file = directoryChooser.showDialog(subStage);
    	
    	if(file!= null){
    		
    		xmlOutputFolderTF.setText(file.getAbsolutePath());
    		
    	}
		
	}
	@FXML
	public void closeOnAction(){
		
		createProperty();
		NavigatorController.loadPane(NavigatorController.WELCOMETAB);
		
	}
    public static void setKeyName(String keyname){

    	keyName = keyname;
    	distkeylist.add(getKeyName());
    	
    }
    public static String getKeyName(){
    	
    	return keyName;
    	
    }
    public static void setKeyDiscription(String keydiscription){

    	keyDiscription = keydiscription;
    	
    }
    public static String getKeyDiscription(){
    	
    	return keyDiscription;
    	
    }
    public void addKey(){
    	
    	distKeyLV.setItems(distkeylist);
    	
    }
    public static void closeRuleWindow(){
    	
    	newRuleWindow.close();
    	
    }
    public static void closeKeyWindow(){
    	
    	newKeyWindow.close();
    	
    }
    public void createProperty(){
    	
    	try {
			FileOutputStream fos = new FileOutputStream("C:/Users/PPCprop.property");
			Properties PPCprop = new Properties();
			PPCprop.put("projectFolderTF", projectFolderTF.getText());
			PPCprop.put("maskPropFileTF", maskPropFileTF.getText());
			PPCprop.put("distPropFileTF", distPropFileTF.getText());
			PPCprop.put("distOutputFolderTF", distOutputFolderTF.getText());
			PPCprop.put("xmlOutputFolderTF", xmlOutputFolderTF.getText());
			try {
				PPCprop.store(fos, "Project Properties File");
				fos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    public void readProperty(){
    	
    	Properties prop = new Properties();
    	try {
			InputStream input = new FileInputStream("C:/Users/PPCprop.property");
			try {
				prop.load(input);
				projectFolderTF.setText(prop.getProperty("projectFolderTF"));
				maskPropFileTF.setText(prop.getProperty("maskPropFileTF"));
				distPropFileTF.setText(prop.getProperty("distPropFileTF"));
				distOutputFolderTF.setText(prop.getProperty("distOutputFolderTF"));
				xmlOutputFolderTF.setText(prop.getProperty("xmlOutputFolderTF"));
				prop.clear();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		readProperty();
		maskRuleLV.setItems(maskrulelist);
		
		
	}
	
}
