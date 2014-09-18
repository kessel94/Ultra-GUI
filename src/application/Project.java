package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Project {
	final String projectName;
	public ObservableList<File> fileList = FXCollections.observableArrayList();

	public Project(String ProjectName) {
		super();
		this.projectName = ProjectName;
	}
	
	public void addFile(String name){
		File File = new File(name);
		fileList.add(File);
	}
	public void addFile(File File){
		fileList.add(File);
	}
	public void removeFile(File File){
		fileList.remove(File);
	}
	public ObservableList<File> getFileList() {
	return fileList;
	}
	public void setFileList(ObservableList<File> FileList) {
		this.fileList = FileList;
	}
	public void PrintFiles(){
		for(int i =0; i < fileList.size(); i++ ){
			System.out.println(fileList.get(i));
		}
	}
}
