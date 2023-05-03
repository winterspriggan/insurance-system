package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:57
 */
public interface AccidentListImpl {

	/**
	 * 
	 * @param accident
	 */
	public boolean add(Accident accident);

	/**
	 * 
	 * @param accident
	 */
	public boolean remove(Accident accident);

	/**
	 * 
	 * @param id
	 */
	public Accident retrieve(String id);

	/**
	 * 
	 * @param accident
	 */
	public boolean update(Accident accident);

}