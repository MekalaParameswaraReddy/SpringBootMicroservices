package com.conduent.claim.bean;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class Claim {

	String tcn;
	String claimType;
	String status;
	
	Member member;
	Provider provider;

	public Claim() {

	}

	/**
	 * Default Constructor
	 */
	public Claim(String tcn, String claimType, String status) {
		super();
		this.tcn = tcn;
		this.claimType = claimType;
		this.status = status;
	}

	/**
	 * @return the tcn
	 */
	public String getTcn() {
		return tcn;
	}

	/**
	 * @param tcn
	 *            the tcn to set
	 */
	public void setTcn(String tcn) {
		this.tcn = tcn;
	}

	/**
	 * @return the claimType
	 */
	public String getClaimType() {
		return claimType;
	}

	/**
	 * @param claimType
	 *            the claimType to set
	 */
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * @return the provider
	 */
	public Provider getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
