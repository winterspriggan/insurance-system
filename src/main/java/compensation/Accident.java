package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:57
 */
public class Accident {

	private String carNumber;
	private String cusotmerServiceId;
	private String customerId;
	private String id;
	private boolean isAccepted;
	private String location;
	private String name;
	private String telephone;
	private Time time;

	public Accident(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param id
	 * @param carNumber
	 * @param location
	 * @param name
	 * @param telephone
	 * @param time
	 */
	public Accident Accident(String id, String carNumber, String location, String name, String telephone, Time time){
		return null;
	}

	/**
	 * 
	 * @param manager
	 */
	public boolean accept(CustomerService manager){
		return false;
	}

	/**
	 * 
	 * @param manager
	 */
	public boolean reject(CustomerService manager){
		return false;
	}

}