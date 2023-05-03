package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:50:00
 */
public interface InvestigatorChangeRequestListImpl {

	/**
	 * 
	 * @param request
	 */
	public boolean add(InvestigatorChangeRequest request);

	/**
	 * 
	 * @param request
	 */
	public boolean remove(InvestigatorChangeRequest request);

	/**
	 * 
	 * @param claimid
	 */
	public InvestigatorChangeRequest retrieve(String claimid);

	/**
	 * 
	 * @param request
	 */
	public boolean update(InvestigatorChangeRequest request);

}