package com.conduent.claim.bean;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Member {
	
	String id;
	String name;
	String eligiblity;
	
	
	/**
	 * Default Constructor
	 */
	public Member() {
		
	}
	/**
	 * Default Constructor
	 */
	public Member(String id, String name, String eligiblity) {
		super();
		this.id = id;
		this.name = name;
		this.eligiblity = eligiblity;
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
	 * @return the eligiblity
	 */
	public String getEligiblity() {
		return eligiblity;
	}
	/**
	 * @param eligiblity the eligiblity to set
	 */
	public void setEligiblity(String eligiblity) {
		this.eligiblity = eligiblity;
	}
	
	
}
