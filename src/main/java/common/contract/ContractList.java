package common.contract;


/**
 * @author imseongbin
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public interface ContractList {

	/**
	 * 
	 * @param contract
	 */
	public void add(Contract contract);

	/**
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 
	 * @param id
	 */
	public void retrieve(int id);

	/**
	 * 
	 * @param contract
	 */
	public void update(Contract contract);

}