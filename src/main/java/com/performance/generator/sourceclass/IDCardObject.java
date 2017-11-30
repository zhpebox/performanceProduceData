package com.performance.generator.sourceclass;

public class IDCardObject {
	
	private String name;
	private String idcard;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	public IDCardObject() {
	}
	
	public IDCardObject(String name, String idcard) {
		super();
		this.name = name;
		this.idcard = idcard;
	}
	
	@Override
	public String toString() {
		return "IDCardObject [name=" + name + ", idcard=" + idcard + "]";
	}
	
	
	
	
}
