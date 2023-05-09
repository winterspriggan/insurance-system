package common.employee;


import common.employee.Employee;

/**
 * @author LG
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:57
 */
public class BusinessEmployee extends Employee {


	public BusinessEmployee(String[] values) {
		super(values);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}