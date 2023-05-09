package common.customer;


/**
 * @author imseongbin
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public interface CustomerList {

	/**
	 * 
	 * @param customer
	 */
	public void add(Customer customer);

	/**
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
     * @param id
     * @return
     */
	public Customer retrieve(String id);

	public void update();

}