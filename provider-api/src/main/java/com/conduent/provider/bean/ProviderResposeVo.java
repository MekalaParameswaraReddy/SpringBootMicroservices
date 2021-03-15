package com.conduent.provider.bean;

import java.util.List;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class ProviderResposeVo {
	
	String status;
	
	List<Provider> list;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the list
	 */
	public List<Provider> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Provider> list) {
		this.list = list;
	}
}
