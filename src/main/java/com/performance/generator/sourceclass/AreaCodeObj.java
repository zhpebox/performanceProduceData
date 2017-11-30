package com.performance.generator.sourceclass;

class AreaCodeObj {

	private String areaCodeNumStr;
	private String areaCodeName;
	
	public AreaCodeObj(String areaCodeNumStr, String areaCodeName) {
		super();
		this.areaCodeNumStr = areaCodeNumStr;
		this.areaCodeName = areaCodeName;
	}
	public String getAreaCodeNumStr() {
		return areaCodeNumStr;
	}
	public void setAreaCodeNumStr(String areaCodeNumStr) {
		this.areaCodeNumStr = areaCodeNumStr;
	}
	public String getAreaCodeName() {
		return areaCodeName;
	}
	public void setAreaCodeName(String areaCodeName) {
		this.areaCodeName = areaCodeName;
	}
	@Override
	public String toString() {
		return "AreaCodeObj [areaCodeNumStr=" + areaCodeNumStr + ", areaCodeName=" + areaCodeName + "]";
	}

	
	
	

}