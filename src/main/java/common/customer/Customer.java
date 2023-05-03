package common.customer;


/**
 * @author imseongbin
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public class Customer {

	private int age;
	private String bankAccount;
	private Date birth;
	private String familyHistory;
	private boolean gender;
	private String healthExaminationRecord;
	private int id;
	private String job;
	private String name;

	public Customer(){

	}

	public void finalize() throws Throwable {

	}

	public boolean createClaim(){
		return false;
	}

	public boolean payment(){
		return false;
	}

	public boolean receiveAnAccident(){
		return false;
	}

	public boolean rewarded(){
		return false;
	}

}