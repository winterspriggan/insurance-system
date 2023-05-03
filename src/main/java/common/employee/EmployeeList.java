package common.employee;


/**
 * @author imseongbin
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public interface EmployeeList {

	/**
	 * 
	 * @param employee
	 */
	public void add(Employee employee);

	/**
	 * 
	 * @param id
	 */
	public void remove(int id);

	/**
	 * 
	 * @param id
	 */
	public void retrieve(int id);

	/**
	 * 
	 * @param employee
	 */
	public void update(Employee employee);

}