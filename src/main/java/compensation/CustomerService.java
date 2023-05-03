package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public class CustomerService extends Employee {

	private List<Accident> accidents;

	public CustomerService(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param accidentId
	 * @param requestorId
	 */
	public boolean requestDispatch(String accidentId, String requestorId){
		return false;
	}

}