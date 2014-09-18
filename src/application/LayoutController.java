package application;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.control.ListCell;
import javafx.scene.control.Label;
import javafx.util.Callback;

public class LayoutController implements Initializable {
	final ObservableList<FieldClass> unselectedList = FXCollections.observableArrayList();
	final ObservableList<String> selectedList = FXCollections.observableArrayList();
	
	@FXML
	public ListView<FieldClass> fieldLV;

	@FXML
	public CheckBox distributionBoolCB;
	@FXML 
	public CheckBox maskBoolCB;
	@FXML
	public ChoiceBox<String> maskRuleCB;
	@FXML
	public ChoiceBox<MaskGroup> maskGroupCB;
	@FXML
	public ListView<String> selectedListView;
	@FXML
	public TextField fieldNameTF;
	@FXML
	public TextField fieldIndexTF;
	@FXML
	public TextField maskFilenameTF;
	@FXML
	public Button addFieldBtn;
	@FXML
	public Button remFieldBtn;
	final Label leadLbl = new Label();
	Project Project;
	File File;
	 @Override
	public void initialize(URL url, ResourceBundle rb) {
		
		maskRuleCB.getItems().addAll(null,"rule 1","rule 2","Rule 3");
		MaskGroup Group1 = new MaskGroup("group1");
		MaskGroup Group2 = new MaskGroup("group2");
		MaskGroup Group3 = new MaskGroup("group3");
		maskGroupCB.getItems().addAll(null,Group1,Group2,Group3);
		//makes the FieldName listview (fieldLV) display the actual name and index nummer
		// from the FieldClass
		fieldLV.setCellFactory(new Callback<ListView<FieldClass>, ListCell<FieldClass>>() {
	          public ListCell<FieldClass> call(ListView<FieldClass> param) {
	            final Tooltip tooltip = new Tooltip();
	            final ListCell<FieldClass> cell = new ListCell<FieldClass>() {
	              @Override
	              public void updateItem(FieldClass item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  leadLbl.setText(item.getName());
	                  setText(item.getName()+ ", " + item.getIndex() );
	                  tooltip.setText(item.getName());
	                  setTooltip(tooltip);
	                }
	                else{this.setText(null);
	                }
	              }
	            }; // ListCell
	            return cell;
	          }
	        }); // setCellFactor
			// When an item from the listview fieldLv is clicked this populates the page elements
			// with the informtation from the class
		fieldLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FieldClass>() {
		    @Override
		    public void changed(ObservableValue<? extends FieldClass> observable, FieldClass oldValue, FieldClass newValue) {
		        // Your action here
		    	maskGroupCB.setValue((MaskGroup)fieldLV.getSelectionModel().getSelectedItem().getGroup());
		    	maskRuleCB.setValue(fieldLV.getSelectionModel().getSelectedItem().getMaskRule());
		        maskFilenameTF.setText(fieldLV.getSelectionModel().getSelectedItem().GetMaskRuleFile());
		       if( fieldLV.getSelectionModel().getSelectedItem().isMasked()){
		    	   maskBoolCB.setSelected(true);
			      }
			      else
			    	  maskBoolCB.setSelected(false);
		       //get distribution checkbox from input from FieldClass
		      if( fieldLV.getSelectionModel().getSelectedItem().getDistributed()){
		    	  distributionBoolCB.setSelected(true);
		      }
		      else
		    	  distributionBoolCB.setSelected(false);
		    }
			    
			 });
			
			// add property from the choice box to the class
			maskRuleCB.valueProperty().addListener(new ChangeListener<String>(){
				@Override
				public void changed(ObservableValue ov, String t, String t1){
					System.out.print(t1);
					fieldLV.getSelectionModel().getSelectedItem().setMaskRule(t1);
					
				}
			});
			maskGroupCB.valueProperty().addListener(new ChangeListener<MaskGroup>(){
				@Override
				public void changed(ObservableValue ov, MaskGroup t, MaskGroup t1){
					System.out.print(t1);
					fieldLV.getSelectionModel().getSelectedItem().SetGroup(t1);
					
				}
			});
			
			}
	public void createFile(String name){
		File File = new File(name);
		this.File = File;
		Project.addFile(File);
	}
	public void setProject(Project Project){
		this.Project = Project;
	}
		
	//the action handler for the checkbox to set the isMasked boolean
	@FXML
	public void SetMaskBool(){
	   fieldLV.getSelectionModel().getSelectedItem().setIsMasked();
	   System.out.print(fieldLV.getSelectionModel().getSelectedItem().isMasked());
   }
	// the same as above only for the distribution boolean
	@FXML 
	public void SetDistBool(){
		   fieldLV.getSelectionModel().getSelectedItem().setDistributed();
		   System.out.print(fieldLV.getSelectionModel().getSelectedItem().isMasked());
	

   }

	
	@FXML
	public void RemoveField(){
		File.removeField(fieldLV.getSelectionModel().getSelectedItem());
		fieldLV.setItems(File.getFieldList());
	}	
	@FXML
	public void SetMaskFilename(){
		fieldLV.getSelectionModel().getSelectedItem().setMaskRruleFile(maskFilenameTF.getText());
		System.out.print(fieldLV.getSelectionModel().getSelectedItem().getMaskRule());
	}
			
		
	
	
	@FXML
	public void CreateField(){ 
		if((fieldNameTF.getText() != null)){
			if(fieldIndexTF.getText() !=null){
				File.addField(fieldNameTF.getText(), Integer.parseInt(fieldIndexTF.getText()));
				fieldLV.setItems(File.getFieldList());
				fieldNameTF.setText(null);
				fieldIndexTF.setText(null);
				if(File.getFieldList().size()<=1){
					fieldLV.getSelectionModel().select(0);
					
				}
				
			}
		}	
	}
	@FXML
	public void SetMaskRule(){
		fieldLV.getSelectionModel().getSelectedItem().setMaskRule(maskRuleCB.getValue());
		System.out.print(fieldLV.getSelectionModel().getSelectedItem().getMaskRule());
	}
	
		
		}
	

		
	
