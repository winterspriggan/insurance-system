package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public interface DispatchRequestListImpl {

	/**
	 * 
	 * @param request
	 */
	public boolean add(DispatchRequest request);

	/**
	 * 
	 * @param request
	 */
	public boolean remove(DispatchRequest request);

	/**
	 * 
	 * @param id
	 */
	public DispatchRequest retrieve(String id);

	/**
	 * 
	 * @param request
	 */
	public boolean update(DispatchRequest request);

}