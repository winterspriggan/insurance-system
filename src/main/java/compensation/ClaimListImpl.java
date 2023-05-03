package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:57
 */
public interface ClaimListImpl {

	/**
	 * 
	 * @param claim
	 */
	public boolean add(Claim claim);

	/**
	 * 
	 * @param claimId
	 */
	public boolean remove(String claimId);

	/**
	 * 
	 * @param claimId
	 */
	public Claim retrieve(String claimId);

	/**
	 * 
	 * @param claim
	 */
	public boolean update(Claim claim);

}