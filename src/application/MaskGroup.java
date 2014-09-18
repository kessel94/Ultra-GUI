package application;

import java.util.List;

public class MaskGroup {
	String groupName;
	List<FieldClass> groupMembers;
	String groupMaskRule;
	String distFilename;
	boolean isDistributed;
	
	public MaskGroup(String groupName) {
		super();
		this.groupName = groupName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<FieldClass> getGroupMembers() {
		return groupMembers;
	}
	public void setGroupMembers(List<FieldClass> groupMembers) {
		this.groupMembers = groupMembers;
	}
	public String getGroupMaskRule() {
		return groupMaskRule;
	}
	public void setGroupMaskRule(String groupMaskRule) {
		this.groupMaskRule = groupMaskRule;
	}
	public String getDistFilename() {
		return distFilename;
	}
	public void setDistFilename(String distFilename) {
		this.distFilename = distFilename;
	}
	public boolean isDistributed() {
		return isDistributed;
	}
	public void setDistributed(boolean isDistributed) {
		this.isDistributed = isDistributed;
	}
	public void addToGroup(FieldClass FieldClass){
		groupMembers.add(FieldClass);
		
	}
	public void removeMember(FieldClass FieldClass){
		groupMembers.remove(FieldClass);
	}
	

}
