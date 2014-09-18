package application;



public class FieldClass {
	final String fieldName;
	final int indexNr;
	private boolean isMasked;
	private String maskRule;
	private String maskRuleFile;
	private boolean isDistributed;
	private String distributionFile;
	private String distributionKey1;
	private String distributionKey2;
	private Object group;
	
	
	
	public FieldClass(String _FieldName,int _indexNR){
	 fieldName = _FieldName;
	 indexNr = _indexNR;
	}
	public boolean isMasked(){
		return isMasked;
	}
	public String getName(){
		return fieldName;
	}
	public int getIndex(){
		return indexNr;
	}
	
	public String getMaskRule(){
		return maskRule;
	}
	public void setMaskRule(String MaskRule){
		maskRule = MaskRule;
	}
	
	public void setIsMasked(){
		if(!isMasked){
			isMasked = true;
		
		}
		else
			isMasked = false;
	}
	
	public void setMaskRruleFile(String MaskRuleFile){
		maskRuleFile = MaskRuleFile;
	}
	public String GetMaskRuleFile(){
		return maskRuleFile;
	}
	
	
	
	
	public boolean getDistributed(){
		return isDistributed;
	}
	public void setDistributed(){
		if(!isDistributed){
			isDistributed = true;
		}
		else
			isDistributed = false;
	}
	
	public String GetDistributionKey1(){
		return distributionKey1;
	}
	public void setDistributionKey1(String Key){
		distributionKey1 = Key;
	}
	
	public String GetDistributionKey2(){
		return distributionKey2;
	}
	public void setDistributionKey2(String Key){
		distributionKey2 = Key;
	}
	
	public void SetGroup(Object Group){
		group = Group;
	}
	public Object getGroup(){
		return group;
	}
	
	public String getDistributionFile() {
		return distributionFile;
	}
	public void setDistributionFile(String distributionFile) {
		this.distributionFile = distributionFile;
	}
	
	
}
