package common.employee;


import java.util.Date;

/**
 * @author imseongbin
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public class Employee {

	private Date birth;
	private enum department;
	private boolean gender;
	private int id;
	private String name;
	private String password;

	public Employee(){

	}

	public void finalize() throws Throwable {

	}

	public boolean business(){
		return false;
	}

	public boolean develop(){
		return false;
	}

	public boolean manage(){
		return false;
	}

}