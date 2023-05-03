package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public class DispatchRequestList implements DispatchRequestListImpl {

	private List<DispatchRequest> dispatchRequestList;
	public DispatchRequest m_DispatchRequest;

	public DispatchRequestList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param request
	 */
	public boolean add(DispatchRequest request){
		return false;
	}

	/**
	 * 
	 * @param request
	 */
	public boolean remove(DispatchRequest request){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public DispatchRequest retrieve(String id){
		return null;
	}

	/**
	 * 
	 * @param request
	 */
	public boolean update(DispatchRequest request){
		return false;
	}

}