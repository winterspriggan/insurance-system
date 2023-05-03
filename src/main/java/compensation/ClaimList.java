package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:57
 */
public class ClaimList implements ClaimListImpl {

	private List<Claim> claimList;
	public Claim m_Claim;

	public ClaimList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param claim
	 */
	public boolean add(Claim claim){
		return false;
	}

	/**
	 * 
	 * @param claimId
	 */
	public boolean remove(String claimId){
		return false;
	}

	/**
	 * 
	 * @param claimId
	 */
	public Claim retrieve(String claimId){
		return null;
	}

	/**
	 * 
	 * @param claim
	 */
	public boolean update(Claim claim){
		return false;
	}

}