package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public interface InsuranceClaimListImpl {

	/**
	 * 
	 * @param insuranceClaim
	 */
	public boolean add(InsuranceClaim insuranceClaim);

	/**
	 * 
	 * @param insuranceClaim
	 */
	public boolean remove(InsuranceClaim insuranceClaim);

	/**
	 * 
	 * @param id
	 */
	public String retrieve(String id);

	/**
	 * 
	 * @param insuranceClaim
	 */
	public boolean update(InsuranceClaim insuranceClaim);

}