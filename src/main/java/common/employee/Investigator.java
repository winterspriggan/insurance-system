package common.employee;


import java.io.File;

/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public class Investigator extends Employee {

	public Investigator(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param claimId
	 * @param compensation
	 */
	public boolean decideCompensation(String claimId, int compensation){
		return false;
	}

	/**
	 * 
	 * @param claimId
	 */
	public boolean requestReview(String claimId){
		return false;
	}

	/**
	 * 
	 * @param claimId
	 * @param report
	 */
	public boolean uploadReport(String claimId, File report){
		return false;
	}

}