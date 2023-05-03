package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public class InsuranceClaimList implements InsuranceClaimListImpl {

	private List<InsuranceClaim> insuranceClaimList;
	public InsuranceClaim m_InsuranceClaim;

	public InsuranceClaimList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param insuranceClaim
	 */
	public boolean add(InsuranceClaim insuranceClaim){
		return false;
	}

	/**
	 * 
	 * @param insuranceClaim
	 */
	public boolean remove(InsuranceClaim insuranceClaim){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public String retrieve(String id){
		return "";
	}

	/**
	 * 
	 * @param insuranceClaim
	 */
	public boolean update(InsuranceClaim insuranceClaim){
		return false;
	}

}