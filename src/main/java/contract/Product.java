package contract;

import java.io.Serializable;

/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String target;
	private String compensationDetail;
	private int rate;
	private String profitNLossAnalysis;
	private int premiums;
	
	public Product(String[] values){
		this.setId(values[0]);
		this.name = values[1];
		this.target = values[2];
		this.compensationDetail = values[3];
		this.rate = Integer.parseInt(values[4]);
		this.profitNLossAnalysis = values[5];
		this.premiums = Integer.parseInt(values[6]);
	}
	

	public String getProductName() {
		return name;
	}

	public void setProductName(String productName) {
		this.name = productName;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getCompensationDetail() {
		return compensationDetail;
	}

	public void setCompensationDetail(String compensationDetail) {
		this.compensationDetail = compensationDetail;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getProfitNLossAnalysis() {
		return profitNLossAnalysis;
	}

	public void setProfitNLossAnalysis(String profitNLossAnalysis) {
		this.profitNLossAnalysis = profitNLossAnalysis;
	}

	public int getPremiums() {
		return premiums;
	}

	public void setPremiums(int premiums) {
		this.premiums = premiums;
	}

	

	public void finalize() throws Throwable {

	}

	public void devleop(){

	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "|| "+getId() + " , " + getProductName()+ " , " + getTarget()+" , " + getCompensationDetail()+" , " 
				+ getRate() +" , " + getProfitNLossAnalysis() + " , " + getPremiums() +" ||" ;
	}
	

}