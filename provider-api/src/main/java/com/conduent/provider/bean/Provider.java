package com.conduent.provider.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@Entity
@Table(name = "provider")
public class Provider {
	
	@Id
	String id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "type")
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
