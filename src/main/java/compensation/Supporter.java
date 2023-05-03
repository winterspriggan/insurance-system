package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:50:00
 */
public class Supporter extends Employee {

	public Supporter(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param claimId
	 * @param compensation
	 */
	public boolean payCompensation(String claimId, int compensation){
		return false;
	}

	/**
	 * 
	 * @param claimId
	 * @param result
	 */
	public boolean reviewClaim(String claimId, boolean result){
		return false;
	}

}