package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class File {
	final String fileName;
	public ObservableList<FieldClass> fieldList = FXCollections.observableArrayList();
 
	public ObservableList<FieldClass> getFieldList() {
		return fieldList;
	}
	public void setFieldList(ObservableList<FieldClass> fieldList) {
		this.fieldList = fieldList;
	}
	public File(String fileName) {
		super();
		this.fileName = fileName;
	}
	public void addField(String name, int index){
		FieldClass field = new FieldClass(name, index);
		fieldList.add(field);
	}
	public void removeField(FieldClass field){
		fieldList.remove(field);
	}
	
}
