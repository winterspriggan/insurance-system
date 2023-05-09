package common.employee;

import java.io.Serializable;

public class Employee implements Serializable {

    // ids
    private String employeeId;
    // personal info
    private String name;
    private boolean gender;
    private String birth;
    // insurance info
    private String department;

    public Employee(String[] values) {
        setEmployeeId(values[0]);
        setDepartment(values[1]);
        setGender(values[2].equals("M"));
        setBirth(values[3]);
        setDepartment(values[4]);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
//	public boolean business(){
//		return false;
//	}
//
//	public boolean develop(){
//		return false;
//	}
//
//	public boolean manage(){
//		return false;
//	}

}