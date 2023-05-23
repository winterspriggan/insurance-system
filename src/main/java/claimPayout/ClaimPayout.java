package claimPayout;

import java.io.Serializable;

public class ClaimPayout implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contractNum;
	public int getContractNum() {
		return contractNum;
	}

	public void setContractNum(int contractNum) {
		this.contractNum = contractNum;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getClaimPayout() {
		return claimPayout;
	}

	public void setClaimPayout(int claimPayout) {
		this.claimPayout = claimPayout;
	}

	private String customerId;
	private int claimPayout; 
	
	public ClaimPayout(String[] values) {
		this.contractNum = Integer.parseInt(values[0]);
		this.customerId = values[1];
		this.claimPayout = Integer.parseInt(values[2]);
	}
	
	public String toString() {
		return getContractNum()+"||"+getCustomerId()+"||"+getClaimPayout();
	}

}
