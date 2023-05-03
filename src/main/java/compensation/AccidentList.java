package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:57
 */
public class AccidentList implements AccidentListImpl {

	private List<Accident> accidentList;
	public Accident m_Accident;

	public AccidentList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param accident
	 */
	public boolean add(Accident accident){
		return false;
	}

	/**
	 * 
	 * @param accident
	 */
	public boolean remove(Accident accident){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public Accident retrieve(String id){
		return null;
	}

	/**
	 * 
	 * @param accident
	 */
	public boolean update(Accident accident){
		return false;
	}

}