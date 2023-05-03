package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:50:00
 */
public class InvestigatorChangeRequestList implements InvestigatorChangeRequestListImpl {

	private List<InvestigatorChangeRequest> investigatorChangeRequestList;
	public InvestigatorChangeRequest m_InvestigatorChangeRequest;

	public InvestigatorChangeRequestList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param request
	 */
	public boolean add(InvestigatorChangeRequest request){
		return false;
	}

	/**
	 * 
	 * @param request
	 */
	public boolean remove(InvestigatorChangeRequest request){
		return false;
	}

	/**
	 * 
	 * @param claimid
	 */
	public InvestigatorChangeRequest retrieve(String claimid){
		return null;
	}

	/**
	 * 
	 * @param request
	 */
	public boolean update(InvestigatorChangeRequest request){
		return false;
	}

}