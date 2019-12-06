package com.conduent.provider.bean;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Provider {
	String id;
	String name;
	String type;
	
	public Provider () {
		
	}
	/**
	 * Default Constructor
	 */
	public Provider(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
